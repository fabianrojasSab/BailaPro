package com.byteCreaColombia.mtto.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "PROFESORES")
public class Profesor implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String especialidad;
	
	private int telefono;
	
	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "El correo electrónico no es válido")
	private String email;
	
	@NotNull
	private LocalDateTime fecha_contratacion;	

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getFecha_contratacion() {
		return fecha_contratacion;
	}

	public void setFecha_contratacion(LocalDateTime fecha_contratacion) {
		this.fecha_contratacion = fecha_contratacion;
	}


}
