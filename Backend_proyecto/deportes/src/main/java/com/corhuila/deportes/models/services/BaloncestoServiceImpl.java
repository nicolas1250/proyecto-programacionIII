package com.corhuila.deportes.models.services;

// Importaciones necesarias para el funcionamiento del servicio
import com.corhuila.deportes.models.dao.IBaloncestoDao;
import com.corhuila.deportes.models.entity.Baloncesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Indica que esta clase es un servicio de Spring, que se utilizará en la capa de lógica de negocio
@Service
public class BaloncestoServiceImpl implements IBaloncestoService {

    // Inyección de dependencia del repositorio BaloncestoDao
    @Autowired
    private IBaloncestoDao baloncestoDao;

    // Método que recupera todos los objetos Baloncesto de la base de datos
    @Override
    @Transactional(readOnly = true) // Marca el método como solo lectura para optimizar el rendimiento
    public List<Baloncesto> findAll() {
        // Llama al repositorio para obtener todos los objetos Baloncesto
        return (List<Baloncesto>) baloncestoDao.findAll();
    }

    // Método que busca un objeto Baloncesto por su id
    @Override
    @Transactional(readOnly = true) // Marca el método como solo lectura
    public Baloncesto findById(Long id) {
        // Llama al repositorio para obtener un Baloncesto por su id. Si no lo encuentra, devuelve null
        return baloncestoDao.findById(id).orElse(null);
    }

    // Método que guarda un nuevo objeto Baloncesto o actualiza uno existente
    @Override
    @Transactional // Marca el método para que se ejecute en una transacción
    public Baloncesto save(Baloncesto baloncesto) {
        // Llama al repositorio para guardar o actualizar el objeto Baloncesto
        return baloncestoDao.save(baloncesto);
    }

    // Método que elimina un objeto Baloncesto por su id
    @Override
    @Transactional // Marca el método para que se ejecute en una transacción
    public void delete(Long id) {
        // Llama al repositorio para eliminar un Baloncesto por su id
        baloncestoDao.deleteById(id);
    }
}
