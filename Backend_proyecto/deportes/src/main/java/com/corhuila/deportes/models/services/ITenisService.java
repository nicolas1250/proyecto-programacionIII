package com.corhuila.deportes.models.services;
// Importación necesaria para trabajar con la entidad Tenis
import com.corhuila.deportes.models.entity.Tenis;
import java.util.List;
// Define una interfaz para el servicio de Tenis que será implementada por una clase de servicio
public interface ITenisService {
    // Método que devuelve una lista de todos los objetos tenis

    public List<Tenis> findAll();
    // Método que busca un objeto Tenis por su id

    public Tenis findById(Long id);
    // Método que guarda un objeto Tenis (puede ser para crear o actualizar)
    public Tenis save (Tenis deporte);
    // Método que elimina un objeto Tenis por su id
    public void delete (Long id);

}
