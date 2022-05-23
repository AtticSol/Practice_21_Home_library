package by.itac.mylibrary.controller.command.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;
import by.itac.mylibrary.start.view.View;

public class ReadSource implements Command {

	@Override
	public String execute(String request) throws ServiceException {
		String response = null;

		ServiceProvider provider = ServiceProvider.getInstance();
		BookService service = provider.getBookService();

		View view = new View();

		try {
			String books = service.allBooks();
			view.printLibrary(books, "Library: ");
			response = "Library output is completed.";
			
		} catch (ServiceException e) {
//			log;			
			response = "Error in library_source_reading process.";
		}

		return response;
	}

}
