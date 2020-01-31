package com.cipy.jpa.models.dao;

import com.cipy.jpa.models.entity.Tutoria;
import java.util.List;

public interface ITutoriaDao {
        
    public List<Tutoria> findAll();
    
    public void save(Tutoria tutoria);
    
    public Tutoria findOne(Integer codTutoria);
    
    public void delete(Integer codTutoria);
}
