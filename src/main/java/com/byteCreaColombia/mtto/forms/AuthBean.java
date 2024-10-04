package com.byteCreaColombia.mtto.forms;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import com.byteCreaColombia.mtto.entities.Usuario;
import com.byteCreaColombia.mtto.services.UsuarioService;


//Clase creada para contener las funciones de autenticacion
/*El término "Bean" se usa porque estos objetos tienen las características
como(encapsulación de datos a través de getters y setters, 
constructor sin parámetros, y potencialmente serializables)*/

@ManagedBean(name = "authBean")
public class AuthBean {

	private long id;

	private String nombre;
	
	private String email;
	
	private String contrasena;

	@ManagedProperty("#{usuarioSesion}")
    private SessionBean usuarioSesion;
	
    public void setUsuarioSesion(SessionBean usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
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
	
	public String login() {
		UsuarioService usuarioServices = new UsuarioService();
		Usuario usuario = usuarioServices.encontrarUsuarioLogin(nombre, contrasena);
		
		if (usuario != null) {
            usuarioSesion.setNombreUsuario(usuario.getNombre());
            usuarioSesion.setAutenticado(true);
			return "paginaPrincipal";
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nombre de usuario o contraseña incorrecto"));
			return null;
		}
	}
	
	public void register() {
        try {
            UsuarioService usuarioService = new UsuarioService();
            Usuario usuario = new Usuario();
            
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuario.setContrasena(contrasena);
            
            usuarioService.crearUsuario(usuario);
            usuarioService.cerrar(); // Cerrar el servicio
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
