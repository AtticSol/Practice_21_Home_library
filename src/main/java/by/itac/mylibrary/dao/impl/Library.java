package by.itac.mylibrary.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public class Library {

	private static Library instance;

	private static final String FILE_SOURCE = "db-home-library.txt";
	private String path = getClass().getClassLoader().getResource(FILE_SOURCE).getPath();
	
	private static final String DELIMETER = "__ __";
	private List<Book> listOfBooksInLibrary = new ArrayList<Book>();
	private boolean isInit = false;
	
	private Library() {
	}

	public static Library getInstance() {
		if (instance == null) {
			instance = new Library();
		}
		return instance;
	}
	
	public String getPath() {
		return path;
	}

	public List<Book> getListOfBooksInLibrary() {
		return listOfBooksInLibrary;
	}

	public void addBook(Book book) {
		listOfBooksInLibrary.add(book);
	}

	public void setIsInit(boolean isInit) {
		this.isInit = isInit;
	}

	public static String getFileSource() {
		return FILE_SOURCE;
	}
	
	public static String getDelimeter() {
		return DELIMETER;
	}

	public void read() throws DAOException {
		if (!isInit) {
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				String line = null;

				while ((line = br.readLine()) != null) {

					String[] bookLine = line.split(DELIMETER);
					int id = Integer.parseInt(bookLine[0]);
					String author = bookLine[1];
					String title = bookLine[2];
					String year = bookLine[3];

					addBook(new Book(id, author, title, year));

				}
			} catch (IOException e) {
				throw new DAOException("Error in file read process", e);
			}
			setIsInit(true);
		}
	}

}
