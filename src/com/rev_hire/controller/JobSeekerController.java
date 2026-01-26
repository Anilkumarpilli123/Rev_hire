package com.rev_hire.controller;

import com.rev_hire.model.JobSeeker;
import com.rev_hire.service.IJobSeekerService;
import com.rev_hire.service.JobSeekerServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class JobSeekerController {

    private static IJobSeekerService jobSeekerService = new JobSeekerServiceImpl();

    public boolean addJobSeeker(JobSeeker jobSeeker) throws SQLException {
        return jobSeekerService.addJobSeeker(jobSeeker);
    }

    public boolean updateJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerService.updateJobSeeker(jobSeeker);
    }

    public boolean deleteJobSeeker(int jobSeekerId) {
        return jobSeekerService.deleteJobSeeker(jobSeekerId);
    }

    public JobSeeker getJobSeeker(int jobSeekerId) {
        return jobSeekerService.getJobSeeker(jobSeekerId);
    }

    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerService.getAllJobSeekers();
    }
}
