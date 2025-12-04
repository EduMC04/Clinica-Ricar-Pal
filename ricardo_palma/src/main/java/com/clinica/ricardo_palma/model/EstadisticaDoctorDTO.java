package com.clinica.ricardo_palma.model;

public class EstadisticaDoctorDTO {
    
    private String nombre;
    private String apellidos;
    private Double promedioPuntualidad;
    private Double promedioTrato;
    private Double promedioCumplimiento;
    private Double promedioServicio;

    public EstadisticaDoctorDTO(String nombre, String apellidos, Double promedioPuntualidad, 
    Double promedioTrato, Double promedioCumplimiento, Double promedioServicio) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.promedioPuntualidad = promedioPuntualidad;
    this.promedioTrato = promedioTrato;
    this.promedioCumplimiento = promedioCumplimiento;
    this.promedioServicio = promedioServicio;
    }

    // Getters (necesarios para el PDF)
    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public Double getPromedioPuntualidad() { return promedioPuntualidad; }
    public Double getPromedioTrato() { return promedioTrato; }
    public Double getPromedioCumplimiento() { return promedioCumplimiento; }
    public Double getPromedioServicio() { return promedioServicio; }

}
