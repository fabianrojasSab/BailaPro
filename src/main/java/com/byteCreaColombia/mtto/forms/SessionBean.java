package com.byteCreaColombia.mtto.forms;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "usuarioSesion")
@SessionScoped
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private String nombreUsuario;
    private boolean autenticado;
    
    // Métodos getter y setter para los atributos de sesión

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    // Método para "cerrar sesión" (resetea los valores de la sesión)
    public void cerrarSesion() {
        this.nombreUsuario = null;
        this.autenticado = false;
    }

}
