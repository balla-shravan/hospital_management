package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "welcome  "+username, Toast.LENGTH_SHORT).show();

        CardView exit=(CardView) findViewById(R.id.card6);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                Toast.makeText(getApplicationContext(), "log out success full", Toast.LENGTH_SHORT).show();
            }
        });
        CardView finddoctor=(CardView) findViewById(R.id.card3);
        finddoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FindDoctor.class));
                Toast.makeText(getApplicationContext(), "doctor details opened", Toast.LENGTH_SHORT).show();
            }
        });
        CardView labtest=(CardView) findViewById(R.id.card1);
        labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LabTest.class));
                Toast.makeText(getApplicationContext(), "Lab Test opened", Toast.LENGTH_SHORT).show();
            }
        });
        CardView orderdetails=(CardView) findViewById(R.id.card5);
        orderdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), OrderDetails.class));
                Toast.makeText(getApplicationContext(), "order details opened", Toast.LENGTH_SHORT).show();
            }
        });
        CardView buymedicines=(CardView) findViewById(R.id.card2);
        buymedicines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BuyMedicines.class));
                Toast.makeText(getApplicationContext(), "order details opened", Toast.LENGTH_SHORT).show();
            }
        });
        CardView articel=(CardView) findViewById(R.id.card4);
        articel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Atricles.class));
                Toast.makeText(getApplicationContext(), "articles opened", Toast.LENGTH_SHORT).show();
            }
        });

    }
}