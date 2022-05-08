package com.example.courierdelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ShowRequests extends AppCompatActivity
{
        private RecyclerView recyclerView;
        private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_requests);

        getSupportActionBar().hide();

        recyclerView=(RecyclerView)findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<RequestModel> options=new FirebaseRecyclerOptions.Builder<RequestModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Requests"),RequestModel.class).build();

        myAdapter=new MyAdapter(options,this);
        recyclerView.setAdapter(myAdapter);


    }
    public void onStart()
    {
        super.onStart();
        myAdapter.startListening();
    }
    public void onStop()
    {
        super.onStop();
        myAdapter.stopListening();
    }

}