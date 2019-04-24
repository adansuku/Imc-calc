package com.example.vicasgo.imc_calculator_2;

import android.os.Parcel;
import android.os.Parcelable;

public class Mujer extends Persona implements Parcelable {

    public String sexo = "mujer";
    public double imc;

    public Mujer(String nombre, String apellidos, double peso, double altura, int edad, double imc) {
        super(nombre, apellidos,peso,altura,edad);
        this.imc = imc;
        this.sexo = sexo;
    }

    protected Mujer(Parcel in) {
//        this.nombre = in.readString();
//        this.apellidos = in.readString();
//        this.altura = Double.parseDouble(in.readString());
//        this.peso = Double.parseDouble(in.readString());
//        this.edad = Integer.parseInt(in.readString());
//        this.imc = Double.parseDouble(in.readString());
        this(in.readString(),in.readString(),Double.parseDouble(in.readString()),Double.parseDouble(in.readString()),Integer.parseInt(in.readString()),Double.parseDouble(in.readString()));
    }


    public static final Creator<Mujer> CREATOR = new Creator<Mujer>() {
        @Override
        public Mujer createFromParcel(Parcel in) {
            return new Mujer(in);
        }

        @Override
        public Mujer[] newArray(int size) {
            return new Mujer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.getNombre());
        dest.writeString(this.getApellidos());
        dest.writeString(String.valueOf(this.getPeso()));
        dest.writeString(String.valueOf(this.getAltura()));
        dest.writeString(String.valueOf(this.getEdad()));
        dest.writeString(String.valueOf(this.getImc()));
        dest.writeString(this.getSexo());
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    @Override
    public String toString() {
        return "Hombre{" +
                ", nombre='" + this.getNombre() + '\'' +
                ", apellidos='" + this.getApellidos() + '\'' +
                ", altura=" + this.getAltura() +
                ", peso=" + this.getPeso() +
                ", edad=" + this.getEdad() +
                "sexo='" + sexo + '\'' +
                ", imc=" + imc +
                '}';
    }
}

