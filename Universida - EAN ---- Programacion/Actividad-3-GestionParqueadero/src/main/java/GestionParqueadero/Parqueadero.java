package GestionParqueadero;

import java.util.ArrayList;
import java.util.List;

public class Parqueadero {

    private List<Vehiculo> vehiculos;

    public Parqueadero() {
        vehiculos = new ArrayList<>();
    }

    // Registrar la entrada de un vehículo
    public void registrarEntrada(Vehiculo vehiculo) {

        if (vehiculo == null) {
            System.out.println("No se puede registrar un vehículo vacío.");
            return;
        }

        if (buscarVehiculo(vehiculo.getPlaca()) != null) {
            System.out.println("Ya existe un vehículo con esa placa.");
            return;
        }

        vehiculos.add(vehiculo);

        System.out.println("Entrada registrada correctamente.");
        System.out.println("Vehículo: " + vehiculo.getPlaca());
        System.out.println("Hora de entrada: "
                + vehiculo.getHoraEntrada());
    }

    // Registrar la salida de un vehículo
    public void registrarSalida(String placa, double horaSalida) {

        Vehiculo vehiculo = buscarVehiculo(placa);

        if (vehiculo == null) {
            System.out.println("No se encontró un vehículo con esa placa.");
            return;
        }

        double tiempoEstadia =
                horaSalida - vehiculo.getHoraEntrada();

        if (tiempoEstadia < 0) {
            System.out.println("La hora de salida no puede ser menor "
                    + "que la hora de entrada.");
            return;
        }

        // Las fracciones de hora cuentan como una hora completa.
        long horas = (long) Math.ceil(tiempoEstadia);

        // Mínimo una hora de cobro.
        if (horas < 1) {
            horas = 1;
        }

        /*
         * POLIMORFISMO:
         * Vehiculo puede ser Automovil, Motocicleta o Camion.
         * Java ejecutará automáticamente el calcularTarifa()
         * correspondiente al tipo real del vehículo.
         */
        double costo = vehiculo.calcularTarifa(horas);

        System.out.println();
        System.out.println("========================================");
        System.out.println("         REGISTRO DE SALIDA");
        System.out.println("========================================");
        System.out.println("Placa: " + vehiculo.getPlaca());
        System.out.println("Marca: " + vehiculo.getMarca());
        System.out.println("Modelo: " + vehiculo.getModelo());
        System.out.println("Hora entrada: "
                + vehiculo.getHoraEntrada());
        System.out.println("Hora salida: " + horaSalida);
        System.out.println("Tiempo de estadía: "
                + tiempoEstadia + " horas");
        System.out.println("Horas cobradas: " + horas);
        System.out.println("Costo total: $" + costo);
        System.out.println("========================================");

        vehiculos.remove(vehiculo);
    }

    // Consultar los vehículos que están actualmente en el parqueadero
    public void consultarEstado() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("       ESTADO DEL PARQUEADERO");
        System.out.println("========================================");

        if (vehiculos.isEmpty()) {
            System.out.println("El parqueadero está vacío.");
            return;
        }

        System.out.println("Vehículos presentes: "
                + vehiculos.size());
        System.out.println();

        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
            System.out.println("Hora de entrada: "
                    + vehiculo.getHoraEntrada());
            System.out.println("----------------------------------------");
        }
    }

    // Buscar un vehículo por su placa
    private Vehiculo buscarVehiculo(String placa) {

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }

        return null;
    }
}