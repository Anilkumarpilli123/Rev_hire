package com.rev_hire.dao;

import com.rev_hire.model.Application;
import com.rev_hire.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDaoImpl implements IApplicationDao {

    @Override
    public boolean applyJob(Application app) {

        String sql = "INSERT INTO applications " +
                "(application_id, job_id, job_seeker_id, resume_id, cover_letter, status, applied_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, app.getApplicationId()); // or use sequence in DB
            ps.setInt(2, app.getJobId());
            ps.setInt(3, app.getJobSeekerId());
            ps.setInt(4, app.getResumeId());
            ps.setString(5, app.getCoverLetter());
            ps.setString(6, app.getStatus());
            ps.setDate(7, app.getAppliedDate());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean withdrawApplication(int applicationId, String reason) {

        String sql = "UPDATE applications SET status=?, withdraw_reason=? WHERE application_id=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "WITHDRAWN");
            ps.setString(2, reason);
            ps.setInt(3, applicationId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Application getApplicationById(int applicationId) {

        String sql = "SELECT * FROM applications WHERE application_id=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, applicationId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Application app = new Application();
                app.setApplicationId(rs.getInt("application_id"));
                app.setJobId(rs.getInt("job_id"));
                app.setJobSeekerId(rs.getInt("job_seeker_id"));
                app.setResumeId(rs.getInt("resume_id"));
                app.setCoverLetter(rs.getString("cover_letter"));
                app.setStatus(rs.getString("status"));
                app.setAppliedDate(rs.getDate("applied_date"));
                app.setWithdrawReason(rs.getString("withdraw_reason"));
                return app;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Application> getApplicationsByJobSeeker(int jobSeekerId) {

        List<Application> list = new ArrayList<>();
        String sql = "SELECT * FROM applications WHERE job_seeker_id=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, jobSeekerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Application app = new Application();
                app.setApplicationId(rs.getInt("application_id"));
                app.setJobId(rs.getInt("job_id"));
                app.setJobSeekerId(rs.getInt("job_seeker_id"));
                app.setResumeId(rs.getInt("resume_id"));
                app.setCoverLetter(rs.getString("cover_letter"));
                app.setStatus(rs.getString("status"));
                app.setAppliedDate(rs.getDate("applied_date"));
                app.setWithdrawReason(rs.getString("withdraw_reason"));

                list.add(app);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}