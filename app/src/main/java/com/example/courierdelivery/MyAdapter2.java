package com.example.courierdelivery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapter2 extends FirebaseRecyclerAdapter<RequestModel,MyAdapter2.MyViewHolder2> {

    public MyAdapter2(@NonNull FirebaseRecyclerOptions<RequestModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder2 myViewHolder2, int i, @NonNull RequestModel requestModel) {

        myViewHolder2.email.setText(requestModel.getEmail());
        myViewHolder2.fromadd.setText(requestModel.getFrom());
        myViewHolder2.toadd.setText(requestModel.getTo());

    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design,parent,false);
        return new MyViewHolder2(view);
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder{

        TextView email,fromadd,toadd;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);

            email=(TextView) itemView.findViewById(R.id.reqemail);
            fromadd=(TextView) itemView.findViewById(R.id.fromadd);
            toadd=(TextView) itemView.findViewById(R.id.toadd);

        }
    }
}
