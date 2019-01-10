package com.hexadecimal.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTablesListView;

    public void generateTimesTable(int timesTablesNumber){

        ArrayList<String> timesTableContent = new ArrayList<String>();

        for ( int j = 1; j <= 100; j++){
            timesTableContent.add(Integer.toString(j * timesTablesNumber));
        }
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timesTablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTablesSeekBar = findViewById(R.id.timesTablesSeekBar);
        timesTablesListView = findViewById(R.id.timesTablesListView);

        int max = 20;
        int startingPosition = 10;

        timesTablesSeekBar.setMax(max);         // seekbar'in maksimum alacagi deger
        timesTablesSeekBar.setProgress(startingPosition);  // seekbar'in nerede oldugunu belirtmek icin
        generateTimesTable(startingPosition);       // uygulama acildiginda startingPosition icin tablo hazır olacak

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTablesNumber;

                // i, seekbar neredeyse o degeri alir

                if( i < min){
                    timesTablesNumber = min; // sifir olmasini engellemek icin
                    timesTablesSeekBar.setProgress(min);
                } else {
                    timesTablesNumber = i;
                }
                generateTimesTable(timesTablesNumber);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }
}
