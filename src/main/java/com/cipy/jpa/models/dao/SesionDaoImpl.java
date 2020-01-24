package com.cipy.jpa.models.dao;

import com.cipy.jpa.models.entity.Sesion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class SesionDaoImpl implements ISesionDao{
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Sesion> findAll() {
        return em.createQuery("from Sesion").getResultList();
    }
}
