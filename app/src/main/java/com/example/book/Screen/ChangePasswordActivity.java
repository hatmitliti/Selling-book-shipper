package com.example.book.Screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.book.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity {
    EditText edtCurrentPassword, edtNewPassword, edtRePassword;
    Button btnChangPassword;
    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //init firebase
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        mapping();
        setEvent();
    }

    private void setEvent() {
        btnChangPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reAuthenticationPassword();
            }
        });
    }

    private void reAuthenticationPassword() {
        String email = user.getEmail();
        String password = edtCurrentPassword.getText().toString().trim();

        if(password.isEmpty()) {
            edtNewPassword.setError("Trường mật khẩu trống!");
        }else {
            AuthCredential credential = EmailAuthProvider
                    .getCredential(email, password);
            user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        changePassword();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Mật khẩu hiện tại không đúng!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void changePassword() {
        user = auth.getCurrentUser();
        String password = edtNewPassword.getText().toString().trim();
        String repassword = edtRePassword.getText().toString().trim();
        if(password.isEmpty()){
            edtNewPassword.setError("Trường mật khẩu trống!");
        }else if(repassword.isEmpty()){
            edtRePassword.setError("Trường nhập lại mật khẩu trống!");
        }else if(!repassword.equalsIgnoreCase(password)){
            edtRePassword.setError("Nhập lại mật khẩu không khớp!");
        }
        else{
            user.updatePassword(password).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Đổi mật khẩu thành công!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Đổi mật khẩu không thành công!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void mapping() {
        edtCurrentPassword = findViewById(R.id.edt_current_password);
        edtNewPassword = findViewById(R.id.edt_change_password);
        edtRePassword = findViewById(R.id.edt_re_enter_password);
        btnChangPassword = findViewById(R.id.btnChangePassword);
    }

}