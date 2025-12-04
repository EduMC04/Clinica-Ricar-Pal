package com.clinica.ricardo_palma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.ricardo_palma.model.Doctor;

public interface DoctorRepository  extends JpaRepository<Doctor, Long> {
    
}
