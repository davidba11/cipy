package com.cipy.jpa.controllers;

import com.cipy.jpa.models.service.ISesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sesiones")
public class SesionController {
    
    @Autowired
    //@Qualifier("alumnoServiceJPA")
    private ISesionService sesionService;
    
    @RequestMapping(value="/listar", method=RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Sesiones");
        model.addAttribute("sesiones", sesionService.findAll());
        return "listarS";
    }
    
//    @RequestMapping(value="/add")
//    public String agregar(Map<String, Object> model){
//        Alumno alumno= new Alumno();
//        model.put("alumno", alumno);
//        model.put("titulo", "Registrar Alumno");
//        return "add";
//    }
//    
//    @RequestMapping(value="/add/{codAlumno}")
//    public String editar(@PathVariable(value="codAlumno") Integer codAlumno, Map<String, Object> model){
//        Alumno alumno=null;
//        
//        if(codAlumno>0)
//            alumno=alumnoService.findOne(codAlumno);
//        else
//            return "redirect:/listar";
//        model.put("alumno", alumno);
//        model.put("titulo", "Editar Alumno");
//        return "add";
//    }
//    
//    @RequestMapping(value="/add", method=RequestMethod.POST)
//    public String guardar(@Valid Alumno alumno, BindingResult result, Model model){
//        
//        if(result.hasErrors()){
//            model.addAttribute("titulo", "Registrar Alumno");
//            return "add";
//        }
//        alumnoService.save(alumno);
//        return "redirect:listar";
//    }
//    
//    @RequestMapping(value="/delete/{codAlumno}")
//    public String eliminar(@PathVariable(value="codAlumno") Integer codAlumno){
//        if(codAlumno>0)
//            alumnoService.delete(codAlumno);
//        return "redirect:/alumnos/listar";
//    }
}
