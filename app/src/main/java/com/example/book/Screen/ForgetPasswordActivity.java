package com.example.book.Screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.book.Dialog.NotificationDialog;
import com.example.book.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ForgetPasswordActivity extends AppCompatActivity {
    private NotificationDialog notificationDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        notificationDialog = new NotificationDialog(this);

        EditText txtmailFogotPass = findViewById(R.id.txtmailFogotPass);
        Button btnGuiMail = findViewById(R.id.btnGuiMail);

        btnGuiMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mail = txtmailFogotPass.getText().toString().trim();
                if (mail.equals("")) {
                    txtmailFogotPass.setError(getResources().getString(R.string.field_empty));
                } else {
                    notificationDialog.startLoadingDialog();
                    FirebaseAuth mAuth = FirebaseAuth.getInstance();
                    mAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                notificationDialog.endLoadingDialog();
                                notificationDialog.startSuccessfulDialog(getResources().getString(R.string.send_email_reset_success));
                            } else {
                                notificationDialog.endLoadingDialog();
                                notificationDialog.startSuccessfulDialog(getResources().getString(R.string.send_email_reset_failed));
                            }
                        }
                    });
                }
            }
        });


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
}