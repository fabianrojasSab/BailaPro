package com.byteCreaColombia.mtto.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseService {
	
    private static EntityManager manager;
    private static EntityManagerFactory emf;
    
    public BaseService() {
	}

	public EntityManager getEm() {
        emf = Persistence.createEntityManagerFactory("persistencia");
        manager = emf.createEntityManager();
        return manager;
    }
	
    public void cerrar() {
        manager.close();
        emf.close();
    }
}
