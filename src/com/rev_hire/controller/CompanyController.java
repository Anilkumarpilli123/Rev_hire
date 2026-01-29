package com.rev_hire.controller;

import com.rev_hire.model.Company;
import com.rev_hire.service.ICompanyService;
import com.rev_hire.service.CompanyServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class CompanyController {

    private static ICompanyService companyService = new CompanyServiceImpl();

    // ================= CREATE =================
    public boolean addCompany(Company company) throws SQLException {
        return companyService.addCompany(company);
    }

    // ================= UPDATE (by ID - internal use) =================
    public boolean updateCompany(Company company) {
        return companyService.updateCompany(company);
    }

    // ================= UPDATE (by NAME - user friendly) =================
    public boolean updateCompanyByName(String companyName, Company updatedData) {
        // Directly call service method that updates by name
        return companyService.updateCompanyByName(companyName, updatedData);
    }

    // ================= DELETE =================
    public boolean deleteCompany(int companyId) {
        return companyService.deleteCompany(companyId);
    }

    // ================= READ (by ID - internal/admin) =================
    public Company getCompany(int companyId) {
        return companyService.getCompany(companyId);
    }

    // ================= READ (by NAME - user friendly) =================
    public Company getCompanyByName(String companyName) {
        return companyService.getCompanyByName(companyName);
    }

    // ================= READ (all) =================
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }
}
