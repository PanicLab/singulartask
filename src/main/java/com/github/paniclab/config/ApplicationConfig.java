package com.github.paniclab.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import({JpaConfig.class})
@Configuration
@ComponentScan("com.github.paniclab")
public class ApplicationConfig {
}
