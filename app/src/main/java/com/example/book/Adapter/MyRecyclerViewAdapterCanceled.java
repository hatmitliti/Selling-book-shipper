package com.example.book.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.Object.Bill;
import com.example.book.Object.Canceled;
import com.example.book.Object.FirebaseConnect;
import com.example.book.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapterCanceled extends RecyclerView.Adapter<MyRecyclerViewAdapterCanceled.MyHolderViewCanceled> {
    private Activity context;
    private int layoutID;
    private ArrayList<Bill> canceledArrayList;

    public MyRecyclerViewAdapterCanceled(Activity context, int layoutID, ArrayList<Bill> canceledArrayList) {
        this.context = context;
        this.layoutID = layoutID;
        this.canceledArrayList = canceledArrayList;
    }

    @NonNull
    @Override
    public MyHolderViewCanceled onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        CardView view = (CardView) layoutInflater.inflate(viewType, parent, false);
        return new MyHolderViewCanceled(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderViewCanceled holder, int position) {
        Bill canceled = canceledArrayList.get(position);
        holder.tvTT.setText("Đã hủy");
        holder.tvDC.setText(canceled.getAddress());
        holder.tvTNN.setText(canceled.getName());
        holder.tvMDH.setText(canceled.getId());


        holder.btnDaTraHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseConnect.setDaTraHangDonHang(canceled.getId());
            }
        });
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
        TextView tvTT, tvDC, tvTNN, tvMDH;
        Button btnDaTraHang;

        public MyHolderViewCanceled(@NonNull View itemView) {
            super(itemView);
            tvTT = itemView.findViewById(R.id.tvTT);
            tvDC = itemView.findViewById(R.id.tvDC);
            tvTNN = itemView.findViewById(R.id.tvTNN);
            tvMDH = itemView.findViewById(R.id.tvMDH);
            btnDaTraHang = itemView.findViewById(R.id.btnDaTraHang);
        }
    }
}
