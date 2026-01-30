package com.rev_hire.service;

import com.rev_hire.dao.JobSeekerDao;
import com.rev_hire.dao.JobSeekerDaoImpl;
import com.rev_hire.model.JobSeeker;

public class JobSeekerServiceImpl implements JobSeekerService {

    private final JobSeekerDao dao = new JobSeekerDaoImpl();

    @Override
    public JobSeeker getJobSeekerByUserId(int userId) {
        return dao.getJobSeekerByUserId(userId);
    }

    @Override
    public boolean createJobSeeker(JobSeeker js) {
        return dao.createJobSeeker(js);
    }

    @Override
    public int getResumeId(int jobSeekerId) {
        return dao.getResumeId(jobSeekerId);
    }
}
