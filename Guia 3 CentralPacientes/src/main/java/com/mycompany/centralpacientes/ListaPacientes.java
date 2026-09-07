package com.mycompany.centralpacientes;

public class ListaPacientes {

    private Nodo cabeza;

    public ListaPacientes() {
        cabeza = null;
    }

    // Agregar un paciente al final de la lista
    public void agregar(Paciente paciente) {
        Nodo nuevo = new Nodo(paciente);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = nuevo;
    }

    // Buscar un paciente por su ID
    public Paciente buscar(int id) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.paciente.getId() == id) {
                return actual.paciente;
            }

            actual = actual.siguiente;
        }

        return null;
    }

    // Eliminar un paciente por su ID
    public boolean eliminar(int id) {
        if (cabeza == null) {
            return false;
        }

        if (cabeza.paciente.getId() == id) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {
            if (actual.siguiente.paciente.getId() == id) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    // Mostrar todos los pacientes
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        Nodo actual = cabeza;

        while (actual != null) {
            System.out.println(actual.paciente);
            actual = actual.siguiente;
        }
    }
}