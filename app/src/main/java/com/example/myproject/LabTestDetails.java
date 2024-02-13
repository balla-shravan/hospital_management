package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetails extends AppCompatActivity {

    TextView packagedetilas,costs;
    EditText etvalue;
    Button back,gotocart;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);
        packagedetilas=(TextView)findViewById(R.id.t2);
        costs=(TextView)findViewById(R.id.t3);
        etvalue=(EditText)findViewById(R.id.e1);
        back=(Button)findViewById(R.id.back);
        gotocart=(Button)findViewById(R.id.cart);
        etvalue.setKeyListener(null);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LabTest.class));
            }
        });
        Intent i=getIntent();
        packagedetilas.setText(i.getStringExtra("text1"));
        etvalue.setText(i.getStringExtra("text2"));
        costs.setText("cost"+i.getStringExtra("text3")+" "+"/-");
     gotocart.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
             String username=sharedPreferences.getString("username","").toString();
             String product=packagedetilas.getText().toString();
             Float price=Float.parseFloat(i.getStringExtra("text3").toString());
             Database db=new Database(getApplicationContext(),"Healthcare",null,1);
             if(db.checkCart(username,product)==1)
             {
                 Toast.makeText(getApplicationContext(),"product is already",Toast.LENGTH_SHORT).show();
             }
             else {
                 db.addcart(username,product,price,"lab");
                 Toast.makeText(getApplicationContext(),"record is inserted",Toast.LENGTH_SHORT).show();
                 startActivity(new Intent(getApplicationContext(),LabTest.class));
             }
         }
     });
    }
}