package com.training.cognizant.fse.model;

import java.util.Set;

public class Subject {
 
    private long subjectId;
 
    private String subtitle;
 
    private int durationInHours;
 
    private Set<Book> references;
 
	
	  // Default constructor public
	  public Subject(com.training.cognizant.fse.repository.entities.Subject subject) {
	  this.subjectId = subject.getSubjectId(); this.subtitle =
	  subject.getSubtitle(); this.durationInHours = subject.getDurationInHours(); }
	 
 
    public Subject() {
 
    }
 
    public long getSubjectId() {
        return subjectId;
    }
 
    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }
 
    public String getSubtitle() {
        return subtitle;
    }
 
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
 
    public int getDurationInHours() {
        return durationInHours;
    }
 
    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }
 
    public Set<Book> getReferences() {
        return references;
    }
 
    public void setReferences(Set<Book> references) {
        this.references = references;
    }
 
}



