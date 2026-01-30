package com.rev_hire.service;

import com.rev_hire.dao.IJobDao;
import com.rev_hire.dao.JobDaoImpl;
import com.rev_hire.model.Job;

import java.util.List;

public class JobServiceImpl implements IJobService {

    private static IJobDao jobDao = new JobDaoImpl();

    public boolean addJob(Job job) {
        return jobDao.addJob(job);
    }

    public Job getJobById(int jobId) {
        return jobDao.getJobById(jobId);
    }

    public List<Job> getJobsByCompany(int companyId) {
        return jobDao.getJobsByCompany(companyId);
    }

    public List<Job> getAllJobs() {
        return jobDao.getAllJobs();
    }

    public boolean updateJob(Job job) {
        return jobDao.updateJob(job);
    }

    public boolean deleteJob(int jobId) {
        return jobDao.deleteJob(jobId);
    }

    public void searchJobs() {
        jobDao.getAllJobs();
    }
}
