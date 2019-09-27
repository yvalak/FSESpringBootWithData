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

import com.training.cognizant.fse.repository.entities.Book;


/**
 * @author Yasheen
 *
 */
@Repository("bookRepository")
public interface BookRepository extends CrudRepository<Book, Id> {

	public <S extends Book> S save(S entity);

	public void delete(Book entity);

	public List<Book> findAll();

	public Book findByBookId(Long id);

	public List<Book> findByTitle(String title);

	@Query("SELECT b from Book b where LOWER(title) = Lower(:title) ")
	public List<Book> _customFindByTitle(@Param("title") String customTitle);

}
