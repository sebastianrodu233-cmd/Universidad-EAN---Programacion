package GestionParqueadero;

public class Camion extends Vehiculo {

    private double capacidadCarga;

    // Tarifa por hora
    private static final double TARIFA_POR_HORA = 8000;

    public Camion(String placa, String marca, String modelo,
                  double horaEntrada, double capacidadCarga) {

        super(placa, marca, modelo, horaEntrada);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularTarifa(long horas) {
        return horas * TARIFA_POR_HORA;
    }

    @Override
    public String toString() {
        return "Camion"
                + " | Placa: " + getPlaca()
                + " | Marca: " + getMarca()
                + " | Modelo: " + getModelo()
                + " | Capacidad de carga: " + capacidadCarga + " toneladas";
    }
}