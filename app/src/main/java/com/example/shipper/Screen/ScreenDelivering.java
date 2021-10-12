package com.example.shipper.Screen;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shipper.Adapter.RecyclerViewAdapterDelivering;
import com.example.shipper.MainActivity;
import com.example.shipper.Object.Delivering;
import com.example.shipper.R;

import java.util.ArrayList;


public class ScreenDelivering extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerViewAdapterDelivering adapter;
    RecyclerView recyclerView;
    ArrayList<Delivering> deliveringArrayList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_don_hang_dang_giao);
        setControl();
        setEvent();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    private void setEvent() {
        deliveringArrayList.add(new Delivering("Đang giao","123,Trường Thọ,Thủ Đức,Tp.HCM","Nguyễn Văn Tèo","214DW4364DS"));
        deliveringArrayList.add(new Delivering("Đang giao","123,Trường Thọ,Thủ Đức,Tp.HCM","Nguyễn Văn Tèo","214DW4364DS"));
        adapter =new RecyclerViewAdapterDelivering(this,R.layout.item_don_hang_dang_giao,deliveringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        adapter.setDelegation(new RecyclerViewAdapterDelivering.MyItemOnClick() {
            @Override
            public void getDeliveringInforation(Delivering delivering) {
                startActivity(new Intent(getApplicationContext(),DetailOrder.class));
            }
        });

        recyclerView.setAdapter(adapter);
    }

    private void setControl() {
        toolbar = findViewById(R.id.tb);
        recyclerView = findViewById(R.id.rv);
    }
}