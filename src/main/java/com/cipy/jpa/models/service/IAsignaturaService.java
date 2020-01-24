package com.cipy.jpa.models.service;

import com.cipy.jpa.models.entity.Asignatura;
import java.util.List;

public interface IAsignaturaService {
    
    public List<Asignatura> findAll();
    
    public void save(Asignatura asignatura);
    
    public Asignatura findOne(Integer codAsinatura);
    
    public void delete(Integer codAsinatura);
}
