package com.training.cognizant.fse.repository.entities;


import java.util.Set;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
import org.hibernate.annotations.NaturalId;
 
@Entity
@Table(name = "SUBJECTS")
public class Subject {
 
    @Id
    @Column(name = "SUBJECT_ID")
    private long subjectId;
 
    @Column(name = "SUBTITLE")
    private String subtitle;
 
    @Column(name = "DURATION")
    private int durationInHours;
 
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Book> references;
// 
	
	  // Default constructor public
	  public Subject(com.training.cognizant.fse.model.Subject subject) {
	  this.subtitle = subject.getSubtitle(); this.durationInHours =
	  subject.getDurationInHours(); }
	 
 
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
 
//    public Set<Book> getReferences() {
//        return references;
//    }
// 
//    public void setReferences(Set<Book> references) {
//        this.references = references;
//    }
 
}



