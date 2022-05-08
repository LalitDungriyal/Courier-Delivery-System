package com.example.courierdelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SendRequest extends AppCompatActivity {

    EditText et1,et2,et3,et4,et5;
    private DatabaseReference databaseReference;
    private DataSnapshot dataSnapshot;
    private FirebaseAuth firebaseAuth;
    public static int index=100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_request);

        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        et1=findViewById(R.id.eml);
        et2=findViewById(R.id.type);
        et3=findViewById(R.id.couwei);
        et4=findViewById(R.id.add1);
        et5=findViewById(R.id.add2);


    }
    public void sendRequest(View view)
    {
        try {
                    String email=et1.getText().toString();
                    String type=et2.getText().toString();
                    String weight=et3.getText().toString();
                    String fromadd=et4.getText().toString();
                    String toadd=et5.getText().toString();
                    RequestDataHolder obj=new RequestDataHolder(email,type,weight,fromadd,toadd);


            HashMap<String,Object> map = new HashMap<>();
            map.put("email",et1.getText().toString());
            map.put("type",et2.getText().toString());
            map.put("weight",et3.getText().toString());
            map.put("from",et4.getText().toString());
            map.put("to",et5.getText().toString());


            FirebaseDatabase.getInstance().getReference().child("Requests").push()
                    .setValue(map);

            et1.setText("");
            et2.setText("");
            et3.setText("");
            et4.setText("");
            et5.setText("");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}