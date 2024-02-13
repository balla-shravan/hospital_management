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

public class LabTest extends AppCompatActivity {
    String labtests[][]= {

            {"complete blood count", "","","","99"},
            {"Thyroid function test", "","","","199"},
            {"liver functional panel", "","","","299"},
            {"hemoglobin", "","","","399"}
    };
    String packageDetails[] = {
            "Complete Blood Count Package"+"\n"+":Includes a comprehensive"+"\n"+ "analysis of"+" \n"+"blood components.",
            "Thyroid Function Test Package:"+"\n"+ "Evaluates the thyroid gland's"+ "\n"+"performance.",
            "Liver Functional Panel Package:" +"\n"+"Assesses the function of the liver through"+"\n"+" various tests.",
            "Hemoglobin Package:"+"\n" +"Focuses on measuring hemoglobin"+"\n"+" levels in the"+"\n"+ "blood."
    };

    HashMap<String,String>map;
    ArrayList list;
    SimpleAdapter sa;
    Button back,gotocart;
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
        back=(Button) findViewById(R.id.back);
        gotocart=(Button) findViewById(R.id.cart);
        lst=(ListView)findViewById(R.id.list1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        list=new ArrayList();
        for(int j=0;j<labtests.length;j++)
        {
            map=new HashMap<>();
            map.put("line1",labtests[j][0]);
            map.put("line2",labtests[j][1]);
            map.put("line3",labtests[j][2]);
            map.put("line4",labtests[j][3]);
            map.put("line5","total cost"+labtests[j][4]);
            list.add(map);
        }
        sa=new SimpleAdapter(this,list,R.layout.mutil_lines,new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=(ListView) findViewById(R.id.list1);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(), LabTestDetails.class);
                intent.putExtra("text1",labtests[i][0]);
                intent.putExtra("text2",packageDetails[i]);
                intent.putExtra("text3",labtests[i][4]);
                startActivity(intent);
            }
        });
    }
}