package view;

import java.util.List;

import model.dto.BooksDTO;
import model.dto.LibrarianDTO;
import model.dto.MainCategoryDTO;
import model.dto.UserDTO;

public class EndView {
	public static void bookView(BooksDTO getBook) {
		System.out.println(getBook);
	}
	
	public static void allBooksView(List<BooksDTO> getBook) {
		System.out.println(getBook);
	}

	public static void userView(UserDTO user) {
		System.out.println(user);
	}
	
	public static void allUserView(List<UserDTO> allUser) {
		System.out.println(allUser);
	}

	public static void allCategoryView(List<MainCategoryDTO> allCategory) {
		System.out.println(allCategory);
	}

	public static void categoryView(MainCategoryDTO category) {
		System.out.println(category);
	}
	
	public static void librarianView(LibrarianDTO librarian) {
		System.out.println(librarian);
		
	}

	public static void allLibrarianView(List<LibrarianDTO> allLibrarian) {
		System.out.println(allLibrarian);
	}


}