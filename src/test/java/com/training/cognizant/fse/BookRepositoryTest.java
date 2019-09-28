package com.training.cognizant.fse;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.training.cognizant.fse.repository.BookRepository;
import com.training.cognizant.fse.repository.entities.Book;
import com.training.cognizant.fse.service.BookService;

public class BookRepositoryTest extends FseSpringBootWithDataApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Before
	public void setup() {
	}
	
	@Test
	public void testSaveBook() {
		int existingNoOfRecords = bookRepository.findAll().size();
		Book book = new Book(0, "This is it", 25, 5 , Date.valueOf("2010-05-09"));

		bookRepository.save(book);
		int newNoOfRecords = bookRepository.findAll().size();
		assertEquals(existingNoOfRecords + 1, newNoOfRecords);
	}

	@Test
	public void testDeleteBook() {

		List<Book> booksList = bookRepository.findByTitle("This is it");
		int existingNoOfRecords = booksList.size();
		bookRepository.delete(booksList.get(0));
		int newNoOfRecords = bookRepository.findByTitle("This is it").size();
		assertEquals(existingNoOfRecords - 1, newNoOfRecords);

	}

	@Test
	public void testFindBookById() {

		Book entityBook = bookRepository.findByBookId(Long.valueOf(29));

		assertEquals(29, entityBook.getBookId());
		assertEquals("DUMBO", entityBook.getTitle());
	}

	@Test
	public void testFindById() {
		Book book = bookRepository.findByBookId(Long.valueOf(29));
		assertEquals("DUMBO", book.getTitle());
		assertEquals(22, book.getVolume());

	}

	@Test
	public void testFindBookByTitle() {

		List<Book> entityBooks = bookRepository.findByTitle("Wings on fire");

		assertEquals(2, entityBooks.size());
	}

	@Test
	public void testFindAllBooks() throws Exception {

		List<Book> booksList = bookRepository.findAll();

		System.out.println(booksList.size());

	}
	
	@Test
	public void test_customFindByTitle() throws Exception {

		List<Book> booksList = bookRepository._customFindByTitle("Wings on fire");
		assertEquals(2, booksList.size());
		System.out.println(booksList.size());

	}
}
