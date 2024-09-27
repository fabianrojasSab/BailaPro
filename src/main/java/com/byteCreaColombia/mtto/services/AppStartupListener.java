package com.byteCreaColombia.mtto.services;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.byteCreaColombia.mtto.entities.Usuario;

@WebListener
public class AppStartupListener implements ServletContextListener {
    
	//Funcion usada para que al momento de iniciar la aplicacion esta haga la conexion 
	//a la base de datos y cree las entidades de ser necesario 27-09-2024
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
        	//Crea una variable de la clase BaseService
        	//la cual contiene la funcion para realizar la conexion 
        	//con el archivo persistence
        	BaseService base = new BaseService();
            base.getEm();
            base.cerrar(); // Cerrar el servicio
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Aquí puedes limpiar recursos si es necesario
    }
}
