package com.example.book.Screen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.book.R;

public class Edit extends AppCompatActivity {
    Toolbar toolbar;
    Button btnLuu;
    EditText etSDT,etHoTen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sua_ho_so);
        setControl();
        setEvent();
    }

    private void setEvent() {
        toolbar();
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setControl() {
        toolbar = findViewById(R.id.tbEditProfile);
        btnLuu = findViewById(R.id.btnLuu);
        etHoTen = findViewById(R.id.etHoTen);
        etSDT = findViewById(R.id.etSDT);
    }
    private void toolbar() {
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

}