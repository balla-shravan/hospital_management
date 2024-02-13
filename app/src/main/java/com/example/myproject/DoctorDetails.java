package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetails extends AppCompatActivity {
    TextView tv;
    Button btn;
    String doctor_details[][]= {

            {"name:Dr. John Doe", "mobile_no:123-456-7890","hospital_address:City Hospital, 123 Main St, Anytown","exp:15 years","charge:$150"},
            {"name:Dr. Jane Smith","mobile_no:987-654-3210","hospital_address:County Medical Center, 456 Oak Ave, Sometown","exp:10 years","charge:$120"},
            {"name:Dr. David Johnson","mobile_no:555-123-4567","hospital_address:Community Clinic, 789 Pine Blvd, Othertown","exp:20 years","charge:$200"},
            {"name:Dr. Sarah Williams","mobile_no:888-999-0000","hospital_address:Unity Health Center, 567 Elm Dr, Anycity","exp:12 years","charge:$180"},
            {"name:Dr. Michael Brown","mobile_no:444-567-8901","hospital_address:Regional Hospital, 890 Cedar Lane, Anothercity","exp:18 years","charge:$170"}
};
    ArrayList list;
    HashMap<String,String> map;
    SimpleAdapter sa;
String doctor_details1[][]={};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv=(TextView) findViewById(R.id.title1);
        btn=(Button) findViewById(R.id.back);
        Intent i=getIntent();
        String title=i.getStringExtra("title");
        tv.setText(title.toUpperCase());
        if(title.compareToIgnoreCase("family physician")==0)
        {
            doctor_details1=doctor_details;
        }
        else
        if(title.compareToIgnoreCase("dietition")==0)
        {
            doctor_details1=doctor_details;
        }
        else
        if(title.compareToIgnoreCase("dentist")==0)
        {
            doctor_details1=doctor_details;
        }
        else
        if(title.compareToIgnoreCase("surgeon")==0)
        {
            doctor_details1=doctor_details;
        }
        else
        {
            doctor_details1=doctor_details;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FindDoctor.class));
            }
        });
        list=new ArrayList();
        for(int j=0;j<doctor_details1.length;j++)
        {
            map=new HashMap<>();
            map.put("line1",doctor_details1[j][0]);
            map.put("line2",doctor_details1[j][1]);
            map.put("line3",doctor_details1[j][2]);
            map.put("line4",doctor_details1[j][3]);
            map.put("line5",doctor_details1[j][4]);
            list.add(map);
        }
        sa=new SimpleAdapter(this,list,R.layout.mutil_lines,new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=(ListView) findViewById(R.id.list1);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(), BookAppointment.class);
                intent.putExtra("text1",title);
                intent.putExtra("text2",doctor_details1[i][0]);
                intent.putExtra("text3",doctor_details1[i][1]);
                intent.putExtra("text4",doctor_details1[i][2]);
                intent.putExtra("text5",doctor_details1[i][4]);
                startActivity(intent);
            }
        });

    }
}