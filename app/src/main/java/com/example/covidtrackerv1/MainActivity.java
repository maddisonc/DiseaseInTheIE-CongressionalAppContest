package com.example.covidtrackerv1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    // handler for splash screen
    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // runnable that delays switching to next screen
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, MainMenu.class);
                startActivity((i));
                finish();
            }
        }, 5000); // end splashScreen code

    } // end onCreate method
} // end MainActivity class
