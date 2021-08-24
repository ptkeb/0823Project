package view;

import java.util.List;

import model.dto.BooksDTO;
import model.dto.LibrarianDTO;

public class EndView {
	public static void bookView(BooksDTO getBook) {
		System.out.println(getBook);
	}
	
	public static void AllBooksView(List<BooksDTO> getBook) {
		System.out.println(getBook);
	}

	
	public static void LibrarianView(LibrarianDTO librarian) {
		System.out.println(librarian);
		
	}

	public static void AllLibrarianView(List<LibrarianDTO> allLibrarian) {
		System.out.println(allLibrarian);
		
	}
}
