package com.cipy.jpa.controllers;

import com.cipy.jpa.models.entity.Sesion;
import com.cipy.jpa.models.service.IAsignaturaService;
import com.cipy.jpa.models.service.IProfesorService;
import com.cipy.jpa.models.service.ISesionService;
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
@RequestMapping("/sesiones")
public class SesionController {
    
    @Autowired
    private ISesionService sesionService;
    
    @Autowired
    private IAsignaturaService asignaturaService;
    
    @Autowired
    private IProfesorService profesorService;
    
    @RequestMapping(value="/listar", method=RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Sesiones");
        model.addAttribute("sesiones", sesionService.findAll());
        return "listarS";
    }
    
    @RequestMapping(value="/add")
    public String agregar(Map<String, Object> map, Model model){
        Sesion sesion= new Sesion();
        map.put("sesion", sesion);
        map.put("titulo", "Registrar Sesión de Clase");
        model.addAttribute("asignaturas", asignaturaService.findAll());
        model.addAttribute("profesores", profesorService.findAll());
        return "addS";
    }
    
    @RequestMapping(value="/add/{codSesion}")
    public String editar(@PathVariable(value="codSesion") Integer codSesion, Map<String, Object> map, Model model){
        Sesion sesion=null;
        
        if(codSesion>0)
            sesion=sesionService.findOne(codSesion);
        else
            return "redirect:listar";
        map.put("sesion", sesion);
        map.put("titulo", "Editar Sesion");
        model.addAttribute("asignaturas", asignaturaService.findAll());
        model.addAttribute("profesores", profesorService.findAll());
        return "addS";
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String guardar(@Valid Sesion sesion, BindingResult result, Model model){
        
        if(result.hasErrors()){
            model.addAttribute("titulo", "Registrar Sesión");
            return "addS";
        }
        sesionService.save(sesion);
        return "redirect:listar";
    }
    
    @RequestMapping(value="/delete/{codSesion}")
    public String eliminar(@PathVariable(value="codSesion") Integer codSesion){
        if(codSesion>0)
            sesionService.delete(codSesion);
        return "redirect:/sesiones/listar";
    }
}
