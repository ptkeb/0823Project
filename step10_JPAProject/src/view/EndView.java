package view;

import java.util.List;

import model.dto.BooksDTO;
import model.dto.LibrarianDTO;

public class EndView {
	public static void bookView(BooksDTO getBook) {
		System.out.println(getBook);
	}
	
	public static void allBooksView(List<BooksDTO> getBook) {
		System.out.println(getBook);
	}

	
	public static void librarianView(LibrarianDTO librarian) {
		System.out.println(librarian);
		
	}

	public static void allLibrarianView(List<LibrarianDTO> allLibrarian) {
		System.out.println(allLibrarian);
		
	}
}
