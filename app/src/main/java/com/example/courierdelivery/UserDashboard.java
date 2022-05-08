package com.example.courierdelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserDashboard extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    TextView tvemail;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tvemail=(TextView)findViewById(R.id.useremail);
        tvemail.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());

        cardView=(CardView)findViewById(R.id.cardView2);



    }

    public void sendRequest(View view)
    {
        Intent intent=new Intent(UserDashboard.this,SendRequest.class);
        startActivity(intent);
    }
    public void showOrders(View view)
    {
        Intent intent=new Intent(UserDashboard.this,ShowOrders.class);
        startActivity(intent);
    }
    public void trackDeliveryPerson(View view)
    {
        Intent intent=new Intent(UserDashboard.this,TrackPerson.class);
        startActivity(intent);
    }
    public void logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        Intent intent=new Intent(UserDashboard.this,MainActivity.class);
        startActivity(intent);
    }
}