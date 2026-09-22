package com.mycompany.techlogistics;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fechaPedido;
    private String direccionEntrega;
    private double total;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Transportista transportista;

    @ManyToOne
    private Ruta ruta;

    @ManyToOne
    private EstadoEnvio estadoEnvio;

    public Pedido() {
    }

    public Pedido(String fechaPedido, String direccionEntrega, double total,
                   Cliente cliente, Transportista transportista,
                   Ruta ruta, EstadoEnvio estadoEnvio) {

        this.fechaPedido = fechaPedido;
        this.direccionEntrega = direccionEntrega;
        this.total = total;
        this.cliente = cliente;
        this.transportista = transportista;
        this.ruta = ruta;
        this.estadoEnvio = estadoEnvio;
    }

    public Long getId() {
        return id;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Transportista getTransportista() {
        return transportista;
    }

    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public EstadoEnvio getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(EstadoEnvio estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }
}