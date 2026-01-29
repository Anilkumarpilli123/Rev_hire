package com.rev_hire.dao;

import com.rev_hire.model.Company;
import com.rev_hire.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImpl implements ICompanyDao {

    // ================= CREATE =================
    @Override
    public boolean addCompany(Company company) {
        String sql = "INSERT INTO companies (name, industry, company_size, description, website, location) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, company.getName());
            ps.setString(2, company.getIndustry());
            ps.setString(3, company.getSize());
            ps.setString(4, company.getDescription());
            ps.setString(5, company.getWebsite());
            ps.setString(6, company.getLocation());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // ================= UPDATE (by ID) =================
    @Override
    public boolean updateCompany(Company company) {
        String sql = "UPDATE companies SET name=?, industry=?, company_size=?, description=?, website=?, location=? " +
                "WHERE company_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, company.getName());
            ps.setString(2, company.getIndustry());
            ps.setString(3, company.getSize());
            ps.setString(4, company.getDescription());
            ps.setString(5, company.getWebsite());
            ps.setString(6, company.getLocation());
            ps.setInt(7, company.getCompanyId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // ================= UPDATE (by NAME - new method) =================
    @Override
    public boolean updateCompanyByName(String companyName, Company company) {
        String sql = "UPDATE companies " +
                "SET industry=?, company_size=?, description=?, website=?, location=? " +
                "WHERE LOWER(name)=LOWER(?)";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, company.getIndustry());
            ps.setString(2, company.getSize());
            ps.setString(3, company.getDescription());
            ps.setString(4, company.getWebsite());
            ps.setString(5, company.getLocation());
            ps.setString(6, companyName);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // ================= DELETE =================
    @Override
    public boolean deleteCompany(int companyId) {
        String sql = "DELETE FROM companies WHERE company_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, companyId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // ================= GET ONE (by ID) =================
    @Override
    public Company getCompany(int companyId) {
        String sql = "SELECT * FROM companies WHERE company_id=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, companyId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Company c = new Company();
                c.setCompanyId(rs.getInt("company_id"));
                c.setName(rs.getString("name"));
                c.setIndustry(rs.getString("industry"));
                c.setSize(rs.getString("company_size"));
                c.setDescription(rs.getString("description"));
                c.setWebsite(rs.getString("website"));
                c.setLocation(rs.getString("location"));
                return c;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ================= GET ONE (by NAME) =================
    @Override
    public Company getCompanyByName(String companyName) {
        String sql = "SELECT * FROM companies WHERE LOWER(name)=LOWER(?)";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, companyName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Company c = new Company();
                c.setCompanyId(rs.getInt("company_id"));
                c.setName(rs.getString("name"));
                c.setIndustry(rs.getString("industry"));
                c.setSize(rs.getString("company_size"));
                c.setDescription(rs.getString("description"));
                c.setWebsite(rs.getString("website"));
                c.setLocation(rs.getString("location"));
                return c;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ================= GET ALL =================
    @Override
    public List<Company> getAllCompanies() {
        List<Company> list = new ArrayList<>();
        String sql = "SELECT * FROM companies";
        try (Connection con = JDBCUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Company c = new Company();
                c.setCompanyId(rs.getInt("company_id"));
                c.setName(rs.getString("name"));
                c.setIndustry(rs.getString("industry"));
                c.setSize(rs.getString("company_size"));
                c.setDescription(rs.getString("description"));
                c.setWebsite(rs.getString("website"));
                c.setLocation(rs.getString("location"));
                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
