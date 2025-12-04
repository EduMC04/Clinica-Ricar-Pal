package com.clinica.ricardo_palma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinica.ricardo_palma.model.Doctor;

public interface DoctorRepository  extends JpaRepository<Doctor, Long> {
    @Query("SELECT DISTINCT d.especialidad FROM Doctor d")
    List<String> findDistinctEspecialidades();
}
