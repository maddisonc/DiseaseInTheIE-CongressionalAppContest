package com.example.covidtrackerv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ChooseSymptoms extends AppCompatActivity {

    private Button nextToRemediesBtn;

    // order of symptoms: fever (0), chills (1), cough (2), difficulty breathing (3), fatigue (4),
    //                    body aches (5), loss of taste/smell (6), sore throat (7), congestion (8)
    public static int[] symptomsIndexList = new int[9];
    public static String[] symptomsStringList = {"Fever", "Chills", "Cough", "Difficulty breathing", "Fatigue",
                                "Body aches", "Loss of taste/smell", "Sore throat", "Congestion"};
    String[] printOutList = new String [symptomsIndexList.length];

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

                // prints out symptoms to console
                // each symptom is printed with either 1 or 0 to show which ones were chosen
                for (int i = 0; i < symptomsIndexList.length; i++)
                {
                    printOutList[i] = symptomsStringList[i] + ": " + symptomsIndexList[i];
                    Log.i("info", printOutList[i]);
                } // end for loop
            } // end onCLick
        });
    } // end next toRemedies handler


    // start of onClicks for symptoms buttons (implemented by using onClick option in attributes)
    // sets element in array to 1 if the button is clicked
    // 1 means the user has the symptom, 0 means the user does not

    public void feverClick (View v)
    {
        symptomsIndexList[0] = 1;
    } // end fever button handler

    public void chillsClick (View v)
    {
        symptomsIndexList[1] = 1;
    } // end chills button handler

    public void coughClick (View v)
    {
        symptomsIndexList[2] = 1;
    } // end cough button handler

    public void diffBreatheClick (View v)
    {
        symptomsIndexList[3] = 1;
    } // end difficulty breathing button handler

    public void fatigueClick (View v)
    {
        symptomsIndexList[4] = 1;
    } // end fatigue button handler

    public void achesClick (View v)
    {
        symptomsIndexList[5] = 1;
    } // end aches button handler

    public void lossClick (View v)
    {
        symptomsIndexList[6] = 1;
    } // end loss of taste/smell button handler

    public void soreThroatClick (View v)
    {
        symptomsIndexList[7] = 1;
    } // end sore throat button handler

    public void congestionClick (View v)
    {
        symptomsIndexList[8] = 1;
    } // end congestion button handler

    // getter for symptom frequency
    public static int[] getSymptomsIndexList ()
    {
        return symptomsIndexList;
    }

    // getter for symptom strings
    public static String[] getSymptomsStringList ()
    {
        return symptomsStringList;
    }

} // end ChooseSymptomsClass
