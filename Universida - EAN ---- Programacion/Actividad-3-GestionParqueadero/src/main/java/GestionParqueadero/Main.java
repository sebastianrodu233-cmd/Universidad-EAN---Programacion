package GestionParqueadero;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero();

        int opcion;

        do {

            System.out.println();
            System.out.println("========================================");
            System.out.println("       SISTEMA DE PARQUEADERO");
            System.out.println("========================================");
            System.out.println("1. Registrar entrada de vehículo");
            System.out.println("2. Registrar salida de vehículo");
            System.out.println("3. Consultar estado del parqueadero");
            System.out.println("4. Salir");
            System.out.println("========================================");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println();
                    System.out.println("--- REGISTRAR ENTRADA ---");

                    System.out.println("1. Automóvil");
                    System.out.println("2. Motocicleta");
                    System.out.println("3. Camión");

                    System.out.print("Seleccione el tipo de vehículo: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();

                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();

                    System.out.print("Hora de entrada (ejemplo 8.5 para 8:30): ");
                    double horaEntrada = scanner.nextDouble();
                    scanner.nextLine();

                    if (tipo == 1) {

                        System.out.print("Tipo de combustible: ");
                        String combustible = scanner.nextLine();

                        Automovil automovil = new Automovil(
                                placa,
                                marca,
                                modelo,
                                horaEntrada,
                                combustible
                        );

                        parqueadero.registrarEntrada(automovil);

                    } else if (tipo == 2) {

                        System.out.print("Cilindraje: ");
                        int cilindraje = scanner.nextInt();
                        scanner.nextLine();

                        Motocicleta motocicleta = new Motocicleta(
                                placa,
                                marca,
                                modelo,
                                horaEntrada,
                                cilindraje
                        );

                        parqueadero.registrarEntrada(motocicleta);

                    } else if (tipo == 3) {

                        System.out.print("Capacidad de carga en toneladas: ");
                        double capacidadCarga = scanner.nextDouble();
                        scanner.nextLine();

                        Camion camion = new Camion(
                                placa,
                                marca,
                                modelo,
                                horaEntrada,
                                capacidadCarga
                        );

                        parqueadero.registrarEntrada(camion);

                    } else {

                        System.out.println("Tipo de vehículo inválido.");
                    }

                    break;

                case 2:

                    System.out.println();
                    System.out.println("--- REGISTRAR SALIDA ---");

                    System.out.print("Ingrese la placa: ");
                    String placaSalida = scanner.nextLine();

                    System.out.print("Ingrese la hora de salida: ");
                    double horaSalida = scanner.nextDouble();
                    scanner.nextLine();

                    parqueadero.registrarSalida(
                            placaSalida,
                            horaSalida
                    );

                    break;

                case 3:

                    parqueadero.consultarEstado();

                    break;

                case 4:

                    System.out.println();
                    System.out.println("Gracias por utilizar el sistema.");

                    break;

                default:

                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}