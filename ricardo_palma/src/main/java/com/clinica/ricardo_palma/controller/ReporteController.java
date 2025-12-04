package com.clinica.ricardo_palma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.clinica.ricardo_palma.service.ReportePdfService;
import com.clinica.ricardo_palma.service.ReporteService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReporteController {
    
    @Autowired
    private ReportePdfService reportePdfService;

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/reportes")
    public String mostrarhtml() {
        return "reportes";
    }
    

    @GetMapping("/generar")
    public ResponseEntity<byte[]> obtenerPdfGeneral() throws Exception {
        byte[] pdfBytes = reportePdfService.generarReporteGeneral(reporteService.obtenerEstadisticasDeDoctoresGenerales(), "Reporte General");
    
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=reporte.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
    

}
