package com.corhuila.deportes.models.services;

import com.corhuila.deportes.models.dao.ITenisDao;
import com.corhuila.deportes.models.entity.Tenis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TenisServiceImpl implements ITenisService {
    @Autowired
    private ITenisDao tenisDao;

    @Override
    @Transactional(readOnly = true)

    public List<Tenis> findAll() {

        return (List<Tenis>) tenisDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Tenis findById(Long id){
        return tenisDao.findById(id).orElse(null);
    }
    @Override
    @Transactional
    public Tenis save(Tenis tenis){
        return tenisDao.save(tenis);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        tenisDao.deleteById(id);
    }
}
