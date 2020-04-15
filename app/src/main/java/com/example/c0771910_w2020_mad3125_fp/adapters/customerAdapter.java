package com.example.c0771910_w2020_mad3125_fp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0771910_w2020_mad3125_fp.R;
import com.example.c0771910_w2020_mad3125_fp.model.Customer;
import com.example.c0771910_w2020_mad3125_fp.ui.detailsDisplayActivity;
import com.example.c0771910_w2020_mad3125_fp.util.DataManager;

import java.util.ArrayList;

public class customerAdapter extends RecyclerView.Adapter<customerAdapter.customerViewholder> {

//    ArrayList<Customer> customersArrayList;
//    private Context mContext;
//
//    public customerAdapter(ArrayList<Customer> customersArrayList,Context mContext) {
//        this.customersArrayList = customersArrayList;
//        this.mContext = mContext;
//    }

    @NonNull
    @Override
    public customerViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.customersitem, parent, false);
         customerViewholder mcustomerViewholder = new customerViewholder(mView);
        return mcustomerViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull final customerAdapter.customerViewholder holder, int position)
    {

        final Customer mcustomer = DataManager.getInstance().getCustomers().get(position);
        holder.txtCustomername.setText(mcustomer.getFirstName());

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(holder.itemView.getContext(), detailsDisplayActivity.class);
                mIntent.putExtra("CustomerOBJ",mcustomer);
                holder.itemView.getContext().startActivity(mIntent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return DataManager.getInstance().getCustomers().size();
    }

    public class customerViewholder extends RecyclerView.ViewHolder {

        TextView txtCustomername;
        public customerViewholder(@NonNull View mView) {
            super(mView);
            txtCustomername = mView.findViewById(R.id.txtCustomerDisplay);
        }
    }
}
