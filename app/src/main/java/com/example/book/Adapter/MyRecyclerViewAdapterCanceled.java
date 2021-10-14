package com.example.book.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.Object.Canceled;
import com.example.book.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapterCanceled extends RecyclerView.Adapter<MyRecyclerViewAdapterCanceled.MyHolderViewCanceled> {
    private Activity context;
    private int layoutID;
    private ArrayList<Canceled> canceledArrayList;

    public MyRecyclerViewAdapterCanceled(Activity context, int layoutID, ArrayList<Canceled> canceledArrayList) {
        this.context = context;
        this.layoutID = layoutID;
        this.canceledArrayList = canceledArrayList;
    }

    @NonNull
    @Override
    public MyHolderViewCanceled onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        CardView view = (CardView) layoutInflater.inflate(viewType,parent,false);
        return new MyHolderViewCanceled(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderViewCanceled holder, int position) {
        Canceled canceled = canceledArrayList.get(position);
        holder.tvTT.setText(canceled.getTrangThai());
        holder.tvDC.setText(canceled.getDiaChi());
        holder.tvTNN.setText(canceled.getTenNgNhan());
        holder.tvMDH.setText(canceled.getMaDH());
    }

    @Override
    public int getItemCount() {
        return canceledArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return layoutID;
    }

    public static class MyHolderViewCanceled extends RecyclerView.ViewHolder {
        TextView tvTT,tvDC,tvTNN,tvMDH;
        public MyHolderViewCanceled(@NonNull View itemView) {
            super(itemView);
            tvTT = itemView.findViewById(R.id.tvTT);
            tvDC = itemView.findViewById(R.id.tvDC);
            tvTNN = itemView.findViewById(R.id.tvTNN);
            tvMDH = itemView.findViewById(R.id.tvMDH);
        }
    }
}
