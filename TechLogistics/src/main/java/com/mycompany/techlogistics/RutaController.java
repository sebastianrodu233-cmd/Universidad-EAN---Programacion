package com.mycompany.techlogistics;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rutas")
public class RutaController {

    private final RutaRepository rutaRepository;

    public RutaController(RutaRepository rutaRepository) {
        this.rutaRepository = rutaRepository;
    }

    @GetMapping
    public List<Ruta> obtenerRutas() {
        return rutaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ruta obtenerRuta(@PathVariable Long id) {
        return rutaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Ruta crearRuta(@RequestBody Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    @DeleteMapping("/{id}")
    public void eliminarRuta(@PathVariable Long id) {
        rutaRepository.deleteById(id);
    }
}