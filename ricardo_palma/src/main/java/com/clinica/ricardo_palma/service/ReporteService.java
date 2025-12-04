package com.clinica.ricardo_palma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.ricardo_palma.model.EstadisticaDoctorDTO;
import com.clinica.ricardo_palma.repository.EvaluacionRepository;

@Service
public class ReporteService {
    
    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public List<EstadisticaDoctorDTO> obtenerEstadisticasDeDoctoresGenerales() {
    return evaluacionRepository.obtenerPromediosPorDoctor();
    }

}
