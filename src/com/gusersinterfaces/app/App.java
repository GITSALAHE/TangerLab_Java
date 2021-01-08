package com.gusersinterfaces.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.gusersinterfaces.controllers.EmployeController;

public class App {

    public static void main(String[] args) throws SQLException {
        EmployeController employe = new EmployeController();
        Scanner reader = new Scanner(System.in);
        Boolean out = true;
        while (true) {
            System.out.println("+-------------------------+ :");
            System.out.println("|   WELCOME TO TANGERLAB    |");
            System.out.println("+-------------------------+ :");
            System.out.println("1\t  Show employer");
            System.out.println("2\t  add a employer");
            System.out.println("3\t  update a employer");
            System.out.println("4\t  delete a employer");
            System.out.println("5\t  Exit");
            int input = reader.nextInt();
            switch (input) {
                case 1:
                    employe.showEmployer();
                    break;
                case 2:
                    employe.addEmployer();
                    break;

                case 3:
                    employe.updateEmployer();
                    break;

                case 4:
                    employe.deleteEmploye();
                    break;

                case 5:
                System.out.println("********************* Exit *********************");
                System.out.println("************  TANGER LAB BY GITSALAH ***********");
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }

    }
}
