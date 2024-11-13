package com.corhuila.deportes.controllers;

import com.corhuila.deportes.models.entity.Futbol;
import com.corhuila.deportes.models.services.IFutbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ={"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class FutbolRestController {
    @Autowired
    private IFutbolService futbolService;

    @GetMapping("/futbol")
    public List<Futbol> index() {

        return futbolService.findAll();
    }

    @GetMapping("/futbol/{id}")
    public Futbol show(@PathVariable Long id) {

        return futbolService.findById(id);
    }

    @PostMapping("/futbol")
    @ResponseStatus(HttpStatus.CREATED)
    public Futbol create(@RequestBody Futbol futbol) {
        return futbolService.save(futbol);
    }

    @PutMapping("/futbol/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Futbol update(@RequestBody Futbol futbol, @PathVariable Long id) {
        Futbol futbolActual = futbolService.findById(id);

        futbolActual.setNombre(futbol.getNombre());
        futbolActual.setJugadoresPorEquipos(futbol.getJugadoresPorEquipos());
        futbolActual.setDuracion(futbol.getDuracion());
        futbolActual.setPopularidadGlobal(futbol.getPopularidadGlobal());
        futbolActual.setOrigen(futbol.getOrigen());

        return futbolService.save(futbolActual);
    }

    @DeleteMapping("/futbol/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        futbolService.delete(id);
    }
}