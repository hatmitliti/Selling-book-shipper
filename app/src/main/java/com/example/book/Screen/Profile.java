package com.example.book.Screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.book.MainActivity;
import com.example.book.Object.FirebaseConnect;
import com.example.book.Object.Shipper;
import com.example.book.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Profile extends Fragment {
    Button btnEdit, btnAccount, btnLogOut, btnForgotPassword, btnChangePassword;
    TextView txtHoTenShipperInHoSo;
    Shipper shipper = new Shipper();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_ho_so, container, false);
        btnEdit = view.findViewById(R.id.btnEdit);
        btnAccount = view.findViewById(R.id.btnAccount);
        btnLogOut = view.findViewById(R.id.btnLogOut);
        btnForgotPassword = view.findViewById(R.id.btnForgotPassword);
        txtHoTenShipperInHoSo = view.findViewById(R.id.txtHoTenShipperInHoSo);
        btnChangePassword = view.findViewById(R.id.btnProfile_ChangePassword);

        getNameShipper();
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Edit.class));
            }
        });
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Account.class));
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(), SignInActivity.class));
                getActivity().finishAffinity();
            }
        });
        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPassword();
            }
        });
        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ChangePasswordActivity.class));
            }
        });
        return view;
    }

    private void forgotPassword() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String email = mUser.getEmail();
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getActivity(), "Gửi email đổi mật khẩu thành công. Vui lòng kiểm tra email!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Gửi email đổi mật khẩu thất bại!", Toast.LENGTH_SHORT).show();
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
                //   if (shipp.getId().equals())
                shipp.setId(snapshot.getKey());
                list.add(shipp);
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).getId().equals(MainActivity.usernameApp)) {
                        shipper = list.get(j);
                        txtHoTenShipperInHoSo.setText(shipper.getName());
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
                        shipper = list.get(j);
                        txtHoTenShipperInHoSo.setText(shipper.getName());
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
}
