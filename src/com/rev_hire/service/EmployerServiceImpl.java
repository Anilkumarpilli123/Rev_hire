package com.rev_hire.service;

import com.rev_hire.dao.EmployerDaoImpl;
import com.rev_hire.dao.IEmployerDao;
import com.rev_hire.model.Employer;

import java.util.List;

public class EmployerServiceImpl implements IEmployerService {

    private static IEmployerDao employerDao = new EmployerDaoImpl();

    @Override
    public boolean addEmployer(Employer employer) {
        return employerDao.addEmployer(employer);
    }

    @Override
    public Employer getEmployer(int employerId) {
        return employerDao.getEmployer(employerId);
    }

    @Override
    public boolean updateEmployer(Employer employer) {
        return employerDao.updateEmployer(employer);
    }

    @Override
    public boolean deleteEmployer(int employerId) {
        return employerDao.deleteEmployer(employerId);
    }

    @Override
    public List<Employer> getAllEmployers() {
        return employerDao.getAllEmployers();
    }
}
