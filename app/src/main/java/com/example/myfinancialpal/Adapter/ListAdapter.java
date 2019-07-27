package com.example.myfinancialpal.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfinancialpal.Model.Income;
import com.example.myfinancialpal.R;

import org.w3c.dom.Text;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private List<Income> incomeList;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView description;
        public TextView date;
        public TextView amount;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            description = (TextView) itemView.findViewById(R.id.list_description_holder);
            date = (TextView) itemView.findViewById(R.id.list_date_holder);
            amount = (TextView) itemView.findViewById(R.id.list_amount_holder);
        }
    }

    public ListAdapter(List<Income> incomeList) {
        this.incomeList = incomeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.amount_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Income income = incomeList.get(position);
        holder.description.setText(income.getSource());
        holder.date.setText(income.getDate().toString());
        holder.amount.setText(String.valueOf(income.getAmount()));
    }

    @Override
    public int getItemCount() {
        return incomeList.size();
    }

}
