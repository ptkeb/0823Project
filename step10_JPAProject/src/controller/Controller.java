package controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;

import model.BooksDAO;
import model.LibrarianDAO;
import model.MainCategoryDAO;
import model.UserDAO;
import model.dto.LibrarianDTO;
import view.EndView;

public class Controller {
	private static Controller instance = new Controller();
	public static Controller getInstance() { return instance; }

	public void getBook(int bookId) {
		try {
			EndView.bookView(BooksDAO.getBook(bookId));
		} catch (NoResultException e) {
			//존재하지 않는 bookId일 경우
			System.out.println("존재하지 않는 책 번호입니다.");
		}
	}

	public void getallBooks() {
		EndView.allBooksView(BooksDAO.getAllBook());
	}

	public void addBook(String bookName, String categoryId) {
		List<String> list = Arrays.asList("000","100", "200", "300", "400", "500", "600", "700", "800", "900");
		if (list.contains(categoryId)) {
			BooksDAO.addBook(bookName, categoryId);
		} else {
			System.out.println("유효하지 않은 분류 번호입니다.");
		}
	}

	public void updateBookName(int bookId, String bookName) { // 두번째파라미터뭐받지? 
		BooksDAO.updateBookName(bookId, bookName);
	}
	
	public void updateBookCategory(int bookId, String categoryId) { // 두번째파라미터뭐받지? 
		BooksDAO.updateBookCategory(bookId, categoryId);
	}

	public void deleteBook(int bookId) {
		BooksDAO.deleteBook(bookId);
	}

	public void getUser(int userId) {
		try {
		EndView.userView(UserDAO.getUser(userId));
		} catch (NoResultException e) {
			System.out.println("데이터가 없습니다.");
		} 
	}

	public void getAllUser() {
		try {
		EndView.allUserView(UserDAO.getAllUser());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("사용자가 존재하지 않습니다.");
		} catch (NoResultException e) {
			System.out.println("출력하려는 값이 존재하지 않습니다.");
		}
	}

	public void addUser(String name, String address) {
		try	{
			UserDAO.addUser(name, address);
		} catch (RollbackException s) {
			System.out.println("글자수를 초과하였습니다.");
		}
	}

	public void updateUserName(int id, String name) {
		try {
			UserDAO.updateUserName(id, name);			
		} catch	(NullPointerException e){
			System.out.println("존재하지 않는 사용자 번호입니다.");
		}
	}
	
	public void updateUserAddress(int id, String add) {
		try {
		UserDAO.updateUserAddress(id, add);
		} catch	(NullPointerException e){
			System.out.println("존재하지 않는 사용자 번호입니다.");
		}
	}

	public void deleteUser(int id) {
		try {
			UserDAO.deleteUser(id);
		} catch (IllegalArgumentException e) {
			System.out.println("존재하지 않는 사용자입니다.");
		}
	}

	public void getLibrarian(int librarianId) {
		EndView.librarianView((LibrarianDTO)LibrarianDAO.getLibrarian(librarianId));
	}

	public void getAllLibrarian() {
		EndView.allLibrarianView(LibrarianDAO.getAllLibrarian());
	}

	public void addLibrarian(int id, String name, String offday) {
		LibrarianDAO.addLibrarian(id, name, offday);
	}

	public void updateLibrarian(int librarianId, String librarianName, String offDay) {
		LibrarianDAO.updateLibrarian(librarianId, librarianName, offDay);
		
	}

	public void deleteLibrarian(int librarianId) {
		try {
			LibrarianDAO.deleteLibrarian(librarianId);			
		} catch (IllegalArgumentException e) {
			System.out.println("존재하지 않는 사서입니다.");
		}
	}

	public void getMainCategory(String id) {
		try {
			EndView.categoryView(MainCategoryDAO.getCategory(id));			
		} catch (NoResultException e) {
			System.out.println("데이터가 없습니다.");
		} 
	}

	public void getAllMainCategory() {
		try {
			EndView.allCategoryView(MainCategoryDAO.getAllCategory());			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("카테고리가 존재하지 않습니다.");
		} catch (NoResultException e) {
			System.out.println("출력하려는 값이 존재하지 않습니다.");
		}
	}

	
	public void updateMainCategory(String id, int librarianId) {
		try {
			MainCategoryDAO.updateCategoryLibrarianId(id, librarianId);
		} catch (NullPointerException e) {
			System.out.println("존재하지않는 분류 번호입니다.");
		}
	}

	public void rentBook(int bookId, int userId) {
		try {
		BooksDAO.rentBook(bookId, userId);
		} catch (NullPointerException e){
			System.out.println("존재하지않는 번호가 지정되었습니다. 다시 확인해주세요.");
		}
	}

	public void returnBook(int userId, int bookId) {
		try {
		BooksDAO.returnBook(userId, bookId);
		} catch (NullPointerException e){
			System.out.println("존재하지않는 번호가 지정되었습니다. 다시 확인해주세요.");
		}
	}
	
	public void returnAllBook(int userId) {
		try {
		BooksDAO.returnAllBook(userId);
		} catch (NullPointerException e) {
			System.out.println("존재하지 않는 사용자 번호입니다.");
		}
	}
}