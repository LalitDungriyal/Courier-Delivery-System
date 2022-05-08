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

public class UserLogin extends AppCompatActivity {

    TextInputLayout t1,t2;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        t1=(TextInputLayout)findViewById(R.id.emailuser);
        t2=(TextInputLayout)findViewById(R.id.pwduser);
    }

    public void onUserLogin(View view)
    {
        String email=t1.getEditText().getText().toString();
        String password=t2.getEditText().getText().toString();

        firebaseAuth= FirebaseAuth.getInstance();

        if(email.equals("")!=true && password.equals("")!=true) {
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        t1.getEditText().setText("");
                        t2.getEditText().setText("");
                        Intent intent = new Intent(UserLogin.this, UserDashboard.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(UserLogin.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else
        {
            Toast.makeText(this, "Both Fields are required...", Toast.LENGTH_SHORT).show();
        }
    }
    public void registerUser(View view)
    {
        Intent intent=new Intent(UserLogin.this,UserRegister.class);
        startActivity(intent);
    }
}