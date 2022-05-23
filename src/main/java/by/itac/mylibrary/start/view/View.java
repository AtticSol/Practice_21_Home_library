package by.itac.mylibrary.start.view;

public class View {
	
	public void printResponse(String response) {
		System.out.println("\n" + response);
	}

	public void printDelimeter() {
		System.out.println("----------------------------------------------");
		
	}

	public void printLibrary(String stringListOfBook, String message) {
		System.out.println(message);
		System.out.println(stringListOfBook);
	}

	public void printTaskTitle(String message) {
		System.out.println(message);		
	}

}
