package com.mycompany.techlogistics;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transportistas")
public class TransportistaController {

    private final TransportistaRepository transportistaRepository;

    public TransportistaController(TransportistaRepository transportistaRepository) {
        this.transportistaRepository = transportistaRepository;
    }

    @GetMapping
    public List<Transportista> obtenerTransportistas() {
        return transportistaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Transportista obtenerTransportista(@PathVariable Long id) {
        return transportistaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Transportista crearTransportista(@RequestBody Transportista transportista) {
        return transportistaRepository.save(transportista);
    }

    @DeleteMapping("/{id}")
    public void eliminarTransportista(@PathVariable Long id) {
        transportistaRepository.deleteById(id);
    }
}