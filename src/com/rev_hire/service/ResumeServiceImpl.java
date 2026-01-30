package com.rev_hire.service;

import com.rev_hire.dao.IResumeDao;
import com.rev_hire.dao.ResumeDaoImpl;
import com.rev_hire.model.Resume;

public class ResumeServiceImpl implements IResumeService {

    private static IResumeDao resumeDao = new ResumeDaoImpl();

    public boolean addResume(Resume resume) {
        return resumeDao.addResume(resume);
    }

    public Resume getResumeByJobSeeker(int jobSeekerId) {
        return resumeDao.getResumeByJobSeeker(jobSeekerId);
    }

    public boolean updateResume(Resume resume) {
        return resumeDao.updateResume(resume);
    }

    public boolean deleteResume(int jobSeekerId) {
        return resumeDao.deleteResume(jobSeekerId);
    }
}
