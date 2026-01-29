package com.rev_hire.main;

import com.rev_hire.controller.EmployerController;
import com.rev_hire.model.Employer;

import java.util.Scanner;

public class EmployerMain {

    public static void start(int userId) {

        EmployerController controller = new EmployerController();
        Scanner sc = new Scanner(System.in);

        Employer employer = controller.getEmployerByUserId(userId);

        // ================= NEW EMPLOYER =================
        if (employer == null) {
            System.out.println("Welcome New Employer!");
            System.out.print("Enter Company ID to link: ");
            int companyId = sc.nextInt();
            sc.nextLine();

            boolean created = controller.createEmployer(userId, companyId);

            if (!created) {
                System.out.println("Failed to create employer profile");
                return;
            }

            System.out.println("Employer profile created successfully");

            // RE-FETCH EMPLOYER (THIS IS THE FIX)
            employer = controller.getEmployerByUserId(userId);
        }

        // ================= EMPLOYER MENU =================
        while (true) {
            System.out.println("""
            ===== EMPLOYER MENU =====
            1. Post New Job
            2. View My Jobs
            3. View Applicants
            4. Update Application Status
            5. Logout
            """);

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> JobMain.start(employer.getCompanyId());
                case 2 -> JobMain.start(employer.getCompanyId());
                case 3 -> ApplicationEmployerMain.start();
                case 4 -> ApplicationEmployerMain.start();
                case 5 -> {
                    System.out.println("Logged out");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

}