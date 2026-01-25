package com.rev_hire.controller;

import com.rev_hire.model.Company;
import com.rev_hire.service.ICompanyService;
import com.rev_hire.service.CompanyServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class CompanyController {

    private static ICompanyService companyService = new CompanyServiceImpl();

    // CREATE
    public boolean addCompany(Company company) throws SQLException {
        return companyService.addCompany(company);
    }

    // UPDATE
    public boolean updateCompany(Company company) {
        return companyService.updateCompany(company);
    }

    // DELETE
    public boolean deleteCompany(int companyId) {
        return companyService.deleteCompany(companyId);
    }

    // READ (single)
    public Company getCompany(int companyId) {
        return companyService.getCompany(companyId);
    }

    // READ (all)
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }
}