package com.example.covidtrackerv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class tubScreen extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tub);

        BarChart barChart = (BarChart) findViewById(R.id.barchart);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(8916f, 0));
        entries.add(new BarEntry(33000f, 1));
        entries.add(new BarEntry(526f, 2));
        entries.add(new BarEntry(3770f, 3));

        BarDataSet bardataset = new BarDataSet(entries, "Cells");
        ArrayList<String> labels = new ArrayList<String>();

        labels.add("USCase");
        labels.add("EuCase");
        labels.add("USDeath");
        labels.add("EuDeath");

        BarData data = new BarData(labels, bardataset);
        barChart.setData(data);

        barChart.setDescription("Tuberculosis cases in 2019");

        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.animateY(3000);
    }//end onCreate

    public void backClick(View v)
    {
        Intent intent = new Intent(this, ChooseSymptoms.class);
        startActivity(intent);
    }
}
