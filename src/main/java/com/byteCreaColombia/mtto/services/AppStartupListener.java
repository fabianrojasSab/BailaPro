package com.byteCreaColombia.mtto.services;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.byteCreaColombia.mtto.entities.Usuario;

@WebListener
public class AppStartupListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Aquí puedes llamar al código que estaba en main()
        try {
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
