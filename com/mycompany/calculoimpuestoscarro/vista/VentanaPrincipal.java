package com.mycompany.calculoimpuestoscarro.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtAnio;
    private JTextField txtCilindraje;
    private JTextField txtAvaluo;
    private JComboBox<String> cmbTipoUso;
    private JButton btnCalcular;
    private JLabel lblResultado;

    public VentanaPrincipal() {
        configurarVentana();
        crearComponentes();
    }

    private void configurarVentana() {
        setTitle("Cálculo de Impuestos de un Carro");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void crearComponentes() {

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitulo = new JLabel("CÁLCULO DE IMPUESTOS DE UN CARRO");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        txtMarca = new JTextField();
        txtModelo = new JTextField();
        txtAnio = new JTextField();
        txtCilindraje = new JTextField();
        txtAvaluo = new JTextField();

        cmbTipoUso = new JComboBox<>(
                new String[]{"Particular", "Público"}
        );

        btnCalcular = new JButton("Calcular impuesto");

        lblResultado = new JLabel("Impuesto a pagar: $0");
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 14));

        panel.add(new JLabel("Marca:"));
        panel.add(txtMarca);

        panel.add(new JLabel("Modelo:"));
        panel.add(txtModelo);

        panel.add(new JLabel("Año de fabricación:"));
        panel.add(txtAnio);

        panel.add(new JLabel("Cilindraje (cc):"));
        panel.add(txtCilindraje);

        panel.add(new JLabel("Avalúo comercial:"));
        panel.add(txtAvaluo);

        panel.add(new JLabel("Tipo de uso:"));
        panel.add(cmbTipoUso);

        panel.add(new JLabel(""));
        panel.add(btnCalcular);

        panel.add(new JLabel(""));
        panel.add(lblResultado);

        setLayout(new BorderLayout());

        add(lblTitulo, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }

    public JTextField getTxtMarca() {
        return txtMarca;
    }

    public JTextField getTxtModelo() {
        return txtModelo;
    }

    public JTextField getTxtAnio() {
        return txtAnio;
    }

    public JTextField getTxtCilindraje() {
        return txtCilindraje;
    }

    public JTextField getTxtAvaluo() {
        return txtAvaluo;
    }

    public JComboBox<String> getCmbTipoUso() {
        return cmbTipoUso;
    }

    public JButton getBtnCalcular() {
        return btnCalcular;
    }

    public void mostrarResultado(double impuesto) {
        lblResultado.setText(
                String.format("Impuesto a pagar: $%,.2f", impuesto)
        );
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Información",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}