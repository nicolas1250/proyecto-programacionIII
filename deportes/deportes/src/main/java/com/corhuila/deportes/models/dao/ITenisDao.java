package com.corhuila.deportes.models.dao;

import com.corhuila.deportes.models.entity.Tenis;
import org.springframework.data.repository.CrudRepository;

public interface ITenisDao extends CrudRepository<Tenis, Long> {
}
