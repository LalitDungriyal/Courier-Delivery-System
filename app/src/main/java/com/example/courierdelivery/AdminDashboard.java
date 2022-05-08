package com.example.courierdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;

public class AdminDashboard extends AppCompatActivity {


    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public void showCouriers(View view)
    {
        Intent intent=new Intent(AdminDashboard.this,ShowCouriers.class);
        startActivity(intent);
    }
    public void showRequests(View view)
    {
        Intent intent=new Intent(AdminDashboard.this,ShowRequests.class);
        startActivity(intent);
    }
    public void trackDeliveryMan(View view)
    {
        Intent intent=new Intent(AdminDashboard.this,TrackPerson.class);
        startActivity(intent);
    }
    public void logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        Intent intent=new Intent(AdminDashboard.this,MainActivity.class);
        startActivity(intent);
    }
}