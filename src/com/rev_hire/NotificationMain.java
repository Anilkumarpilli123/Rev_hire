package com.rev_hire;

import com.rev_hire.controller.NotificationController;
import com.rev_hire.model.Notification;

import java.util.List;
import java.util.Scanner;

public class NotificationMain {

    public static void main(String[] args) {

        NotificationController controller = new NotificationController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== NOTIFICATION MENU ====");
            System.out.println("1. Add Notification");
            System.out.println("2. View Notification by ID");
            System.out.println("3. Update Notification");
            System.out.println("4. Delete Notification");
            System.out.println("5. View All Notifications");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    Notification n = new Notification();

                    System.out.print("Enter User ID: ");
                    n.setUserId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Message: ");
                    n.setMessage(sc.nextLine());

                    System.out.print("Is Read (true/false): ");
                    n.setRead(sc.nextBoolean());
                    sc.nextLine();

                    System.out.println("Notification Added: " +
                            controller.addNotification(n));
                    System.out.println("Generated Notification ID: " + n.getNotificationId());
                    break;

                case 2:
                    System.out.print("Enter Notification ID: ");
                    int nid = sc.nextInt();
                    sc.nextLine();

                    Notification fetched = controller.getNotification(nid);
                    if (fetched != null) {
                        System.out.println("Notification ID: " + fetched.getNotificationId());
                        System.out.println("User ID: " + fetched.getUserId());
                        System.out.println("Message: " + fetched.getMessage());
                        System.out.println("Is Read: " + fetched.isRead());
                        System.out.println("Created At: " + fetched.getCreatedAt());
                    } else {
                        System.out.println("Notification not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter Notification ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Notification existing = controller.getNotification(updateId);
                    if (existing != null) {

                        System.out.print("New User ID: ");
                        existing.setUserId(sc.nextInt());
                        sc.nextLine();

                        System.out.print("New Message: ");
                        existing.setMessage(sc.nextLine());

                        System.out.print("Is Read (true/false): ");
                        existing.setRead(sc.nextBoolean());
                        sc.nextLine();

                        System.out.println("Notification Updated: " +
                                controller.updateNotification(existing));
                    } else {
                        System.out.println("Notification not found");
                    }
                    break;

                case 4:
                    System.out.print("Enter Notification ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Notification Deleted: " +
                            controller.deleteNotification(deleteId));
                    break;

                case 5:
                    List<Notification> all = controller.getAllNotifications();
                    if (all.isEmpty()) {
                        System.out.println("No notifications found.");
                    } else {
                        System.out.println("\nAll Notifications:");
                        for (Notification noti : all) {
                            System.out.println("-------------------------------");
                            System.out.println("Notification ID: " + noti.getNotificationId());
                            System.out.println("User ID: " + noti.getUserId());
                            System.out.println("Message: " + noti.getMessage());
                            System.out.println("Is Read: " + noti.isRead());
                            System.out.println("Created At: " + noti.getCreatedAt());
                        }
                        System.out.println("-------------------------------");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
