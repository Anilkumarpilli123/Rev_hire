package com.rev_hire.controller;

import com.rev_hire.model.Resume;
import com.rev_hire.service.IResumeService;
import com.rev_hire.service.ResumeServiceImpl;

import java.util.List;

public class ResumeController {

    private static IResumeService resumeService = new ResumeServiceImpl();

    public boolean addResume(Resume resume) {
        return resumeService.addResume(resume);
    }

    public boolean updateResume(Resume resume) {
        return resumeService.updateResume(resume);
    }

    public boolean deleteResume(int resumeId) {
        return resumeService.deleteResume(resumeId);
    }

    public Resume getResume(int resumeId) {
        return resumeService.getResume(resumeId);
    }

    public List<Resume> getAllResumes() {
        return resumeService.getAllResumes();
    }
}
