package com.example.myfinancialpal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfinancialpal.Model.Income;
import com.example.myfinancialpal.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {


    private List<Income> incomeList;
    private LayoutInflater inflater;

    private String description, sold, date;

    public ListAdapter(Context context, List<Income> incomeList) {
        this.inflater = LayoutInflater.from(context);
        this.incomeList = incomeList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.amount_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

  /*  @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }
*/
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        description = incomeList.get(position).getSource();
        sold = String.valueOf(incomeList.get(position).getAmount());
        date = incomeList.get(position).getDate().toString();

        holder.description.setText(description);
        holder.sold.setText(sold);
        holder.date.setText(date);
    }



    @Override
    public int getItemCount() {
        return incomeList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView description, sold, date;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.list_description_holder);
            sold = itemView.findViewById(R.id.list_amount_holder);
            date = itemView.findViewById(R.id.list_date_holder);
        }
    }

}

/*
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.amount_list_item, parent, false);
        return new MyViewHolder(view);
    }
*/

    /*


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView description;
        public TextView date;
        public TextView amount;


        public MyViewHolder(View itemView) {
            super(itemView);
            description =  itemView.findViewById(R.id.list_description_holder);
            date = itemView.findViewById(R.id.list_date_holder);
            amount = itemView.findViewById(R.id.list_amount_holder);
        }
    }

    public ListAdapter(List<Income> incomeList) {

        this.incomeList = incomeList;
    }

    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.amount_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.MyViewHolder holder, int position) {
        Income income = incomeList.get(position);

        holder.description.setText(income.getSource());
        holder.date.setText(income.getDate().toString());
        holder.amount.setText(String.valueOf(income.getAmount()));
    }



    @Override
    public int getItemCount() {
        return incomeList.size();
    }

    */

