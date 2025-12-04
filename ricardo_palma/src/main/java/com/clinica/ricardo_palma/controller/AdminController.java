package com.clinica.ricardo_palma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/login")
public class AdminController {
    
    @GetMapping
    public String mostrarPaginaInicioSesion() {
        return "login";
    }

}
