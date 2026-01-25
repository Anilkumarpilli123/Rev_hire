package com.rev_hire.service;

import com.rev_hire.model.Company;
import java.util.List;

public interface ICompanyService {

    boolean addCompany(Company company);

    boolean updateCompany(Company company);

    boolean deleteCompany(int companyId);

    Company getCompany(int companyId);

    List<Company> getAllCompanies();
}
