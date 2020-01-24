package com.cipy.jpa.models.service;

import com.cipy.jpa.models.entity.Alumno;
import java.util.List;

public interface IAlumnoService {
        
    public List<Alumno> findAll();
    
    public void save(Alumno alumno);
    
    public Alumno findOne(Integer codAlumno);
    
    public void delete(Integer codAlumno);
    
}
