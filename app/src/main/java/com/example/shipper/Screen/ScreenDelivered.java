package com.example.shipper.Screen;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shipper.Adapter.MyRecyclerViewAdapterDelivered;
import com.example.shipper.MainActivity;
import com.example.shipper.Object.Delivered;
import com.example.shipper.R;

import java.util.ArrayList;


public class ScreenDelivered extends AppCompatActivity {
    Toolbar toolbar;
    MyRecyclerViewAdapterDelivered adapter;
    RecyclerView recyclerView;
    ArrayList<Delivered> deliveredArrayList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_don_hang_da_giao);
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
        deliveredArrayList.add(new Delivered("Đã giao","123,Trường Thọ,Thủ Đức,Tp.HCM","Nguyễn Văn Tèo","214DW4364DS","Đã giao tiền"));
        deliveredArrayList.add(new Delivered("Đã giao","123,Trường Thọ,Thủ Đức,Tp.HCM","Nguyễn Văn Tèo","214DW4364DS","Chưa giao tiền"));
        adapter =new MyRecyclerViewAdapterDelivered(this,R.layout.item_don_hang_da_giao,deliveredArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setAdapter(adapter);
    }

    private void setControl() {
        toolbar = findViewById(R.id.tb);
        recyclerView = findViewById(R.id.rv);
    }
}