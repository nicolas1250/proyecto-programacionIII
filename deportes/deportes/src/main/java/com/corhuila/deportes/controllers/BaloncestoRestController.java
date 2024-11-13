package com.corhuila.deportes.controllers;

import com.corhuila.deportes.models.entity.Baloncesto;
import com.corhuila.deportes.models.services.IBaloncestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ={"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class BaloncestoRestController {
    @Autowired
    private IBaloncestoService baloncestoService;

    @GetMapping("/baloncesto")
    public List<Baloncesto> index() {

        return baloncestoService.findAll();
    }

    @GetMapping("/baloncesto/{id}")
    public Baloncesto show(@PathVariable Long id) {

        return baloncestoService.findById(id);
    }

    @PostMapping("/baloncesto")
    @ResponseStatus(HttpStatus.CREATED)
    public Baloncesto create(@RequestBody Baloncesto baloncesto) {
        return baloncestoService.save(baloncesto);
    }

    @PutMapping("/baloncesto/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Baloncesto update(@RequestBody Baloncesto baloncesto, @PathVariable Long id) {
        Baloncesto baloncestoActual = baloncestoService.findById(id);

        baloncestoActual.setNombre(baloncesto.getNombre());
        baloncestoActual.setJugadoresPorEquipos(baloncesto.getJugadoresPorEquipos());
        baloncestoActual.setDuracion(baloncesto.getDuracion());
        baloncestoActual.setPopularidadGlobal(baloncesto.getPopularidadGlobal());
        baloncestoActual.setOrigen(baloncesto.getOrigen());

        return baloncestoService.save(baloncestoActual);
    }

    @DeleteMapping("/baloncesto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        baloncestoService.delete(id);
    }
}