package com.byteCreaColombia.mtto.entities;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String nombre;
	
	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "El correo electrónico no es válido")
	private String email;
	
	@NotBlank(message = "La contraseña no puede estar en blanco")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$", 
	             message = "La contraseña debe tener al menos una letra mayúscula, una minúscula, un número y un carácter especial")
	private String contrasena;
	
	@OneToOne
	private Rol rol_id; 
	
	
	public Rol getRol_id() {
		return rol_id;
	}

	public void setRol_id(Rol rol_id) {
		this.rol_id = rol_id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
