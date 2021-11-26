package com.example.book.Screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.book.R;

public class ScreenTDTT extends AppCompatActivity {
  //  Toolbar toolbar;
    Button btnTTNG, btnTTDD;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ly_do_thay_doi_thong_tin);
        setConTrol();
        setEvent();
    }

    private void setEvent() {
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

        btnTTNG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Intent intent1 = new Intent(getApplicationContext(), ScreenConfirm.class);
                intent1.putExtra("idBill", intent.getStringExtra("idBill"));
                intent1.putExtra("reason", intent.getStringExtra("reason"));
                intent1.putExtra("reason2", btnTTNG.getText());
                startActivity(intent1);
            }
        });
        btnTTDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Intent intent1 = new Intent(getApplicationContext(), ScreenConfirm.class);
                intent1.putExtra("idBill", intent.getStringExtra("idBill"));
                intent1.putExtra("reason", intent.getStringExtra("reason"));
                intent1.putExtra("reason2", btnTTDD.getText());
                startActivity(intent1);
            }
        });
    }

    private void setConTrol() {
     //   toolbar = findViewById(R.id.tb);
        btnTTNG = findViewById(R.id.btnTTNG);
        btnTTDD = findViewById(R.id.btnTTDD);
    }
}
