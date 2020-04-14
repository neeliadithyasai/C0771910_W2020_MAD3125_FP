package com.example.c0771910_w2020_mad3125_fp.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0771910_w2020_mad3125_fp.classes.Customer;

import java.util.ArrayList;

public class customerAdapter extends RecyclerView.Adapter<customerAdapter.customerViewholder> {

    ArrayList<Customer> customersArrayList;

    public customerAdapter(ArrayList<Customer> customersArrayList) {
        this.customersArrayList = customersArrayList;
    }

    @NonNull
    @Override
    public customerViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull customerViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class customerViewholder extends RecyclerView.ViewHolder {
    }
}
