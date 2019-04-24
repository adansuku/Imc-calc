package com.example.vicasgo.imc_calculator_2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActivityDataIn extends AppCompatActivity {

    private Button btnCalculate;
    private EditText altura, edad, peso;
    private RadioButton hombre, mujer;


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        String altStr = "";
        String edStr = "";
        String pesStr = "";

        if (altura.getText().length() > 0)
            altStr = altura.getText().toString();
        if (edad.getText().length() > 0)
            edStr = edad.getText().toString();
        if (peso.getText().length() > 0)
            pesStr = peso.getText().toString();
        outState.putString("altura", altStr);
        outState.putString("edad", edStr);
        outState.putString("peso", pesStr);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_in);
        btnCalculate = (Button) findViewById(R.id.btnCalcular);
        altura = (EditText) findViewById(R.id.etAltura);
        edad = (EditText) findViewById(R.id.etEdad);
        peso = (EditText) findViewById(R.id.etPeso);
        hombre = (RadioButton) findViewById(R.id.rbHombre);
        mujer = (RadioButton) findViewById(R.id.rbMujer);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ed = (Integer.parseInt((edad.getText().toString())));
                double pes = (Double.parseDouble(peso.getText().toString()));
                double alt = Double.parseDouble(altura.getText().toString());
                double imc;

                Object o1 = null;


                if (hombre.isChecked() == true) {
                    imc = (pes / (alt * alt));
                    o1 = new Hombre("", "", pes, alt, ed, imc);
                    //Toast.makeText(getApplicationContext(), "Has marcado Hombre", Toast.LENGTH_SHORT).show();
                } else {
                    if (mujer.isChecked() == true) {

                        imc = (pes / (alt * alt));
                        o1 = new Mujer("", "", pes, alt, ed, imc);
                        //Toast.makeText(getApplicationContext(), "Has marcado Mujer", Toast.LENGTH_SHORT).show();
                    }

                }

                Intent intentResult = new Intent(ActivityDataIn.this, ActivityResult.class);
                intentResult.putExtra("Parcelable", (Parcelable) o1);
                startActivity(intentResult);


            }
        });
    }
}
