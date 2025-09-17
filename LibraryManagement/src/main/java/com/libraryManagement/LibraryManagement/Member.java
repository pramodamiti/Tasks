package com.libraryManagement.LibraryManagement;

public class Member {
	private String name;
	private Library library;
	
	
	public void list() {
		System.out.println(library.getBook());
	}
	
	
	
	public Member(String name, Library library) {
		this.name = name;
		this.library = library;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Library getLibrary() {
		return library;
	}


	public void setLibrary(Library library) {
		this.library = library;
	}
	
	

}
