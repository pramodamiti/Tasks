package com.libraryManagement.LibraryManagement;

import java.util.List;

public class Library {
	
	private List<Book> books;
	
	public Library(List<Book> books) {
		this.books = books;
	}

	
	public List<Book> getBook() {
		return books;
	}



	public void setBook(List<Book> book) {
		this.books = book;
	}



	public void init() {
		System.out.println("library is open !");
	}
	
	public void destroy() {
		System.out.println("library is closed !");
	}


	@Override
	public String toString() {
		return "Library [books=" + books + "]";
	}
	
	
}
