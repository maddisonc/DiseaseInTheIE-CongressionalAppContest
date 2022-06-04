package com.example.covidtrackerv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseSymptoms extends AppCompatActivity {

    private Button nextToRemediesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_symptoms);

        // initialize next button
        nextToRemediesBtn = findViewById(R.id.toRemediesBtn);
        nextToRemediesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configureToRemediesButton();
            }
        }); // listener that calls next activity method
    }

    private void configureToRemediesButton ()
    {
        Button nextButton = (Button) findViewById(R.id.toRemediesBtn);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)
            {
                startActivity(new Intent(ChooseSymptoms.this, Remedies.class));
            }
        });
    } // end next toRemedies handler
}
