package com.rev_hire.service;

import com.rev_hire.dao.IResumeDao;
import com.rev_hire.dao.ResumeDaoImpl;
import com.rev_hire.model.Resume;

import java.util.List;

public class ResumeServiceImpl implements IResumeService {

    private static IResumeDao resumeDao = new ResumeDaoImpl();

    @Override
    public boolean addResume(Resume resume) {
        return resumeDao.addResume(resume);
    }

    @Override
    public boolean updateResume(Resume resume) {
        return resumeDao.updateResume(resume);
    }

    @Override
    public boolean deleteResume(int resumeId) {
        return resumeDao.deleteResume(resumeId);
    }

    @Override
    public Resume getResume(int resumeId) {
        return resumeDao.getResume(resumeId);
    }

    @Override
    public List<Resume> getAllResumes() {
        return resumeDao.getAllResumes();
    }
}
