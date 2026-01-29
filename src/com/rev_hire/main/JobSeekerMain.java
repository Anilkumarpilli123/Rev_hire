package com.rev_hire.main;

import com.rev_hire.controller.JobController;
import com.rev_hire.controller.JobSeekerController;
import com.rev_hire.model.JobSeeker;

import java.util.Scanner;

public class JobSeekerMain {

    public static void start(int userId) {

        JobSeekerController controller = new JobSeekerController();
        Scanner sc = new Scanner(System.in);

        JobSeeker js = controller.getJobSeekerByUserId(userId);

        // ===== CREATE PROFILE IF NEW =====
        if (js == null) {
            System.out.println("Welcome New Job Seeker!");

            js = new JobSeeker();
            js.setUserId(userId);

            System.out.print("Enter Name: ");
            js.setName(sc.nextLine());

            System.out.print("Enter Phone: ");
            js.setPhone(sc.nextLine());

            System.out.print("Experience (years): ");
            js.setExperienceYears(Integer.parseInt(sc.nextLine()));

            js.setProfileCompletion(40);

            if (!controller.createJobSeeker(js)) {
                System.out.println("Failed to create profile");
                return;
            }
            System.out.println("Profile created");
        }

        // ===== MENU LOOP =====
        while (true) {
            System.out.println("""
                ===== JOB SEEKER MENU =====
                1. View Profile
                2. Search Jobs
                3. Manage Resume
                4. Apply / View Applications
                5. View Notifications
                6. Logout
                """);

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> controller.viewProfile(userId);
                case 2 -> JobController.searchJobs();
                case 3 -> ResumeMain.start(js.getJobSeekerId());
                case 4 -> {
                    int resumeId = controller.getResumeId(js.getJobSeekerId());
                    if (resumeId == -1) {
                        System.out.println("Please create a resume first");
                    } else {
                        ApplicationJobSeekerMain.start(js.getJobSeekerId(), resumeId);
                    }
                }
                case 5 -> NotificationMain.start(userId);
                case 6 -> {
                    System.out.println("Logged out");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}