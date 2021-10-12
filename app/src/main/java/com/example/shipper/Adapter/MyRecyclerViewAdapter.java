package com.example.shipper.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shipper.Object.Confirm;
import com.example.shipper.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private Activity context;
    private int layoutID;
    private ArrayList<Confirm> confirmArrayList;

    public MyRecyclerViewAdapter(Activity context, int layoutID, ArrayList<Confirm> confirmArrayList) {
        this.context = context;
        this.layoutID = layoutID;
        this.confirmArrayList = confirmArrayList;
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
        Confirm confirm = confirmArrayList.get(position);
        holder.LyDo.setText(confirm.getLyDo());
        holder.MaDH.setText(confirm.getMaDH());
    }

    @Override
    public int getItemCount() {
        return confirmArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return layoutID;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView MaDH,LyDo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            MaDH = itemView.findViewById(R.id.tvMDH);
            LyDo = itemView.findViewById(R.id.tvLyDo);
        }
    }
}
