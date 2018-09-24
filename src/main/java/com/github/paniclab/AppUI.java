package com.github.paniclab;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

@Theme(ValoTheme.THEME_NAME)
@SpringUI
public class AppUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

    }
}
