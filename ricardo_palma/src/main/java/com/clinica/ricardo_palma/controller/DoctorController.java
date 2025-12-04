package com.clinica.ricardo_palma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinica.ricardo_palma.model.Doctor;
import com.clinica.ricardo_palma.service.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/FormularioDoctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public String mostrarFormularioDoctor(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "FormularioDoctor"; // Retorna la vista del formulario del doctor
    }
    
    @PostMapping("/guardar")
    public String guardarDoctor(Doctor doctor) {
        doctorService.guardarDoctor(doctor);
        return "redirect:/PaginaPrincipal?success=true"; // Redirige de vuelta al formulario con un mensaje de éxito
    }

    @GetMapping("/editar/{id}")
    public String editarDoctor(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.obtenerDoctorPorId(id);
        model.addAttribute("doctor", doctor);
        return "FormularioDoctor"; // Retorna la vista del formulario del doctor con los datos cargados
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDoctor(@PathVariable Long id) {
        doctorService.eliminarDoctor(id);
        return "redirect:/PaginaPrincipal?deleted=true"; // Redirige de vuelta al listado con un mensaje de eliminación
    }

}
