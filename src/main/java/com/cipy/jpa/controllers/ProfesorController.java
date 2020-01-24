package com.cipy.jpa.controllers;

import com.cipy.jpa.models.entity.Profesor;
import com.cipy.jpa.models.service.IProfesorService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profesores")
public class ProfesorController {
    
    @Autowired
    private IProfesorService profesorService;
    
    @RequestMapping(value="/listar", method=RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Profesores");
        model.addAttribute("profesores", profesorService.findAll());
        return "listarP";
    }
    
    @RequestMapping(value="/add")
    public String agregar(Map<String, Object> model){
        Profesor profesor= new Profesor();
        model.put("profesor", profesor);
        model.put("titulo", "Registrar Profesor");
        return "addP";
    }
    
    @RequestMapping(value="/add/{codProfesor}")
    public String editar(@PathVariable(value="codProfesor") Integer codProfesor, Map<String, Object> model){
        Profesor profesor=null;
        
        if(codProfesor>0)
            profesor=profesorService.findOne(codProfesor);
        else
            return "redirect:listar";
        model.put("profesor", profesor);
        model.put("titulo", "Editar Profesor");
        return "addP";
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String guardar(@Valid Profesor profesor, BindingResult result, Model model){
        
        if(result.hasErrors()){
            model.addAttribute("titulo", "Registrar Profesor");
            return "addP";
        }
        profesorService.save(profesor);
        return "redirect:listar";
    }
    
    @RequestMapping(value="/delete/{codProfesor}")
    public String eliminar(@PathVariable(value="codProfesor") Integer codProfesor){
        if(codProfesor>0)
            profesorService.delete(codProfesor);
        return "redirect:/profesores/listar";
    }
}
