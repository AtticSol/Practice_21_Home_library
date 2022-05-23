package by.itac.mylibrary.service;

import by.itac.mylibrary.service.exception.ServiceException;

public interface StatusBookService {
	void changeToRead(int id)  throws ServiceException;
}
