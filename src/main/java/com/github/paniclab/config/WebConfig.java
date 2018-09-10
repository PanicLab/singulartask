package com.github.paniclab.config;

import com.vaadin.spring.server.SpringVaadinServlet;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebServlet;

@Configuration
@WebServlet(urlPatterns = "/", name = "vaadinServlet", asyncSupported = true)
public class WebConfig extends SpringVaadinServlet {
}
