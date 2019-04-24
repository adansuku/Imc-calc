package com.example.vicasgo.imc_calculator_2;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ActivityResult extends AppCompatActivity {

    // El código 200 es un código personalizado, es para poder después poder usarlo en comprobaciones.
    private static final int PERMISSION_REQUEST_CODE = 200;

    private WebView webViewResultado;
    private Object o;
    private EditText etName,etApe;
    private TextView name ,ape;
    //private String [] datosPersonas;
    //private final String [] titulos = {"Edad: ","Altura: ","Peso: ","IMC: ","Sexo: "};
    BaseDatos db;
    private Button btnSave;
    private String nombre,apellido,altura,adad,peso,imc;
    Persona o1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        etName = (EditText)findViewById(R.id.etName);
        etApe = (EditText)findViewById(R.id.etApe);
        btnSave = (Button)findViewById(R.id.btnGrabar);
        webViewResultado = (WebView)findViewById(R.id.wvResult);

        o1 = getIntent().getParcelableExtra("Parcelable");



        webViewResultado.loadDataWithBaseURL(null,
                "<html><head></head><body>"+o1+"</body></html>",
                "text/html",
                "utf-8",
                null);


        nombre = etName.getText().toString();
        apellido = etApe.getText().toString();


        o1.setNombre(nombre);
        o1.setApellidos(apellido);






        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new BaseDatos(ActivityResult.this);
                db.insertarRegistro(o1);
                Toast.makeText(getApplicationContext(),"Datos guardados correctamente",Toast.LENGTH_LONG).show();
            }
        });
    }


    public void btnAtras(View view) {
        finish();


    }


   /* public void btnSaveData(View view) {

       /* StringBuilder linea = new StringBuilder();

        // Comprobamos si exist almacenimiento SD externo
        // si es así grabamos en ella, en caso contrario en la SD interna
        if(Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED)) {
            // Alamacenamiento externo disponible
            for (int i = 0; i < datosPersonas.length ; i++)
                linea.append(titulos[i]).append(datosPersonas[i]).append(",");

            linea.append("\n");
            saveInMemory(linea.toString());

        } else {
            // Almacenamiento externo no disponible
//            grabarMemoriaInterna(o.toString());

        }

    }

    public void saveSdCard(String texto){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                PERMISSION_REQUEST_CODE
        );
        File tarjeta = Environment.getExternalStorageDirectory();
        File dir = new File (tarjeta.getAbsolutePath() );
        dir.mkdirs();
        File file = new File(dir, "ficheroPersonas.txt");
        try {
            OutputStreamWriter osw = new OutputStreamWriter( new
                    FileOutputStream(file));
            osw.write(texto);
            osw.flush();
            osw.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveInMemory(String textoGrabar) {
        OutputStreamWriter archivo;

        //permite añadir contenido a un fichero
        try {
            archivo = new
                    OutputStreamWriter(getApplicationContext().openFileOutput("ficheroPersonas.txt",
                    Activity.MODE_APPEND));
            archivo.write(textoGrabar);
            archivo.flush();
            archivo.close();
        } catch (FileNotFoundException e) {
            Log.println(Log.ERROR, String.valueOf(e), "Error");
        } catch (IOException e) {
            Log.println(Log.ERROR, String.valueOf(e), "Error");
        }

    }*/




}
