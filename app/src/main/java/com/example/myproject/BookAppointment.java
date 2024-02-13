package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BookAppointment extends AppCompatActivity {
  EditText name,address,contact,fee;
  TextView text;
  Button back,book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        text=(TextView) findViewById(R.id.t2);
        name=(EditText) findViewById(R.id.e1);
        address=(EditText) findViewById(R.id.e2);
        contact=(EditText) findViewById(R.id.e3);
        fee=(EditText) findViewById(R.id.e4);
        back=(Button)findViewById(R.id.b1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DoctorDetails.class));
            }
        });
        name.setKeyListener(null);
        address.setKeyListener(null);
        contact.setKeyListener(null);
        fee.setKeyListener(null);
        Intent i=getIntent();
        String s=i.getStringExtra("text1");
        String s1=i.getStringExtra("text2");
        String s2=i.getStringExtra("text3");
        String s3=i.getStringExtra("text4");
        String s4=i.getStringExtra("text5");
        text.setText(s);
        name.setText(s1);
        address.setText(s3);
        contact.setText(s2);
        fee.setText(s4);
        book=(Button) findViewById(R.id.b2);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}