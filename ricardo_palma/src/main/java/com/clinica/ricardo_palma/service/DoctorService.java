package com.clinica.ricardo_palma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.ricardo_palma.model.Doctor;
import com.clinica.ricardo_palma.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    
    public List<Doctor> obtenerTodosLosDoctores() {
        return doctorRepository.findAll();
    }
    public void guardarDoctor(Doctor doctor) {  
        doctorRepository.save(doctor);
    }

    public Doctor obtenerDoctorPorId(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public void eliminarDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

}
