package com.clinica.ricardo_palma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.clinica.ricardo_palma.service.EvaluacionService;

@Controller
public class EvaluacionVistaClienteController {

    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping("/evaluaciones")
    public String mostrarFormularioDoctor(Model model) {
        model.addAttribute("listaEvaluaciones", evaluacionService.obtenerTodasLasEvaluaciones());
        return "evaluaciones"; // Retorna la vista del formulario del doctor
    }

}