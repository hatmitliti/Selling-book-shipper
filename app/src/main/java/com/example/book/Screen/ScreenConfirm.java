package com.example.book.Screen;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book.Adapter.MyRecyclerViewAdapter;
import com.example.book.MainActivity;
import com.example.book.Object.Confirm;
import com.example.book.R;

import java.util.ArrayList;


public class ScreenConfirm extends AppCompatActivity {
    Toolbar toolbar;
    Button btnConfirm;
    TextView txtMaDonHangXacNhanHuy;
    TextView txtLyDoHuyDon1XacNhanHuy;
    TextView txtLyDoHuyDon2XacNhanHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xac_nhan_ly_do_that_bai);
        setControl();
        setEvent();
        setTooBar();
        setTextData();
    }

    private void setTextData() {
        txtMaDonHangXacNhanHuy.setText(getIntent().getStringExtra("idBill"));
        txtLyDoHuyDon1XacNhanHuy.setText(getIntent().getStringExtra("reason"));
        txtLyDoHuyDon2XacNhanHuy.setText(getIntent().getStringExtra("reason2"));
    }

    private void setTooBar() {
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
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setControl() {
        toolbar = findViewById(R.id.tb);
        btnConfirm = findViewById(R.id.btnConfirm);
        txtMaDonHangXacNhanHuy = findViewById(R.id.txtMaDonHangXacNhanHuy);
        txtLyDoHuyDon1XacNhanHuy = findViewById(R.id.txtLyDoHuyDon1XacNhanHuy);
        txtLyDoHuyDon2XacNhanHuy = findViewById(R.id.txtLyDoHuyDon2XacNhanHuy);
    }
}
