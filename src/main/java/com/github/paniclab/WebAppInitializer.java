package com.github.paniclab;

import com.github.paniclab.config.ApplicationConfig;
import com.github.paniclab.config.VaadinConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(ApplicationConfig.class);
        appContext.scan(WebAppInitializer.class.getPackage().getName());

        //servletContext.addListener(new ContextLoaderListener(appContext));

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.setParent(appContext);
        webContext.register(VaadinConfig.class);
        webContext.scan(WebAppInitializer.class.getPackage().getName());

        ServletRegistration.Dynamic vaadin = servletContext.addServlet("vaadinServlet", VaadinConfig.class);
        vaadin.setLoadOnStartup(1);
        vaadin.addMapping("/*");
    }
}
