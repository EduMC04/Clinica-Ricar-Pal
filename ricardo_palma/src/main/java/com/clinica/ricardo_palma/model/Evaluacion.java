package com.clinica.ricardo_palma.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private Integer puntualidad;
    private Integer trato;
    private Integer cumplimiento;
    private Integer servicio;
    private String comentarios;
    private LocalDate fechaEvaluacion = LocalDate.now();

    // Getters and Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Integer getPuntualidad() {
        return puntualidad;
    }
    public void setPuntualidad(Integer puntualidad) {
        this.puntualidad = puntualidad;
    }
    public Integer getTrato() {
        return trato;
    }
    public void setTrato(Integer trato) {
        this.trato = trato;
    }
    public Integer getCumplimiento() {
        return cumplimiento;
    }
    public void setCumplimiento(Integer cumplimiento) {
        this.cumplimiento = cumplimiento;
    }
    public Integer getServicio() {
        return servicio;
    }
    public void setServicio(Integer servicio) {
        this.servicio = servicio;
    }
    public String getComentarios() {
        return comentarios;
    }
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }
    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

}
