package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicines extends AppCompatActivity {

    private String[][] packages =
            {

    {"Uprise-D3 1000IU Capsule","","",
            "50"},
    {"HealthVit Chromium Picolinate 200mcg Capsule","","",

            "448"},
                    {"Vitamin B Complex Capsules","","",
                            "305"},
    {"Inlife Vitamin E Wheat Germ Oil Capsule","",
           "", "539"},
        {"Dolo 650 Tablet", "", "",
                "30"},
        {"Crocin 650 Advance Tablet","",
                "","50"},
        {"Strepsils Medicated Lozenges for Sore Throat", "",
                "", "30"},
                    {"Tata 1mg Calcium + Vitamin D3", "","",
                            "40"},
        {"Feronia -XT Tablet", "","",
                "130"}};
        private String[] package_details = {

        "Building and keeping the bones & teeth strong\n" +
                "Reducing Fatigue/stress and muscular pains\n" +
                "Boosting immunity and increasing resistance against infection",
                "Chromium is an essential trace mineral that plays an important role in helping insulin regulat"+ "Provides relief from vitamin B deficiencies\n" +
        "Helps in formation of red blood cells\n" + "Maintains healthy nervous system",
                "It promotes health as well as skin benefit.\n" +
                        "It helps reduce skin blemish and pigmentation.\n" +
                        "It act as safeguard the skin from the harsh UVA and UVB sun rays.",
                "Dolo 650 Tablet helps relieve pain and fever by blocking the release of certain chemical messe "+"Helps relieve fever and bring down a high temperature\n" +
        "Suitable for people with a heart condition or high blood pressure",
                "Relieves the symptoms of a bacterial throat infection and soothes the recovery process\n" + "Provides a warm and comforting feeling during sore throat",
                "Reduces the risk of calcium deficiency, Rickets, and Osteoporosis\n" +
                        "Promotes mobility and flexibility of joints",
                "Helps to reduce the iron deficiency due to chronic blood loss or low intake of iron"};
    HashMap<String,String> map;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button back,gotocart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicines);
        lst=(ListView) findViewById(R.id.list1);
        back=(Button) findViewById(R.id.back);
        gotocart=(Button) findViewById(R.id.cart);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        gotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CartBuyMedicians.class));
            }
        });
        list=new ArrayList();
        for(int j=0;j<packages.length;j++)
        {
            map=new HashMap<>();
            map.put("line1",packages[j][0]);
            map.put("line2",packages[j][1]);
            map.put("line3",packages[j][2]);
            map.put("line4",packages[j][3]);
            map.put("line5","Total Cost"+packages[j][4]+"/-");
            list.add(map);
        }
        sa=new SimpleAdapter(this,list,R.layout.mutil_lines,new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(), BuyMedicianDetails.class);
                intent.putExtra("text1",packages[i][0]);
                intent.putExtra("text2",package_details[i]);
                intent.putExtra("text3",packages[i][4]);
                startActivity(intent);
            }
        });
    }
}