package com.rev_hire.service;

import com.rev_hire.dao.*;
import com.rev_hire.model.Application;

import java.util.List;

public class ApplicationServiceImpl implements IApplicationService {

    private static IApplicationDao dao = new ApplicationDaoImpl();

    public boolean applyJob(Application application) {
        return dao.applyJob(application);
    }

    public List<Application> getApplicationsByJobSeeker(int jobSeekerId) {
        return dao.getApplicationsByJobSeeker(jobSeekerId);
    }

    public List<Application> getApplicationsByJob(int jobId) {
        return dao.getApplicationsByJob(jobId);
    }

    public boolean updateStatus(int applicationId, String status) {
        return dao.updateStatus(applicationId, status);
    }

    public boolean withdrawApplication(int applicationId, String reason) {
        return dao.withdrawApplication(applicationId, reason);
    }
}