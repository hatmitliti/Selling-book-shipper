package com.example.book.Screen;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
    Button btnLuuSuaHoSo;
    EditText txtHoVaTenSuaHoSo;
    EditText txtSoDienThoaiSuaHoSo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sua_ho_so);
        setControl();
        setEvent();
        getNameShipper();
    }

    private void setEvent() {
        toolbar();

        // lưu thông tin vào firebase:
        btnLuuSuaHoSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtSoDienThoaiSuaHoSo.getText().toString().isEmpty()) {
                    Dialog();
                    //Toast.makeText(getApplicationContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
                } else if (txtHoVaTenSuaHoSo.getText().toString().isEmpty()) {
                    Dialog();
                    //Toast.makeText(getApplicationContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("shipper");
                    mDatabase.child(MainActivity.usernameApp).child("name").setValue(txtHoVaTenSuaHoSo.getText().toString());
                    mDatabase.child(MainActivity.usernameApp).child("phone").setValue(txtSoDienThoaiSuaHoSo.getText().toString());
                    onBackPressed();
                }
            }
        });


    }
    private void Dialog(){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Cảnh báo");
        b.setMessage("Không được để trống");
        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog al = b.create();
        al.show();
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
        btnLuuSuaHoSo = findViewById(R.id.btnLuuSuaHoSo);
        txtHoVaTenSuaHoSo = findViewById(R.id.txtHoVaTenSuaHoSo);
        txtSoDienThoaiSuaHoSo = findViewById(R.id.txtSoDienThoaiSuaHoSo);

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