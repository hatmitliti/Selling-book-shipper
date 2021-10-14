package com.example.book.Screen;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.Adapter.MyRecyclerViewAdapterDetail;
import com.example.book.Object.Detail;
import com.example.book.R;

import java.util.ArrayList;


public class DetailOrder extends AppCompatActivity {
    Toolbar toolbar;
    Button btnFail,btnCompleted;
    MyRecyclerViewAdapterDetail adapter;
    RecyclerView recyclerView;
    ArrayList<Detail> detailArrayList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chi_tiet_don_hang);
        setControl();
        setEvent();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScreenDelivering.class));
            }
        });
    }

    private void setEvent() {
        detailArrayList.add(new Detail("214DW4364DS","1000"));
        detailArrayList.add(new Detail("214DW4364DS","1000"));
        adapter =new MyRecyclerViewAdapterDetail(this,R.layout.item_chi_tiet_don_hang,detailArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setAdapter(adapter);

        btnCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScreenDelivered.class));
            }
        });
        btnFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Failure.class));
            }
        });
    }

    private void setControl() {
        toolbar = findViewById(R.id.tb);
        recyclerView = findViewById(R.id.rv);
        btnCompleted = findViewById(R.id.btnCompleted);
        btnFail = findViewById(R.id.btnFail);
    }
}