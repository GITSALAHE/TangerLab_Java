package com.gusersinterfaces.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.guserinterfaces.config.DB;
public class EmployeController implements ProductionRisquesInterface, ManutentionRisqueInterface{
    DB db;
    Scanner scan;

    private double vrChiffre = 20000;
	private double rpChiffre = 30000;
	private int uNProduitMensuel = 20;
    private int nBheur = 200;
    
    public EmployeController() {
        db = new DB();
        scan = new Scanner(System.in);
    }

    public double calculerSalaire(int type) {
        if(type == 1){
            return vrChiffre *0.2 + 1500;
        }
        else if(type == 2){
            return rpChiffre *0.2 + 2500;
        }
        else if(type == 3){
            return uNProduitMensuel*5 + ProductionRisquesInterface.salaireFixe;
        }
        else if(type == 4){
            return nBheur*50 + ManutentionRisqueInterface.salaireFixe;
        }
        return 0;
    }

    public void showEmployer() throws SQLException {
        ResultSet rs = db.selectAll("employe");
        String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n";

        System.out.format("+-----------------+---------------------------------------------------GESTION Employe-----------------------------------------+%n");
        System.out.format("|      id         |      Nom        |      Prenom     |       age       |        DES      |      Type       |     Salary      |%n");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");

        while (rs.next()) {
            System.out.format(leftAlignFormat, rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
                    rs.getInt("age"), rs.getString("DES"), rs.getString("type"), rs.getDouble("salary"));
        }
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");

    }

    public void addEmployer() throws SQLException {
        System.out.println("please put your name");
        String fname = scan.next();

        System.out.println("Please put your last name");
        String lname = scan.next();

        System.out.println("Please put your age");
        int age = scan.nextInt();

        System.out.println("Please put date of entry into service");
        String des = scan.next();

        System.out.println("Please put your type");
        String leftAlignFormat = "| %-15s | %-15s |%n";
        System.out.format("+-----------------+-----------------+%n");
        System.out.format(leftAlignFormat, "1", "vendeur");
        System.out.format(leftAlignFormat, 2, "representeur");
        System.out.format(leftAlignFormat, 3, "producteur");
        System.out.format(leftAlignFormat, 4, "Manutentionaire");
        System.out.format("+-----------------+-----------------+%n");
        
        int choosen = scan.nextInt();

        String type = "";
        switch (choosen) {
            case 1:
                type = "vendeur";
                break;
            case 2: 
                type = "representeur";
                break;
            case 3: 
                type = "producteur";
            break;
            case 4:
                type = "Manutentionaire";
            break;
        }

        String sql = "INSERT INTO employe SET nom ='" + fname + "', prenom='" + lname + "', age=" + age + ", des='"
                + des + "', type='" + type + "', salary=" + calculerSalaire(choosen) + "";
        db.createAndUpdateAndDelete(sql);
        System.out.println("employe added successfuly");
    }

    public void updateEmployer() throws SQLException {
        showEmployer();
        System.out.println("please give me the id");
        int id = scan.nextInt();
        System.out.println("please put your name");
        String fname = scan.next();

        System.out.println("Please put your last name");
        String lname = scan.next();

        System.out.println("Please put your age");
        int age = scan.nextInt();

        System.out.println("Please put date of entry into service");
        String des = scan.next();

        System.out.println("Please put your type");
        String leftAlignFormat = "| %-15s | %-15s |%n";
        System.out.format("+-----------------+-----------------+%n");
        System.out.format(leftAlignFormat, "1", "vendeur");
        System.out.format(leftAlignFormat, 2, "representeur");
        System.out.format(leftAlignFormat, 3, "producteur");
        System.out.format(leftAlignFormat, 4, "Manutentionaire");
        System.out.format("+-----------------+-----------------+%n");
        
        int choosen = scan.nextInt();

        String type = "";
        switch (choosen) {
            case 1:
                type = "vendeur";
                break;
            case 2: 
                type = "representeur";
                break;
            case 3: 
                type = "producteur";
            break;
            case 4:
                type = "Manutentionaire";
            break;
        }
       
        String sql = "UPDATE employe SET nom ='" + fname + "', prenom='" + lname + "', age=" + age + ", des='" + des
                + "', type='" + type + "', salary=" + calculerSalaire(choosen) + " WHERE id=" + id;
        db.createAndUpdateAndDelete(sql);
        System.out.println("employe updated successfuly");
    }

    public void deleteEmploye() throws SQLException {
        showEmployer();
        System.out.println("please give me the id");
        int id = scan.nextInt();
        String sql = "DELETE FROM employe where id=" + id;
        db.createAndUpdateAndDelete(sql);
        System.out.println("employe deleted successfuly");
    }
}
