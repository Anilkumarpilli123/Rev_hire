package com.rev_hire.dao;

import com.rev_hire.model.Company;
import java.util.List;

public interface ICompanyDao {

    boolean addCompany(Company company);
    boolean updateCompany(Company company);
    boolean deleteCompany(int companyId);
    Company getCompany(int companyId);
    List<Company> getAllCompanies();
}