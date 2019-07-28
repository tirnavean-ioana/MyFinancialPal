package com.example.myfinancialpal;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myfinancialpal.Model.Income;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AmountList extends Fragment {


    private List<Income> incomeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListAdapter mAdapter = null;

    public AmountList() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_amount_list, container,false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.amount_list_recycler_view);

        setListAdapter();

        return inflater.inflate(R.layout.fragment_amount_list, container, false);
    }


    //TODO set adapter

    //TODO populate list items with data


    private void setListAdapter() {

        prepareListData();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);
    }

    private void prepareListData() {
        Income i1 = new Income("mergi?", 100.0, new Date());
        incomeList.add(i1);

        Income i2 = new Income("sau", 30.0, new Date());
        incomeList.add(i2);

        Income i3 = new Income("nu vrei sa mergi?", 150.0, new Date());
        incomeList.add(i3);
    }

}
