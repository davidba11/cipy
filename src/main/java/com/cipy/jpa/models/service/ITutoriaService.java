package com.cipy.jpa.models.service;

import com.cipy.jpa.models.entity.Tutoria;
import java.util.List;

public interface ITutoriaService {

    
    public List<Tutoria> findAll();
    
    public void save(Tutoria tutoria);
    
    public Tutoria findOne(Integer codTutoria);
    
    public void delete(Integer codTutoria);    
}
