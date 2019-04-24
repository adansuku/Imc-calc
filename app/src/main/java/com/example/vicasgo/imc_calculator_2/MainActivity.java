package com.example.vicasgo.imc_calculator_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btncalc,btnVerData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = this.getIntent();
        if(intent == null){
            Log.d("Tag","");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncalc = (Button)findViewById(R.id.btnCalcularIMC);
        btnVerData = (Button)findViewById(R.id.btnVerDatos);
    }

    public void calcularIMC(View view){
        Intent dataIn = new Intent(getApplicationContext(),ActivityDataIn.class);
        startActivity(dataIn);
    }
    public void verDatos (View view) {
        Intent dataSaved = new Intent(getApplicationContext(), Activity_DataSaved.class);
        startActivity(dataSaved);
    }
}
