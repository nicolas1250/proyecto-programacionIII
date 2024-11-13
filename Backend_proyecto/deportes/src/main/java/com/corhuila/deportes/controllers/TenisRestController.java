package com.corhuila.deportes.controllers;

// Importaciones necesarias para el funcionamiento del controlador
import com.corhuila.deportes.models.entity.Tenis;
import com.corhuila.deportes.models.services.ITenisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Habilita el acceso a la API desde otro origen (en este caso localhost:4200 para aplicaciones Angular)
@CrossOrigin(origins ={"http://localhost:4200"})
// Indica que esta clase es un controlador REST que manejará solicitudes HTTP
@RestController
// Define la ruta base de los endpoints de este controlador ("/api")
@RequestMapping("/api")
public class TenisRestController {

    // Inyección de dependencia del servicio ITenisService
    @Autowired
    private ITenisService tenisService;

    // Endpoint GET que devuelve una lista de todos los objetos Tenis
    @GetMapping("/tenis")
    public List<Tenis> index() {
        // Llama al servicio para obtener todos los objetos Tenis
        return tenisService.findAll();
    }

    // Endpoint GET que devuelve un objeto Tenis según su id
    @GetMapping("/tenis/{id}")
    public Tenis show(@PathVariable Long id) {
        // Llama al servicio para obtener un Tenis específico por su id
        return tenisService.findById(id);
    }

    // Endpoint POST para crear un nuevo objeto Tenis
    @PostMapping("/tenis")
    // Indica que se debe responder con el código de estado HTTP 201 (CREADO) al crear correctamente un recurso
    @ResponseStatus(HttpStatus.CREATED)
    public Tenis create(@RequestBody Tenis tenis) {
        // Llama al servicio para guardar el nuevo objeto Tenis
        return tenisService.save(tenis);
    }

    // Endpoint PUT para actualizar un objeto Tenis existente
    @PutMapping("/tenis/{id}")
    // Indica que se debe responder con el código de estado HTTP 201 (CREADO) al actualizar el recurso
    @ResponseStatus(HttpStatus.CREATED)
    public Tenis update(@RequestBody Tenis tenis, @PathVariable Long id) {
        // Obtiene el Tenis actual de la base de datos
        Tenis tenisActual = tenisService.findById(id);

        // Actualiza los valores del Tenis con los datos del objeto recibido en la solicitud
        tenisActual.setNombre(tenis.getNombre());
        tenisActual.setJugadoresPorEquipos(tenis.getJugadoresPorEquipos());
        tenisActual.setDuracion(tenis.getDuracion());
        tenisActual.setPopularidadGlobal(tenis.getPopularidadGlobal());
        tenisActual.setOrigen(tenis.getOrigen());

        // Guarda y devuelve el Tenis actualizado
        return tenisService.save(tenisActual);
    }

    // Endpoint DELETE para eliminar un objeto Tenis por su id
    @DeleteMapping("/tenis/{id}")
    // Indica que la respuesta tendrá el código de estado HTTP 204 (SIN CONTENIDO) tras eliminar el recurso
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        // Llama al servicio para eliminar el Tenis con el id proporcionado
        tenisService.delete(id);
    }
}
