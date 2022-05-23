package by.itac.mylibrary.controller.command.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class SaveBook implements Command {

	private static final String DELIMETER = "__ __";
	private final char paramDelimeter = ' ';

	@Override
	public String execute(String request){
		String response = null;

		ServiceProvider provider = ServiceProvider.getInstance();
		BookService service = provider.getBookService();

		String author = "";
		String title = "";
		String year = "";
		
		request = request.substring(request.indexOf(paramDelimeter)).trim();
		String[] bookst = request.split(DELIMETER);
		author = bookst[0];
		title = bookst[1];
		year = bookst[2];

		Book b1 = new Book(author, title, year);

		try {
			service.save(b1);
			response = "Book is saved";
		} catch (ServiceException e) {
//			log;
			response = "Error in Save_book process";
		}

		return response;
	}

}
