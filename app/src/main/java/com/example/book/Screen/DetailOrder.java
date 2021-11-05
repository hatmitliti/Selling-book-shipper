package com.example.book.Screen;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.Adapter.MyRecyclerViewAdapterDetail;
import com.example.book.Object.Detail;
import com.example.book.Object.FirebaseConnect;
import com.example.book.Object.ProductInCart;
import com.example.book.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.ArrayList;


public class DetailOrder extends AppCompatActivity {
    Toolbar toolbar;
    Button btnFail, btnCompleted;
    MyRecyclerViewAdapterDetail adapter;
    RecyclerView recyclerView;
    ArrayList<ProductInCart> detailArrayList = new ArrayList<>();

    String nameBill;
    String idBill;
    String addressBill;
    String shipperBill;
    String totalmoneyBill;
    String phoneBill;
    String discountBill;
    String tienThuBill;

    TextView txtNameChiTietDonHang;
    TextView txtPhoneChiTietDonHang;
    TextView txtAddressChiTietDonHang;
    TextView txtTongTienChiTietDonHang;
    TextView txtTienGiamChiTietDonHang;
    TextView txtTienThuChiTietDonHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chi_tiet_don_hang);
        setControl();
        setIntent();
        setEvent();
        setTooBar();
        setTextData();
    }

    private void setTextData() {
        txtNameChiTietDonHang.setText(nameBill);
        txtPhoneChiTietDonHang.setText(phoneBill);
        txtAddressChiTietDonHang.setText(addressBill);
        txtTongTienChiTietDonHang.setText("Tổng tiền: " + totalmoneyBill);
        txtTienGiamChiTietDonHang.setText("Tiền giảm: -" + discountBill);
        txtTienThuChiTietDonHang.setText("Tiền thu: " + tienThuBill);

    }

    private void setIntent() {
        Intent intent = getIntent();
        nameBill = intent.getStringExtra("name");
        idBill = intent.getStringExtra("id");
        addressBill = intent.getStringExtra("address");
        shipperBill = intent.getStringExtra("shipper");
        totalmoneyBill = intent.getStringExtra("totalmoney");
        phoneBill = intent.getStringExtra("phone");
        discountBill = intent.getStringExtra("discount");
        tienThuBill = intent.getStringExtra("tienThuBill");
    }


    private void setTooBar() {
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
        //  detailArrayList.add(new Detail("214DW4364DS", "1000"));
        //  detailArrayList.add(new Detail("214DW4364DS", "1000"));

        getDataInDatabase();
        adapter = new MyRecyclerViewAdapterDetail(this, R.layout.item_chi_tiet_don_hang, detailArrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setAdapter(adapter);

        // bấm thành công
        btnCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseConnect.setcompleteBill(idBill);
                onBackPressed();
            }
        });
        // bấm thất bại
        btnFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseConnect.setcancelingOrders(idBill);
                Intent intent = new Intent(getApplicationContext(),Failure.class);
                intent.putExtra("idBill",idBill);
                startActivity(intent);
            }
        });
    }

    public void getDataInDatabase() {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("bill_detail").child(idBill).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                ProductInCart productInCart = snapshot.getValue(ProductInCart.class);
                detailArrayList.add(productInCart);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

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
        toolbar = findViewById(R.id.tb);
        recyclerView = findViewById(R.id.rv);
        btnCompleted = findViewById(R.id.btnCompleted);
        btnFail = findViewById(R.id.btnFail);

        txtNameChiTietDonHang = findViewById(R.id.txtNameChiTietDonHang);
        txtPhoneChiTietDonHang = findViewById(R.id.txtPhoneChiTietDonHang);
        txtAddressChiTietDonHang = findViewById(R.id.txtAddressChiTietDonHang);
        txtTongTienChiTietDonHang = findViewById(R.id.txtTongTienChiTietDonHang);
        txtTienGiamChiTietDonHang = findViewById(R.id.txtTienGiamChiTietDonHang);
        txtTienThuChiTietDonHang = findViewById(R.id.txtTienThuChiTietDonHang);
    }
}