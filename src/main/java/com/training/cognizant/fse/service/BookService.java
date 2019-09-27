package com.training.cognizant.fse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.training.cognizant.fse.repository.BookRepository;
import com.training.cognizant.fse.repository.entities.Book;

 
@Component
@Qualifier("bookService")
public class BookService {
 
 
    @Autowired
    private BookRepository bookRepository;
    
    public BookService() {
    	
    }

	 public Book findById(long id) {
		Book book = bookRepository.findByBookId(Long.valueOf(id));
		return book;
	}

	public List<Book> findAll() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

	public void save(Book entity) {
		bookRepository.save(entity);
		
	}

	public void remove(Book book) {
		bookRepository.delete(book);
		
	}
	
	public List<Book> findByTitle(String title) {
        List<Book> books = bookRepository.findByTitle(title);
        return books;
	}

	public List<Book> _customFindByTitle(String title) {
		List<Book> books = bookRepository._customFindByTitle(title);
        return books;
	}
	
 
}
