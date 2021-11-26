package com.example.book.Screen;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.Adapter.MyRecyclerViewAdapterDelivered;
import com.example.book.MainActivity;
import com.example.book.Object.Bill;
import com.example.book.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class ScreenDelivered extends AppCompatActivity {
  //  Toolbar toolbar;
    MyRecyclerViewAdapterDelivered adapter;
    RecyclerView recyclerView;
    ArrayList<Bill> deliveredArrayList = new ArrayList<>();
    ArrayList<String> mKey = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_don_hang_da_giao);
        setControl();
        setEvent();
        // toolbarr
        Toolbar toolbar = findViewById(R.id.toolbar);
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
        // deliveredArrayList.add(new Delivered("Đã giao","123,Trường Thọ,Thủ Đức,Tp.HCM","Nguyễn Văn Tèo","214DW4364DS","Đã giao tiền"));
        // deliveredArrayList.add(new Delivered("Đã giao","123,Trường Thọ,Thủ Đức,Tp.HCM","Nguyễn Văn Tèo","214DW4364DS","Chưa giao tiền"));

        getDataInDatabase();
        adapter = new MyRecyclerViewAdapterDelivered(this, R.layout.item_don_hang_da_giao, deliveredArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setAdapter(adapter);
    }

    public void loc() {
        for (int j = 0; j < deliveredArrayList.size(); j++) {
            if (deliveredArrayList.get(j).getStatus() != 5) {
                deliveredArrayList.remove(j);
                //  mKey.remove(j);
            }
        }
        adapter.notifyDataSetChanged();
    }

    private void getDataInDatabase() {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("bills").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Bill bill = snapshot.getValue(Bill.class);
                bill.setId(snapshot.getKey());
                if (bill.getShipper().equals(MainActivity.usernameApp)) {
                    if (bill.getStatus() == 5) {
                        deliveredArrayList.add(bill);
                        String key = snapshot.getKey();
                        mKey.add(key);
                    }
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // lấy địa chỉ id của đối tượng vừa bị thay đổi bên trong mảng mkey
                String key = snapshot.getKey();
                Bill bill = snapshot.getValue(Bill.class);
                bill.setId(snapshot.getKey());

                int index = mKey.indexOf(key);
                if (index != -1) {
                    mKey.remove(index);
                    deliveredArrayList.remove(index);
                }
                loc();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void setControl() {
      //  toolbar = findViewById(R.id.tb);
        recyclerView = findViewById(R.id.rv);
    }
}