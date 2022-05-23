package by.itac.mylibrary.controller.command.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;
import by.itac.mylibrary.start.view.View;

public class FindByAuthor implements Command {
	
	private final char paramDelimeter = ' ';

	@Override
	public String execute(String request){
		String response = null;
		
		ServiceProvider provider = ServiceProvider.getInstance();
		BookService service = provider.getBookService();
		View view = new View();
		
		String enteredAuthor = request.substring(request.indexOf(paramDelimeter)+1);
		
		try {
			String listOfBookChoosedAuthor = service.findByAuthor(enteredAuthor);
			
			view.printLibrary(listOfBookChoosedAuthor, "List of books by: " + enteredAuthor);	
			
			response = "Book search by author is completed.";
		} catch (ServiceException e) {
			// log
			response = "Error in find_by_author process.";
		}

		return response;
	}

}
