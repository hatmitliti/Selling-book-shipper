package com.example.book.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.Object.ProductInCart;
import com.example.book.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapterDetail extends RecyclerView.Adapter<MyRecyclerViewAdapterDetail.MyViewHolder> {
    private Activity context;
    private int layoutID;
    private ArrayList<ProductInCart> detailArrayList;

    public MyRecyclerViewAdapterDetail(Activity context, int layoutID, ArrayList<ProductInCart> detailArrayList) {
        this.context = context;
        this.layoutID = layoutID;
        this.detailArrayList = detailArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        CardView view = (CardView) layoutInflater.inflate(viewType, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProductInCart detail = detailArrayList.get(position);
        holder.txtNameProductInCartDetail.setText(detail.getName());
        holder.txtPriceProductInCartDetail.setText(detail.getPrice() + "");
        holder.txtQualityProductInCartDetail.setText("x" + detail.getQuality());
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
        TextView txtNameProductInCartDetail, txtPriceProductInCartDetail, txtQualityProductInCartDetail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameProductInCartDetail = itemView.findViewById(R.id.txtNameProductInCartDetail);
            txtPriceProductInCartDetail = itemView.findViewById(R.id.txtPriceProductInCartDetail);
            txtQualityProductInCartDetail = itemView.findViewById(R.id.txtQualityProductInCartDetail);
        }
    }
}
