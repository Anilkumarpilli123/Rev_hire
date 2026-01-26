package com.rev_hire.dao;

import com.rev_hire.model.Employer;
import com.rev_hire.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployerDaoImpl implements IEmployerDao {

    @Override
    public boolean addEmployer(Employer e) {

        String sql = "INSERT INTO employers (employer_id, user_id, company_id) VALUES (?, ?, ?)";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, e.getEmployerId());
            ps.setInt(2, e.getUserId());
            ps.setInt(3, e.getCompanyId());

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Employer getEmployer(int employerId) {

        String sql = "SELECT * FROM employers WHERE employer_id=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, employerId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employer e = new Employer();
                e.setEmployerId(rs.getInt("employer_id"));
                e.setUserId(rs.getInt("user_id"));
                e.setCompanyId(rs.getInt("company_id"));
                return e;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateEmployer(Employer e) {

        String sql = "UPDATE employers SET user_id=?, company_id=? WHERE employer_id=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, e.getUserId());
            ps.setInt(2, e.getCompanyId());
            ps.setInt(3, e.getEmployerId());

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmployer(int employerId) {

        String sql = "DELETE FROM employers WHERE employer_id=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, employerId);
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employer> getAllEmployers() {

        List<Employer> list = new ArrayList<>();
        String sql = "SELECT * FROM employers";

        try (Connection con = JDBCUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Employer e = new Employer();
                e.setEmployerId(rs.getInt("employer_id"));
                e.setUserId(rs.getInt("user_id"));
                e.setCompanyId(rs.getInt("company_id"));
                list.add(e);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
