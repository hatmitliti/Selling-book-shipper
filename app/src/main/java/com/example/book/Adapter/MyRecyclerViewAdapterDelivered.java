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
import com.example.book.Object.Delivered;
import com.example.book.Object.FirebaseConnect;
import com.example.book.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapterDelivered extends RecyclerView.Adapter<MyRecyclerViewAdapterDelivered.MyHolderViewDelivered> {
    private Activity context;
    private int layoutID;
    private ArrayList<Bill> deliveredArrayList;

    public MyRecyclerViewAdapterDelivered(Activity context, int layoutID, ArrayList<Bill> deliveredArrayList) {
        this.context = context;
        this.layoutID = layoutID;
        this.deliveredArrayList = deliveredArrayList;
    }

    @NonNull
    @Override
    public MyHolderViewDelivered onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        CardView view = (CardView) layoutInflater.inflate(viewType, parent, false);
        return new MyHolderViewDelivered(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderViewDelivered holder, int position) {
        Bill delivered = deliveredArrayList.get(position);
        holder.tvTT.setText("Đã giao");
        holder.tvGT.setText(delivered.getTotalMoney() +"");
        holder.tvDC.setText(delivered.getAddress());
        holder.tvTNN.setText(delivered.getName());
        holder.tvMDH.setText(delivered.getId());

        holder.btnDaGiaoTienDaGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseConnect.setDaGiaoTienDHCanGiao(delivered.getId());
            }
        });
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
        TextView tvTT, tvGT, tvDC, tvTNN, tvMDH;
        Button btnDaGiaoTienDaGiao;

        public MyHolderViewDelivered(@NonNull View itemView) {
            super(itemView);
            tvTT = itemView.findViewById(R.id.tvTT);
            tvGT = itemView.findViewById(R.id.tvGT);
            tvDC = itemView.findViewById(R.id.tvDC);
            tvTNN = itemView.findViewById(R.id.tvTNN);
            tvMDH = itemView.findViewById(R.id.tvMDH);
            btnDaGiaoTienDaGiao = itemView.findViewById(R.id.btnDaGiaoTienDaGiao);
        }
    }
}
