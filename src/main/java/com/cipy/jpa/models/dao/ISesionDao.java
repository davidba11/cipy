package com.cipy.jpa.models.dao;

import com.cipy.jpa.models.entity.Sesion;
import java.util.List;

public interface ISesionDao {
    public List<Sesion> findAll();
    
    public void save(Sesion sesion);
    
    public Sesion findOne(Integer sesion);
    
    public void delete(Integer codSesion);
    
}
