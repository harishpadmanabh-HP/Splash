package com.example.user.splash;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Reg extends AppCompatActivity {
    EditText nametext;
    EditText emailtext;
    EditText pswdtext;
    EditText dobtext;
    Button submit;
    String specialCharacters = "[" + "-/@#!*$%^&.'_+={}()" + "]+";
    String emailstring = "@.";

    private Calendar myCalendar;
    private EditText mdob_et;
    private int day, month, year;
    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        nametext = (EditText) findViewById(R.id.nametext);
        emailtext = (EditText) findViewById(R.id.emailtext);
        pswdtext = (EditText) findViewById(R.id.pswdtext);
        dobtext = (EditText) findViewById(R.id.dobtext);
        submit=(Button)findViewById(R.id.submitbutton);
        myCalendar=Calendar.getInstance();
        dobtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DateDialog();
                new DatePickerDialog(Reg.this, (DatePickerDialog.OnDateSetListener) date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                updateLabel();

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namereg=nametext.getText().toString();
                String emailreg=emailtext.getText().toString();
                String pswdreg=pswdtext.getText().toString();


                dobtext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // DateDialog();
                        new DatePickerDialog(Reg.this, (DatePickerDialog.OnDateSetListener) date, myCalendar
                                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                        updateLabel();

                    }
                });


                String dobreg=dobtext.getText().toString();

                SharedPreferences shared = getApplicationContext().getSharedPreferences("Pref",MODE_PRIVATE);
                SharedPreferences.Editor editor=shared.edit();
                editor.putString("namekey",namereg);
                editor.putString("emailkey",emailreg);
                editor.putString("pswdkey",pswdreg);
                editor.putString("dobkey",dobreg);
                Intent intent=new Intent(Reg.this,Login.class);
                startActivity(intent);

                editor.apply();


            }
        });


    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dobtext.setText(sdf.format(myCalendar.getTime()));
    }
    public void DateDialog () {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dobtext.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
            }
        };
        DatePickerDialog dpDialog = new DatePickerDialog(getApplicationContext(), listener, year, month, day);
        dpDialog.show();
    }


}
