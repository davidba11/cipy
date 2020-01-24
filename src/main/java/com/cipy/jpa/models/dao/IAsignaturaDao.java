package com.cipy.jpa.models.dao;

import com.cipy.jpa.models.entity.Asignatura;
import java.util.List;

public interface IAsignaturaDao {
    
    public List<Asignatura> findAll();
    
    public void save(Asignatura asignatura);
    
    public Asignatura findOne(Integer codAsinatura);
    
    public void delete(Integer codAsinatura);
}
