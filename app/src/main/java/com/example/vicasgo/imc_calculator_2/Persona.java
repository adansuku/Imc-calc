package com.example.vicasgo.imc_calculator_2;


public abstract class Persona {

    private String nombre = "";
    private String apellidos = "";
    private double altura;
    private double peso;
    private int edad;

    public Persona(String nombre, String apellidos, double peso, double altura, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {

        this.apellidos = apellidos;
    }

    public double getAltura() {

        return altura;
    }

    public void setAltura(double altura) {

        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
