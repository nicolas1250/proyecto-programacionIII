package com.corhuila.deportes.models.services;

import com.corhuila.deportes.models.entity.Baloncesto;
import java.util.List;

public interface IBaloncestoService {
    public List<Baloncesto> findAll();
    public Baloncesto findById(Long id);

    public Baloncesto save (Baloncesto deporte);


    public void delete (Long id);

}
