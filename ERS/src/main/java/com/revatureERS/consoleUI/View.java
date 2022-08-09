package com.revatureERS.consoleUI;

import com.revatureERS.services.ConsoleService;

public abstract class View {

    protected String viewName;
    protected ConsoleService consoleService;


    public String getViewName() {
        return viewName;
    }

    public abstract void renderView();
}
