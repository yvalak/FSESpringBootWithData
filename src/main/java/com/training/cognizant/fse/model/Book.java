package com.training.cognizant.fse.model;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Book {

	private long bookId;

	private String title;

	private double price;

	private int volume;

	private String publishDate;

	public Book() {
	}

	
	  public Book(com.training.cognizant.fse.repository.entities.Book entityBook) {
	  this.bookId = entityBook.getBookId(); this.title = entityBook.getTitle();
	  this.price = entityBook.getPrice(); this.volume = entityBook.getVolume();
	  SimpleDateFormat dateFormater = new SimpleDateFormat("MM/dd/yyyy");
	  this.publishDate = entityBook.getPublishDate().toString();
	  
	  }
	 
	 

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
}
