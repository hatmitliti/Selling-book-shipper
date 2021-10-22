package com.example.book.Screen;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.book.MainActivity;
import com.example.book.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    Button btnLogin;
    EditText txtUsernameLogin;
    EditText txtPasswordLogin;
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dang_nhap);
        setControl();
        setEvent();
    }

    private void setEvent() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Cảnh báo");
        // khi bấm đăng nh  ập
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUsernameLogin.getText().toString();
                String password = txtPasswordLogin.getText().toString();
                if (username.isEmpty()) {
                    b.setMessage("Vui long nhập tài khoản");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog al = b.create();
                    al.show();
                    //Toast.makeText(getApplicationContext(), "Vui lòng nhập tài khoản!", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    b.setMessage("Vui long nhập mật khẩu");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog al = b.create();
                    al.show();
                    //Toast.makeText(getApplicationContext(), "Vui lòng nhập mật khẩu!", Toast.LENGTH_SHORT).show();
                } else {
                    auth = FirebaseAuth.getInstance();
                    auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                MainActivity.usernameApp = auth.getUid();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else {
                                b.setMessage("Sai tài khoản hoặc mật khẩu!");
                                b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                });
                                AlertDialog al = b.create();
                                al.show();
                                //Toast.makeText(getApplicationContext(), "Sai tài khoản hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }


    private void setControl() {
        btnLogin = findViewById(R.id.btnLogin);
        txtPasswordLogin = findViewById(R.id.txtPasswordLogin);
        txtUsernameLogin = findViewById(R.id.txtUsernameLogin);
    }
}
