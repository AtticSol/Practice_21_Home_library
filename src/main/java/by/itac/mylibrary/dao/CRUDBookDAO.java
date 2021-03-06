package by.itac.mylibrary.dao;

import java.util.List;

import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public interface CRUDBookDAO {
	void save(Book book) throws DAOException;
	List<Book> readSource() throws DAOException;
	void update(int id, Book book) throws DAOException;
	void delete(Book book) throws DAOException;
	void delete(int id) throws DAOException;
	void updateStatus(int id, int newStatus) throws DAOException;

}
