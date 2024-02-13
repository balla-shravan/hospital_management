package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Atricles extends AppCompatActivity {
    private String health_details[][]={
            {"Walking daily","","","","click for more details"},
            {"Home Care Covid-19","","","","click for more details"},
            {"Stop Smoking","","","","click for more details"},
            {"Mentsurantinal cycle","","","","click for more details"},
            {"Health govrn","","","","click for more details"}
    };
private int[] images ={
        R.drawable.health1,
        R.drawable.health2,
        R.drawable.health3,
        R.drawable.health4,
        R.drawable.health5
};
    ArrayList list;
    HashMap<String,String> map;
    SimpleAdapter sa;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atricles);
       back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        list=new ArrayList();
        for(int j=0;j<health_details.length;j++)
        {
            map=new HashMap<>();
            map.put("line1",health_details[j][0]);
            map.put("line2",health_details[j][1]);
            map.put("line3",health_details[j][2]);
            map.put("line4",health_details[j][3]);
            map.put("line5","Total Cost"+health_details[j][4]+"/-");
            list.add(map);
        }
        sa=new SimpleAdapter(this,list,R.layout.mutil_lines,new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=(ListView) findViewById(R.id.list1);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(), HealthArticleDetails.class);
                intent.putExtra("text1",health_details[i][0]);
                intent.putExtra("text2",images[i]);
                startActivity(intent);
            }
        });
    }
}