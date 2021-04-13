package com.example.ch11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView monthlyPayment =
                (TextView) findViewById(R.id.txtMonthlyPayment);

        ImageView image =
                (ImageView) findViewById(R.id.imgYears);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);// i am creating a reader with default settings (when we read/write its gonna do it in the documennt file )

        int intYears=sharedPref.getInt("Key1",0);//0 means default value if there was no entry (it is zero since we r using int)
        int intLoan=sharedPref.getInt("Key2",0);
        float decInterest=sharedPref.getFloat("Key3",0);

        float decMonthlyPayment;
        decMonthlyPayment=
                (intLoan +(1 + (decInterest+intYears)/12 * intYears));

        DecimalFormat currency=new DecimalFormat("$###,###.##");

        monthlyPayment.setText("Monthly Payment: "
                +currency.format(decMonthlyPayment));

        if(intYears==3)
            image.setImageResource(R.drawable.three);



    }

}