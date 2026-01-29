package com.rev_hire;

import com.rev_hire.controller.CompanyController;
import com.rev_hire.model.Company;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CompanyController controller = new CompanyController();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            System.out.println("\n==== COMPANY MANAGEMENT MENU ====");
            System.out.println("1. Create Company");
            System.out.println("2. View Company (by Name)");
            System.out.println("3. Update Company (by Name)");
            System.out.println("4. Delete Company (by ID)");
            System.out.println("5. Exit");
            System.out.println("6. View All Companies");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // ================= CREATE =================
                case 1:
                    try {
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Industry: ");
                        String industry = sc.nextLine();

                        System.out.print("Enter Size (e.g., 50-60): ");
                        String size = sc.nextLine();

                        System.out.print("Enter Description: ");
                        String description = sc.nextLine();

                        System.out.print("Enter Website: ");
                        String website = sc.nextLine();

                        System.out.print("Enter Location: ");
                        String location = sc.nextLine();

                        Company newCompany = new Company();
                        newCompany.setName(name);
                        newCompany.setIndustry(industry);
                        newCompany.setSize(size);
                        newCompany.setDescription(description);
                        newCompany.setWebsite(website);
                        newCompany.setLocation(location);

                        System.out.println(
                                "Company Added: " + controller.addCompany(newCompany)
                        );

                    } catch (SQLException e) {
                        System.out.println("Database Error while adding company!");
                        e.printStackTrace();
                    }
                    break;

                // ================= VIEW BY NAME =================
                case 2:
                    System.out.print("Enter Company Name: ");
                    String viewName = sc.nextLine();

                    Company viewCompany = controller.getCompanyByName(viewName);
                    if (viewCompany != null) {
                        System.out.println("Name: " + viewCompany.getName());
                        System.out.println("Industry: " + viewCompany.getIndustry());
                        System.out.println("Size: " + viewCompany.getSize());
                        System.out.println("Description: " + viewCompany.getDescription());
                        System.out.println("Website: " + viewCompany.getWebsite());
                        System.out.println("Location: " + viewCompany.getLocation());
                    } else {
                        System.out.println("Company Not Found!");
                    }
                    break;

                // ================= UPDATE BY NAME =================
                case 3:
                    System.out.print("Enter Company Name to Update: ");
                    String updateName = sc.nextLine();

                    Company updatedData = new Company();

                    System.out.print("Enter New Industry: ");
                    updatedData.setIndustry(sc.nextLine());

                    System.out.print("Enter New Size (e.g., 50-60): ");
                    updatedData.setSize(sc.nextLine());

                    System.out.print("Enter New Description: ");
                    updatedData.setDescription(sc.nextLine());

                    System.out.print("Enter New Website: ");
                    updatedData.setWebsite(sc.nextLine());

                    System.out.print("Enter New Location: ");
                    updatedData.setLocation(sc.nextLine());

                    // Calls new controller/service/DAO logic
                    boolean updated = controller.updateCompanyByName(updateName, updatedData);
                    System.out.println("Company Updated: " + updated);

                    if (!updated) {
                        System.out.println("Update failed: Company not found or database error.");
                    }
                    break;

                // ================= DELETE =================
                case 4:
                    System.out.print("Enter Company ID to Delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    System.out.println(
                            "Company Deleted: " + controller.deleteCompany(deleteId)
                    );
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                case 6:
                    List<Company> companies = controller.getAllCompanies();
                    if (companies.isEmpty()) {
                        System.out.println("No companies found!");
                    } else {
                        for (Company c : companies) {
                            System.out.println(
                                    c.getCompanyId() + " | " +
                                            c.getName() + " | " +
                                            c.getIndustry() + " | " +
                                            c.getSize()
                            );
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
        sc.close();
    }
}
