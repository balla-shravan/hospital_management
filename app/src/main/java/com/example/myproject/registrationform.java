package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registrationform extends AppCompatActivity {
EditText et1,et2,et3,et4;
Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationform);
        et1=(EditText)findViewById(R.id.e1);
        et2=(EditText)findViewById(R.id.e2);
        et3=(EditText)findViewById(R.id.e3);
        et4=(EditText)findViewById(R.id.e4);
        bt1=(Button) findViewById(R.id.b1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=et1.getText().toString();
                String s1=et2.getText().toString();
                String s2=et3.getText().toString();
                String s3=et4.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                if(s.length()==0 || s1.length()==0 ||s2.length()==0 ||s3.length()==0  )
                {
                    Toast.makeText(getApplicationContext(),"Please fill the details",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(s2.equals(s3))
                    {
                        if(isValid(s2))
                        {
                            db.register(s,s2,s3);
                            Toast.makeText(getApplicationContext(),"Registration is successfull",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(i);
                        }else {
                            Toast.makeText(getApplicationContext(),"password is not in valid format",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"confirmed password not match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static boolean isValid(String password) {
        //return true if and only if password:
        //1. have at least eight characters.
        //2. consists of only letters and digits.
        //3. must contain at least two digits.
        if (password.length() < 8) {
            return false;
        } else {
            char c;
            int count = 1;
            for (int i = 0; i < password.length() - 1; i++) {
                c = password.charAt(i);
                if (!Character.isLetterOrDigit(c)) {
                    return false;
                } else if (Character.isDigit(c)) {
                    count++;
                    if (count < 2)   {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}