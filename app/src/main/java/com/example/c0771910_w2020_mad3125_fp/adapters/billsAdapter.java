package com.example.c0771910_w2020_mad3125_fp.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0771910_w2020_mad3125_fp.R;
import com.example.c0771910_w2020_mad3125_fp.model.Bill;
import com.example.c0771910_w2020_mad3125_fp.model.Customer;
import com.example.c0771910_w2020_mad3125_fp.ui.detailedBillDisplay;
import com.example.c0771910_w2020_mad3125_fp.ui.detailsDisplayActivity;
import com.example.c0771910_w2020_mad3125_fp.util.StringExtension;

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
        View mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bill_cell, parent, false);
        billsAdapter.billsViewHolder mBillsViewHolder = new billsAdapter.billsViewHolder(mView);
        return mBillsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final billsAdapter.billsViewHolder holder, int position) {

        final Bill mBills = this.billArrayList.get(position);
        holder.txtCellBillId.setText(mBills.getBillId());
       holder.txtCellBillAmount.setText(StringExtension.doubleFormatter(mBills.getBillAmount()));
        holder.txtCellBillDate.setText(mBills.getBillDate().toString());
        holder.txtCellBillType.setText(mBills.getBillType().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mIntent = new Intent(holder.itemView.getContext(), detailedBillDisplay.class);
                mIntent.putExtra("billOBJ",mBills);
                holder.itemView.getContext().startActivity(mIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return this.billArrayList.size();
    }

    public class billsViewHolder extends RecyclerView.ViewHolder {

        TextView txtCellBillId;
        TextView txtCellBillDate;
        TextView txtCellBillType;
        TextView txtCellBillAmount;
        public billsViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCellBillId = itemView.findViewById(R.id.txtCellBillId);
            txtCellBillDate = itemView.findViewById(R.id.txtCellBillDate);
            txtCellBillType = itemView.findViewById(R.id.txtCellBillType);
            txtCellBillAmount = itemView.findViewById(R.id.txtCellBillAmount);
        }
    }
}
