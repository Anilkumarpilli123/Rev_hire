package com.rev_hire;

import com.rev_hire.controller.UserAccountController;
import com.rev_hire.controller.JobSeekerController;
import com.rev_hire.model.UserAccount;
import com.rev_hire.model.JobSeeker;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        UserAccountController userController = new UserAccountController();
        JobSeekerController jobSeekerController = new JobSeekerController();

        while (true) {

            System.out.println("\n====== REV HIRE MENU ======");
            System.out.println("1. Create User Account");
            System.out.println("2. View User Account");
            System.out.println("3. Update User Account");
            System.out.println("4. Delete User Account");

            System.out.println("5. Create Job Seeker");
            System.out.println("6. View Job Seeker");
            System.out.println("7. Update Job Seeker");
            System.out.println("8. Delete Job Seeker");

            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // USER ACCOUNT CRUD
                case 1:
                    UserAccount user = new UserAccount();

                    System.out.print("Enter ID: ");
                    user.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Email: ");
                    user.setEmail(sc.nextLine());

                    System.out.print("Enter Password: ");
                    user.setPassword(sc.nextLine());

                    System.out.print("Enter Role: ");
                    user.setRole(sc.nextLine());

                    System.out.println("User Added: " + userController.addUserAccount(user));
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();

                    UserAccount fetched = userController.getUserAccount(uid);
                    if (fetched != null) {
                        System.out.println("Email: " + fetched.getEmail());
                        System.out.println("Role: " + fetched.getRole());
                    } else {
                        System.out.println("User not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    int upid = sc.nextInt();
                    sc.nextLine();

                    UserAccount existing = userController.getUserAccount(upid);
                    if (existing != null) {
                        System.out.print("New Email: ");
                        existing.setEmail(sc.nextLine());

                        System.out.print("New Password: ");
                        existing.setPassword(sc.nextLine());

                        System.out.print("New Role: ");
                        existing.setRole(sc.nextLine());

                        System.out.println("Updated: " + userController.updateUserAccount(existing));
                    } else {
                        System.out.println("User not found");
                    }
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    int did = sc.nextInt();
                    System.out.println("Deleted: " + userController.deleteUserAccount(did));
                    break;

                // JOB SEEKER CRUD
                case 5:
                    JobSeeker js = new JobSeeker();

                    System.out.print("Job Seeker ID: ");
                    js.setJobSeekerId(sc.nextInt());

                    System.out.print("User ID: ");
                    js.setUserId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Name: ");
                    js.setName(sc.nextLine());

                    System.out.print("Phone: ");
                    js.setPhone(sc.nextLine());

                    System.out.print("Experience Years: ");
                    js.setExperienceYears(sc.nextInt());

                    System.out.print("Profile Completion: ");
                    js.setProfileCompletion(sc.nextInt());

                    System.out.println("Inserted: " + jobSeekerController.addJobSeeker(js));
                    break;

                case 6:
                    System.out.print("Job Seeker ID: ");
                    int jid = sc.nextInt();

                    JobSeeker job = jobSeekerController.getJobSeeker(jid);
                    if (job != null) {
                        System.out.println("Name: " + job.getName());
                        System.out.println("Phone: " + job.getPhone());
                    } else {
                        System.out.println("Not found");
                    }
                    break;

                case 7:
                    System.out.print("Job Seeker ID: ");
                    int ujid = sc.nextInt();
                    sc.nextLine();

                    JobSeeker upd = jobSeekerController.getJobSeeker(ujid);
                    if (upd != null) {
                        System.out.print("New Name: ");
                        upd.setName(sc.nextLine());

                        System.out.print("New Phone: ");
                        upd.setPhone(sc.nextLine());

                        System.out.print("Experience: ");
                        upd.setExperienceYears(sc.nextInt());

                        System.out.print("Profile Completion: ");
                        upd.setProfileCompletion(sc.nextInt());

                        System.out.println("Updated: " + jobSeekerController.updateJobSeeker(upd));
                    }
                    break;

                case 8:
                    System.out.print("Job Seeker ID: ");
                    int djid = sc.nextInt();
                    System.out.println("Deleted: " + jobSeekerController.deleteJobSeeker(djid));
                    break;

                case 9:
                    System.out.println("Bye");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
