package com.example.courierdelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ShowOrders extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter2 myAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_orders);

        getSupportActionBar().hide();

        //Toast.makeText(this,  FirebaseAuth.getInstance().getCurrentUser().getEmail().toString(), Toast.LENGTH_SHORT).show();
        recyclerView=(RecyclerView)findViewById(R.id.recview3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<RequestModel> options=new FirebaseRecyclerOptions.Builder<RequestModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Couriers").orderByChild("email").equalTo(FirebaseAuth.getInstance().getCurrentUser().getEmail()),RequestModel.class).build();

        myAdapter2=new MyAdapter2(options);
        recyclerView.setAdapter(myAdapter2);
    }
    @Override
    public void onStart()
    {
        super.onStart();
        myAdapter2.startListening();
    }
    @Override
    public void onStop()
    {
        super.onStop();
        myAdapter2.stopListening();
    }
}