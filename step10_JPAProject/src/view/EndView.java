package view;

import java.util.List;

import model.dto.BooksDTO;
import model.dto.LibrarianDTO;
import model.dto.MainCategoryDTO;
import model.dto.UserDTO;
 
public class EndView {
	public static void bookView(BooksDTO getBook) {
		if (getBook.getUserId() != null) {
			System.out.println(getBook);
		} else {
			System.out.println("[책 번호] " + getBook.getBookId() + "\n" +
							   "[책 이름] " + getBook.getBookName() + "\n" +
							   "[분류 번호] " + getBook.getCategoryId() + "\n" +
							   "[대여자 번호] 현재 대여자 없음\n");
		}
	}
	
	public static void allBooksView(List<BooksDTO> getBook) {
		for (BooksDTO book : getBook) {
			UserDTO user = book.getUserId();
			if (user != null) {
				System.out.println(getBook);
			} else {
				System.out.println("[책 번호] " + book.getBookId() + "\n" +
								   "[책 이름] " + book.getBookName() + "\n" +
								   "[분류 번호] " + book.getCategoryId() + "\n" +
								   "[대여자 번호] 현재 대여자 없음\n");
			}
		}
	}

	public static void userView(UserDTO user) {
		if (user.getBooks() != null) {
			System.out.println(user);
		} else {
			System.out.println(	"[사용자 번호] " + user.getUserId() + "\n" +
		   						"[사용자 이름] " + user.getUserName() + "\n" +
		   						"[사용자 주소] " + user.getUserAddress() + "\n" +
								"[빌린 책] 현재 대여중인 책 없음\n");
		}
	}
	
	public static void allUserView(List<UserDTO> allUser) {
		for(UserDTO i : allUser) {
			List<BooksDTO> book = i.getBooks();
			if (book != null) {
					System.out.println(i);
			} else {
				System.out.println(	"[사용자 번호] " + i.getUserId() + "\n" +
						   			"[사용자 이름] " + i.getUserName() + "\n" +
						   			"[사용자 주소] " + i.getUserAddress() + "\n" +
									"[빌린 책] 현재 대여중인 책 없음\n");
			}	
		}
	}
	
	public static void categoryView(MainCategoryDTO category) {
		System.out.println(category);
	}
	
	public static void allCategoryView(List<MainCategoryDTO> allCategory) {
		System.out.println(allCategory);
	}
	
	public static void librarianView(LibrarianDTO librarian) {
		System.out.println(librarian);
	}

	public static void allLibrarianView(List<LibrarianDTO> allLibrarian) {
		System.out.println(allLibrarian);
	}
}