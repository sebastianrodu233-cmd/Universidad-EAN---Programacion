package com.mycompany.techlogistics;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final TransportistaRepository transportistaRepository;
    private final RutaRepository rutaRepository;
    private final EstadoEnvioRepository estadoEnvioRepository;

    public PedidoController(
            PedidoRepository pedidoRepository,
            ClienteRepository clienteRepository,
            TransportistaRepository transportistaRepository,
            RutaRepository rutaRepository,
            EstadoEnvioRepository estadoEnvioRepository) {

        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.transportistaRepository = transportistaRepository;
        this.rutaRepository = rutaRepository;
        this.estadoEnvioRepository = estadoEnvioRepository;
    }

    @GetMapping
    public List<Pedido> obtenerPedidos() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido obtenerPedido(@PathVariable Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {

        if (pedido.getCliente() != null) {
            pedido.setCliente(
                clienteRepository.findById(pedido.getCliente().getId()).orElse(null)
            );
        }

        if (pedido.getTransportista() != null) {
            pedido.setTransportista(
                transportistaRepository.findById(pedido.getTransportista().getId()).orElse(null)
            );
        }

        if (pedido.getRuta() != null) {
            pedido.setRuta(
                rutaRepository.findById(pedido.getRuta().getId()).orElse(null)
            );
        }

        if (pedido.getEstadoEnvio() != null) {
            pedido.setEstadoEnvio(
                estadoEnvioRepository.findById(pedido.getEstadoEnvio().getId()).orElse(null)
            );
        }

        return pedidoRepository.save(pedido);
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
}