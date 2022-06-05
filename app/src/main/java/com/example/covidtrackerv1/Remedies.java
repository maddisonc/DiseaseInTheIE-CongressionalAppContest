package com.example.covidtrackerv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Remedies extends AppCompatActivity {

    private Button backToSymptomsBtn;
    private Button backToMainMenuBtn;

    String[] treatmentList = {
            "Rest and drink plenty of fluids.  If necessary, take acetaminophen (Tylenol), ibuprofen (Advil, Motrin IB), or aspirin.",
            "Layer clothes or rest in a warm place.  Drink hot chocolate, coffee, or tea to increase your body temperature.",
            "Drink fluids, eat cough drops/hard candies, drink honey, and avoid tobacco smoke.",
            "Avoid smoking, areas with high pollution, elevations over 5,000 feet and see a doctor if necessary.",
            "Rest and maintain a regular sleep schedule as well as a healthy diet.",
            "Rest the area of the body where you are experiencing aches and ice this area.  Take over-the-counter pain relievers such as ibuprofen (Advil.)",
            "Add small amounts of strong cheese, bacon or toasted nuts to dishes, or use aromatic herbs, including seasonings and spices (not salt) to boost flavor.",
            "Gargle with salt water, drink extra-cold liquids, and avoid acidic foods.",
            "Use a humidifier and rinse the inside of your nose with a saline solution."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedies);

        updateRemediesText();

        // initialize backToSymptoms button
        backToSymptomsBtn = findViewById(R.id.backToSymptomsBtn);
        backToSymptomsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configureBackToSymptomsButton();
            }
        }); // listener that calls previous activity method

        // initialize backToMain button
        backToMainMenuBtn = findViewById(R.id.backToMainBtn);
        backToMainMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configureBackToMainButton();
            }
        }); // listener that calls main menu activity method

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


    public void updateRemediesText ()
    {
        String remedies = "";
        int symptomsCount = 0;
        int[] symptomsIndexArr = ChooseSymptoms.getSymptomsIndexList();
        String[] symptomsNameArr = ChooseSymptoms.getSymptomsStringList();

        // new arraylist to hold the names of only chosen symptoms
        ArrayList<String> chosenSymptoms = new ArrayList<>();

        TextView remediesTextView = (TextView) findViewById(R.id.scrollViewText);

        // for loop that prints out the symptoms that the user chose, adds these symptoms to the ArrayList
        for (int i = 0; i < symptomsIndexArr.length; i++)
        {
            if (symptomsIndexArr[i] == 1)
            {
                symptomsCount++;
                chosenSymptoms.add(symptomsNameArr[i]);
            }
        }

        // outputs number of symptoms
        remedies += "\nYou have " + symptomsCount + " out of 9 of the most common COVID-19 symptoms.\n";

        // if the user selected at least one symptom
        if (symptomsCount > 0) {
            remedies += "\nYou are experiencing: ";
            for (String a : chosenSymptoms)
            {
                remedies += "\n" + a;
            }
        }

        // prints out specific treatment for each symptom
        remedies += "\n";
        String symptom = "";
        for (int i = 0; i < symptomsIndexArr.length; i++)
        {
            if (symptomsIndexArr[i] == 1)
            {
                symptom = symptomsNameArr[i];
                remedies += "\n" + symptom + ": " + treatmentList[i] + "\n";
            }
        } // end foreach

        // outputs the amount of days the user should isolate based on number of symptoms
        if (symptomsCount >= 1)
        {
            remedies += "\nYou should isolate for at least five days from the date your symptoms began.\n";
        }
        else if (symptomsCount == 0)
        {
            remedies += "\nYou are not experiencing COVID-19 symptoms.\n";
        }

        remediesTextView.setText(remedies);
    } // end updateRemediesText

}
