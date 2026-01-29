package com.rev_hire.service;

import com.rev_hire.dao.EmployerDaoImpl;
import com.rev_hire.dao.IEmployerDao;
import com.rev_hire.model.Employer;

public class EmployerServiceImpl implements IEmployerService {

    private IEmployerDao employerDao = new EmployerDaoImpl();

    @Override
    public Employer getEmployerByUserId(int userId) {
        return employerDao.getEmployerByUserId(userId);
    }

    @Override
    public boolean registerEmployer(int userId, int companyId) {
        return employerDao.createEmployer(userId, companyId);
    }
}