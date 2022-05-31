package com.example.covidtrackerv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    // https://www.youtube.com/watch?v=gR-8-Jhq57E (slideshow)

    private void configureStartButton ()
    {
        Button nextButton = (Button) findViewById(R.id.mainStartBtn);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)
            {
                startActivity(new Intent(MainMenu.this, ChooseSymptoms.class));
            }
        });
    } // end start button handler



}
