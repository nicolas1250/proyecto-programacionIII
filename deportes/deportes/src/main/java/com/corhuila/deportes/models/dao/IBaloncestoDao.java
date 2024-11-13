package com.corhuila.deportes.models.dao;

import com.corhuila.deportes.models.entity.Baloncesto;
import org.springframework.data.repository.CrudRepository;

public interface IBaloncestoDao extends CrudRepository<Baloncesto, Long> {
}
