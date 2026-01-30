package com.rev_hire.main;

import com.rev_hire.controller.JobController;
import com.rev_hire.model.Job;

import java.sql.Date;
import java.util.Scanner;

public class JobMain {

    public static void start(int companyId) {

        Scanner sc = new Scanner(System.in);
        JobController controller = new JobController();

        while (true) {
            System.out.println("""
                ==== JOB MENU ====
                1. Post New Job
                2. View My Jobs
                3. Update Job
                4. Delete Job
                5. Back
                """);

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> {
                    Job j = new Job();
                    j.setCompanyId(companyId);

                    System.out.print("Title: ");
                    j.setTitle(sc.nextLine());
                    System.out.print("Description: ");
                    j.setDescription(sc.nextLine());
                    System.out.print("Skills: ");
                    j.setSkillsRequired(sc.nextLine());
                    System.out.print("Experience (years): ");
                    j.setExperienceRequired(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Education: ");
                    j.setEducationRequired(sc.nextLine());
                    System.out.print("Location: ");
                    j.setLocation(sc.nextLine());
                    System.out.print("Salary Range: ");
                    j.setSalaryRange(sc.nextLine());
                    System.out.print("Job Type: ");
                    j.setJobType(sc.nextLine());

                    j.setDeadline(new Date(System.currentTimeMillis()));
                    j.setStatus("OPEN");

                    System.out.println("Job Posted: " +
                            controller.addJob(j));
                }

                case 2 -> controller.getJobsByCompany(companyId)
                        .forEach(j ->
                                System.out.println(j.getJobId() + " - " + j.getTitle())
                        );

                case 3 -> {
                    System.out.print("Job ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Job j = controller.getJob(id);
                    if (j != null) {
                        System.out.print("New Title: ");
                        j.setTitle(sc.nextLine());
                        System.out.print("New Status: ");
                        j.setStatus(sc.nextLine());
                        System.out.println("Updated: " +
                                controller.updateJob(j));
                    }
                }

                case 4 -> {
                    System.out.print("Job ID: ");
                    int id = sc.nextInt();
                    Job j = controller.getJob(id);
                    j.setStatus("CLOSED");
                    controller.updateJob(j);
                    System.out.println("✅ Job closed successfully");
                }

                case 5 -> {
                    return;
                }
            }
        }
    }
}
