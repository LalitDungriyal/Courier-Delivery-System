package com.example.courierdelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UserRegister extends AppCompatActivity {

    EditText e1,e2,e3,p1,p2;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        e1=findViewById(R.id.et1);
        e2=findViewById(R.id.et2);
        e3=findViewById(R.id.et3);
        p1=findViewById(R.id.p1);
        p2=findViewById(R.id.p2);


    }

    public void register(View view)
    {
        String email=e2.getText().toString();
        String password=p1.getText().toString();
        String name=e1.getText().toString();
        String num=e3.getText().toString();
        firebaseAuth= FirebaseAuth.getInstance();


       if(password.equals(p2.getText().toString())==true)
        {
            if(name.equals("")==true)
            {
                Toast.makeText(this, "Name field is required", Toast.LENGTH_SHORT).show();
            }
            else if(email.equals("")==true)
            {
                Toast.makeText(this, "Email field is required", Toast.LENGTH_SHORT).show();
            }
            else if(num.equals("")==true)
            {
                Toast.makeText(this, "Num field is required", Toast.LENGTH_SHORT).show();
            }
            else if(password.equals("")==true)
            {
                Toast.makeText(this, "password required", Toast.LENGTH_SHORT).show();
            }
            else
            {

                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){

                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            HashMap<String ,Object> map=new HashMap<String,Object>();
                            map.put("email",email);
                            map.put("Name",name);
                            map.put("Number",num);

                            FirebaseDatabase.getInstance().getReference().child("Users").push().setValue(map);

                            Intent intent=new Intent(UserRegister.this,UserLogin.class);
                            startActivity(intent);
                        }
                        else
                            {
                            Toast.makeText(UserRegister.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
        else
        {
            Toast.makeText(this, "Password Not Matching...", Toast.LENGTH_SHORT).show();
        }
    }


}