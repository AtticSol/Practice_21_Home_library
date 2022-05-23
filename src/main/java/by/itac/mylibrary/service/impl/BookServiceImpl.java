package by.itac.mylibrary.service.impl;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.DAOProvider;
import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.exception.ServiceException;

public class BookServiceImpl implements BookService {
	
	@Override
	public void save(Book book) throws ServiceException {
		try {
			Integer.parseInt(book.getYear());
		} catch (NumberFormatException e) {
			throw new ServiceException("Error in parse of Year process",e);
		}
		
		try {
			DAOProvider provider = DAOProvider.getInstance();
			CRUDBookDAO dao = provider.getBookDAO();
			dao.save(book);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public String allBooks() throws ServiceException {
		String allBooks;
		try {			
			DAOProvider provider = DAOProvider.getInstance();
			CRUDBookDAO dao = provider.getBookDAO();
			allBooks = dao.readSource().toString();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return allBooks;
	}
	
	@Override
	public Book findByID(int id) {
		return null;
	}
	
	@Override
	public String findByAuthor(String author) throws ServiceException {
		String books;
		
		if (author.trim().length() < 1) {
			throw new ServiceException("Author name is empty.");
		}
		
		try {
			DAOProvider provider = DAOProvider.getInstance();
			FindBookDAO dao = provider.getFindDAO();
			books = dao.findByAuthor(author).toString();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return books;
	}

	@Override
	public String findByTitle(String title) throws ServiceException {
		String books;
		
		if (title.trim().length() < 1) {
			throw new ServiceException("Entered title is empty.");
		}
		
		try {
			DAOProvider provider = DAOProvider.getInstance();
			FindBookDAO dao = provider.getFindDAO();
			books = dao.findByTitle(title).toString();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return books;
	}

}
