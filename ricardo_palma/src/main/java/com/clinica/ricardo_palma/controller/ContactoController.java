package com.clinica.ricardo_palma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController {
    
    @GetMapping("/contacto")
    public String vistaContacto() {
        return "contacto";
    }
    

}
