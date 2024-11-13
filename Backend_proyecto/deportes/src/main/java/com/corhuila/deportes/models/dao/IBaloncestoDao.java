// Define el paquete donde se encuentra la interfaz.
package com.corhuila.deportes.models.dao;

import com.corhuila.deportes.models.entity.Baloncesto; // Importa la entidad Baloncesto.
import org.springframework.data.repository.CrudRepository; // Importa la interfaz CrudRepository de Spring Data.

// Define una interfaz DAO (Data Access Object) para la entidad Baloncesto.
public interface IBaloncestoDao extends CrudRepository<Baloncesto, Long> {
    // Hereda de CrudRepository, lo que proporciona métodos CRUD básicos:
    // - save(): Guarda una entidad en la base de datos.
    // - findById(): Busca una entidad por su id.
    // - findAll(): Obtiene todas las entidades.
    // - deleteById(): Elimina una entidad por su id.
    // - count(): Cuenta el número de entidades.
}
