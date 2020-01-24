package com.cipy.jpa.models.dao;

import com.cipy.jpa.models.entity.Alumno;
import java.util.List;

public interface IAlumnoDao {

    public List<Alumno> findAll();
    
    public void save(Alumno alumno);
    
    public Alumno findOne(Integer codAlumno);
    
    public void delete(Integer codAlumno);
}
