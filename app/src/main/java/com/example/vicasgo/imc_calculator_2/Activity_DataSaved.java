package com.example.vicasgo.imc_calculator_2;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Activity_DataSaved extends AppCompatActivity {

    ListView lvDataSaved;
    EditText etFiltro;
    Button btnFiltro;
    ArrayList <String> list;
    ArrayAdapter adaptador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__data_saved);

        lvDataSaved = (ListView)findViewById(R.id.lvResult);
        etFiltro = (EditText)findViewById(R.id.etFilter);
        btnFiltro = (Button)findViewById(R.id.btnFilter);

        BaseDatos db = new BaseDatos(getApplicationContext());
        list = db.obtenerRegistros();
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lvDataSaved.setAdapter(adaptador);








    }
}
