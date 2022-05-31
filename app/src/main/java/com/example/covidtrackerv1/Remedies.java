package com.example.covidtrackerv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Remedies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedies);
    }

    private void configureBackToSymptomsButton ()
    {
        Button nextButton = (Button) findViewById(R.id.backToSymptomsBtn);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)
            {
                startActivity(new Intent(Remedies.this, ChooseSymptoms.class));
            }
        });
    } // end back to symptoms button handler

    private void configureBackToMainButton ()
    {
        Button nextButton = (Button) findViewById(R.id.backToMainBtn);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)
            {
                startActivity(new Intent(Remedies.this, MainMenu.class));
            }
        });
    } // end back to main menu button handler


}
