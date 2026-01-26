package com.rev_hire;

import com.rev_hire.model.Company;
import com.rev_hire.dao.ICompanyDao;
import com.rev_hire.dao.CompanyDaoImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ICompanyDao companyDao = new CompanyDaoImpl();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n==== COMPANY MANAGEMENT MENU ====");
            System.out.println("1. Create Company");
            System.out.println("2. View Company");
            System.out.println("3. Update Company");
            System.out.println("4. Delete Company");
            System.out.println("5. Exit");
            System.out.println("6. View All Companies");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: // Create
                    System.out.print("Enter Company ID: ");
                    int createId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: ");
                    String createName = sc.nextLine();
                    System.out.print("Enter Industry: ");
                    String createIndustry = sc.nextLine();
                    System.out.print("Enter Size: ");
                    int createSize = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Description: ");
                    String createDesc = sc.nextLine();
                    System.out.print("Enter Website: ");
                    String createWebsite = sc.nextLine();
                    System.out.print("Enter Location: ");
                    String createLocation = sc.nextLine();

                    // ✅ Use no-arg constructor + setters
                    Company newCompany = new Company();
                    newCompany.setCompanyId(createId);
                    newCompany.setName(createName);
                    newCompany.setIndustry(createIndustry);
                    newCompany.setSize(createSize);
                    newCompany.setDescription(createDesc);
                    newCompany.setWebsite(createWebsite);
                    newCompany.setLocation(createLocation);

                    System.out.println("Company Added: " + companyDao.addCompany(newCompany));
                    break;

                case 2: // View
                    System.out.print("Enter Company ID: ");
                    int viewId = sc.nextInt(); sc.nextLine();
                    Company viewCompany = companyDao.getCompany(viewId);
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

                case 3: // Update
                    System.out.print("Enter Company ID to Update: ");
                    int updateId = sc.nextInt(); sc.nextLine();
                    Company updateCompany = companyDao.getCompany(updateId);
                    if (updateCompany != null) {
                        System.out.print("Enter New Name: ");
                        updateCompany.setName(sc.nextLine());
                        System.out.print("Enter New Industry: ");
                        updateCompany.setIndustry(sc.nextLine());
                        System.out.print("Enter New Size: ");
                        updateCompany.setSize(sc.nextInt()); sc.nextLine();
                        System.out.print("Enter New Description: ");
                        updateCompany.setDescription(sc.nextLine());
                        System.out.print("Enter New Website: ");
                        updateCompany.setWebsite(sc.nextLine());
                        System.out.print("Enter New Location: ");
                        updateCompany.setLocation(sc.nextLine());

                        System.out.println("Company Updated: " + companyDao.updateCompany(updateCompany));
                    } else {
                        System.out.println("Company Not Found!");
                    }
                    break;

                case 4: // Delete
                    System.out.print("Enter Company ID to Delete: ");
                    int deleteId = sc.nextInt(); sc.nextLine();
                    System.out.println("Company Deleted: " + companyDao.deleteCompany(deleteId));
                    break;

                case 5: // Exit
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                case 6: // View All
                    List<Company> allCompanies = companyDao.getAllCompanies();
                    if (allCompanies.isEmpty()) {
                        System.out.println("No companies found!");
                    } else {
                        System.out.printf("%-10s %-20s %-10s %-12s %-25s %-25s %-15s%n",
                                "ID", "Name", "Industry", "Size", "Description", "Website", "Location");
                        for (Company c : allCompanies) {
                            System.out.printf("%-10d %-20s %-10s %-12d %-25s %-25s %-15s%n",
                                    c.getCompanyId(),
                                    c.getName(),
                                    c.getIndustry(),
                                    c.getSize(),
                                    c.getDescription(),
                                    c.getWebsite(),
                                    c.getLocation());
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
