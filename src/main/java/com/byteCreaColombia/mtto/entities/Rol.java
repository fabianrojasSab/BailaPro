package com.byteCreaColombia.mtto.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "ROLES")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull	
	private String nombre_rol;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")  // mappedBy apunta a la propiedad 'rol' en Permiso
	private List<Permiso> fk_permiso;  
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre_rol() {
		return nombre_rol;
	}

	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}

	public List<Permiso> getFk_permiso() {
		return fk_permiso;
	}

	public void setFk_permiso(List<Permiso> fk_permiso) {
		this.fk_permiso = fk_permiso;
	}

}
