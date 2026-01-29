package com.rev_hire.dao;

import com.rev_hire.model.Employer;
import com.rev_hire.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployerDaoImpl {

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String DB_USER = "REVHIRE";
    private static final String DB_PASSWORD = "your_password_here";

    // Add Employer
    public boolean addEmployer(Employer e) {
        String sql = "INSERT INTO employers (user_id, company_id) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getUserId());
            ps.setInt(2, e.getCompanyId());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Get Employer by ID
    public Employer getEmployer(int id) {
        String sql = "SELECT employer_id, user_id, company_id FROM employers WHERE employer_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employer e = new Employer();
                e.setEmployerId(rs.getInt("employer_id"));
                e.setUserId(rs.getInt("user_id"));
                e.setCompanyId(rs.getInt("company_id"));
                return e;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // Update Employer
    public boolean updateEmployer(Employer e) {
        String sql = "UPDATE employers SET user_id = ?, company_id = ? WHERE employer_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getUserId());
            ps.setInt(2, e.getCompanyId());
            ps.setInt(3, e.getEmployerId());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Delete Employer
    public boolean deleteEmployer(int id) {
        String sql = "DELETE FROM employers WHERE employer_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Get All Employers
    public List<Employer> getAllEmployers() {
        List<Employer> list = new ArrayList<>();
        String sql = "SELECT employer_id, user_id, company_id FROM employers";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement st = conn.createStatement()) {

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Employer e = new Employer();
                e.setEmployerId(rs.getInt("employer_id"));
                e.setUserId(rs.getInt("user_id"));
                e.setCompanyId(rs.getInt("company_id"));
                list.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }


    public Employer getEmployerByUserId(int userId) {
        Employer e = null;
        String sql = "SELECT employer_id, user_id, company_id FROM employers WHERE user_id = ?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e = new Employer();
                e.setEmployerId(rs.getInt("employer_id"));
                e.setUserId(rs.getInt("user_id"));
                e.setCompanyId(rs.getInt("company_id"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

}
