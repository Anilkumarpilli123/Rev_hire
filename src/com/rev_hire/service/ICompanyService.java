package com.rev_hire.service;

import com.rev_hire.model.Company;

import java.sql.SQLException;
import java.util.List;

public interface ICompanyService {

    // ================= CREATE =================
    boolean addCompany(Company company) throws SQLException;

    // ================= UPDATE (by ID) =================
    boolean updateCompany(Company company);

    // ================= UPDATE (by NAME - new method) =================
    boolean updateCompanyByName(String companyName, Company updatedData);

    // ================= DELETE =================
    boolean deleteCompany(int companyId);

    // ================= READ (by ID) =================
    Company getCompany(int companyId);

    // ================= READ (by NAME) =================
    Company getCompanyByName(String companyName);

    // ================= READ ALL =================
    List<Company> getAllCompanies();
}
