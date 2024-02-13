package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
     EditText user,pass;
    Button bt1;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=(EditText)findViewById(R.id.e1);
        pass=(EditText)findViewById(R.id.e2);
        bt1=(Button)findViewById(R.id.b1);
        txt=(TextView)findViewById(R.id.t3);
        Database db=new Database(getApplicationContext(),"healthcare",null,1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=user.getText().toString();
                String password=pass.getText().toString();
                if(username.length()==0 || password.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"please fill details",Toast.LENGTH_SHORT).show();
                }else{
                    if(db.login(username,password)==1)
                    {
                        Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sh=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sh.edit();
                        editor.putString("username",username);
                        editor.apply();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }else
                    {
                        Toast.makeText(getApplicationContext(), "invalid username and password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),registrationform.class);
                startActivity(i);
            }
        });
    }
}