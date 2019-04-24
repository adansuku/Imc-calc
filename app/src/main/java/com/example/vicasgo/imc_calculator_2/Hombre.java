package com.example.vicasgo.imc_calculator_2;

import android.os.Parcel;
import android.os.Parcelable;

public class Hombre extends Persona implements Parcelable {

    private String sexo = "hombre";
    private double imc;

    public Hombre(String nombre, String apellidos, double peso, double altura, int edad, double imc) {
        super(nombre, apellidos,peso,altura,edad);
        this.imc = imc;
    }

    protected Hombre(Parcel in) {

        this(in.readString(),in.readString(),Double.parseDouble(in.readString()),Double.parseDouble(in.readString()),Integer.parseInt(in.readString()),Double.parseDouble(in.readString()));
    }


    public static final Creator<Hombre> CREATOR = new Creator<Hombre>() {
        @Override
        public Hombre createFromParcel(Parcel in) {
            return new Hombre(in);
        }

        @Override
        public Hombre[] newArray(int size) {
            return new Hombre[size];
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
