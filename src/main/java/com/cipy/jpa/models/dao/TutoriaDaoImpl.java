package com.cipy.jpa.models.dao;

import com.cipy.jpa.models.entity.Tutoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TutoriaDaoImpl implements ITutoriaDao{
    
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Tutoria> findAll() {
        return em.createQuery("from Tutoria").getResultList();
    }
    
    @Override
    @Transactional
    public void save(Tutoria tutoria) {
        if (tutoria.getCodTutoria() != null && tutoria.getCodTutoria() > 0) {
            em.merge(tutoria);
        } else {
            em.persist(tutoria);
        }
    }
    
    @Override
    public Tutoria findOne(Integer codTutoria) {
        return em.find(Tutoria.class, codTutoria);
    }
    
    @Transactional
    @Override
    public void delete(Integer codTutoria){
        em.remove(findOne(codTutoria));
    }
}
