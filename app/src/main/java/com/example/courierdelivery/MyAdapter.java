package com.example.courierdelivery;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MyAdapter extends FirebaseRecyclerAdapter<RequestModel,MyAdapter.MyViewHolder> {

    Context context;
    public MyAdapter(@NonNull FirebaseRecyclerOptions<RequestModel> options, Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i, @NonNull RequestModel requestModel) {
        RequestModel temp=requestModel;

        myViewHolder.email.setText(requestModel.getEmail());
        myViewHolder.fromadd.setText(requestModel.getFrom());
        myViewHolder.toadd.setText(requestModel.getTo());

        myViewHolder.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(context);

                builder.setMessage("Add or Delete courier request :")
                        .setCancelable(true)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try{
                                    HashMap<String ,Object> map=new HashMap();

                                    map.put("email",temp.getEmail());
                                    map.put("type",temp.getType());
                                    map.put("weight",temp.getWeight());
                                    map.put("from",temp.getFrom());
                                    map.put("to",temp.getTo());

                                    FirebaseDatabase.getInstance().getReference().child("Couriers").push()
                                            .setValue(map);

                                    FirebaseDatabase.getInstance().getReference().child("Requests").child(getRef(i).getKey()).removeValue();
                                }
                                catch(Exception e)
                                {
                                        e.printStackTrace();
                                }
                            }
                        })
                .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        FirebaseDatabase.getInstance().getReference().child("Requests").child(getRef(i).getKey()).removeValue();

                    }
                });

                AlertDialog alertDialog= builder.create();
                alertDialog.show();

            }
        });
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design,parent,false);
        return new MyViewHolder(view);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView email,fromadd,toadd;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            email=(TextView) itemView.findViewById(R.id.reqemail);
            fromadd=(TextView) itemView.findViewById(R.id.fromadd);
            toadd=(TextView) itemView.findViewById(R.id.toadd);



        }
    }

}
