package com.rev_hire.dao;

import com.rev_hire.model.JobSeeker;
import java.util.List;

public interface IJobSeekerDao {
    boolean addJobSeeker(JobSeeker jobSeeker);
    boolean updateJobSeeker(JobSeeker jobSeeker);
    boolean deleteJobSeeker(int jobSeekerId);
    JobSeeker getJobSeeker(int jobSeekerId);
    List<JobSeeker> getAllJobSeekers();
}
