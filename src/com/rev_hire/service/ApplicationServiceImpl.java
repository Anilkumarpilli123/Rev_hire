package com.rev_hire.service;

import com.rev_hire.dao.ApplicationDaoImpl;
import com.rev_hire.dao.IApplicationDao;
import com.rev_hire.model.Application;

import java.util.List;

public class ApplicationServiceImpl implements IApplicationService {

    private static IApplicationDao applicationDao = new ApplicationDaoImpl();

    @Override
    public boolean applyJob(Application application) {
        return applicationDao.applyJob(application);
    }

    @Override
    public boolean withdrawApplication(int applicationId, String reason) {
        return applicationDao.withdrawApplication(applicationId, reason);
    }

    @Override
    public Application getApplicationById(int applicationId) {
        return applicationDao.getApplicationById(applicationId);
    }

    @Override
    public List<Application> getApplicationsByJobSeeker(int jobSeekerId) {
        return applicationDao.getApplicationsByJobSeeker(jobSeekerId);
    }
}
