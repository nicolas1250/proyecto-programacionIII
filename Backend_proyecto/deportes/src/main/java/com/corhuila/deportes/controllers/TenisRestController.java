package com.corhuila.deportes.controllers;

import com.corhuila.deportes.models.entity.Tenis;
import com.corhuila.deportes.models.services.ITenisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ={"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class TenisRestController {
    @Autowired
    private ITenisService tenisService;

    @GetMapping("/tenis")
    public List<Tenis> index() {

        return tenisService.findAll();
    }

    @GetMapping("/tenis/{id}")
    public Tenis show(@PathVariable Long id) {

        return tenisService.findById(id);
    }

    @PostMapping("/tenis")
    @ResponseStatus(HttpStatus.CREATED)
    public Tenis create(@RequestBody Tenis tenis) {
        return tenisService.save(tenis);
    }

    @PutMapping("/tenis/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Tenis update(@RequestBody Tenis tenis, @PathVariable Long id) {
        Tenis tenisActual = tenisService.findById(id);

        tenisActual.setNombre(tenis.getNombre());
        tenisActual.setJugadoresPorEquipos(tenis.getJugadoresPorEquipos());
        tenisActual.setDuracion(tenis.getDuracion());
        tenisActual.setPopularidadGlobal(tenis.getPopularidadGlobal());
        tenisActual.setOrigen(tenis.getOrigen());

        return tenisService.save(tenisActual);
    }

    @DeleteMapping("/tenis/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        tenisService.delete(id);
    }
}