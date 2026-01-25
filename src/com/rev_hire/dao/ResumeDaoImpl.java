package com.rev_hire.dao;

import com.rev_hire.model.Resume;
import com.rev_hire.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResumeDaoImpl implements IResumeDao {

    @Override
    public boolean addResume(Resume resume) {
        String sql = "INSERT INTO resumes (resume_id, job_seeker_id, objective, education, experience, skills, projects) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, resume.getResumeId());
            ps.setInt(2, resume.getJobSeekerId());
            ps.setString(3, resume.getObjective());
            ps.setString(4, resume.getEducation());
            ps.setString(5, resume.getExperience());
            ps.setString(6, resume.getSkills());
            ps.setString(7, resume.getProjects());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateResume(Resume resume) {
        String sql = "UPDATE resumes SET job_seeker_id=?, objective=?, education=?, experience=?, skills=?, projects=? " +
                "WHERE resume_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, resume.getJobSeekerId());
            ps.setString(2, resume.getObjective());
            ps.setString(3, resume.getEducation());
            ps.setString(4, resume.getExperience());
            ps.setString(5, resume.getSkills());
            ps.setString(6, resume.getProjects());
            ps.setInt(7, resume.getResumeId());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteResume(int resumeId) {
        String sql = "DELETE FROM resumes WHERE resume_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, resumeId);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Resume getResume(int resumeId) {
        String sql = "SELECT * FROM resumes WHERE resume_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, resumeId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Resume r = new Resume();
                r.setResumeId(rs.getInt("resume_id"));
                r.setJobSeekerId(rs.getInt("job_seeker_id"));
                r.setObjective(rs.getString("objective"));
                r.setEducation(rs.getString("education"));
                r.setExperience(rs.getString("experience"));
                r.setSkills(rs.getString("skills"));
                r.setProjects(rs.getString("projects"));
                return r;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Resume> getAllResumes() {
        String sql = "SELECT * FROM resumes ORDER BY resume_id"; // <-- sorted
        List<Resume> list = new ArrayList<>();
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Resume r = new Resume();
                r.setResumeId(rs.getInt("resume_id"));
                r.setJobSeekerId(rs.getInt("job_seeker_id"));
                r.setObjective(rs.getString("objective"));
                r.setEducation(rs.getString("education"));
                r.setExperience(rs.getString("experience"));
                r.setSkills(rs.getString("skills"));
                r.setProjects(rs.getString("projects"));
                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}