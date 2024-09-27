package com.byteCreaColombia.mtto.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "INSCRIPCIONES")
public class Inscripcion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	private Estudiante estudiante_id;

	@OneToOne
	private Clase clase_id;
	
	@NotNull
	private LocalDateTime fecha_inscripcion;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Estudiante getEstudiante_id() {
		return estudiante_id;
	}

	public void setEstudiante_id(Estudiante estudiante_id) {
		this.estudiante_id = estudiante_id;
	}

	public Clase getClase_id() {
		return clase_id;
	}

	public void setClase_id(Clase clase_id) {
		this.clase_id = clase_id;
	}

	public LocalDateTime getFecha_inscripcion() {
		return fecha_inscripcion;
	}

	public void setFecha_inscripcion(LocalDateTime fecha_inscripcion) {
		this.fecha_inscripcion = fecha_inscripcion;
	}
}
