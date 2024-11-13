package com.corhuila.deportes.models.services;

// Importaciones necesarias para el funcionamiento del servicio
import com.corhuila.deportes.models.dao.IFutbolDao;
import com.corhuila.deportes.models.entity.Futbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Indica que esta clase es un servicio de Spring, que se utilizará en la capa de lógica de negocio
@Service
public class FutbolServiceImpl implements IFutbolService {

    // Inyección de dependencia del repositorio FutbolDao
    @Autowired
    private IFutbolDao futbolDao;

    // Método que recupera todos los objetos Futbol de la base de datos
    @Override
    @Transactional(readOnly = true) // Marca el método como solo lectura para optimizar el rendimiento
    public List<Futbol> findAll() {
        // Llama al repositorio para obtener todos los objetos Futbol
        return (List<Futbol>) futbolDao.findAll();
    }

    // Método que busca un objeto Futbol por su id
    @Override
    @Transactional(readOnly = true) // Marca el método como solo lectura
    public Futbol findById(Long id) {
        // Llama al repositorio para obtener un Futbol por su id. Si no lo encuentra, devuelve null
        return futbolDao.findById(id).orElse(null);
    }

    // Método que guarda un nuevo objeto Futbol o actualiza uno existente
    @Override
    @Transactional // Marca el método para que se ejecute en una transacción
    public Futbol save(Futbol futbol) {
        // Llama al repositorio para guardar o actualizar el objeto Futbol
        return futbolDao.save(futbol);
    }

    // Método que elimina un objeto Futbol por su id
    @Override
    @Transactional // Marca el método para que se ejecute en una transacción
    public void delete(Long id) {
        // Llama al repositorio para eliminar un Futbol por su id
        futbolDao.deleteById(id);
    }
}
