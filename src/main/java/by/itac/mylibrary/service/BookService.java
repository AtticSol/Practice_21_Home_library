package by.itac.mylibrary.service;

import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.exception.ServiceException;

public interface BookService {
	
	void save(Book book) throws ServiceException;
	String allBooks() throws ServiceException;
	Book findByID(int id) throws ServiceException;
	String findByAuthor(String author) throws ServiceException;
	String findByTitle(String title) throws ServiceException;

}
