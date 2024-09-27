package com.byteCreaColombia.mtto.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Clase creada para contener las funciones basicas para que el aplicativo funcione
public class BaseService {
	
    private static EntityManager manager;
    private static EntityManagerFactory emf;
    
    public BaseService() {
	}

    //Realiza la conexion con el archivo persistence
	public EntityManager getEm() {
        emf = Persistence.createEntityManagerFactory("persistencia");
        manager = emf.createEntityManager();
        return manager;
    }
	
	//Cierra la conexion con el persistence
    public void cerrar() {
        manager.close();
        emf.close();
    }
}
