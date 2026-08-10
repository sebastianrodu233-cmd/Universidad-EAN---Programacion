package GestionParqueadero;

public class Motocicleta extends Vehiculo {

    private int cilindraje;

    // Tarifa por hora
    private static final double TARIFA_POR_HORA = 3000;

    public Motocicleta(String placa, String marca, String modelo,
                       double horaEntrada, int cilindraje) {

        super(placa, marca, modelo, horaEntrada);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularTarifa(long horas) {
        return horas * TARIFA_POR_HORA;
    }

    @Override
    public String toString() {
        return "Motocicleta"
                + " | Placa: " + getPlaca()
                + " | Marca: " + getMarca()
                + " | Modelo: " + getModelo()
                + " | Cilindraje: " + cilindraje + " cc";
    }
}