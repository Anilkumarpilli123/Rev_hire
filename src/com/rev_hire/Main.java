package com.rev_hire;

import com.rev_hire.controller.UserAccountController;
import com.rev_hire.model.UserAccount;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        UserAccountController controller = new UserAccountController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== USER ACCOUNT MENU ====");
            System.out.println("1. Create User");
            System.out.println("2. View User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1: // CREATE
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

                    System.out.println("User Added: " +
                            controller.addUserAccount(user));
                    break;

                case 2: // READ
                    System.out.print("Enter User ID: ");
                    int id = sc.nextInt();
                    UserAccount fetched = controller.getUserAccount(id);
                    if (fetched != null) {
                        System.out.println("Email: " + fetched.getEmail());
                        System.out.println("Role: " + fetched.getRole());
                    } else {
                        System.out.println("User not found");
                    }
                    break;

                case 3: // UPDATE
                    System.out.print("Enter User ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    UserAccount existing = controller.getUserAccount(uid);
                    if (existing != null) {
                        System.out.print("New Email: ");
                        existing.setEmail(sc.nextLine());
                        System.out.print("New Password: ");
                        existing.setPassword(sc.nextLine());
                        System.out.print("New Role: ");
                        existing.setRole(sc.nextLine());

                        System.out.println("User Updated: " +
                                controller.updateUserAccount(existing));
                    } else {
                        System.out.println("User not found");
                    }
                    break;

                case 4: // DELETE
                    System.out.print("Enter User ID to delete: ");
                    int did = sc.nextInt();
                    System.out.println("User Deleted: " +
                            controller.deleteUserAccount(did));
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
            }
        }
    }
}
