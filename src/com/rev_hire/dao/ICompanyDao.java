package com.rev_hire.dao;

import com.rev_hire.model.Company;
import java.util.List;

public interface ICompanyDao {

    boolean addCompany(Company company);

    boolean updateCompany(Company company);

    // ================= UPDATE BY NAME =================
    boolean updateCompanyByName(String companyName, Company updatedData);

    boolean deleteCompany(int companyId);

    Company getCompany(int companyId);

    Company getCompanyByName(String companyName);

    List<Company> getAllCompanies();
}
