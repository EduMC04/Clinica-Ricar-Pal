package com.clinica.ricardo_palma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.clinica.ricardo_palma.service.DoctorService;

@Controller
public class PrincipalController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/PaginaPrincipal")
    public String mostrarPaginaPrincipal(Model model) {
        model.addAttribute("listaDoctores", doctorService.obtenerTodosLosDoctores());
        return "PaginaPrincipal"; 
    }
    
}