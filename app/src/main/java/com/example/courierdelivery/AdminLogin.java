package com.example.courierdelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminLogin extends AppCompatActivity {

    TextInputLayout t1,t2;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        t1=(TextInputLayout)findViewById(R.id.reqemail);
        t2=(TextInputLayout)findViewById(R.id.pwd);

    }

    public void onAdminLogin(View view)
    {
        String email=t1.getEditText().getText().toString();
        String password=t2.getEditText().getText().toString();

            if (email.equals("lalitdungriyal4@gmail.com")) {

                if(password.equals(""))
                {
                    Toast.makeText(this, "Password cannot be null", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    firebaseAuth = FirebaseAuth.getInstance();

                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {

                        if (task.isSuccessful()) {
                            t1.getEditText().setText("");
                            t2.getEditText().setText("");

                            Intent intent = new Intent(AdminLogin.this, AdminDashboard.class);
                            startActivity(intent);

                        } else {
                           Toast.makeText(AdminLogin.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            } else {
                Toast.makeText(this, "Login failed..Because the user is not admin...", Toast.LENGTH_SHORT).show();
            }

    }
}