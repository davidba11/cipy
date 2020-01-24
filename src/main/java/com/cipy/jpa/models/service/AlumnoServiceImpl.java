package com.cipy.jpa.models.service;

import com.cipy.jpa.models.dao.IAlumnoDao;
import com.cipy.jpa.models.entity.Alumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoServiceImpl implements IAlumnoService {
    
    @Autowired
    private IAlumnoDao alumnoDao;

    @Override
    @Transactional(readOnly=true)
    public List<Alumno> findAll() {
        return alumnoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Alumno alumno) {
        alumnoDao.save(alumno);
    }

    @Override
    @Transactional(readOnly=true)
    public Alumno findOne(Integer codAlumno) {
        return alumnoDao.findOne(codAlumno);
    }

    @Override
    @Transactional
    public void delete(Integer codAlumno) {
        alumnoDao.delete(codAlumno);
    }
    
}
