package com.rev_hire.dao;

import com.rev_hire.model.Resume;
import java.util.List;

public interface IResumeDao {
    boolean addResume(Resume resume);
    boolean updateResume(Resume resume);
    boolean deleteResume(int resumeId);
    Resume getResume(int resumeId);
    List<Resume> getAllResumes();
}