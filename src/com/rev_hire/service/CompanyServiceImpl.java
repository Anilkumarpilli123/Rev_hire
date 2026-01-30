package com.rev_hire.service;

import com.rev_hire.dao.CompanyDaoImpl;
import com.rev_hire.dao.ICompanyDao;
import com.rev_hire.model.Company;

import java.util.List;

public class CompanyServiceImpl implements ICompanyService {

    private static ICompanyDao companyDao = new CompanyDaoImpl();

    public boolean addCompany(Company c) {
        return companyDao.addCompany(c);
    }

    public Company getCompanyById(int id) {
        return companyDao.getCompanyById(id);
    }

    public List<Company> getAllCompanies() {
        return companyDao.getAllCompanies();
    }

    public boolean updateCompany(Company c) {
        return companyDao.updateCompany(c);
    }

    public boolean deleteCompany(int id) {
        return companyDao.deleteCompany(id);
    }
}
