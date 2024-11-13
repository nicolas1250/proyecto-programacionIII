package com.corhuila.deportes.models.services;

// Importación necesaria para trabajar con la entidad Baloncesto
import com.corhuila.deportes.models.entity.Baloncesto;
import java.util.List;

// Define una interfaz para el servicio de Baloncesto que será implementada por una clase de servicio
public interface IBaloncestoService {

    // Método que devuelve una lista de todos los objetos Baloncesto
    public List<Baloncesto> findAll();

    // Método que busca un objeto Baloncesto por su id
    public Baloncesto findById(Long id);

    // Método que guarda un objeto Baloncesto (puede ser para crear o actualizar)
    public Baloncesto save (Baloncesto deporte);

    // Método que elimina un objeto Baloncesto por su id
    public void delete (Long id);
}
