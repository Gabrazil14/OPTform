package com.barbosa.gabriel.optform.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

@SuppressWarnings("unused")
public class OPT implements Parcelable {

    public static final Creator<OPT> CREATOR = new Creator<OPT>() {
        @Override
        public OPT createFromParcel(Parcel in) {
            return new OPT(in);
        }

        @Override
        public OPT[] newArray(int size) {
            return new OPT[size];
        }
    };

    @SerializedName("Name")
    private String name;
    @SerializedName("A10__c")
    private String a10;
    @SerializedName("A11__c")
    private String a11;
    @SerializedName("A12__c")
    private String a12;
    @SerializedName("A13__c")
    private String a13;
    @SerializedName("A14__c")
    private String a14;
    @SerializedName("A15__c")
    private String a15;
    @SerializedName("A16__c")
    private String a16;
    @SerializedName("A17__c")
    private String a17;
    @SerializedName("A18__c")
    private String a18;
    @SerializedName("A19__c")
    private String a19;
    @SerializedName("A1__c")
    private String a1;
    @SerializedName("A2__c")
    private String a2;
    @SerializedName("A3__c")
    private String a3;
    @SerializedName("A4__c")
    private String a4;
    @SerializedName("A5__c")
    private String a5;
    @SerializedName("A6__c")
    private String a6;
    @SerializedName("A7__c")
    private String a7;
    @SerializedName("A8__c")
    private String a8;
    @SerializedName("A9__c")
    private String a9;
    @SerializedName("CreatedDate")
    private Date createdDate;
    @SerializedName("Filtro__c")
    private String filtroId;
    @SerializedName("Id")
    private String id;
    @SerializedName("Operador__c")
    private String operadorId;
    @SerializedName("Posto__c")
    private String postoId;
    @SerializedName("Q10__c")
    private String q10;
    @SerializedName("Q11__c")
    private String q11;
    @SerializedName("Q12__c")
    private String q12;
    @SerializedName("Q13__c")
    private String q13;
    @SerializedName("Q14__c")
    private String q14;
    @SerializedName("Q15__c")
    private String q15;
    @SerializedName("Q16__c")
    private String q16;
    @SerializedName("Q17__c")
    private String q17;
    @SerializedName("Q18__c")
    private String q18;
    @SerializedName("Q19__c")
    private String q19;
    @SerializedName("Q1__c")
    private String q1;
    @SerializedName("Q2__c")
    private String q2;
    @SerializedName("Q3__c")
    private String q3;
    @SerializedName("Q4__c")
    private String q4;
    @SerializedName("Q5__c")
    private String q5;
    @SerializedName("Q6__c")
    private String q6;
    @SerializedName("Q7__c")
    private String q7;
    @SerializedName("Q8__c")
    private String q8;
    @SerializedName("Q9__c")
    private String q9;
    @SerializedName("Supervisor__c")
    private String supervisorId;
    @SerializedName("UET__c")
    private String uETId;
    @SerializedName("Perguntas__c")
    private String questionsId;

    public OPT(String name,
               String filtroId,
               String operadorId,
               String postoId,
               String questionsId,
               String q10,
               String q11,
               String q12,
               String q13,
               String q14,
               String q15,
               String q16,
               String q17,
               String q18,
               String q19,
               String q1,
               String q2,
               String q3,
               String q4,
               String q5C,
               String q6,
               String q7,
               String q8,
               String q9C,
               String supervisorId,
               String uETId) {

        this.name = name;
        this.filtroId = filtroId;
        this.operadorId = operadorId;
        this.postoId = postoId;
        this.questionsId = questionsId;
        this.q10 = q10;
        this.q11 = q11;
        this.q12 = q12;
        this.q13 = q13;
        this.q14 = q14;
        this.q15 = q15;
        this.q16 = q16;
        this.q17 = q17;
        this.q18 = q18;
        this.q19 = q19;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5C;
        this.q6 = q6;
        this.q7 = q7;
        this.q8 = q8;
        this.q9 = q9C;
        this.supervisorId = supervisorId;
        this.uETId = uETId;
    }

    private OPT(Parcel in) {
        name = in.readString();
        a10 = in.readString();
        a11 = in.readString();
        a12 = in.readString();
        a13 = in.readString();
        a14 = in.readString();
        a15 = in.readString();
        a16 = in.readString();
        a17 = in.readString();
        a18 = in.readString();
        a19 = in.readString();
        a1 = in.readString();
        a2 = in.readString();
        a3 = in.readString();
        a4 = in.readString();
        a5 = in.readString();
        a6 = in.readString();
        a7 = in.readString();
        a8 = in.readString();
        a9 = in.readString();
        filtroId = in.readString();
        id = in.readString();
        operadorId = in.readString();
        postoId = in.readString();
        q10 = in.readString();
        q11 = in.readString();
        q12 = in.readString();
        q13 = in.readString();
        q14 = in.readString();
        q15 = in.readString();
        q16 = in.readString();
        q17 = in.readString();
        q18 = in.readString();
        q19 = in.readString();
        q1 = in.readString();
        q2 = in.readString();
        q3 = in.readString();
        q4 = in.readString();
        q5 = in.readString();
        q6 = in.readString();
        q7 = in.readString();
        q8 = in.readString();
        q9 = in.readString();
        supervisorId = in.readString();
        uETId = in.readString();
        questionsId = in.readString();
        createdDate = (Date) in.readSerializable();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getA10() {
        return a10;
    }

    public void setA10(String a10) {
        this.a10 = a10;
    }

    public String getA11() {
        return a11;
    }

    public void setA11(String a11) {
        this.a11 = a11;
    }

    public String getA12() {
        return a12;
    }

    public void setA12(String a12) {
        this.a12 = a12;
    }

    public String getA13() {
        return a13;
    }

    public void setA13(String a13) {
        this.a13 = a13;
    }

    public String getA14() {
        return a14;
    }

    public void setA14(String a14) {
        this.a14 = a14;
    }

    public String getA15() {
        return a15;
    }

    public void setA15(String a15) {
        this.a15 = a15;
    }

    public String getA16() {
        return a16;
    }

    public void setA16(String a16) {
        this.a16 = a16;
    }

    public String getA17() {
        return a17;
    }

    public void setA17(String a17) {
        this.a17 = a17;
    }

    public String getA18() {
        return a18;
    }

    public void setA18(String a18) {
        this.a18 = a18;
    }

    public String getA19() {
        return a19;
    }

    public void setA19(String a19) {
        this.a19 = a19;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public String getA5() {
        return a5;
    }

    public void setA5(String a5) {
        this.a5 = a5;
    }

    public String getA6() {
        return a6;
    }

    public void setA6(String a6) {
        this.a6 = a6;
    }

    public String getA7() {
        return a7;
    }

    public void setA7(String a7) {
        this.a7 = a7;
    }

    public String getA8() {
        return a8;
    }

    public void setA8(String a8) {
        this.a8 = a8;
    }

    public String getA9() {
        return a9;
    }

    public void setA9(String a9) {
        this.a9 = a9;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getFiltroId() {
        return filtroId;
    }

    public void setFiltroId(String filtroId) {
        this.filtroId = filtroId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperadorId() {
        return operadorId;
    }

    public void setOperadorId(String operadorId) {
        this.operadorId = operadorId;
    }

    public String getPostoId() {
        return postoId;
    }

    public void setPostoId(String postoId) {
        this.postoId = postoId;
    }

    public String getQ10() {
        return q10;
    }

    public void setQ10(String q10) {
        this.q10 = q10;
    }

    public String getQ11() {
        return q11;
    }

    public void setQ11(String q11) {
        this.q11 = q11;
    }

    public String getQ12() {
        return q12;
    }

    public void setQ12(String q12) {
        this.q12 = q12;
    }

    public String getQ13() {
        return q13;
    }

    public void setQ13(String q13) {
        this.q13 = q13;
    }

    public String getQ14() {
        return q14;
    }

    public void setQ14(String q14) {
        this.q14 = q14;
    }

    public String getQ15() {
        return q15;
    }

    public void setQ15(String q15) {
        this.q15 = q15;
    }

    public String getQ16() {
        return q16;
    }

    public void setQ16(String q16) {
        this.q16 = q16;
    }

    public String getQ17() {
        return q17;
    }

    public void setQ17(String q17) {
        this.q17 = q17;
    }

    public String getQ18() {
        return q18;
    }

    public void setQ18(String q18) {
        this.q18 = q18;
    }

    public String getQ19() {
        return q19;
    }

    public void setQ19(String q19) {
        this.q19 = q19;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getQ4() {
        return q4;
    }

    public void setQ4(String q4) {
        this.q4 = q4;
    }

    public String getQ5() {
        return q5;
    }

    public void setQ5(String q5) {
        this.q5 = q5;
    }

    public String getQ6() {
        return q6;
    }

    public void setQ6(String q6) {
        this.q6 = q6;
    }

    public String getQ7() {
        return q7;
    }

    public void setQ7(String q7) {
        this.q7 = q7;
    }

    public String getQ8() {
        return q8;
    }

    public void setQ8(String q8) {
        this.q8 = q8;
    }

    public String getQ9() {
        return q9;
    }

    public void setQ9(String q9) {
        this.q9 = q9;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getUETC() {
        return uETId;
    }

    public void setUETC(String uETC) {
        this.uETId = uETC;
    }

    public String getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(String questionsId) {
        this.questionsId = questionsId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(a10);
        dest.writeString(a11);
        dest.writeString(a12);
        dest.writeString(a13);
        dest.writeString(a14);
        dest.writeString(a15);
        dest.writeString(a16);
        dest.writeString(a17);
        dest.writeString(a18);
        dest.writeString(a19);
        dest.writeString(a1);
        dest.writeString(a2);
        dest.writeString(a3);
        dest.writeString(a4);
        dest.writeString(a5);
        dest.writeString(a6);
        dest.writeString(a7);
        dest.writeString(a8);
        dest.writeString(a9);
        dest.writeString(filtroId);
        dest.writeString(id);
        dest.writeString(operadorId);
        dest.writeString(postoId);
        dest.writeString(q10);
        dest.writeString(q11);
        dest.writeString(q12);
        dest.writeString(q13);
        dest.writeString(q14);
        dest.writeString(q15);
        dest.writeString(q16);
        dest.writeString(q17);
        dest.writeString(q18);
        dest.writeString(q19);
        dest.writeString(q1);
        dest.writeString(q2);
        dest.writeString(q3);
        dest.writeString(q4);
        dest.writeString(q5);
        dest.writeString(q6);
        dest.writeString(q7);
        dest.writeString(q8);
        dest.writeString(q9);
        dest.writeString(supervisorId);
        dest.writeString(uETId);
        dest.writeString(questionsId);
        dest.writeSerializable(createdDate);
    }
}
