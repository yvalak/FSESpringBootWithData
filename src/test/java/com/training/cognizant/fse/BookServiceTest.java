package com.training.cognizant.fse;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.training.cognizant.fse.repository.entities.Book;
import com.training.cognizant.fse.service.BookService;

public class BookServiceTest extends FseSpringBootWithDataApplicationTests {

	@Autowired
	private BookService autoWiredBookService;

	@Before
	public void setup() {
	}

	@Test
	public void testSaveBook() {
		int existingNoOfRecords = autoWiredBookService.findAll().size();
		Book book = new Book(0, "This is it", 250, 12, Date.valueOf("2019-05-08"));

		autoWiredBookService.save(book);
		int newNoOfRecords = autoWiredBookService.findAll().size();
		assertEquals(existingNoOfRecords + 1, newNoOfRecords);
	}

	@Test
	public void testDeleteBook() {

		List<Book> booksList = autoWiredBookService.findByTitle("This is it");
		int existingNoOfRecords = booksList.size();
		autoWiredBookService.remove(booksList.get(0));
		int newNoOfRecords = autoWiredBookService.findByTitle("This is it").size();
		assertEquals(existingNoOfRecords - 1, newNoOfRecords);

	}

	@Test
	public void testFindBookById() {

		Book entityBook = autoWiredBookService.findById(29);

		assertEquals(29, entityBook.getBookId());
		assertEquals("DUMBO", entityBook.getTitle());
	}

	@Test
	public void testFindById() {
		Book book = autoWiredBookService.findById(Long.valueOf(29));
		assertEquals("DUMBO", book.getTitle());
		assertEquals(22, book.getVolume());

	}

	@Test
	public void testFindBookByTitle() {

		List<Book> entityBooks = autoWiredBookService.findByTitle("Wings on fire");

		assertEquals(2, entityBooks.size());
	}

	@Test
	public void testFindAllBooks() throws Exception {

		List<Book> booksList = autoWiredBookService.findAll();

		System.out.println(booksList.size());

	}
}
