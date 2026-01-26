package com.rev_hire.controller;

import com.rev_hire.model.Employer;
import com.rev_hire.service.EmployerServiceImpl;
import com.rev_hire.service.IEmployerService;

import java.util.List;

public class EmployerController {

    private static IEmployerService service = new EmployerServiceImpl();

    public boolean addEmployer(Employer e) {
        return service.addEmployer(e);
    }

    public Employer getEmployer(int id) {
        return service.getEmployer(id);
    }

    public boolean updateEmployer(Employer e) {
        return service.updateEmployer(e);
    }

    public boolean deleteEmployer(int id) {
        return service.deleteEmployer(id);
    }

    public List<Employer> getAllEmployers() {
        return service.getAllEmployers();
    }
}
