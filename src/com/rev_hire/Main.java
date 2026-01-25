package com.rev_hire;

import com.rev_hire.controller.CompanyController;
import com.rev_hire.model.Company;
import java.util.Scanner;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CompanyController controller = new CompanyController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== COMPANY MANAGEMENT MENU ====");
            System.out.println("1. Create Company");
            System.out.println("2. View Company");
            System.out.println("3. Update Company");
            System.out.println("4. Delete Company");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {
                case 1: // CREATE
                    Company company = new Company();
                    System.out.print("Enter Company ID: ");
                    company.setCompanyId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    company.setName(sc.nextLine());
                    System.out.print("Enter Industry: ");
                    company.setIndustry(sc.nextLine());
                    System.out.print("Enter Size: ");
                    company.setSize(sc.nextLine());
                    System.out.print("Enter Description: ");
                    company.setDescription(sc.nextLine());
                    System.out.print("Enter Website: ");
                    company.setWebsite(sc.nextLine());
                    System.out.print("Enter Location: ");
                    company.setLocation(sc.nextLine());

                    System.out.println("Company Added: " + controller.addCompany(company));
                    break;

                case 2: // READ
                    System.out.print("Enter Company ID: ");
                    int id = sc.nextInt();
                    Company fetched = controller.getCompany(id);
                    if (fetched != null) {
                        System.out.println("Name: " + fetched.getName());
                        System.out.println("Location: " + fetched.getLocation());
                    } else {
                        System.out.println("Company not found");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
            }
        }
    }
}