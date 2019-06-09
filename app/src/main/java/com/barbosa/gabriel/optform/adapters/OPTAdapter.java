package com.barbosa.gabriel.optform.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barbosa.gabriel.optform.R;
import com.barbosa.gabriel.optform.models.OPT;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OPTAdapter extends RecyclerView.Adapter<OPTAdapter.OPTViewHolder> implements Filterable {
    private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    private List<OPT> originalOpts;
    private List<OPT> filteredOpts;
    private OPTClickListener clickListener;
    private Filter optFilter;

    public OPTAdapter(final List<OPT> originalOpts, OPTClickListener clickListener) {
        this.originalOpts = this.filteredOpts = originalOpts;
        this.clickListener = clickListener;

        optFilter = new Filter() {
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<OPT> tmpFilteredopts = new ArrayList<>();

                constraint = constraint.toString().toLowerCase();

                if (((String) constraint).isEmpty()) {
                    results.count = 0;
                    results.values = null;
                    return results;
                } else {
                    for (OPT opt : originalOpts) {
                        String optDate = df.format(opt.getCreatedDate());
                        if (opt.getName().toLowerCase().contains(constraint) || optDate.toLowerCase().contains(constraint)) {
                            tmpFilteredopts.add(opt);
                        }
                    }
                    results.count = tmpFilteredopts.size();
                    results.values = tmpFilteredopts;
                    return results;
                }

            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredOpts = (List<OPT>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    @NonNull
    @Override
    public OPTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OPTViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.opt_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OPTViewHolder holder, int position) {
        final OPT opt = filteredOpts.get(position);
        holder.optDate.setText(df.format(opt.getCreatedDate()));
        holder.optName.setText(opt.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onOPTClickListener(opt);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (filteredOpts != null)
            return filteredOpts.size();
        else
            return 0;
    }

    @Override
    public Filter getFilter() {
        return optFilter;
    }

    public void resetFilter() {
        filteredOpts = originalOpts;
        notifyDataSetChanged();
    }

    public interface OPTClickListener {
        void onOPTClickListener(OPT opt);
    }

    class OPTViewHolder extends RecyclerView.ViewHolder {
        TextView optDate;
        TextView optName;

        OPTViewHolder(@NonNull View itemView) {
            super(itemView);
            optDate = itemView.findViewById(R.id.opt_date);
            optName = itemView.findViewById(R.id.opt_name);
        }
    }
}
