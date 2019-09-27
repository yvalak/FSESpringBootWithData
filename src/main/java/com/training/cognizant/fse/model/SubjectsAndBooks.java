package com.training.cognizant.fse.model;

import java.io.Serializable;


public class SubjectsAndBooks implements Serializable{

	private Book book;
	private Subject subject;
	
	public SubjectsAndBooks() {
		
	}
	
	public SubjectsAndBooks(Subject subject,Book book) {
		this.book = book;
		this.subject =subject;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
