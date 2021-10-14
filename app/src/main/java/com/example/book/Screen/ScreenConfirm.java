package com.example.book.Screen;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.Adapter.MyRecyclerViewAdapter;
import com.example.book.Object.Confirm;
import com.example.book.R;

import java.util.ArrayList;


public class ScreenConfirm extends AppCompatActivity {
    Toolbar toolbar;
    MyRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Confirm> confirmArrayList =new ArrayList<>();
    Button btnConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xac_nhan_ly_do_that_bai);
        setControl();
        setEvent();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setEvent() {
        confirmArrayList.add(new Confirm("214DW4364DS","Khách muốn hủy đơn hàng"));
        confirmArrayList.add(new Confirm("214DW4364DS","Khách muốn hủy đơn hàng"));
        adapter =new MyRecyclerViewAdapter(this,R.layout.item_xac_nhan_ly_do_that_bai,confirmArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setAdapter(adapter);


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ScreenCanceled.class));
            }
        });
    }

    private void setControl() {
        toolbar = findViewById(R.id.tb);
        recyclerView = findViewById(R.id.rv);
        btnConfirm = findViewById(R.id.btnConfirm);
    }
}
