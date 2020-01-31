package com.cipy.jpa.models.service;

import com.cipy.jpa.models.dao.ISesionDao;
import com.cipy.jpa.models.entity.Sesion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SesionServiceImpl implements ISesionService{
    @Autowired
    private ISesionDao sesionDao;

    @Override
    @Transactional(readOnly=true)
    public List<Sesion> findAll() {
        return sesionDao.findAll();
    }
    
    @Override
    @Transactional
    public void save(Sesion sesion) {
        sesionDao.save(sesion);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Sesion findOne(Integer codSesion) {
        return sesionDao.findOne(codSesion);
    }
    
    @Override
    @Transactional
    public void delete(Integer codSesion) {
        sesionDao.delete(codSesion);
    }
}
