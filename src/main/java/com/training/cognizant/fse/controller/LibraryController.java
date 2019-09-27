package com.training.cognizant.fse.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.training.cognizant.fse.model.Book;
import com.training.cognizant.fse.model.SubjectsAndBooks;
import com.training.cognizant.fse.repository.entities.Subject;
import com.training.cognizant.fse.service.BookService;
import com.training.cognizant.fse.service.SubjectService;

@Controller
@RequestMapping("/library")
public class LibraryController {


	private static final String MODEL_NAME ="subjectsAndBooks";
	
	@Autowired
	private SubjectService subjectRepo;
	
	@Autowired
	private BookService bookRepo;
	
	@RequestMapping("/")
	public ModelAndView goHome(HttpServletRequest req, Model model) {
		
		System.out.println("in controller->goHome");
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("message", "");
		mv.addObject(MODEL_NAME, new SubjectsAndBooks());
		return mv;
	}
	
	@RequestMapping(value = "/addSubject")
	public ModelAndView addSubject(@ModelAttribute(MODEL_NAME) SubjectsAndBooks subjectsAndBooks, HttpServletRequest req, Model model) {
		System.out.println("in controller->addSubject");
		
        subjectRepo.save(new Subject(subjectsAndBooks.getSubject()));
        
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("message", "Subject saved succesfully");
		mv.addObject(MODEL_NAME, new SubjectsAndBooks());
		return mv;
	}
	
	@RequestMapping("/getAllSubject")
	public ModelAndView getAllSubject(@ModelAttribute(MODEL_NAME) SubjectsAndBooks subjectsAndBooks, HttpServletRequest req, Model model) {
		System.out.println("in controller->getAllSubject");

		List<com.training.cognizant.fse.model.Subject> subjects =getAllSubjects();
        
		ModelAndView mv = new ModelAndView("home");
		if(CollectionUtils.isEmpty(subjects)) {
			mv.addObject("message", "No saved subjects are available !!!");
		}else {
			mv.addObject("message", "");
			mv.addObject("subjects", subjects);
		}
		
		return mv;
	}
	
	private List<com.training.cognizant.fse.model.Subject> getAllSubjects(){
		
		
		List<Subject> subjects = subjectRepo.findAll();
        if (subjects == null) {
        	subjects = new ArrayList<Subject>();
        }
        List<com.training.cognizant.fse.model.Subject> modelSubjects = new ArrayList<com.training.cognizant.fse.model.Subject>();        		
        for(Subject entitySubject: subjects) {
        	modelSubjects.add(new com.training.cognizant.fse.model.Subject(entitySubject));
        }
		return modelSubjects;
	}
	
	@RequestMapping("/deleteSubject")
	public ModelAndView deleteSubject(@ModelAttribute(MODEL_NAME) SubjectsAndBooks subjectsAndBooks, HttpServletRequest req, Model model) {
		System.out.println("in controller->deleteBook");

		boolean hasDeleted = false;
		Long subjectId= subjectsAndBooks.getSubject().getSubjectId();
		Subject subject= subjectRepo.findById(subjectId);
		if(subject !=null) {
			subjectRepo.remove(subject);
			hasDeleted = true;
		}
		List<com.training.cognizant.fse.model.Subject> subjects =getAllSubjects();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("message", hasDeleted ? "Subject removed succesfully": "No matching Title found !!!");
		mv.addObject(MODEL_NAME, new SubjectsAndBooks());
		mv.addObject("subjects", subjects);

		return mv;
	}
	
	@RequestMapping("/searchSubject")
	public ModelAndView searchSubject(@ModelAttribute(MODEL_NAME) SubjectsAndBooks subjectsAndBooks, HttpServletRequest req, Model model) {
		System.out.println("in controller->searchSubject");

		List<Subject> searchResults = subjectRepo.findByTitle(subjectsAndBooks.getSubject().getSubtitle());
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("subjects", searchResults);
		if(CollectionUtils.isEmpty(searchResults)) {
			mv.addObject("message", "No records found");
		}
		mv.addObject(MODEL_NAME, new SubjectsAndBooks());

		return mv;
	}
	

	@RequestMapping("/searchSubjectByDuration")
	public ModelAndView searchSubjectByDuration(@ModelAttribute(MODEL_NAME) SubjectsAndBooks subjectsAndBooks, HttpServletRequest req, Model model) {
		System.out.println("in controller->searchSubject");

		List<Subject> searchResults = subjectRepo.findByDuration(subjectsAndBooks.getSubject().getDurationInHours());
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("subjects", searchResults);
		if(CollectionUtils.isEmpty(searchResults)) {
			mv.addObject("message", "No records found");
		}
		mv.addObject(MODEL_NAME, new SubjectsAndBooks());

		return mv;
	}
	
	
	@RequestMapping(value = "/addBook")
	public ModelAndView addBook(@ModelAttribute(MODEL_NAME) SubjectsAndBooks subjectsAndBooks, HttpServletRequest req, Model model) {
		System.out.println("in controller->addBook");
		
        bookRepo.save(new com.training.cognizant.fse.repository.entities.Book(subjectsAndBooks.getBook()));
        
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("message", "Book saved succesfully");
		mv.addObject(MODEL_NAME, new SubjectsAndBooks());
		return mv;
	}
	
	@RequestMapping("/getAllBook")
	public ModelAndView getAllBook(@ModelAttribute(MODEL_NAME) SubjectsAndBooks subjectsAndBooks, HttpServletRequest req, Model model) {
		System.out.println("in controller->getAllBook");

		List<Book> books =getAllBooks();
        
		ModelAndView mv = new ModelAndView("home");
		if(CollectionUtils.isEmpty(books)) {
			mv.addObject("message", "No saved subjects are available !!!");
		}else {
			mv.addObject("message", "");
			mv.addObject("books", books);
		}
		
		return mv;
	}
	
	private List<Book> getAllBooks(){
		
		
		List<com.training.cognizant.fse.repository.entities.Book> books = bookRepo.findAll();
        if (books == null) {
        	books = new ArrayList<com.training.cognizant.fse.repository.entities.Book>();
        }
        List<Book> modelBooks = new ArrayList<Book>();        		
        for(com.training.cognizant.fse.repository.entities.Book entityBook: books) {
        	modelBooks.add(new Book(entityBook));
        }
		return modelBooks;
	}
	
	@RequestMapping("/deleteBook")
	public ModelAndView deleteBook(@ModelAttribute(MODEL_NAME) SubjectsAndBooks subjectsAndBooks, HttpServletRequest req, Model model) {
		System.out.println("in controller->deleteBook");

		boolean hasDeleted = false;
		Long bookId= subjectsAndBooks.getBook().getBookId();
		com.training.cognizant.fse.repository.entities.Book book= bookRepo.findById(bookId);
		if(book !=null) {
			bookRepo.remove(book);
			hasDeleted = true;
		}
		List<Book> books =getAllBooks();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("message", hasDeleted ? "Book removed succesfully": "No matching record found !!!");
		mv.addObject(MODEL_NAME, new SubjectsAndBooks());
		mv.addObject("books", books);

		return mv;
	}
	
	@RequestMapping("/searchBook")
	public ModelAndView searchBook(@ModelAttribute(MODEL_NAME) SubjectsAndBooks subjectsAndBooks, HttpServletRequest req, Model model) {
		System.out.println("in controller->searchBook");

		List<com.training.cognizant.fse.repository.entities.Book> searchResults = bookRepo.findByTitle(subjectsAndBooks.getBook().getTitle());
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("books", searchResults);
		if(CollectionUtils.isEmpty(searchResults)) {
			mv.addObject("message", "No records found");
		}
		mv.addObject(MODEL_NAME, new SubjectsAndBooks());

		return mv;
	}
	
	@RequestMapping("/searchBookByTitle")
	public ModelAndView searchBookByTitle(@ModelAttribute(MODEL_NAME) SubjectsAndBooks subjectsAndBooks, HttpServletRequest req, Model model) {
		System.out.println("in controller->searchBook");

		List<com.training.cognizant.fse.repository.entities.Book> searchResults = bookRepo._customFindByTitle(subjectsAndBooks.getBook().getTitle());
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("books", searchResults);
		if(CollectionUtils.isEmpty(searchResults)) {
			mv.addObject("message", "No records found");
		}
		mv.addObject(MODEL_NAME, new SubjectsAndBooks());

		return mv;
	}

}
