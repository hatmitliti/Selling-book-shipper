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
import com.example.book.Object.Delivery;
import com.example.book.Object.FirebaseConnect;
import com.example.book.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapterNeedDelivery extends RecyclerView.Adapter<MyRecyclerViewAdapterNeedDelivery.MyHolderViewNeedDelivery> {
    private Activity context;
    private int layoutID;
    private ArrayList<Bill> deliveryArrayList;

    public MyRecyclerViewAdapterNeedDelivery(Activity context, int layoutID, ArrayList<Bill> deliveryArrayList) {
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
        Bill delivery = deliveryArrayList.get(position);
        holder.tvTT.setText("Cần giao");
        holder.tvDC.setText(delivery.getAddress());
        holder.tvTNN.setText(delivery.getName());
        holder.tvMDH.setText(delivery.getId());

        // bấm xác nhận để nhận đơn và đi giao
        holder.btnDaNhanHangCanGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseConnect.setOrderReceivedBill(delivery);

            }
        });
        // bấm hủy đơn hàng sẽ quay lại trạng thái đã đóng gói
        holder.btnHuyHangCanGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseConnect.setOrderCancelBill(delivery);
            }
        });

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
        Button btnDaNhanHangCanGiao;
        Button btnHuyHangCanGiao;

        public MyHolderViewNeedDelivery(@NonNull View itemView) {
            super(itemView);
            tvTT = itemView.findViewById(R.id.tvTT);
            tvDC = itemView.findViewById(R.id.tvDC);
            tvTNN = itemView.findViewById(R.id.tvTNN);
            tvMDH = itemView.findViewById(R.id.tvMDH);
            btnDaNhanHangCanGiao = itemView.findViewById(R.id.btnDaNhanHangCanGiao);
            btnHuyHangCanGiao = itemView.findViewById(R.id.btnHuyHangCanGiao);
        }
    }
}
