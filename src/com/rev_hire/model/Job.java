package com.rev_hire.model;

import java.time.LocalDate;

public class Job {

    private int jobId;
    private int companyId;
    private String title;
    private String description;
    private String skillsRequired;
    private int experienceRequired;
    private String educationRequired;
    private String location;
    private String salaryRange;
    private String jobType;
    private LocalDate deadline;
    private String status;

    // No-arg constructor
    public Job() {
    }

    // Parameterized constructor
    public Job(int jobId, int companyId, String title, String description,
               String skillsRequired, int experienceRequired,
               String educationRequired, String location,
               String salaryRange, String jobType,
               LocalDate deadline, String status) {
        this.jobId = jobId;
        this.companyId = companyId;
        this.title = title;
        this.description = description;
        this.skillsRequired = skillsRequired;
        this.experienceRequired = experienceRequired;
        this.educationRequired = educationRequired;
        this.location = location;
        this.salaryRange = salaryRange;
        this.jobType = jobType;
        this.deadline = deadline;
        this.status = status;
    }

    // Getters and Setters
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(String skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public int getExperienceRequired() {
        return experienceRequired;
    }

    public void setExperienceRequired(int experienceRequired) {
        this.experienceRequired = experienceRequired;
    }

    public String getEducationRequired() {
        return educationRequired;
    }

    public void setEducationRequired(String educationRequired) {
        this.educationRequired = educationRequired;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

