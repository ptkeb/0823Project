package view;

import java.util.List;

import model.dto.BooksDTO;

public class EndView {
	public static void bookView(BooksDTO getBook) {
		System.out.println(getBook);
	}
	
	public static void AllBooksView(List<BooksDTO> getBook) {
		System.out.println(getBook);
	}
}
