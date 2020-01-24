package com.cipy.jpa.models.service;

import com.cipy.jpa.models.dao.IAsignaturaDao;
import com.cipy.jpa.models.entity.Asignatura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService{
    
    @Autowired
    private IAsignaturaDao asignaturaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Asignatura> findAll() {
        return asignaturaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Asignatura asignatura) {
        asignaturaDao.save(asignatura);
    }

    @Override
    @Transactional(readOnly=true)
    public Asignatura findOne(Integer codAsinatura) {
        return asignaturaDao.findOne(codAsinatura);
    }

    @Override
    @Transactional
    public void delete(Integer codAsinatura) {
        asignaturaDao.delete(codAsinatura);
    }
}
