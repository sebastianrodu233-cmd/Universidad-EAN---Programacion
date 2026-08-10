package GestionParqueadero;

public class Automovil extends Vehiculo {

    private String tipoCombustible;

    // Tarifa por hora
    private static final double TARIFA_POR_HORA = 5000;

    public Automovil(String placa, String marca, String modelo,
                     double horaEntrada, String tipoCombustible) {

        super(placa, marca, modelo, horaEntrada);
        this.tipoCombustible = tipoCombustible;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public double calcularTarifa(long horas) {
        return horas * TARIFA_POR_HORA;
    }

    @Override
    public String toString() {
        return "Automovil"
                + " | Placa: " + getPlaca()
                + " | Marca: " + getMarca()
                + " | Modelo: " + getModelo()
                + " | Combustible: " + tipoCombustible;
    }
}