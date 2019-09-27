package com.training.cognizant.fse;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.training.cognizant.fse.service.BookService;

public class BookServiceTest extends FseSpringBootWithDataApplicationTests {

	@Autowired
	private BookService bookService;


	@Before
	public void setup() {
		
	}

	@Test
	public void testBookService() throws Exception {
		
	}
}
