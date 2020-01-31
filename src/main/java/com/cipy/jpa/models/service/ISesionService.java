package com.cipy.jpa.models.service;

import com.cipy.jpa.models.entity.Sesion;
import java.util.List;

public interface ISesionService {
    
    public List<Sesion> findAll();
    
    public void save(Sesion sesion);
    
    public Sesion findOne(Integer codSesion);
    
    public void delete(Integer codSesion);
}
