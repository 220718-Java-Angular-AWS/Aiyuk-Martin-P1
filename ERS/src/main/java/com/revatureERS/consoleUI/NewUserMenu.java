package com.revatureERS.consoleUI;

import com.revatureERS.daos.EmployeeUserDAO;
import com.revatureERS.pojos.EmployeeUser;
import com.revatureERS.services.ConsoleService;
import com.revatureERS.services.EmployeeUserservice;

import java.sql.DatabaseMetaData;
import java.util.Scanner;


public class NewUserMenu extends View {

    private EmployeeUserservice service;

    public NewUserMenu() {
        viewName = "NewUser";
        consoleService = ConsoleService.getConsoleService();
        service = new EmployeeUserservice();
    }

    @Override
    public void renderView() {
        Scanner scan = new Scanner(System.in);

        System.out.println("=============== New User =============");
        System.out.print("Enter Username: ");
        String username = scan.nextLine();
        System.out.print("Enter Email: ");
        String email = scan.nextLine();
        System.out.print("Enter Password: ");
        String password = scan.nextLine();

        EmployeeUser newEmployeeUser = new EmployeeUser(username, email, password);

        service.saveEmployeeUser(newEmployeeUser);

        consoleService.navigate("MainMenu");

    }
}
