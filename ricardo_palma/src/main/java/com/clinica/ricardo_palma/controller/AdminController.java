package com.clinica.ricardo_palma.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/login")
public class AdminController {
    
    @GetMapping
    public String mostrarPaginaInicioSesion() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && 
            authentication.isAuthenticated() && 
            !authentication.getPrincipal().equals("anonymousUser")) {
            
            // Si ya está autenticado, lo redirigimos a la página principal
            return "redirect:/PaginaPrincipal";
        }
        return "login";
    }

}
