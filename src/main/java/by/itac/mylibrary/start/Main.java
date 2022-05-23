package by.itac.mylibrary.start;

import java.util.Scanner;

import by.itac.mylibrary.controller.Controller;
import by.itac.mylibrary.service.exception.ServiceException;
import by.itac.mylibrary.start.view.View;

public class Main {

	public static void main(String[] args) throws ServiceException {

		Controller c = new Controller();
		View view = new View();


		Scanner scInt = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);
		
		String request;
		String response;

		while (true) {
			System.out.print("Choose menu item: \n" + "0. exit\n" + "1. Print list of all books in Library\n"
					+ "2. Book search\n" + "3. Add new book in Library\n>> ");
			int choice = scInt.nextInt();
			if (choice == 0) {
				break;
			}
			if (choice < 1 || choice > 3) {
				System.out.println("A non-existent menu item was choosed. Repeat choice: ");
				continue;
			}
			System.out.println("----------------------------------------------");
			switch (choice) {
			case 1:
				request = "read_source ";
				
				response = c.executeTask(request);
				
				view.printResponse(response);
				view.printDelimeter();
				break;
			case 2:
				while (true) {
					System.out.print("Choose menu item: \n" + "(0) - Step back\n" + "(1) - Book search by author\n"
							+ "(2) - Book search by title\n>> ");
					int choice2 = scInt.nextInt();
					if (choice2 == 0) {
						System.out.println("----------------------------------------------");
						break;
					}
					if (choice2 > 2) {
						System.out.println("A non-existent menu item was choosed. Repeat choice: ");
						continue;
					}
					System.out.println("----------------------------------------------");
					switch (choice2) {
					case 1:
						System.out.print("Enter author name: >> ");
						String enteredAuthor = scString.nextLine();
						request = "find_book_by_author " + enteredAuthor;
						
						response = c.executeTask(request);
						
						view.printResponse(response);
						view.printDelimeter();
						break;
					case 2:
						System.out.print("Enter book title: >> ");
						String enteredTitle = scString.nextLine();
						request = "find_book_by_title " + enteredTitle;
						
						response = c.executeTask(request);
						
						view.printResponse(response);
						view.printDelimeter();
						break;
					}
					break;
				}
				break;
			case 3:
				System.out.print("Enter book data: \n" + "Author name: >> ");
				String enteredAuthor = scString.nextLine();
				System.out.print("Book title: >> ");
				String enteredTitle = scString.nextLine();
				System.out.print("Year of publishing: >> ");
				String enteredYear = scString.nextLine();
				request = "save_book" + " " + enteredAuthor + "__ __" + enteredTitle + "__ __" + enteredYear;

				response = c.executeTask(request);

				view.printResponse(response);
				view.printDelimeter();
				break;
			}
		}
		scInt.close();
		scString.close();

	}

}
