package com.corhuila.deportes.models.services;
import com.corhuila.deportes.models.dao.IBaloncestoDao;
import com.corhuila.deportes.models.entity.Baloncesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BaloncestoServiceImpl implements IBaloncestoService {
    @Autowired
    private IBaloncestoDao baloncestoDao;

    @Override
    @Transactional(readOnly = true)

    public List<Baloncesto> findAll() {
        return (List<Baloncesto>) baloncestoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Baloncesto findById(Long id) {
        return baloncestoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Baloncesto save(Baloncesto baloncesto){
        return baloncestoDao.save(baloncesto);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        baloncestoDao.deleteById(id);
    }
}
