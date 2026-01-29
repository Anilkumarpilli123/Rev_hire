package com.rev_hire.main;

import com.rev_hire.controller.ApplicationController;
import com.rev_hire.model.Application;

import java.util.List;
import java.util.Scanner;

public class ApplicationJobSeekerMain {

    public static void start(int jobSeekerId, int resumeId) {

        Scanner sc = new Scanner(System.in);
        ApplicationController controller = new ApplicationController();

        while (true) {
            System.out.println("""
                ==== APPLICATION MENU (JOB SEEKER) ====
                1. Apply for Job
                2. View My Applications
                3. Withdraw Application
                4. Back
                """);
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> {
                    Application a = new Application();
                    a.setJobSeekerId(jobSeekerId);
                    a.setResumeId(resumeId);

                    System.out.print("Enter Job ID: ");
                    a.setJobId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Cover Letter: ");
                    a.setCoverLetter(sc.nextLine());

                    System.out.println("Applied: " +
                            controller.applyJob(a));
                }

                case 2 -> {
                    List<Application> list =
                            controller.getMyApplications(jobSeekerId);

                    for (Application a : list) {
                        System.out.println("AppID: " + a.getApplicationId()
                                + " | JobID: " + a.getJobId()
                                + " | Status: " + a.getStatus());
                    }
                }

                case 3 -> {
                    System.out.print("Application ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Withdraw Reason: ");
                    String reason = sc.nextLine();

                    System.out.println("Withdrawn: " +
                            controller.withdrawApplication(id, reason));
                }

                case 4 -> {
                    return;
                }
            }
        }
    }
}