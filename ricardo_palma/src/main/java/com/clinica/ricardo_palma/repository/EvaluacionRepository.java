package com.clinica.ricardo_palma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinica.ricardo_palma.model.EstadisticaDoctorDTO;
import com.clinica.ricardo_palma.model.Evaluacion;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {

    @Query("SELECT new com.clinica.ricardo_palma.model.EstadisticaDoctorDTO(" +
        "e.doctor.nombre, e.doctor.apellidos, " +
        "AVG(e.puntualidad), AVG(e.trato), AVG(e.cumplimiento), AVG(e.servicio)) " +
        "FROM Evaluacion e GROUP BY e.doctor.id, e.doctor.nombre, e.doctor.apellidos")
        List<EstadisticaDoctorDTO> obtenerPromediosPorDoctor();
}