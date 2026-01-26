package com.rev_hire.dao;

import com.rev_hire.model.JobSeeker;
import com.rev_hire.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobSeekerDaoImpl implements IJobSeekerDao {

    @Override
    public boolean addJobSeeker(JobSeeker js) {
        String sql = "INSERT INTO job_seekers VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, js.getJobSeekerId());
            ps.setInt(2, js.getUserId());
            ps.setString(3, js.getName());
            ps.setString(4, js.getPhone());
            ps.setInt(5, js.getExperienceYears());
            ps.setInt(6, js.getProfileCompletion());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateJobSeeker(JobSeeker js) {
        String sql = "UPDATE job_seekers SET name=?, phone=?, experience_years=?, profile_completion=? WHERE job_seeker_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, js.getName());
            ps.setString(2, js.getPhone());
            ps.setInt(3, js.getExperienceYears());
            ps.setInt(4, js.getProfileCompletion());
            ps.setInt(5, js.getJobSeekerId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteJobSeeker(int id) {
        String sql = "DELETE FROM job_seekers WHERE job_seeker_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public JobSeeker getJobSeeker(int id) {
        String sql = "SELECT * FROM job_seekers WHERE job_seeker_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JobSeeker js = new JobSeeker();
                js.setJobSeekerId(rs.getInt("job_seeker_id"));
                js.setUserId(rs.getInt("user_id"));
                js.setName(rs.getString("name"));
                js.setPhone(rs.getString("phone"));
                js.setExperienceYears(rs.getInt("experience_years"));
                js.setProfileCompletion(rs.getInt("profile_completion"));
                return js;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<JobSeeker> getAllJobSeekers() {
        List<JobSeeker> list = new ArrayList<>();
        String sql = "SELECT * FROM job_seekers";

        try (Connection con = JDBCUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                JobSeeker js = new JobSeeker();
                js.setJobSeekerId(rs.getInt("job_seeker_id"));
                js.setUserId(rs.getInt("user_id"));
                js.setName(rs.getString("name"));
                js.setPhone(rs.getString("phone"));
                js.setExperienceYears(rs.getInt("experience_years"));
                js.setProfileCompletion(rs.getInt("profile_completion"));
                list.add(js);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}