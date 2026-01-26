package com.rev_hire.service;

import com.rev_hire.dao.INotificationDao;
import com.rev_hire.dao.NotificationDaoImpl;
import com.rev_hire.model.Notification;

import java.util.List;

public class NotificationServiceImpl implements INotificationService {

    private static INotificationDao dao = new NotificationDaoImpl();

    @Override
    public boolean addNotification(Notification notification) {
        return dao.addNotification(notification);
    }

    @Override
    public boolean updateNotification(Notification notification) {
        return dao.updateNotification(notification);
    }

    @Override
    public boolean deleteNotification(int notificationId) {
        return dao.deleteNotification(notificationId);
    }

    @Override
    public Notification getNotification(int notificationId) {
        return dao.getNotification(notificationId);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return dao.getAllNotifications();
    }
}

