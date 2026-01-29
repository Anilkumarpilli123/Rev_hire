package com.rev_hire.service;

import com.rev_hire.model.Employer;

import java.util.List;

public interface IEmployerService {
    boolean addEmployer(Employer e);
    Employer getEmployer(int id);
    boolean updateEmployer(Employer e);
    boolean deleteEmployer(int id);
    List<Employer> getAllEmployers();

    Employer getEmployerByUserId(int userId);

}
