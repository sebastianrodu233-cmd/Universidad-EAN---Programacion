package com.mycompany.centralpacientes;

import java.util.Scanner;

public class CentralPacientes {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ListaPacientes lista = new ListaPacientes();

        int opcion;

        do {
            System.out.println("\n===== CENTRAL DE PACIENTES =====");
            System.out.println("1. Agregar paciente");
            System.out.println("2. Buscar paciente");
            System.out.println("3. Eliminar paciente");
            System.out.println("4. Mostrar pacientes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese el ID del paciente: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();

                    if (lista.buscar(id) != null) {
                        System.out.println("Ya existe un paciente con ese ID.");
                        break;
                    }

                    System.out.print("Ingrese el nombre: ");
                    String nombre = entrada.nextLine();

                    System.out.print("Ingrese la edad: ");
                    int edad = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Ingrese la clinica: ");
                    String clinica = entrada.nextLine();

                    Paciente paciente = new Paciente(id, nombre, edad, clinica);
                    lista.agregar(paciente);

                    System.out.println("Paciente agregado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el ID del paciente a buscar: ");
                    int idBuscar = entrada.nextInt();

                    Paciente encontrado = lista.buscar(idBuscar);

                    if (encontrado != null) {
                        System.out.println("Paciente encontrado:");
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el ID del paciente a eliminar: ");
                    int idEliminar = entrada.nextInt();

                    if (lista.eliminar(idEliminar)) {
                        System.out.println("Paciente eliminado correctamente.");
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n===== LISTA DE PACIENTES =====");
                    lista.mostrar();
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 5);

        entrada.close();
    }
}