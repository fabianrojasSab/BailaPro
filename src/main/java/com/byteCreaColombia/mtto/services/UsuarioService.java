package com.byteCreaColombia.mtto.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.byteCreaColombia.mtto.entities.Usuario;

/*hace referencia a una clase de servicio que contiene la lógica de negocio 
relacionada con un dominio específico. En este caso, UsuarioService se 
encargaría de manejar las operaciones relacionadas con el objeto o entidad Usuario.*/

public class UsuarioService extends BaseService {

    public UsuarioService() {
    }

    public void crearUsuario(Usuario usuario) {
    	
        try {
        	EntityManager em = getEm();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            cerrar();
        } catch (Exception e) {
                cerrar();
        }
    }
    
    public Usuario encontrarUsuarioPorId(Long id) {
        return getEm().find(Usuario.class, id);
    }

    public Usuario encontrarUsuarioLogin(String username, String password) {
		StringBuffer sql = null;
        try {
    		//se declara la variable sql como un nuevo objeto de tipo stringbuffer
    		sql = new StringBuffer();
    		sql.append("select o from ");
    		sql.append(Usuario.class.getCanonicalName()).append(" o ");
    		// se ingresa la condicional de la consulta sql
    		sql.append(" where o.nombre = :username and o.contrasena = :password");
    		
            // Consulta JPQL para buscar un usuario por nombre de usuario y contraseña
            return (Usuario) getEm().createQuery(sql.toString())
                          .setParameter("username", username)
                          .setParameter("password", password)
                          .getSingleResult();
        } catch (Exception e) {
            // Si no se encuentra el usuario o hay otro problema, se puede retornar null o lanzar una excepción personalizada
            return null;
        }
    }

}
