package com.example.camelbanana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText number0fBanana,distanceToMarket;
    Spinner numberOfCamel,numberOfBananaPerKm;
    Button calculateNumberOfBanana;
    TextView showMaximumBanana;
    int numberOfCamels,numberOfBananaPerKms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number0fBanana = findViewById(R.id.number_of_banana);
         distanceToMarket = findViewById(R.id.distance_to_market);
         numberOfCamel = findViewById(R.id.number_of_camel);
         numberOfBananaPerKm = findViewById(R.id.number_of_banana_perkm);
         calculateNumberOfBanana = findViewById(R.id.calculate_number_of_banana);
         showMaximumBanana = findViewById(R.id.shownumberofbananatext);
         numberOfCamel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 numberOfCamels = Integer.valueOf(numberOfCamel.getItemAtPosition(i).toString());
             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });

         numberOfBananaPerKm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 numberOfBananaPerKms = Integer.valueOf(numberOfBananaPerKm.getItemAtPosition(i).toString());
             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });


    }

public void prepareForMaximum(){
    showMaximumBanana.setVisibility(View.INVISIBLE);
    int number0fBananas = Integer.valueOf(number0fBanana.getText().toString());
    int distanceToMarkets = Integer.valueOf(distanceToMarket.getText().toString());
    MaximumBanana maximumBanana = new MaximumBanana(number0fBananas,distanceToMarkets,numberOfCamels,numberOfBananaPerKms);
    int  numberOfBananass = maximumBanana.maximumBanana();
    if (numberOfBananass > 0 ){
        showMaximumBanana.setText(getString(R.string.maximum_number)+" " +  numberOfBananass);
    }
    else {
        showMaximumBanana.setText(R.string.sorry);
    }

    showMaximumBanana.setVisibility(View.VISIBLE);
}


    public void calculateNumberOfBanana(View view ){
        showMaximumBanana.setVisibility(View.INVISIBLE);
    if (number0fBanana.getText().toString().isEmpty() | Integer.valueOf(number0fBanana.getText().toString()) <3000   ){
        number0fBanana.setError("Number of banana must be greater than 30000");
    }
    if(distanceToMarket.getText().toString().isEmpty() | Integer.valueOf(distanceToMarket.getText().toString()) <1000 | Integer.valueOf(distanceToMarket.getText().toString()) >10000 ){
        distanceToMarket.setError("Distance to market must be within the range of 1000 and 10000");
    }
    if (!number0fBanana.getText().toString().isEmpty() && Integer.valueOf(number0fBanana.getText().toString()) >=3000 && !distanceToMarket.getText().toString().isEmpty() && Integer.valueOf(distanceToMarket.getText().toString()) >=1000 && Integer.valueOf(distanceToMarket.getText().toString()) <=10000){
        prepareForMaximum();
    }



    }
}
