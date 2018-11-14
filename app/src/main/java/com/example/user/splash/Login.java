package com.example.user.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText emaillogin;
    EditText pswdlogin;
    TextView newuser;
    Button login;
    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emaillogin=(EditText)findViewById(R.id.emailtextlogin);
        pswdlogin=(EditText)findViewById(R.id.passwordtextlogin);
        newuser=(TextView)findViewById(R.id.newuser);
        login=(Button)findViewById(R.id.login);
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this,Reg.class);
                startActivity(i);
            }
        });

         shared = getApplicationContext().getSharedPreferences("Pref",MODE_PRIVATE);


         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 final        String emailcheck=shared.getString("emailkey",null);
                 final   String pswdcheck=shared.getString("pswdkey",null);

                 String emaillog=emaillogin.getText().toString();

                 String pswdlog=pswdlogin.getText().toString();

                 if(emailcheck.equalsIgnoreCase(emaillogin.getText().toString())&&pswdcheck.equalsIgnoreCase(pswdlogin.getText().toString()))
                 //  if((emaillog==emailcheck)&&(pswdlog==pswdcheck))
                 {
                     Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                     Intent intent =new Intent(Login.this,Profile.class);
                     startActivity(intent);

                 }
                 else
                 {
                     Toast.makeText(Login.this, "Login not Successfull", Toast.LENGTH_SHORT).show();

                 }

             }

         });


    }
}
