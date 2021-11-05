package com.example.book.Screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.book.R;

public class ScreenKH extends AppCompatActivity {
    Toolbar toolbar;
    Button btnHDH, btnTDH;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ly_do_khach_huy);
        setConTrol();
        setEvent();
    }

    private void setEvent() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnHDH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Intent intent1 = new Intent(getApplicationContext(), ScreenConfirm.class);
                intent1.putExtra("idBill", intent.getStringExtra("idBill"));
                intent1.putExtra("reason", intent.getStringExtra("reason"));
                intent1.putExtra("reason2", btnHDH.getText());
                startActivity(intent1);
            }
        });

        btnTDH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Intent intent1 = new Intent(getApplicationContext(), ScreenConfirm.class);
                intent1.putExtra("idBill", intent.getStringExtra("idBill"));
                intent1.putExtra("reason", intent.getStringExtra("reason"));
                intent1.putExtra("reason2", btnHDH.getText());
                startActivity(intent1);
            }
        });
    }

    private void setConTrol() {
        toolbar = findViewById(R.id.tb);
        btnHDH = findViewById(R.id.btnHDH);
        btnTDH = findViewById(R.id.btnTDH);
    }
}
