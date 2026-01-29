package com.rev_hire.service;

import com.rev_hire.dao.ICompanyDao;
import com.rev_hire.dao.CompanyDaoImpl;
import com.rev_hire.model.Company;

import java.util.List;

public class CompanyServiceImpl implements ICompanyService {

    private static ICompanyDao companyDao = new CompanyDaoImpl();

    // ================= CREATE =================
    @Override
    public boolean addCompany(Company company) {
        return companyDao.addCompany(company);
    }

    // ================= UPDATE (by ID - internal) =================
    @Override
    public boolean updateCompany(Company company) {
        return companyDao.updateCompany(company);
    }

    // ================= UPDATE (by NAME - user friendly) =================
    @Override
    public boolean updateCompanyByName(String companyName, Company updatedData) {
        return companyDao.updateCompanyByName(companyName, updatedData);
    }

    // ================= DELETE =================
    @Override
    public boolean deleteCompany(int companyId) {
        return companyDao.deleteCompany(companyId);
    }

    // ================= READ (by ID) =================
    @Override
    public Company getCompany(int companyId) {
        return companyDao.getCompany(companyId);
    }

    // ================= READ (by NAME) =================
    @Override
    public Company getCompanyByName(String companyName) {
        return companyDao.getCompanyByName(companyName);
    }

    // ================= READ ALL =================
    @Override
    public List<Company> getAllCompanies() {
        return companyDao.getAllCompanies();
    }
}
