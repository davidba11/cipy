package com.cipy.jpa.models.service;

import com.cipy.jpa.models.entity.Profesor;
import java.util.List;

public interface IProfesorService {
    
    public List<Profesor> findAll();
    
    public void save(Profesor profesor);
    
    public Profesor findOne(Integer codProfesor);
    
    public void delete(Integer codProfesor);
    
}
