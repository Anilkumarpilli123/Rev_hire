package com.rev_hire.service;

import com.rev_hire.model.JobSeeker;
import java.util.List;

public interface IJobSeekerService {

    boolean addJobSeeker(JobSeeker jobSeeker);

    boolean updateJobSeeker(JobSeeker jobSeeker);

    boolean deleteJobSeeker(int id);

    JobSeeker getJobSeeker(int id);

    List<JobSeeker> getAllJobSeekers();
}
