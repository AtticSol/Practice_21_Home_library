package by.itac.mylibrary.controller.command;

import by.itac.mylibrary.service.exception.ServiceException;

public interface Command {
	public String execute(String request) throws ServiceException;
}
