package com.rev_hire.service;

import com.rev_hire.dao.EmployerDaoImpl;
import com.rev_hire.model.Employer;

import java.util.List;

public class EmployerServiceImpl implements IEmployerService {

    private EmployerDaoImpl dao = new EmployerDaoImpl();

    @Override
    public boolean addEmployer(Employer e) {
        return dao.addEmployer(e);
    }

    @Override
    public Employer getEmployer(int id) {
        return dao.getEmployer(id);
    }

    @Override
    public boolean updateEmployer(Employer e) {
        return dao.updateEmployer(e);
    }

    @Override
    public boolean deleteEmployer(int id) {
        return dao.deleteEmployer(id);
    }

    @Override
    public List<Employer> getAllEmployers() {
        return dao.getAllEmployers();
    }

    @Override
    public Employer getEmployerByUserId(int userId) {
        return dao.getEmployerByUserId(userId); // call the DAO method
    }
}
