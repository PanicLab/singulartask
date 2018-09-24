package com.github.paniclab.config;

import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.server.SpringVaadinServlet;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebServlet;

@Configuration
@EnableVaadin
@WebServlet(urlPatterns = "/*", name = "vaadinServlet", asyncSupported = true)
public class VaadinConfig extends SpringVaadinServlet {
}
