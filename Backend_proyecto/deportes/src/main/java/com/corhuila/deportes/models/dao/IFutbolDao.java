package com.corhuila.deportes.models.dao;

import com.corhuila.deportes.models.entity.Futbol;// Importa la entidad futbol.
import org.springframework.data.repository.CrudRepository;// Importa la interfaz CrudRepository de Spring Data.

public interface IFutbolDao extends CrudRepository<Futbol, Long>{
    // Hereda de CrudRepository, lo que proporciona métodos CRUD básicos:
    // - save(): Guarda una entidad en la base de datos.
    // - findById(): Busca una entidad por su id.
    // - findAll(): Obtiene todas las entidades.
    // - deleteById(): Elimina una entidad por su id.
    // - count(): Cuenta el número de entidades.
}

