package com.example.ch11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int intYears,intLoan;
    float decInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText years=(EditText)findViewById(R.id.txtYears);
        final EditText loan=(EditText)findViewById(R.id.txtLoan);
        final EditText interest=(EditText)findViewById(R.id.txtInterest);
        Button button=(Button)findViewById(R.id.button);

        final SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intYears=Integer.parseInt(years.getText().toString());
                intLoan=Integer.parseInt(loan.getText().toString());
                decInterest=Float.parseFloat(interest.getText().toString());

                SharedPreferences.Editor editor=sharedPref.edit();// we now use this editor to write pairs inside our sharedPref
                editor.putInt("Key1",intYears);
                editor.putInt("Key2",intLoan);
                editor.putFloat("Key3",decInterest);
                editor.commit(); // we now have a structure (sharedPref) that saves those pairs
                startActivity(new Intent(MainActivity.this,Payment.class));

            }
        });

    }
}