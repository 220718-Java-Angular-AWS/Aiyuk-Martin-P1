package com.revatureERS.services;

import javax.swing.text.View;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ConsoleService {

    private static ConsoleService viewManager;

    private boolean running;

    List<View> viewList;

    Scanner scanner;

    View nextView;

    private ConsoleService() {
        //setting up Starting values and references
        running = true;
        scanner = new Scanner(System.in);
        viewList = new LinkedList<>();
    }

    public static ConsoleService getConsoleService() {
        if (viewManager == null) {
            viewManager = new ConsoleService();
        }
        return viewManager;
    }



}
