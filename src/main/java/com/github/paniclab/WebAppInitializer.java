package com.github.paniclab;

import com.github.paniclab.config.ApplicationConfig;
import com.github.paniclab.config.WebConfig;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.server.SpringVaadinServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(ApplicationConfig.class);

        //servletContext.addListener(new ContextLoaderListener(appContext));

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.setParent(appContext);
        webContext.register(WebConfig.class);

        ServletRegistration.Dynamic vaadin = servletContext.addServlet("vaadinServlet", SpringVaadinServlet.class);
        vaadin.setLoadOnStartup(1);
        vaadin.addMapping("/");
    }
}
