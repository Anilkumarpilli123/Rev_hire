package com.rev_hire.model;


public class Company {

    private int companyId;
    private String name;
    private String industry;
    private String size;
    private String description;
    private String website;
    private String location;

    // No-arg constructor
    public Company() {
    }

    // Parameterized constructor
    public Company(int companyId, String name, String industry, String size,
                   String description, String website, String location) {
        this.companyId = companyId;
        this.name = name;
        this.industry = industry;
        this.size = size;
        this.description = description;
        this.website = website;
        this.location = location;
    }

    // Getters and Setters
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

