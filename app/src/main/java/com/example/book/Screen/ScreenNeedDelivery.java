package com.example.book.Screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.Adapter.MyRecyclerViewAdapterNeedDelivery;
import com.example.book.MainActivity;
import com.example.book.Object.Delivery;
import com.example.book.R;

import java.util.ArrayList;

public class ScreenNeedDelivery extends AppCompatActivity {
    Toolbar toolbar;
    MyRecyclerViewAdapterNeedDelivery adapter;
    RecyclerView recyclerView;
    ArrayList<Delivery> deliveryArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_don_hang_can_giao);
        setControl();
        Toolbar();
        setEvent();
    }

    private void setEvent() {

        deliveryArrayList.add(new Delivery("Cần giao", "123,Trường Thọ,Thủ Đức,Tp.HCM", "Nguyễn Văn Tèo", "214DW4364DS"));
        deliveryArrayList.add(new Delivery("Cần giao", "123,Trường Thọ,Thủ Đức,Tp.HCM", "Nguyễn Văn Tèo", "214DW4364DS"));
        adapter = new MyRecyclerViewAdapterNeedDelivery(this, R.layout.item_don_hang_can_giao, deliveryArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setAdapter(adapter);
    }

    private void setControl() {
        toolbar = findViewById(R.id.tb);
        recyclerView = findViewById(R.id.rv);
    }
    private void Toolbar(){
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
}
