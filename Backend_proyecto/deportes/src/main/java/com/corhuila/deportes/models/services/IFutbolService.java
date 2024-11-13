package com.corhuila.deportes.models.services;

import com.corhuila.deportes.models.entity.Futbol;

import java.util.List;

public interface IFutbolService {
    public List<Futbol> findAll();
    public Futbol findById(Long id);

    public Futbol save (Futbol deporte);


    public void delete (Long id);


}
