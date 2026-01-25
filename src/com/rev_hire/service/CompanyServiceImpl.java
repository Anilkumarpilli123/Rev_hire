package com.rev_hire.service;

import com.rev_hire.dao.*;
import com.rev_hire.model.Company;

import java.util.List;

public class CompanyServiceImpl implements ICompanyService {

    private static ICompanyDao companyDao = new CompanyDaoImpl();

    @Override
    public boolean addCompany(Company company) {
        return companyDao.addCompany(company);
    }

    @Override
    public boolean updateCompany(Company company) {
        return companyDao.updateCompany(company);
    }

    @Override
    public boolean deleteCompany(int companyId) {
        return companyDao.deleteCompany(companyId);
    }

    @Override
    public Company getCompany(int companyId) {
        return companyDao.getCompany(companyId);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyDao.getAllCompanies();
    }
}