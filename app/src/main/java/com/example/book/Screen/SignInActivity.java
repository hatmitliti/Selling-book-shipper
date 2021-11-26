package com.example.book.Screen;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.book.Dialog.NotificationDialog;
import com.example.book.MainActivity;
import com.example.book.Object.Shipper;
import com.example.book.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SignInActivity extends AppCompatActivity {
    Button btnLogin;
    EditText txtUsernameLogin;
    EditText txtPasswordLogin;
    FirebaseAuth auth;
    TextView txtQuenMK;
    FirebaseUser mUser;
    private NotificationDialog notificationDialog;
    ArrayList<String> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dang_nhap);
        list = getListShipper();
        notificationDialog = new NotificationDialog(this);
        auth = FirebaseAuth.getInstance();
        mUser = auth.getCurrentUser();
        setControl();
        setEvent();
    }

    private void setEvent() {
        // khi bấm đăng nhập
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUsernameLogin.getText().toString();
                String password = txtPasswordLogin.getText().toString();

                if (username.isEmpty()) {
                    txtUsernameLogin.setError(getResources().getString(R.string.field_empty));
                } else if (password.isEmpty()) {
                    txtPasswordLogin.setError(getResources().getString(R.string.field_empty));
                } else {
                    notificationDialog.startLoadingDialog();
                    auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                boolean check = false;
                                for (int i = 0; i < list.size(); i++) {
                                    if (list.get(i).equals(auth.getUid())) {
                                        check = true;
                                    }
                                }
                                if (check) {
                                    notificationDialog.endLoadingDialog();
                                    MainActivity.usernameApp = auth.getUid();
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                    finish();
                                } else {
                                    notificationDialog.endLoadingDialog();
                                    notificationDialog.startErrorDialog(getResources().getString(R.string.login_failed));
                                    auth.signOut();
                                }


                            } else {
                                notificationDialog.endLoadingDialog();
                                notificationDialog.startErrorDialog(getResources().getString(R.string.login_failed));
                            }
                        }
                    });
                }
            }
        });

        // bấm quên mk:
        txtQuenMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ForgetPasswordActivity.class));
            }
        });
    }

    public ArrayList<String> getListShipper() {
        ArrayList<String> list = new ArrayList<>();
        FirebaseDatabase.getInstance().getReference("shipper")
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        list.add(snapshot.getKey());
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
        return list;
    }

    private void setControl() {
        btnLogin = findViewById(R.id.btnLogin);
        txtPasswordLogin = findViewById(R.id.txtPasswordLogin);
        txtUsernameLogin = findViewById(R.id.txtUsernameLogin);
        txtQuenMK = findViewById(R.id.txtQuenMK);
    }
}
