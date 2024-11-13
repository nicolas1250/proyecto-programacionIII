package com.corhuila.deportes.models.dao;

import com.corhuila.deportes.models.entity.Futbol;
import org.springframework.data.repository.CrudRepository;

public interface IFutbolDao extends CrudRepository<Futbol, Long>{
}

