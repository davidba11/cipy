package com.cipy.jpa.models.dao;

import com.cipy.jpa.models.entity.Sesion;
import java.util.List;

public interface ISesionDao {
    public List<Sesion> findAll();
    
//    public void save(Alumno alumno);
//    
//    public Alumno findOne(Integer codAlumno);
//    
//    public void delete(Integer codAlumno);
}
