package com.example.vicasgo.imc_calculator_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "imc.db";
    private final Context contexto;


    public BaseDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.contexto = context;

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + "PERSONAS" + " ("
                + " id " + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + " nombre " + " TEXT NOT NULL ,"
                + " apellidos " + " TEXT NOT NULL ,"
                + " altura " + " NUMBER NOT NULL ,"
                + " peso "+ " NUMBER NOT NULL ,"
                + " edad " + " NUMBER NOT NULL ,"
                + " sexo " + " TEXT NOT NULL "+
                ")"
        );
    }
    // se usa si hay cambios estructurales en la base de datos y (por
//ejemplo)se vuelven a crear las tablas
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if( i1 > i){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + " PERSONAS");
            onCreate(sqLiteDatabase);
        }
    }

    public long insertarRegistro(Persona persona){
        //Creamos el registro a insertar como objeto ContentValues
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("nombre", persona.getNombre());
        nuevoRegistro.put("apellido", persona.getApellidos());
        nuevoRegistro.put("altura", persona.getAltura());
        nuevoRegistro.put("edad", persona.getEdad());
        nuevoRegistro.put("peso", persona.getPeso());

        //Insertamos el registro en la base de datos
        //return db.insert("PERSONAS",null, nuevoRegistro);
        return this.getWritableDatabase().insert("PERSONAS", null, nuevoRegistro);
    }

    public ArrayList obtenerRegistros(){

        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase base= this.getWritableDatabase();
        String q = "SELECT * FROM PERSONAS";
        Cursor c= base.rawQuery(q, null);
        if(c.moveToFirst())
            do{
                lista.add(" nombre: "+c.getString(1)+"\n "+", apellido: "+c.getString(2)+"\n "+"altura: "+ c.getString(3)
                        +"\n "+"peso: "+ c.getString(4)+"\n "+"edad: "+ c.getString(5)+"\n "+"sexo: "+ c.getString(6));
            }
            while(c.moveToNext());
            return lista;
    }
}
