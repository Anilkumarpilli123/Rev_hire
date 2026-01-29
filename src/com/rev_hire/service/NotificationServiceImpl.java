package com.rev_hire.service;

import com.rev_hire.dao.*;
import com.rev_hire.model.Notification;

import java.util.List;

public class NotificationServiceImpl implements INotificationService {

    private static INotificationDao dao = new NotificationDaoImpl();

    public boolean sendNotification(Notification notification) {
        return dao.addNotification(notification);
    }

    public List<Notification> getUserNotifications(int userId) {
        return dao.getNotificationsByUser(userId);
    }

    public boolean markAsRead(int notificationId) {
        return dao.markAsRead(notificationId);
    }

    public boolean deleteNotification(int notificationId) {
        return dao.deleteNotification(notificationId);
    }
}