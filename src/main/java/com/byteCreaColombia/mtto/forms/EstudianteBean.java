package com.byteCreaColombia.mtto.forms;

import java.io.Serializable;
import java.sql.Date;
import java.time.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.byteCreaColombia.mtto.dtos.EstudianteDto;
import com.byteCreaColombia.mtto.services.EstudianteService;

import java.util.List; // Importa la clase correcta

@ManagedBean(name = "estudianteBean")
public class EstudianteBean implements Serializable {


	private static final long serialVersionUID = 1L;
	

	private String nombre;
	
	private int telefono;
	
	private String email;
	
	private LocalDate fecha_nacimiento;
	
    // Inyecta el servicio donde manejas la lógica del estudiante
    @ManagedProperty("#{estudianteServices}")
    private EstudianteService estudianteService;

	private List<EstudianteDto> allEstudiantes;
	
    
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}	

	public EstudianteService getEstudianteService() {
		return estudianteService;
	}

	public void setEstudianteService(EstudianteService estudianteService) {
		this.estudianteService = estudianteService;
	}

	public List<EstudianteDto> getAllEstudiantes() {
		this.allEstudiantes = estudianteService.getAllEstudiantes();
		return allEstudiantes;
	}

	public void setAllEstudiantes(List<EstudianteDto> allEstudiantes) {
		this.allEstudiantes = allEstudiantes;
	}
	
	
	public void register() {
		LocalDateTime fecha_registro = LocalDateTime.now();
		EstudianteDto estudianteDto =  new EstudianteDto(nombre, email, telefono, fecha_nacimiento, fecha_registro);
		
        estudianteService.crearEstudiante(estudianteDto);
        estudianteService.cerrar(); // Cerrar el servicio
		
		
	}
     

}
