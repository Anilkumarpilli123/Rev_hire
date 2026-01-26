package com.rev_hire.controller;

import com.rev_hire.model.Application;
import com.rev_hire.service.ApplicationServiceImpl;
import com.rev_hire.service.IApplicationService;

import java.util.List;

public class ApplicationController {

    private static IApplicationService applicationService = new ApplicationServiceImpl();

    public boolean applyJob(Application application) {
        return applicationService.applyJob(application);
    }

    public boolean withdrawApplication(int applicationId, String reason) {
        return applicationService.withdrawApplication(applicationId, reason);
    }

    public Application getApplicationById(int applicationId) {
        return applicationService.getApplicationById(applicationId);
    }

    public List<Application> getApplicationsByJobSeeker(int jobSeekerId) {
        return applicationService.getApplicationsByJobSeeker(jobSeekerId);
    }
}