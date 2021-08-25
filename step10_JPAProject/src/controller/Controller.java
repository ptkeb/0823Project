package controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.NoResultException;

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
		List<String> list = Arrays.asList("000", "200", "300", "400", "500", "600", "700", "800", "900");
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
		EndView.userView(UserDAO.getUser(userId));
	}

	public void getAllUser() {
		EndView.allUserView(UserDAO.getAllUser());
	}

	public void addUser(String name, String address) {
		UserDAO.addUser(name, address);
	}

	public void updateUser(int id, String name, String add) {
		UserDAO.updateUserName(id, name);
		UserDAO.updateUserAddress(id, add);
	}

	public void deleteUser(int id) {
		UserDAO.deleteUser(id);
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
		LibrarianDAO.deleteLibrarian(librarianId);
		
	}


	public void getMainCategory(String id) {
		EndView.categoryView(MainCategoryDAO.getCategory(id));
	}

	public void getAllMainCategory() {
		EndView.allCategoryView(MainCategoryDAO.getAllCategory());
	}

	public void updateMainCategory(String id, int librarianId) {
		MainCategoryDAO.updateCategoryLibrarianId(id, librarianId);
	}

	public void rentBook(int bookId, int userId) {
		BooksDAO.rentBook(bookId, userId);
	}

	public void returnBook(int userId, int bookId) {
		BooksDAO.returnBook(userId, bookId);
	}
	
	public void returnAllBook(int userId) {
		BooksDAO.returnAllBook(userId);
	}
}