package com.example.book.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.Object.Bill;
import com.example.book.Object.Delivering;
import com.example.book.R;

import java.util.ArrayList;

public class RecyclerViewAdapterDelivering extends RecyclerView.Adapter<RecyclerViewAdapterDelivering.MyHolderViewDelivering> {
    private Activity context;
    private int layoutID;
    private ArrayList<Bill> deliveringArrayList;
    private MyItemOnClick delegation;

    public void setDelegation(MyItemOnClick delegation) {
        this.delegation = delegation;
    }

    public RecyclerViewAdapterDelivering(Activity context, int layoutID, ArrayList<Bill> deliveringArrayList) {
        this.context = context;
        this.layoutID = layoutID;
        this.deliveringArrayList = deliveringArrayList;
    }

    @NonNull
    @Override
    public MyHolderViewDelivering onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        CardView view = (CardView) layoutInflater.inflate(viewType,parent,false);
        return new MyHolderViewDelivering(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderViewDelivering holder, int position) {
        Bill delivering = deliveringArrayList.get(position);
        holder.tvTT.setText("Đang giao");
        holder.tvDC.setText(delivering.getAddress());
        holder.tvTNN.setText(delivering.getName());
        holder.tvMDH.setText(delivering.getId());

        holder.onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(delegation != null){
                    delegation.getDeliveringInforation(delivering);
                }else {
                    Toast.makeText(context,"ddd",Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @Override
    public int getItemCount() {
        return deliveringArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return layoutID;
    }

    public static class MyHolderViewDelivering extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvTT,tvDC,tvTNN,tvMDH;
        View.OnClickListener onClickListener;
        public MyHolderViewDelivering(@NonNull View itemView) {
            super(itemView);
            tvTT = itemView.findViewById(R.id.tvTT);
            tvTT.setOnClickListener(this);
            tvDC = itemView.findViewById(R.id.tvDC);
            tvDC.setOnClickListener(this);
            tvTNN = itemView.findViewById(R.id.tvTNN);
            tvTNN.setOnClickListener(this);
            tvMDH = itemView.findViewById(R.id.tvMDH);
            tvMDH.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(onClickListener != null){
                onClickListener.onClick(v);
            }
        }
    }

    public static interface MyItemOnClick {
        public void getDeliveringInforation(Bill delivering);
    }
}
