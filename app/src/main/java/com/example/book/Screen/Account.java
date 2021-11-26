package com.example.book.Screen;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

import java.util.ArrayList;

public class Account extends AppCompatActivity {
  //  Toolbar toolbar;
    TextView txtHoVaTenQLTK;
    TextView txtSoDienThoaiQLTK;
    TextView txtNgaySinhQLTK;
    TextView txtid;
    TextView txtemail;
    TextView txtluongcb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_quan_ly_tai_khoan);
        setControl();

        // Hiển thị đúng dữ liệu
        getNameShipper();
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
                        txtHoVaTenQLTK.setText(list.get(j).getName());
                        txtSoDienThoaiQLTK.setText(list.get(j).getSdt());
                        txtNgaySinhQLTK.setText(list.get(j).getBirth());

                        txtid.setText(list.get(j).getId());
                        txtemail.setText(list.get(j).getEmail());
                        txtluongcb.setText(list.get(j).getLuongCB() + "");
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
                        txtHoVaTenQLTK.setText(list.get(j).getName());
                        txtSoDienThoaiQLTK.setText(list.get(j).getSdt());
                        txtNgaySinhQLTK.setText(list.get(j).getBirth());

                        txtid.setText(list.get(j).getId());
                        txtemail.setText(list.get(j).getEmail());
                        txtluongcb.setText(list.get(j).getLuongCB() + "");
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
       // toolbar = findViewById(R.id.tb);
        txtHoVaTenQLTK = findViewById(R.id.txtHoVaTenQLTK);
        txtSoDienThoaiQLTK = findViewById(R.id.txtSoDienThoaiQLTK);
        txtNgaySinhQLTK = findViewById(R.id.txtNgaySinhQLTK);
        txtid = findViewById(R.id.txtid);
        txtemail = findViewById(R.id.txtemail);
        txtluongcb = findViewById(R.id.txtluongcb);
    }
}
