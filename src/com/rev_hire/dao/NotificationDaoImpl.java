package com.rev_hire.dao;

import com.rev_hire.model.Notification;
import com.rev_hire.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationDaoImpl implements INotificationDao {

    @Override
    public boolean addNotification(Notification n) {
        String sql = "INSERT INTO notifications (user_id, message, is_read) VALUES (?, ?, ?)";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, n.getUserId());
            ps.setString(2, n.getMessage());
            ps.setBoolean(3, n.isRead());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                // fetch auto-generated ID
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    n.setNotificationId(rs.getInt(1));
                }
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateNotification(Notification n) {
        String sql = "UPDATE notifications SET user_id=?, message=?, is_read=? WHERE notification_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, n.getUserId());
            ps.setString(2, n.getMessage());
            ps.setBoolean(3, n.isRead());
            ps.setInt(4, n.getNotificationId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteNotification(int notificationId) {
        String sql = "DELETE FROM notifications WHERE notification_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, notificationId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Notification getNotification(int notificationId) {
        String sql = "SELECT * FROM notifications WHERE notification_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, notificationId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Notification n = new Notification();
                n.setNotificationId(rs.getInt("notification_id"));
                n.setUserId(rs.getInt("user_id"));
                n.setMessage(rs.getString("message"));
                n.setRead(rs.getBoolean("is_read"));
                n.setCreatedAt(rs.getTimestamp("created_at"));
                return n;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Notification> getAllNotifications() {
        String sql = "SELECT * FROM notifications ORDER BY notification_id";
        List<Notification> list = new ArrayList<>();

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Notification n = new Notification();
                n.setNotificationId(rs.getInt("notification_id"));
                n.setUserId(rs.getInt("user_id"));
                n.setMessage(rs.getString("message"));
                n.setRead(rs.getBoolean("is_read"));
                n.setCreatedAt(rs.getTimestamp("created_at"));
                list.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}


