package com.corhuila.deportes.models.services;
// Importación necesaria para trabajar con la entidad Futbol
import com.corhuila.deportes.models.entity.Futbol;

import java.util.List;
// Define una interfaz para el servicio de Futbol que será implementada por una clase de servicio
public interface IFutbolService {
    // Método que devuelve una lista de todos los objetos futbol

    public List<Futbol> findAll();
    // Método que busca un objeto Futbol por su id

    public Futbol findById(Long id);
    // Método que guarda un objeto Futbol (puede ser para crear o actualizar)
    public Futbol save (Futbol deporte);
    // Método que elimina un objeto Futbol por su id
    public void delete (Long id);


}
