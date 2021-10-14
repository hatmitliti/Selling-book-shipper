package com.example.book.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.Object.Delivery;
import com.example.book.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapterNeedDelivery extends RecyclerView.Adapter<MyRecyclerViewAdapterNeedDelivery.MyHolderViewNeedDelivery> {
    private Activity context;
    private int layoutID;
    private ArrayList<Delivery> deliveryArrayList;

    public MyRecyclerViewAdapterNeedDelivery(Activity context, int layoutID, ArrayList<Delivery> deliveryArrayList) {
        this.context = context;
        this.layoutID = layoutID;
        this.deliveryArrayList = deliveryArrayList;
    }

    @NonNull
    @Override
    public MyHolderViewNeedDelivery onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        CardView view = (CardView) layoutInflater.inflate(viewType, parent, false);
        return new MyHolderViewNeedDelivery(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderViewNeedDelivery holder, int position) {
        Delivery delivery = deliveryArrayList.get(position);
        holder.tvTT.setText(delivery.getTrangThai());
        holder.tvDC.setText(delivery.getDiaChi());
        holder.tvTNN.setText(delivery.getTenNgNhan());
        holder.tvMDH.setText(delivery.getMaDH());
    }

    @Override
    public int getItemCount() {
        return deliveryArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return layoutID;
    }

    public static class MyHolderViewNeedDelivery extends RecyclerView.ViewHolder {
        TextView tvTT, tvDC, tvTNN, tvMDH;

        public MyHolderViewNeedDelivery(@NonNull View itemView) {
            super(itemView);
            tvTT = itemView.findViewById(R.id.tvTT);
            tvDC = itemView.findViewById(R.id.tvDC);
            tvTNN = itemView.findViewById(R.id.tvTNN);
            tvMDH = itemView.findViewById(R.id.tvMDH);
        }
    }
}
