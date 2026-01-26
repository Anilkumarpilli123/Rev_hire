package com.rev_hire;

import com.rev_hire.controller.ResumeController;
import com.rev_hire.model.Resume;

import java.util.Scanner;
import java.util.List;

public class ResumeMain {

    public static void main(String[] args) {

        ResumeController controller = new ResumeController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== RESUME MENU ====");
            System.out.println("1. Add Resume");
            System.out.println("2. View Resume by ID");
            System.out.println("3. Update Resume");
            System.out.println("4. Delete Resume");
            System.out.println("5. View All Resumes");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {

                case 1: // ADD
                    Resume newResume = new Resume();

                    System.out.print("Enter Resume ID: ");
                    newResume.setResumeId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Job Seeker ID: ");
                    newResume.setJobSeekerId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Objective: ");
                    newResume.setObjective(sc.nextLine());

                    System.out.print("Enter Education: ");
                    newResume.setEducation(sc.nextLine());

                    System.out.print("Enter Experience: ");
                    newResume.setExperience(sc.nextLine());

                    System.out.print("Enter Skills: ");
                    newResume.setSkills(sc.nextLine());

                    System.out.print("Enter Projects: ");
                    newResume.setProjects(sc.nextLine());

                    System.out.println("Resume Added: " + controller.addResume(newResume));
                    break;

                case 2: // VIEW BY ID
                    System.out.print("Enter Resume ID: ");
                    int rid = sc.nextInt();
                    sc.nextLine();

                    Resume fetched = controller.getResume(rid);
                    if (fetched != null) {
                        System.out.println("Resume ID: " + fetched.getResumeId());
                        System.out.println("Job Seeker ID: " + fetched.getJobSeekerId());
                        System.out.println("Objective: " + fetched.getObjective());
                        System.out.println("Education: " + fetched.getEducation());
                        System.out.println("Experience: " + fetched.getExperience());
                        System.out.println("Skills: " + fetched.getSkills());
                        System.out.println("Projects: " + fetched.getProjects());
                    } else {
                        System.out.println("Resume not found");
                    }
                    break;

                case 3: // UPDATE
                    System.out.print("Enter Resume ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Resume existing = controller.getResume(updateId);
                    if (existing != null) {
                        System.out.print("New Job Seeker ID: ");
                        existing.setJobSeekerId(sc.nextInt());
                        sc.nextLine();

                        System.out.print("New Objective: ");
                        existing.setObjective(sc.nextLine());

                        System.out.print("New Education: ");
                        existing.setEducation(sc.nextLine());

                        System.out.print("New Experience: ");
                        existing.setExperience(sc.nextLine());

                        System.out.print("New Skills: ");
                        existing.setSkills(sc.nextLine());

                        System.out.print("New Projects: ");
                        existing.setProjects(sc.nextLine());

                        System.out.println("Resume Updated: " + controller.updateResume(existing));
                    } else {
                        System.out.println("Resume not found");
                    }
                    break;

                case 4: // DELETE
                    System.out.print("Enter Resume ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Resume Deleted: " + controller.deleteResume(deleteId));
                    break;

                case 5: // VIEW ALL
                    List<Resume> allResumes = controller.getAllResumes();
                    if (allResumes.isEmpty()) {
                        System.out.println("No resumes found.");
                    } else {
                        System.out.println("\nAll Resumes:");
                        for (Resume r : allResumes) {
                            System.out.println("-------------------------------");
                            System.out.println("Resume ID: " + r.getResumeId());
                            System.out.println("Job Seeker ID: " + r.getJobSeekerId());
                            System.out.println("Objective: " + r.getObjective());
                            System.out.println("Education: " + r.getEducation());
                            System.out.println("Experience: " + r.getExperience());
                            System.out.println("Skills: " + r.getSkills());
                            System.out.println("Projects: " + r.getProjects());
                        }
                        System.out.println("-------------------------------");
                    }
                    break;

                case 6: // EXIT
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
