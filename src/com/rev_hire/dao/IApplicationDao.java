package com.rev_hire.dao;

import com.rev_hire.model.Application;
import java.util.List;

public interface IApplicationDao {

    boolean applyJob(Application application);

    boolean withdrawApplication(int applicationId, String reason);

    Application getApplicationById(int applicationId);

    List<Application> getApplicationsByJobSeeker(int jobSeekerId);
}
