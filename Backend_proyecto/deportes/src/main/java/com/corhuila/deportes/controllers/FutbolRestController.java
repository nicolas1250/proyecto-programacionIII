// Define el paquete donde se encuentra el controlador.
package com.corhuila.deportes.controllers;

import com.corhuila.deportes.models.entity.Futbol; // Importa la entidad Futbol.
import com.corhuila.deportes.models.services.IFutbolService; // Importa el servicio de Futbol.
import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación para inyectar dependencias.
import org.springframework.http.HttpStatus; // Importa los códigos de estado HTTP.
import org.springframework.web.bind.annotation.*; // Importa las anotaciones para los controladores REST.

import java.util.List; // Importa la clase List para manejar colecciones.

@CrossOrigin(origins ={"http://localhost:4200"}) // Permite solicitudes desde el frontend en localhost:4200.
@RestController // Marca la clase como un controlador REST.
@RequestMapping("/api") // Define la ruta base para las peticiones de este controlador.
public class FutbolRestController {

    @Autowired
    private IFutbolService futbolService; // Inyecta el servicio de Futbol.

    // Método para obtener todos los registros de Futbol.
    @GetMapping("/futbol")
    public List<Futbol> index() {
        return futbolService.findAll(); // Llama al servicio para obtener todos los registros de futbol.
    }

    // Método para obtener un registro específico de Futbol por su id.
    @GetMapping("/futbol/{id}")
    public Futbol show(@PathVariable Long id) {
        return futbolService.findById(id); // Llama al servicio para obtener el registro por id.
    }

    // Método para crear un nuevo registro de Futbol.
    @PostMapping("/futbol")
    @ResponseStatus(HttpStatus.CREATED) // Devuelve el estado HTTP 201 (Creado).
    public Futbol create(@RequestBody Futbol futbol) {
        return futbolService.save(futbol); // Llama al servicio para guardar el nuevo registro.
    }

    // Método para actualizar un registro de Futbol existente.
    @PutMapping("/futbol/{id}")
    @ResponseStatus(HttpStatus.CREATED) // Devuelve el estado HTTP 201 (Creado).
    public Futbol update(@RequestBody Futbol futbol, @PathVariable Long id) {
        // Obtiene el registro existente por id.
        Futbol futbolActual = futbolService.findById(id);

        // Actualiza los campos del registro con los nuevos datos.
        futbolActual.setNombre(futbol.getNombre());
        futbolActual.setJugadoresPorEquipos(futbol.getJugadoresPorEquipos());
        futbolActual.setDuracion(futbol.getDuracion());
        futbolActual.setPopularidadGlobal(futbol.getPopularidadGlobal());
        futbolActual.setOrigen(futbol.getOrigen());

        // Guarda y retorna el registro actualizado.
        return futbolService.save(futbolActual);
    }

    // Método para eliminar un registro de Futbol por su id.
    @DeleteMapping("/futbol/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Devuelve el estado HTTP 204 (Sin contenido).
    public void delete(@PathVariable Long id) {
        futbolService.delete(id); // Llama al servicio para eliminar el registro por id.
    }
}
