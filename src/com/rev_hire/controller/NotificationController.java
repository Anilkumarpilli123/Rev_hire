package com.rev_hire.controller;

import com.rev_hire.model.Notification;
import com.rev_hire.service.INotificationService;
import com.rev_hire.service.NotificationServiceImpl;

import java.util.List;

public class NotificationController {

    private static INotificationService service = new NotificationServiceImpl();

    public boolean addNotification(Notification n) {
        return service.addNotification(n);
    }

    public boolean updateNotification(Notification n) {
        return service.updateNotification(n);
    }

    public boolean deleteNotification(int id) {
        return service.deleteNotification(id);
    }

    public Notification getNotification(int id) {
        return service.getNotification(id);
    }

    public List<Notification> getAllNotifications() {
        return service.getAllNotifications();
    }
}

