package com.cipy.jpa.models.dao;

import com.cipy.jpa.models.entity.Profesor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProfesorDaoImpl implements IProfesorDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)

    @Override
    public List<Profesor> findAll() {
        return em.createQuery("from Profesor").getResultList();
    }

    @Override
    @Transactional
    public void save(Profesor profesor) {
        if (profesor.getCodProfesor() != null && profesor.getCodProfesor() > 0) {
            em.merge(profesor);
        } else {
            em.persist(profesor);
        }
    }

    @Override
    public Profesor findOne(Integer codProfesor) {
        return em.find(Profesor.class, codProfesor);
    }
    
    @Transactional
    @Override
    public void delete(Integer codProfesor){
        em.remove(findOne(codProfesor));
    }

}
