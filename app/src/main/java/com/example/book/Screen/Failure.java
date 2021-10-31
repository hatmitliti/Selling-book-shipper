package com.example.book.Screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.book.R;

public class Failure extends AppCompatActivity {
    TextView txtMaDHThatBai;
    Toolbar toolbar;
    Button btnKLLD, btnTDTT, btnKH;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ly_do_that_bai);
         intent = getIntent();
        setControl();
        //txtMaDHThatBai.setText(intent.getStringExtra("idBill"));
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



        btnKLLD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),ScreenKLLD.class);
                intent1.putExtra("idBill",intent.getStringExtra("idBill"));
                intent1.putExtra("reason",btnKLLD.getText());
                startActivity(intent1);
            }
        });

        btnTDTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),ScreenTDTT.class);
                intent1.putExtra("idBill",intent.getStringExtra("idBill"));
                intent1.putExtra("reason",btnKLLD.getText());
                startActivity(intent1);
            }
        });

        btnKH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),ScreenKH.class);
                intent1.putExtra("idBill",intent.getStringExtra("idBill"));
                intent1.putExtra("reason",btnKLLD.getText());
                startActivity(intent1);
            }
        });
    }

    private void setControl() {
        toolbar = findViewById(R.id.tb);
        btnKH = findViewById(R.id.btnKH);
        btnKLLD = findViewById(R.id.btnKLLD);
        btnTDTT = findViewById(R.id.btnTDTT);
        txtMaDHThatBai = findViewById(R.id.txtMaDHThatBai);
    }
}