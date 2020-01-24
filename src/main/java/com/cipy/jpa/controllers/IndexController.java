package com.cipy.jpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String mostrarInicio(Model model){
        model.addAttribute("ventana", "inicio");
        model.addAttribute("titulo", "razonar");
        return "index";
    }
}
