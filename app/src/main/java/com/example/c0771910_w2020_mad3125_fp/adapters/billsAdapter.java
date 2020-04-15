package com.example.c0771910_w2020_mad3125_fp.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0771910_w2020_mad3125_fp.model.Bill;

import java.util.ArrayList;

public class billsAdapter extends RecyclerView.Adapter<billsAdapter.billsViewHolder> {

    public static ArrayList<Bill> billArrayList;

    public billsAdapter(ArrayList<Bill> billArrayList)
    {
        this.billArrayList = billArrayList;
    }
    @NonNull
    @Override
    public billsAdapter.billsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull billsAdapter.billsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class billsViewHolder extends RecyclerView.ViewHolder {
        public billsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
