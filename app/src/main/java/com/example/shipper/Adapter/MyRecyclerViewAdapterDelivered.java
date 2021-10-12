package com.example.shipper.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shipper.Object.Delivered;
import com.example.shipper.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapterDelivered extends RecyclerView.Adapter<MyRecyclerViewAdapterDelivered.MyHolderViewDelivered> {
    private Activity context;
    private int layoutID;
    private ArrayList<Delivered> deliveredArrayList;

    public MyRecyclerViewAdapterDelivered(Activity context, int layoutID, ArrayList<Delivered> deliveredArrayList) {
        this.context = context;
        this.layoutID = layoutID;
        this.deliveredArrayList = deliveredArrayList;
    }

    @NonNull
    @Override
    public MyHolderViewDelivered onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        CardView view = (CardView) layoutInflater.inflate(viewType,parent,false);
        return new MyHolderViewDelivered(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderViewDelivered holder, int position) {
        Delivered delivered = deliveredArrayList.get(position);
        holder.tvTT.setText(delivered.getTrangThai());
        holder.tvGT.setText(delivered.getGiaoTien());
        holder.tvDC.setText(delivered.getDiaChi());
        holder.tvTNN.setText(delivered.getTenNgNhan());
        holder.tvMDH.setText(delivered.getMaDH());
    }

    @Override
    public int getItemCount() {
        return deliveredArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return layoutID;
    }

    public static class MyHolderViewDelivered extends RecyclerView.ViewHolder {
        TextView tvTT,tvGT,tvDC,tvTNN,tvMDH;
        public MyHolderViewDelivered(@NonNull View itemView) {
            super(itemView);
            tvTT = itemView.findViewById(R.id.tvTT);
            tvGT = itemView.findViewById(R.id.tvGT);
            tvDC = itemView.findViewById(R.id.tvDC);
            tvTNN = itemView.findViewById(R.id.tvTNN);
            tvMDH = itemView.findViewById(R.id.tvMDH);
        }
    }
}
