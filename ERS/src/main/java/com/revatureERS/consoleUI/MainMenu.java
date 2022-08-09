package com.revatureERS.consoleUI;

import com.revatureERS.services.ConsoleService;

import java.util.Scanner;

public class MainMenu extends View{

     public MainMenu() {
         viewName = "MainMenu";
         consoleService = ConsoleService.getConsoleService();
     }

      public void renderView() {
         //to prompt the User
          System.out.println("============= Main Menu============");
          System.out.println("1) New User \n2) Update User \n3) Delete User \n4) Get User \n5 Get All Users \n6) Quit ");

          Scanner scan = new Scanner(System.in);
          String input = scan.nextLine();

          switch(input) {
              case "1":
                  System.out.println("Navigating...");
                  consoleService.navigate("NewUser");
                  break;
              case "2":
                  consoleService.navigate("UpdateUser");
                  break;
              case "3":
                  consoleService.navigate("DeleteUser");
                  break;
              case "4":
                  consoleService.navigate("GetUser");
                  break;
              case "5":
                  consoleService.navigate("GetAllUsers");
                  break;
              case "6":
                  consoleService.quit();
                  break;
          }
          System.out.println("Nav complete?");

      }
}
