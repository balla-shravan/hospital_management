package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        CardView back=(CardView)findViewById (R.id.cardback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        CardView familyphysician =(CardView) findViewById(R.id.cardfamilyphysician);
       familyphysician.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(getApplicationContext(),DoctorDetails.class);
               i.putExtra("title","family physician");
               startActivity(i);
           }
       });
        CardView diet =(CardView) findViewById(R.id.carddiet);
        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),DoctorDetails.class);
                i.putExtra("title","dietition");
                startActivity(i);
            }
        });
        CardView dentisit =(CardView) findViewById(R.id.carddentist);
        dentisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),DoctorDetails.class);
                i.putExtra("title","dentist");
                startActivity(i);
            }
        });

        CardView surgeon =(CardView) findViewById(R.id.cardsurgon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),DoctorDetails.class);
                i.putExtra("title","surgeon");
                startActivity(i);
            }
        });
        CardView cardio =(CardView) findViewById(R.id.cardcardiologist);
        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),DoctorDetails.class);
                i.putExtra("title","cardio");
                startActivity(i);
            }
        });
    }
}