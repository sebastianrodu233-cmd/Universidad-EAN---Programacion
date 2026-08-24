package com.mycompany.calculoimpuestoscarro.modelo;

public class CalculadoraImpuestos {

    public double calcularImpuesto(Vehiculo vehiculo) {

        double tarifa;

        if (vehiculo.getAvaluoComercial() <= 57349000) {
            tarifa = 0.015;
        } else if (vehiculo.getAvaluoComercial() <= 129032000) {
            tarifa = 0.025;
        } else {
            tarifa = 0.035;
        }

        return vehiculo.getAvaluoComercial() * tarifa;
    }
}