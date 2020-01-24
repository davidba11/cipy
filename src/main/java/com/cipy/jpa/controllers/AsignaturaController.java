package com.cipy.jpa.controllers;

import com.cipy.jpa.models.entity.Asignatura;
import com.cipy.jpa.models.service.IAsignaturaService;
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
@RequestMapping("/asignaturas")
public class AsignaturaController {
    
    @Autowired
    private IAsignaturaService asignaturaService;
    
    @RequestMapping(value="/listar", method=RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Asignaturas");
        model.addAttribute("asignaturas", asignaturaService.findAll());
        return "listarA";
    }
    
    @RequestMapping(value="/add")
    public String agregar(Map<String, Object> model){
        Asignatura asignatura= new Asignatura();
        model.put("asignatura", asignatura);
        model.put("titulo", "Registrar Asignatura");
        return "addA";
    }
    
    @RequestMapping(value="/add/{codAsinatura}")
    public String editar(@PathVariable(value="codAsinatura") Integer codAsinatura, Map<String, Object> model){
            Asignatura asignatura=null;
        
        if(codAsinatura>0)
            asignatura=asignaturaService.findOne(codAsinatura);
        else
            return "redirect:/listar";
        model.put("asignatura", asignatura);
        model.put("titulo", "Editar Asignatura");
        return "addA";
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String guardar(@Valid Asignatura asignatura, BindingResult result, Model model){
        
        if(result.hasErrors()){
            model.addAttribute("titulo", "Registrar Asignatura");
            return "addA";
        }
        asignaturaService.save(asignatura);
        return "redirect:listar";
    }
    
    @RequestMapping(value="/delete/{codAsinatura}")
    public String eliminar(@PathVariable(value="codAsinatura") Integer codAsinatura){
        if(codAsinatura>0)
            asignaturaService.delete(codAsinatura);
        return "redirect:/asignaturas/listar";
    }
}
