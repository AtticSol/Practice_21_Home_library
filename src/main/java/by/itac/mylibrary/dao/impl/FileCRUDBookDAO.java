package by.itac.mylibrary.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public class FileCRUDBookDAO implements CRUDBookDAO {

	private Library library = Library.getInstance();

	public void save(Book book) throws DAOException {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(library.getPath(), true))) {

			nextId(book);
			bw.append(bookToString(book));

		} catch (IOException e) {
			throw new DAOException("Error in save process", e);
		}
	}

	public List<Book> readSource() throws DAOException {
		library.read();
		return library.getListOfBooksInLibrary();
	}

	public void update(int id, Book book) {
	}

	public void delete(Book book) {
	}

	public void delete(int id) {
	}

	public void updateStatus(int id, int newStatus) {
	}

	private String bookToString(Book book) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append(book.getId());
		sb.append(Library.getDelimeter());
		sb.append(book.getAuthor());
		sb.append(Library.getDelimeter());
		sb.append(book.getTitle());
		sb.append(Library.getDelimeter());
		sb.append(book.getYear());
		return sb.toString();
	}
	

	private void nextId(Book book) throws DAOException {
		int id = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(library.getPath()))) {

			String line = null;
			String lastLine = null;

			while ((line = br.readLine()) != null) {
				lastLine = line;
			}

			if (lastLine != null) {
				String[] lastBook = lastLine.split(Library.getDelimeter() );
				id = Integer.parseInt(lastBook[0]) + 1;
			} else {
				id = 1;
			}
		} catch (NumberFormatException  nfe) {
			throw new DAOException("Error in last ID number reading process", nfe);
		} catch (IOException e) {
			throw new DAOException("Error in Next ID creating process", e);
		}
		book.setId(id);
	}

}
