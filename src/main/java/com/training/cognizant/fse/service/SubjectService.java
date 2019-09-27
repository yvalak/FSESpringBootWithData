package com.training.cognizant.fse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.training.cognizant.fse.repository.SubjectRepository;
import com.training.cognizant.fse.repository.entities.Subject;

 
@Component
@Qualifier("subjectService")
public class SubjectService {
 
 
    @Autowired
    private SubjectRepository subjectRepository;
    
    public SubjectService() {
    	
    }

	public Subject findById(long id) {
		Subject subject = subjectRepository.findBySubjectId(Long.valueOf(id));
		return subject;
	}

	public List<Subject> findAll() {
		List<Subject> subjects = subjectRepository.findAll();
		return subjects;
	}

	public void save(Subject entity) {
		subjectRepository.save(entity);
		
	}

	public void remove(Subject subject) {
		subjectRepository.delete(subject);
		
	}
	
	public List<Subject> findByTitle(String title) {
        List<Subject> subjects = subjectRepository.findBySubtitle(title);
        return subjects;
	}

	public List<Subject> findByDuration(Integer customDuration) {
		List<Subject> subjects = subjectRepository.findByDuration(customDuration);
        return subjects;
	}
	
 
}
