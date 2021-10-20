package com.example.book.Screen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
<<<<<<< HEAD
=======
import android.widget.Toast;
>>>>>>> 05701adeeac22d3cf1bc0c0a0b15b465f9e43d10

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.book.MainActivity;
import com.example.book.Object.Shipper;
import com.example.book.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Edit extends AppCompatActivity {
    Toolbar toolbar;
<<<<<<< HEAD
    Button btnLuu;
    EditText etSDT,etHoTen;
=======
    Button btnLuuSuaHoSo;
    EditText txtHoVaTenSuaHoSo;
    EditText txtSoDienThoaiSuaHoSo;
>>>>>>> 05701adeeac22d3cf1bc0c0a0b15b465f9e43d10

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sua_ho_so);
        setControl();
        setEvent();
        getNameShipper();
    }

    private void setEvent() {
<<<<<<< HEAD
        toolbar();
        btnLuu.setOnClickListener(new View.OnClickListener() {
=======
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        // lưu thông tin vào firebase:
        btnLuuSuaHoSo.setOnClickListener(new View.OnClickListener() {
>>>>>>> 05701adeeac22d3cf1bc0c0a0b15b465f9e43d10
            @Override
            public void onClick(View v) {
                if (txtSoDienThoaiSuaHoSo.getText().equals("")) {
                    Toast.makeText(getApplicationContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
                } else if (txtHoVaTenSuaHoSo.getText().equals("")) {
                    Toast.makeText(getApplicationContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("shipper");
                    mDatabase.child(MainActivity.usernameApp).child("name").setValue(txtHoVaTenSuaHoSo.getText().toString());
                    mDatabase.child(MainActivity.usernameApp).child("phone").setValue(txtSoDienThoaiSuaHoSo.getText().toString());
                    onBackPressed();
                }
            }
        });


    }

    public void getNameShipper() {
        ArrayList<Shipper> list = new ArrayList<>();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("shipper");
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Shipper shipp = snapshot.getValue(Shipper.class);
                shipp.setId(snapshot.getKey());
                list.add(shipp);
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).getId().equals(MainActivity.usernameApp)) {
                        txtHoVaTenSuaHoSo.setText(list.get(j).getName());
                        txtSoDienThoaiSuaHoSo.setText(list.get(j).getPhone());
                    }
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Shipper shipp = snapshot.getValue(Shipper.class);
                shipp.setId(snapshot.getKey());
                list.add(shipp);
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).getId().equals(MainActivity.usernameApp)) {
                        txtHoVaTenSuaHoSo.setText(list.get(j).getName());
                        txtSoDienThoaiSuaHoSo.setText(list.get(j).getPhone());
                    }
                }

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
        toolbar = findViewById(R.id.tbEditProfile);
<<<<<<< HEAD
        btnLuu = findViewById(R.id.btnLuu);
        etHoTen = findViewById(R.id.etHoTen);
        etSDT = findViewById(R.id.etSDT);
=======
        btnLuuSuaHoSo = findViewById(R.id.btnLuuSuaHoSo);
        txtHoVaTenSuaHoSo = findViewById(R.id.txtHoVaTenSuaHoSo);
        txtSoDienThoaiSuaHoSo = findViewById(R.id.txtSoDienThoaiSuaHoSo);
>>>>>>> 05701adeeac22d3cf1bc0c0a0b15b465f9e43d10
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