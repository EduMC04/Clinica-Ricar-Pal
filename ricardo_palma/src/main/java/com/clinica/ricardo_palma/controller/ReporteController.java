package com.clinica.ricardo_palma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.clinica.ricardo_palma.model.EstadisticaDoctorDTO;
import com.clinica.ricardo_palma.repository.DoctorRepository;
import com.clinica.ricardo_palma.repository.EvaluacionRepository;
import com.clinica.ricardo_palma.service.ReportePdfService;
import com.clinica.ricardo_palma.service.ReporteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reportes")
public class ReporteController {
    
    @Autowired
    private ReportePdfService reportePdfService;

    @Autowired
    private ReporteService reporteService;

    @Autowired
    private DoctorRepository doctorRepository; // Inyecta el repositorio

    @GetMapping
    public String mostrarhtml(Model model) {
        List<String> especialidades = doctorRepository.findDistinctEspecialidades();
        model.addAttribute("listaEspecialidades", especialidades);
        return "reportes";
    }
    
    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @GetMapping("/generar")
    public ResponseEntity<byte[]> obtenerPdfGeneral() throws Exception {
        byte[] pdfBytes = reportePdfService.generarReporteGeneral(reporteService.obtenerEstadisticasDeDoctoresGenerales(), "Reporte General");
    
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=reporte.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
    
    @GetMapping("/generar/especialidad/{especialidad}")
    public ResponseEntity<byte[]> obtenerPdfPorEspecialidad(@PathVariable("especialidad") String especialidad) {
        
        // 1. Obtener datos filtrados
        List<EstadisticaDoctorDTO> lista = evaluacionRepository.obtenerEstadisticasPorEspecialidad(especialidad);

        // 2. Definir título
        String titulo = "REPORTE DE EVALUACIONES - ESPECIALIDAD: " + especialidad.toUpperCase();

        // 3. Generar PDF
        byte[] pdfBytes = reportePdfService.generarReporteGeneral(lista, titulo);

        // 4. Configurar respuesta HTTP (Headers)
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        String filename = "Reporte_" + especialidad.replace(" ", "_") + ".pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        // 5. Devolver PDF
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

}
