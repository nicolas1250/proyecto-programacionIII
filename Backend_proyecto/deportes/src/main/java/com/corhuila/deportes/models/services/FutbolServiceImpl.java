package com.corhuila.deportes.models.services;
import com.corhuila.deportes.models.dao.IFutbolDao;
import com.corhuila.deportes.models.entity.Futbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FutbolServiceImpl implements IFutbolService {

    @Autowired
    private IFutbolDao futbolDao;

    @Override
    @Transactional(readOnly = true)

    public List<Futbol> findAll() {

        return (List<Futbol>) futbolDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Futbol findById(Long id){
        return futbolDao.findById(id).orElse(null);
    }
    @Override
    @Transactional
    public Futbol save(Futbol futbol){
        return futbolDao.save(futbol);
}

    @Override
    @Transactional
    public void delete(Long id) {
        futbolDao.deleteById(id);
    }


}
