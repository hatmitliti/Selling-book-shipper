package com.example.book.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.Object.Detail;
import com.example.book.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapterDetail extends RecyclerView.Adapter<MyRecyclerViewAdapterDetail.MyViewHolder> {
    private Activity context;
    private int layoutID;
    private ArrayList<Detail> detailArrayList;

    public MyRecyclerViewAdapterDetail(Activity context, int layoutID, ArrayList<Detail> detailArrayList) {
        this.context = context;
        this.layoutID = layoutID;
        this.detailArrayList = detailArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =context.getLayoutInflater();
        CardView view = (CardView) layoutInflater.inflate(viewType,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Detail detail = detailArrayList.get(position);
        holder.Tien.setText(detail.getTien());
        holder.MaDH.setText(detail.getMaDH());
    }

    @Override
    public int getItemCount() {
        return detailArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return layoutID;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView MaDH,Tien;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            MaDH = itemView.findViewById(R.id.tvMDH);
            Tien = itemView.findViewById(R.id.tvTTH);
        }
    }
}
