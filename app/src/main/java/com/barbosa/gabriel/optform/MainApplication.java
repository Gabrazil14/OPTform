package com.barbosa.gabriel.optform;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.barbosa.gabriel.optform.interfaces.SalesForceLoginApi;
import com.barbosa.gabriel.optform.models.Session;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainApplication extends Application {
    private static Retrofit retrofit;
    private static Session currentSession;
    private static SharedPreferences sharedpreferences;
    private static SharedPreferences.Editor editor;

    public static Retrofit getRetrofit(String url) {
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    .create();
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(provideOkHttpClient())
                    .baseUrl(url)
                    .build();
        }
        return retrofit;
    }

    public static Session getSession() {
        if (currentSession == null) {
            String token = sharedpreferences.getString("token", "");
            String url = sharedpreferences.getString("instance_url", "");
            currentSession = new Session(token, url);
        }
        return currentSession;
    }

    public static void saveSession(Session session) {
        currentSession = session;
        editor.putString("instance_url", session.getInstanceUrl());
        editor.putString("token", session.getAccessToken().replace("Bearer ", ""));
        editor.apply();
        editor.commit();
    }

    private static OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();
        okhttpClientBuilder.addInterceptor(new AuthorizationInterceptor(getSession()));
        return okhttpClientBuilder.build();
    }

    @SuppressLint("CommitPrefEdits")
    @Override
    public void onCreate() {
        super.onCreate();
        sharedpreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
    }

    public static class AuthorizationInterceptor implements Interceptor {
        private Session session;

        AuthorizationInterceptor(Session session) {
            this.session = session;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Response mainResponse = chain.proceed(chain.request());
            Request mainRequest = chain.request();

            if (mainResponse.code() == 401 || mainResponse.code() == 403) {

                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(SalesForceLoginApi.LOGIN_URL)
                        .build();
                SalesForceLoginApi loginApi = retrofit.create(SalesForceLoginApi.class);
                retrofit2.Response<Session> loginResponse = loginApi.refreshToken("refresh_token",
                        SalesForceLoginApi.CLIENT_ID,
                        SalesForceLoginApi.CLIENT_SECRET,
                        session.getAccessToken().replace("Bearer ", ""))
                        .execute();

                if (loginResponse.isSuccessful()) {
                    Session session = loginResponse.body();
                    saveSession(session);

                    Request.Builder builder = mainRequest.newBuilder().header("Authorization", session.getAccessToken()).
                            method(mainRequest.method(), mainRequest.body());
                    mainResponse = chain.proceed(builder.build());
                }
            }

            return mainResponse;
        }

    }

}
