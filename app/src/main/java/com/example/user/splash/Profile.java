package com.example.user.splash;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
TextView nameprofile;
TextView emailprofie;
TextView pswdprofile;
TextView dobprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
     nameprofile=(TextView)findViewById(R.id.nameprof);
     emailprofie=(TextView)findViewById(R.id.emailprof);
     pswdprofile=(TextView)findViewById(R.id.pswdprof);
     dobprofile=(TextView)findViewById(R.id.dobprof);
        SharedPreferences shared = getApplicationContext().getSharedPreferences("Pref",MODE_PRIVATE);
         String namep=shared.getString("namekey",null);
         String emailp=shared.getString("emailkey",null);
         String pswdp=shared.getString("pswdkey",null);
         String dobp=shared.getString("dobkey",null);
         nameprofile.setText(namep);
         emailprofie.setText(emailp);
         dobprofile.setText(dobp);


    }
}
