/**
 * 
 */
package com.training.cognizant.fse.repository;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.cognizant.fse.repository.entities.Subject;


/**
 * @author Yasheen
 *
 */
@Repository("subjectRepository")
public interface SubjectRepository extends CrudRepository<Subject, Id> {

	public <S extends Subject> S save(S entity);

	public void delete(Subject entity);

	public List<Subject> findAll();

	public Subject findBySubjectId(Long id);

	public List<Subject> findBySubtitle(String title);

    @Query("SELECT s FROM Subject s WHERE durationInHours = :durationInHours")
	public List<Subject> findByDuration(@Param("durationInHours") Integer durationInHours);

}
