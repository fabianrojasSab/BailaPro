package com.byteCreaColombia.mtto.services;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import com.byteCreaColombia.mtto.dtos.EstudianteDto;
import com.byteCreaColombia.mtto.entities.Estudiante;
import com.byteCreaColombia.mtto.forms.SessionBean;

@ManagedBean(name = "estudianteServices")
public class EstudianteService extends BaseService {

	private List<EstudianteDto> allEstudiantes;
	
	public EstudianteService() {
	}

	public List<EstudianteDto> getAllEstudiantes() {
				
		StringBuffer sql = null;
		if (usuarioSesion.nombreUsuario) {
			
		}
        try {
    		//se declara la variable sql como un nuevo objeto de tipo stringbuffer
    		sql = new StringBuffer();
    		sql.append("select o from ");
    		sql.append(Estudiante.class.getCanonicalName()).append(" o ");
    		
            // Consulta JPQL para buscar un usuario por nombre de usuario y contraseña
            this.allEstudiantes = getEm().createQuery(sql.toString()).getResultList();
            return allEstudiantes;
        } catch (Exception e) {
            // Si no se encuentra el usuario o hay otro problema, se puede retornar null o lanzar una excepción personalizada
            return null;
        }
	}
	
	public void crearEstudiante(EstudianteDto estudianteDto) {
		try {
        	EntityManager em = getEm();
            em.getTransaction().begin();
            Estudiante estudiante = estudianteDto.convertToEntity(estudianteDto);
            em.persist(estudiante);
            em.getTransaction().commit();
            cerrar();
		}catch (Exception e) {
			cerrar();
        }
	}
}
