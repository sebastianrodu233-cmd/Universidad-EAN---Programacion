package com.mycompany.calculoimpuestoscarro.controlador;

import com.mycompany.calculoimpuestoscarro.modelo.CalculadoraImpuestos;
import com.mycompany.calculoimpuestoscarro.modelo.Vehiculo;
import com.mycompany.calculoimpuestoscarro.vista.VentanaPrincipal;

public class VehiculoController {

    private final VentanaPrincipal vista;
    private final CalculadoraImpuestos calculadora;

    public VehiculoController(VentanaPrincipal vista) {
        this.vista = vista;
        this.calculadora = new CalculadoraImpuestos();

        this.vista.getBtnCalcular().addActionListener(e -> calcularImpuesto());
    }

    private void calcularImpuesto() {

        try {
            String marca = vista.getTxtMarca().getText().trim();
            String modelo = vista.getTxtModelo().getText().trim();

            int anio = Integer.parseInt(
                    vista.getTxtAnio().getText().trim()
            );

            int cilindraje = Integer.parseInt(
                    vista.getTxtCilindraje().getText().trim()
            );

            double avaluo = Double.parseDouble(
                    vista.getTxtAvaluo().getText().trim()
            );

            String tipoUso = (String) vista.getCmbTipoUso().getSelectedItem();

            if (marca.isEmpty() || modelo.isEmpty()) {
                vista.mostrarError(
                        "Por favor, ingrese la marca y el modelo."
                );
                return;
            }

            if (anio <= 0) {
                vista.mostrarError(
                        "El año de fabricación debe ser válido."
                );
                return;
            }

            if (cilindraje <= 0) {
                vista.mostrarError(
                        "El cilindraje debe ser mayor que cero."
                );
                return;
            }

            if (avaluo <= 0) {
                vista.mostrarError(
                        "El avalúo comercial debe ser mayor que cero."
                );
                return;
            }

            Vehiculo vehiculo = new Vehiculo(
                    marca,
                    modelo,
                    anio,
                    cilindraje,
                    avaluo,
                    tipoUso
            );

            double impuesto = calculadora.calcularImpuesto(vehiculo);

            vista.mostrarResultado(impuesto);

        } catch (NumberFormatException e) {

            vista.mostrarError(
                    "Por favor, ingrese valores numéricos válidos."
            );
        }
    }
}