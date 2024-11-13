package com.corhuila.deportes.models.services;

// Importaciones necesarias para el funcionamiento del servicio
import com.corhuila.deportes.models.dao.ITenisDao;
import com.corhuila.deportes.models.entity.Tenis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Indica que esta clase es un servicio de Spring, que se utilizará en la capa de lógica de negocio
@Service
public class TenisServiceImpl implements ITenisService {

    // Inyección de dependencia del repositorio TenisDao
    @Autowired
    private ITenisDao tenisDao;

    // Método que recupera todos los objetos Tenis de la base de datos
    @Override
    @Transactional(readOnly = true) // Marca el método como solo lectura para optimizar el rendimiento
    public List<Tenis> findAll() {
        // Llama al repositorio para obtener todos los objetos Tenis
        return (List<Tenis>) tenisDao.findAll();
    }

    // Método que busca un objeto Tenis por su id
    @Override
    @Transactional(readOnly = true) // Marca el método como solo lectura
    public Tenis findById(Long id) {
        // Llama al repositorio para obtener un Tenis por su id. Si no lo encuentra, devuelve null
        return tenisDao.findById(id).orElse(null);
    }

    // Método que guarda un nuevo objeto Tenis o actualiza uno existente
    @Override
    @Transactional // Marca el método para que se ejecute en una transacción
    public Tenis save(Tenis tenis) {
        // Llama al repositorio para guardar o actualizar el objeto Tenis
        return tenisDao.save(tenis);
    }

    // Método que elimina un objeto Tenis por su id
    @Override
    @Transactional // Marca el método para que se ejecute en una transacción
    public void delete(Long id) {
        // Llama al repositorio para eliminar un Tenis por su id
        tenisDao.deleteById(id);
    }
}
