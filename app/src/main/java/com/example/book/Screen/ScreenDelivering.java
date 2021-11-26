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

import com.example.book.Adapter.RecyclerViewAdapterDelivering;
import com.example.book.MainActivity;
import com.example.book.Object.Bill;
import com.example.book.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.ArrayList;


public class ScreenDelivering extends AppCompatActivity {
    //Toolbar toolbar;
    RecyclerViewAdapterDelivering adapter;
    RecyclerView recyclerView;
    ArrayList<Bill> deliveringArrayList = new ArrayList<>();
    ArrayList<String> mKey = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_don_hang_dang_giao);
        setControl();
        setEvent();
        setTooBar();
    }


    private void setTooBar() {
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
        //  deliveringArrayList.add(new Delivering("Đang giao","123,Trường Thọ,Thủ Đức,Tp.HCM","Nguyễn Văn Tèo","214DW4364DS"));
        // deliveringArrayList.add(new Delivering("Đang giao","123,Trường Thọ,Thủ Đức,Tp.HCM","Nguyễn Văn Tèo","214DW4364DS"));

        getDataInDatabase();
        adapter = new RecyclerViewAdapterDelivering(this, R.layout.item_don_hang_dang_giao, deliveringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        adapter.setDelegation(new RecyclerViewAdapterDelivering.MyItemOnClick() {
            @Override
            public void getDeliveringInforation(Bill bill) {
                Intent intent = new Intent(getApplicationContext(), DetailOrder.class);
                intent.putExtra("name", bill.getName());
                intent.putExtra("id", bill.getId());
                intent.putExtra("address", bill.getAddress());
                intent.putExtra("shipper", bill.getShipper());
                intent.putExtra("totalmoney", NumberFormat.getInstance().format(bill.getTotalMoney()));
                intent.putExtra("phone", bill.getPhone());
                intent.putExtra("discount", NumberFormat.getInstance().format(bill.getDiscount()));
                intent.putExtra("tienThuBill", NumberFormat.getInstance().format((bill.getTotalMoney() - bill.getDiscount())) + "");
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
    }

    public void loc() {
        for (int j = 0; j < deliveringArrayList.size(); j++) {
            if (deliveringArrayList.get(j).getStatus() != 4) {
                deliveringArrayList.remove(j);
               // mKey.remove(j);
            }
        }
        adapter.notifyDataSetChanged();
    }

    private void getDataInDatabase() {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        //deliveringArrayList.clear();
        mDatabase.child("bills").addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Bill bill = snapshot.getValue(Bill.class);
                bill.setId(snapshot.getKey());
                if (bill.getShipper().equals(MainActivity.usernameApp)) {
                    if (bill.getStatus() == 4) {
                        deliveringArrayList.add(bill);
                        mKey.add(snapshot.getKey());
                    }
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                // lấy địa chỉ id của đối tượng vừa bị thay đổi bên trong mảng mkey
                String key = snapshot.getKey();
                Bill bill = snapshot.getValue(Bill.class);
                int index = mKey.indexOf(key);
                if (index != -1) {
                  mKey.remove(index);
                    deliveringArrayList.remove(index);
                }
                loc();

//                String key = snapshot.getKey();
//                Bill bill = snapshot.getValue(Bill.class);
//                bill.setId(snapshot.getKey());
//                int index = mKey.indexOf(key);
//                deliveringArrayList.set(index, bill);

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