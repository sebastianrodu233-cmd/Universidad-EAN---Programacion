package com.mycompany.techlogistics;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estados-envio")
public class EstadoEnvioController {

    private final EstadoEnvioRepository estadoEnvioRepository;

    public EstadoEnvioController(EstadoEnvioRepository estadoEnvioRepository) {
        this.estadoEnvioRepository = estadoEnvioRepository;
    }

    @GetMapping
    public List<EstadoEnvio> obtenerEstados() {
        return estadoEnvioRepository.findAll();
    }

    @GetMapping("/{id}")
    public EstadoEnvio obtenerEstado(@PathVariable Long id) {
        return estadoEnvioRepository.findById(id).orElse(null);
    }

    @PostMapping
    public EstadoEnvio crearEstado(@RequestBody EstadoEnvio estado) {
        return estadoEnvioRepository.save(estado);
    }

    @DeleteMapping("/{id}")
    public void eliminarEstado(@PathVariable Long id) {
        estadoEnvioRepository.deleteById(id);
    }
}