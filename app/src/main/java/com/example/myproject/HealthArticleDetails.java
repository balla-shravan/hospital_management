package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HealthArticleDetails extends AppCompatActivity {
 TextView text;
 Button back;
 ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article_details);
        back=(Button)findViewById(R.id.back);
        text=(TextView) findViewById(R.id.t2);
        img=(ImageView) findViewById(R.id.i1);
        Intent i=getIntent();
        text.setText(i.getStringExtra("text1"));
        Bundle bundle=getIntent().getExtras();
        if(bundle != null)
        {
            int resid=bundle.getInt("text2");
            img.setImageResource(resid);
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Atricles.class));
            }
        });
    }
}