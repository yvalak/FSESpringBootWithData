package com.training.cognizant.fse.repository.entities;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "BOOKS")
public class Book {

	@Id
	@Column(name = "BOOK_ID")
	private long bookId;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "VOLUME")
	private int volume;

	@Column(name = "PUBLISH_DATE")
	private Date publishDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBJECT_ID")
	private Subject subject;

	public Book() {

	}

	public Book(com.training.cognizant.fse.model.Book modelBook) {
		this.title = modelBook.getTitle();
		this.price = modelBook.getPrice();
		this.volume = modelBook.getVolume();
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
		this.publishDate = Date.valueOf(modelBook.getPublishDate());

	}
	
	public Book(long bookId, String title, double price, int volume, Date publishDate) {
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishDate = publishDate;

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

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
