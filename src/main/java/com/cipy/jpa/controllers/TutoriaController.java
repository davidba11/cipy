package com.cipy.jpa.controllers;

import com.cipy.jpa.models.entity.Tutoria;
import com.cipy.jpa.models.service.ITutoriaService;
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
@RequestMapping("/tutorias")
public class TutoriaController {
    
    @Autowired
    private ITutoriaService tutoriaService;
    
    @RequestMapping(value="/listar", method=RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Tipos de Tutorias");
        model.addAttribute("tutorias", tutoriaService.findAll());
        return "listarT";
    }
    
    @RequestMapping(value="/add")
    public String agregar(Map<String, Object> model){
        Tutoria tutoria= new Tutoria();
        model.put("tutoria", tutoria);
        model.put("titulo", "Registrar Tutoria");
        return "addT";
    }
    
    @RequestMapping(value="/add/{codTutoria}")
    public String editar(@PathVariable(value="codTutoria") Integer codTutoria, Map<String, Object> model){
        Tutoria tutoria=null;
        
        if(codTutoria>0)
            tutoria=tutoriaService.findOne(codTutoria);
        else
            return "redirect:listar";
        model.put("tutoria", tutoria);
        model.put("titulo", "Editar Tutoria");
        return "addT";
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String guardar(@Valid Tutoria tutoria, BindingResult result, Model model){
        
        if(result.hasErrors()){
            model.addAttribute("titulo", "Registrar Tutoria");
            return "addT";
        }
        tutoriaService.save(tutoria);
        return "redirect:listar";
    }
    
    @RequestMapping(value="/delete/{codTutoria}")
    public String eliminar(@PathVariable(value="codTutoria") Integer codTutoria){
        if(codTutoria>0)
            tutoriaService.delete(codTutoria);
        return "redirect:/tutorias/listar";
    }
}
