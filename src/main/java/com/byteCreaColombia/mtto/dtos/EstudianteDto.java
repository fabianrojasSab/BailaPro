package com.byteCreaColombia.mtto.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.byteCreaColombia.mtto.entities.Estudiante;

public class EstudianteDto {

	private String nombre;
    private String email;
    private int telefono;
	private LocalDate fecha_nacimiento;
	private LocalDateTime fecha_registro;
	
	
    public EstudianteDto(String nombre, String email, int telefono, LocalDate fecha_nacimiento,
    		LocalDateTime fecha_registro) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.fecha_nacimiento = fecha_nacimiento;
		this.fecha_registro = fecha_registro;
	}
    
    public Estudiante convertToEntity(EstudianteDto dto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setEmail(dto.getEmail());
        estudiante.setTelefono(dto.getTelefono());
        estudiante.setFecha_nacimiento(dto.getFecha_nacimiento());
        estudiante.setFecha_registro(dto.getFecha_registro());
        return estudiante;
    }
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public LocalDateTime getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(LocalDateTime fecha_registro) {
		this.fecha_registro = fecha_registro;
	}


}
