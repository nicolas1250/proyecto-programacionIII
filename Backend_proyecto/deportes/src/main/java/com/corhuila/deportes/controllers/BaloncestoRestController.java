// Define el paquete donde se encuentra el controlador.
package com.corhuila.deportes.controllers;

import com.corhuila.deportes.models.entity.Baloncesto; // Importa la entidad Baloncesto.
import com.corhuila.deportes.models.services.IBaloncestoService; // Importa el servicio de Baloncesto.
import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación para inyectar dependencias.
import org.springframework.http.HttpStatus; // Importa los códigos de estado HTTP.
import org.springframework.web.bind.annotation.*; // Importa las anotaciones para los controladores REST.

import java.util.List; // Importa la clase List para manejar colecciones.

@CrossOrigin(origins ={"http://localhost:4200"}) // Permite solicitudes desde el frontend en localhost:4200.
@RestController // Marca la clase como un controlador REST.
@RequestMapping("/api") // Define la ruta base para las peticiones de este controlador.
public class BaloncestoRestController {

    @Autowired
    private IBaloncestoService baloncestoService; // Inyecta el servicio de Baloncesto.

    // Método para obtener todos los registros de Baloncesto.
    @GetMapping("/baloncesto")
    public List<Baloncesto> index() {
        return baloncestoService.findAll(); // Llama al servicio para obtener todos los registros de baloncesto.
    }

    // Método para obtener un registro específico de Baloncesto por su id.
    @GetMapping("/baloncesto/{id}")
    public Baloncesto show(@PathVariable Long id) {
        return baloncestoService.findById(id); // Llama al servicio para obtener el registro por id.
    }

    // Método para crear un nuevo registro de Baloncesto.
    @PostMapping("/baloncesto")
    @ResponseStatus(HttpStatus.CREATED) // Devuelve el estado HTTP 201 (Creado).
    public Baloncesto create(@RequestBody Baloncesto baloncesto) {
        return baloncestoService.save(baloncesto); // Llama al servicio para guardar el nuevo registro.
    }

    // Método para actualizar un registro de Baloncesto existente.
    @PutMapping("/baloncesto/{id}")
    @ResponseStatus(HttpStatus.CREATED) // Devuelve el estado HTTP 201 (Creado).
    public Baloncesto update(@RequestBody Baloncesto baloncesto, @PathVariable Long id) {
        // Obtiene el registro existente por id.
        Baloncesto baloncestoActual = baloncestoService.findById(id);

        // Actualiza los campos del registro con los nuevos datos.
        baloncestoActual.setNombre(baloncesto.getNombre());
        baloncestoActual.setJugadoresPorEquipos(baloncesto.getJugadoresPorEquipos());
        baloncestoActual.setDuracion(baloncesto.getDuracion());
        baloncestoActual.setPopularidadGlobal(baloncesto.getPopularidadGlobal());
        baloncestoActual.setOrigen(baloncesto.getOrigen());

        // Guarda y retorna el registro actualizado.
        return baloncestoService.save(baloncestoActual);
    }

    // Método para eliminar un registro de Baloncesto por su id.
    @DeleteMapping("/baloncesto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Devuelve el estado HTTP 204 (Sin contenido).
    public void delete(@PathVariable Long id) {
        baloncestoService.delete(id); // Llama al servicio para eliminar el registro por id.
    }
}
