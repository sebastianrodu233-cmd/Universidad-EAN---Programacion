package com.mycompany.calculoimpuestoscarro.modelo;

public class Vehiculo {

    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int cilindraje;
    private double avaluoComercial;
    private String tipoUso;

    public Vehiculo(String marca, String modelo, int anioFabricacion,
                    int cilindraje, double avaluoComercial, String tipoUso) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.cilindraje = cilindraje;
        this.avaluoComercial = avaluoComercial;
        this.tipoUso = tipoUso;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public double getAvaluoComercial() {
        return avaluoComercial;
    }

    public String getTipoUso() {
        return tipoUso;
    }
}