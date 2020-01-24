package com.cipy.jpa.models.service;

import com.cipy.jpa.models.dao.IProfesorDao;
import com.cipy.jpa.models.entity.Profesor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorServiceImpl implements IProfesorService{
    
    @Autowired
    private IProfesorDao profesorDao;

    @Override
    @Transactional(readOnly=true)
    public List<Profesor> findAll() {
        return profesorDao.findAll();
    }

    @Override
    @Transactional
    public void save(Profesor profesor) {
        profesorDao.save(profesor);
    }

    @Override
    @Transactional(readOnly=true)
    public Profesor findOne(Integer codProfesor) {
        return profesorDao.findOne(codProfesor);
    }

    @Override
    @Transactional
    public void delete(Integer codProfesor) {
        profesorDao.delete(codProfesor);
    }
}
