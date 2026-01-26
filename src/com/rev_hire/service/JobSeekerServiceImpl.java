package com.rev_hire.service;

import com.rev_hire.dao.*;
import com.rev_hire.model.JobSeeker;
import java.util.List;

public class JobSeekerServiceImpl implements IJobSeekerService {

    private static IJobSeekerDao dao = new JobSeekerDaoImpl();

    public boolean addJobSeeker(JobSeeker js) { return dao.addJobSeeker(js); }
    public boolean updateJobSeeker(JobSeeker js) { return dao.updateJobSeeker(js); }
    public boolean deleteJobSeeker(int id) { return dao.deleteJobSeeker(id); }
    public JobSeeker getJobSeeker(int id) { return dao.getJobSeeker(id); }
    public List<JobSeeker> getAllJobSeekers() { return dao.getAllJobSeekers(); }
}
