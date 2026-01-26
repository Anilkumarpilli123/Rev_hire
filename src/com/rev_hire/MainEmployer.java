package com.rev_hire;

import com.rev_hire.controller.EmployerController;
import com.rev_hire.model.Employer;

import java.util.List;
import java.util.Scanner;

public class MainEmployer {

    public static void main(String[] args) {

        EmployerController controller = new EmployerController();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n==== EMPLOYER MENU ====");
            System.out.println("1. Add Employer");
            System.out.println("2. View Employer");
            System.out.println("3. Update Employer");
            System.out.println("4. Delete Employer");
            System.out.println("5. View All Employers");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Employer e = new Employer();
                    System.out.print("Employer ID: ");
                    e.setEmployerId(sc.nextInt());
                    System.out.print("User ID: ");
                    e.setUserId(sc.nextInt());
                    System.out.print("Company ID: ");
                    e.setCompanyId(sc.nextInt());

                    System.out.println("Added: " + controller.addEmployer(e));
                    break;

                case 2:
                    System.out.print("Enter Employer ID: ");
                    Employer emp = controller.getEmployer(sc.nextInt());
                    if (emp != null) print(emp);
                    else System.out.println("Employer not found");
                    break;

                case 3:
                    System.out.print("Employer ID: ");
                    int id = sc.nextInt();
                    Employer upd = controller.getEmployer(id);

                    if (upd != null) {
                        System.out.print("New User ID: ");
                        upd.setUserId(sc.nextInt());
                        System.out.print("New Company ID: ");
                        upd.setCompanyId(sc.nextInt());
                        System.out.println("Updated: " + controller.updateEmployer(upd));
                    } else {
                        System.out.println("Employer not found");
                    }
                    break;

                case 4:
                    System.out.print("Employer ID to delete: ");
                    System.out.println("Deleted: " +
                            controller.deleteEmployer(sc.nextInt()));
                    break;

                case 5:
                    List<Employer> list = controller.getAllEmployers();
                    for (Employer x : list) {
                        print(x);
                        System.out.println("------------");
                    }
                    break;

                case 6:
                    System.out.println("Exit");
                    return;
            }
        }
    }

    private static void print(Employer e) {
        System.out.println("Employer ID: " + e.getEmployerId());
        System.out.println("User ID    : " + e.getUserId());
        System.out.println("Company ID : " + e.getCompanyId());
    }
}
