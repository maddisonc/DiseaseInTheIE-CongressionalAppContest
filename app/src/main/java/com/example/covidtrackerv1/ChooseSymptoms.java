package com.example.covidtrackerv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ChooseSymptoms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_symptoms);
    }//end onCreate

    public void hepClick(View v)
    {
        Intent intent = new Intent(this, hepScreen.class);
        startActivity(intent);
    }//end hepClick

    public void whoopClick(View v)
    {
        Intent intent = new Intent(this, whoopScreen.class);
        startActivity(intent);
    }

    public void menClick(View v)
    {
        Intent intent = new Intent(this, menScreen.class);
        startActivity(intent);
    }




} // end ChooseSymptomsClass
