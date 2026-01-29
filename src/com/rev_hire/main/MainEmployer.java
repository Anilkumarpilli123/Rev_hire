package com.rev_hire.main;

import com.rev_hire.controller.EmployerController;
import com.rev_hire.dao.UserAccountDaoImpl;
import com.rev_hire.model.Employer;

import java.util.Scanner;

public class MainEmployer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployerController controller = new EmployerController();
        UserAccountDaoImpl userDao = new UserAccountDaoImpl(); // your existing DAO

        System.out.print("Enter your User ID: ");
        int userId = sc.nextInt();
        sc.nextLine(); // consume newline

        // ✅ Check if the user already has an employer record
        boolean hasEmployerRecord = controller.getEmployerByUserId(userId) != null;

        if (!hasEmployerRecord) {
            // Show Onboarding Menu
            while (true) {
                System.out.println("\n==== EMPLOYER ONBOARDING ====");
                System.out.println("1. Create Company");
                System.out.println("2. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Redirecting to Company creation...");
                        // You can call your Company creation logic here
                        break;
                    case 2:
                        System.out.println("Exiting Onboarding");
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } else {
            // Show Employer Dashboard
            while (true) {
                System.out.println("\n==== EMPLOYER DASHBOARD ====");
                System.out.println("1. View Company Profile");
                System.out.println("2. Update Company Profile");
                System.out.println("3. Post New Job");
                System.out.println("4. View My Jobs");
                System.out.println("5. View Applications");
                System.out.println("6. Logout");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        Employer e = controller.getEmployerByUserId(userId);
                        if (e != null) {
                            print(e);
                        } else {
                            System.out.println("Company profile not found.");
                        }
                        break;

                    case 2:
                        Employer upd = controller.getEmployerByUserId(userId);
                        if (upd != null) {
                            System.out.print("New Company ID: ");
                            upd.setCompanyId(sc.nextInt());
                            sc.nextLine();
                            System.out.println("Updated: " + controller.updateEmployer(upd));
                        } else {
                            System.out.println("Company profile not found.");
                        }
                        break;

                    case 3:
                        System.out.println("Redirecting to Post New Job...");
                        // Call your job posting logic here
                        break;

                    case 4:
                        System.out.println("Redirecting to View My Jobs...");
                        // Call logic to view jobs
                        break;

                    case 5:
                        System.out.println("Redirecting to View Applications...");
                        // Call logic to view applications
                        break;

                    case 6:
                        System.out.println("Logout");
                        return;

                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
    }

    private static void print(Employer e) {
        System.out.println("Employer ID: " + e.getEmployerId() +
                " | User ID: " + e.getUserId() +
                " | Company ID: " + e.getCompanyId());
    }
}
