package com.rev_hire.service;

import com.rev_hire.model.Employer;
import java.util.List;

public interface IEmployerService {

    boolean addEmployer(Employer employer);

    Employer getEmployer(int employerId);

    boolean updateEmployer(Employer employer);

    boolean deleteEmployer(int employerId);

    List<Employer> getAllEmployers();
}
