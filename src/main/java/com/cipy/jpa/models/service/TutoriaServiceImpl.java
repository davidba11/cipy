package com.cipy.jpa.models.service;

import com.cipy.jpa.models.dao.ITutoriaDao;
import com.cipy.jpa.models.entity.Tutoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TutoriaServiceImpl implements ITutoriaService{
    
    @Autowired
    private ITutoriaDao tutoriaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Tutoria> findAll() {
        return tutoriaDao.findAll();
    }
    
    @Override
    @Transactional
    public void save(Tutoria tutoria) {
        tutoriaDao.save(tutoria);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Tutoria findOne(Integer codTutoria) {
        return tutoriaDao.findOne(codTutoria);
    }
    
    @Override
    @Transactional
    public void delete(Integer codTutoria) {
        tutoriaDao.delete(codTutoria);
    }
}
