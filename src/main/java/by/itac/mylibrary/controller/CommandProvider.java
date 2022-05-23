package by.itac.mylibrary.controller;

import java.util.HashMap;
import java.util.Map;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.controller.command.CommandName;
import by.itac.mylibrary.controller.command.impl.FindByAuthor;
import by.itac.mylibrary.controller.command.impl.FindByTitle;
import by.itac.mylibrary.controller.command.impl.ReadSource;
import by.itac.mylibrary.controller.command.impl.SaveBook;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider(){
		repository.put(CommandName.SAVE_BOOK, new SaveBook());
		repository.put(CommandName.READ_SOURCE, new ReadSource());
		repository.put(CommandName.FIND_BOOK_BY_AUTHOR, new FindByAuthor());
		repository.put(CommandName.FIND_BOOK_BY_TITLE, new FindByTitle());

	}
	
	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;
		
		try{
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch(IllegalArgumentException | NullPointerException e) {
			
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}

}
