package by.itac.mylibrary.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public class FileFindBookDAO implements FindBookDAO {

	private Library library = Library.getInstance();
	private List<Book> listOfBooksInLibrary;
	
	public List<Book> findByAuthor(String enteredAuthor) throws DAOException {
		List<Book> booksByAuthor = new ArrayList<>();
		
		library.read();
		listOfBooksInLibrary = library.getListOfBooksInLibrary();
		
		for (Book book : listOfBooksInLibrary) {
			if (book.getAuthor().toLowerCase().contains(enteredAuthor.trim().toLowerCase())) {
				booksByAuthor.add(book);
			}
		}

		return booksByAuthor;
	}

	
	public List<Book> findByTitle(String enteredTitle) throws DAOException {
		List<Book> booksByTitle = new ArrayList<>();
		
		library.read();
		listOfBooksInLibrary = library.getListOfBooksInLibrary();
		
		for (Book book : listOfBooksInLibrary) {
			if (book.getTitle().toLowerCase().contains(enteredTitle.trim().toLowerCase())) {
				booksByTitle.add(book);
			}
		}
		return booksByTitle;
	}

	
	public Book find(int id) {
		return null;
	}

}
