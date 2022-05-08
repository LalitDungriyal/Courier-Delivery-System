package com.example.courierdelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ShowCouriers extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter2 myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_couriers);

        getSupportActionBar().hide();

        recyclerView=(RecyclerView)findViewById(R.id.recview2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<RequestModel> options=new FirebaseRecyclerOptions.Builder<RequestModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Couriers"),RequestModel.class).build();


        myAdapter=new MyAdapter2(options);
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