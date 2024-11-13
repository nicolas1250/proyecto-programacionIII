package com.corhuila.deportes.models.services;
import com.corhuila.deportes.models.entity.Tenis;
import java.util.List;

public interface ITenisService {
    public List<Tenis> findAll();
    public Tenis findById(Long id);

    public Tenis save (Tenis deporte);


    public void delete (Long id);

}
