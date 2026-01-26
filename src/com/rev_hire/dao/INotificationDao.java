package com.rev_hire.dao;
import com.rev_hire.model.Notification;
import java.util.List;
public interface INotificationDao {
    boolean addNotification(Notification notification);
    boolean updateNotification(Notification notification);
    boolean deleteNotification(int notificationId);
    Notification getNotification(int notificationId);
    List<Notification> getAllNotifications();
}
