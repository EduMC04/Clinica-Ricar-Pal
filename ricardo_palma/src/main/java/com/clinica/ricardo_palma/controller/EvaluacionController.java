package com.clinica.ricardo_palma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinica.ricardo_palma.model.Evaluacion;
import com.clinica.ricardo_palma.service.DoctorService;
import com.clinica.ricardo_palma.service.EvaluacionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/FormularioEvaluacion")
public class EvaluacionController {
    
    @Autowired
    private EvaluacionService evaluacionService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public String mostrarFormularioDoctor(Model model) {
        model.addAttribute("evaluacion", new Evaluacion());
        model.addAttribute("doctores", doctorService.obtenerTodosLosDoctores());
        return "FormularioEvaluacion"; // Retorna la vista del formulario del doctor
    }
    
    @PostMapping("/guardar")
    public String guardarEvaluacion(Evaluacion evaluacion) {
        evaluacionService.guardarEvaluacion(evaluacion);
        return "redirect:/PaginaPrincipal?success=true"; // Redirige de vuelta al formulario con un mensaje de éxito
    }

}
