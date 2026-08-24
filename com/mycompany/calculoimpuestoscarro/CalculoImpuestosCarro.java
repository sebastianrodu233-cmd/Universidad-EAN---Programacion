package com.mycompany.calculoimpuestoscarro;

import com.mycompany.calculoimpuestoscarro.controlador.VehiculoController;
import com.mycompany.calculoimpuestoscarro.vista.VentanaPrincipal;

public class CalculoImpuestosCarro {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {

            VentanaPrincipal vista = new VentanaPrincipal();

            new VehiculoController(vista);

            vista.setVisible(true);
        });
    }
}