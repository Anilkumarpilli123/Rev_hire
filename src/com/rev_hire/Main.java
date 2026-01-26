package com.rev_hire;

import com.rev_hire.controller.ApplicationController;
import com.rev_hire.model.Application;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ApplicationController controller = new ApplicationController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== APPLICATION MENU ====");
            System.out.println("1. Apply for Job");
            System.out.println("2. Withdraw Application");
            System.out.println("3. View Application by ID");
            System.out.println("4. View Applications by Job Seeker");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1: // APPLY
                    Application newApp = new Application();
                    System.out.print("Enter Application ID: ");
                    newApp.setApplicationId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Job ID: ");
                    newApp.setJobId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Job Seeker ID: ");
                    newApp.setJobSeekerId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Resume ID: ");
                    newApp.setResumeId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Cover Letter: ");
                    newApp.setCoverLetter(sc.nextLine());

                    newApp.setStatus("APPLIED");
                    newApp.setAppliedDate(new Date(System.currentTimeMillis()));

                    boolean applied = controller.applyJob(newApp);
                    System.out.println("Application Submitted: " + applied);
                    break;

                case 2: // WITHDRAW
                    System.out.print("Enter Application ID to withdraw: ");
                    int appId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Reason for Withdrawal: ");
                    String reason = sc.nextLine();

                    boolean withdrawn = controller.withdrawApplication(appId, reason);
                    System.out.println("Application Withdrawn: " + withdrawn);
                    break;

                case 3: // VIEW BY ID
                    System.out.print("Enter Application ID: ");
                    int viewId = sc.nextInt();
                    sc.nextLine();

                    Application fetched = controller.getApplicationById(viewId);
                    if (fetched != null) {
                        System.out.println("Application ID: " + fetched.getApplicationId());
                        System.out.println("Job ID: " + fetched.getJobId());
                        System.out.println("Job Seeker ID: " + fetched.getJobSeekerId());
                        System.out.println("Resume ID: " + fetched.getResumeId());
                        System.out.println("Cover Letter: " + fetched.getCoverLetter());
                        System.out.println("Status: " + fetched.getStatus());
                        System.out.println("Applied Date: " + fetched.getAppliedDate());
                        System.out.println("Withdraw Reason: " + fetched.getWithdrawReason());
                    } else {
                        System.out.println("Application not found");
                    }
                    break;

                case 4: // VIEW BY JOB SEEKER
                    System.out.print("Enter Job Seeker ID: ");
                    int seekerId = sc.nextInt();
                    sc.nextLine();

                    List<Application> apps = controller.getApplicationsByJobSeeker(seekerId);
                    if (!apps.isEmpty()) {
                        for (Application a : apps) {
                            System.out.println("\nApplication ID: " + a.getApplicationId() +
                                    ", Job ID: " + a.getJobId() +
                                    ", Status: " + a.getStatus() +
                                    ", Applied Date: " + a.getAppliedDate());
                        }
                    } else {
                        System.out.println("No applications found for this Job Seeker");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
