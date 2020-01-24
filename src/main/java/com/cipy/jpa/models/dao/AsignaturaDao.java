package com.cipy.jpa.models.dao;

import com.cipy.jpa.models.entity.Asignatura;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AsignaturaDao implements IAsignaturaDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)

    @Override
    public List<Asignatura> findAll() {
        return em.createQuery("from Asignatura").getResultList();
    }

    @Override
    @Transactional
    public void save(Asignatura asignatura) {
        if (asignatura.getCodAsinatura() != null && asignatura.getCodAsinatura() > 0) {
            em.merge(asignatura);
        } else {
            em.persist(asignatura);
        }
    }

    @Override
    public Asignatura findOne(Integer codAsinatura) {
        return em.find(Asignatura.class, codAsinatura);
    }
    
    @Transactional
    @Override
    public void delete(Integer codAsinatura){
        em.remove(findOne(codAsinatura));
    }
}
