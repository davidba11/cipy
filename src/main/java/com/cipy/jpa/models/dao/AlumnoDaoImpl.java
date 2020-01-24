package com.cipy.jpa.models.dao;

import com.cipy.jpa.models.entity.Alumno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AlumnoDaoImpl implements IAlumnoDao {
    
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Alumno> findAll() {
        return em.createQuery("from Alumno").getResultList();
    }
    
    @Override
    public Alumno findOne(Integer codAlumno){
        return em.find(Alumno.class, codAlumno); 
    }
    
    @Override
    public void save(Alumno alumno) {
        if (alumno.getCodAlumno()!=null && alumno.getCodAlumno()>0)
            em.merge(alumno);
        else
            em.persist(alumno);
    }
    
    @Transactional
    @Override
    public void delete(Integer codAlumno){
        em.remove(findOne(codAlumno));
    }
    
}
