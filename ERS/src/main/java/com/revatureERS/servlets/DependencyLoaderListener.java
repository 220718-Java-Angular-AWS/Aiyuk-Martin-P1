package com.revatureERS.servlets;

import com.revatureERS.services.DataSourceService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Initializing Servlet context...");
        DataSourceService.getConnection();

        System.out.println("Servlet context Initialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}