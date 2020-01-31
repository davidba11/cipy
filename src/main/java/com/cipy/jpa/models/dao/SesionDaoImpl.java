package com.cipy.jpa.models.dao;

import com.cipy.jpa.models.entity.Sesion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SesionDaoImpl implements ISesionDao{
    @PersistenceContext
    private EntityManager em;
    
    private EntityManager a;

    @SuppressWarnings("unchecked")
    @Override
    public List<Sesion> findAll() {
        return em.createQuery("from Sesion").getResultList();
    }
    
    @Override
    public void save(Sesion sesion) {
        if (sesion.getCodSesion() != null && sesion.getCodSesion() > 0) {
            em.merge(sesion);
        } else {
            em.persist(sesion);
        }
    }
    
    @Override
    public Sesion findOne(Integer codSesion) {
        return em.find(Sesion.class, codSesion);
    }   
    
    @Transactional
    @Override
    public void delete(Integer codSesion){
        em.remove(findOne(codSesion));
    }
}
