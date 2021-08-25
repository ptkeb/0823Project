package controller;

import model.BooksDAO;
import model.LibrarianDAO;
import model.MainCategoryDAO;
import model.UserDAO;
import model.dto.BooksDTO;
import model.dto.LibrarianDTO;
import view.EndView;

public class Controller {
	private static Controller instance = new Controller();
	public static Controller getInstance() { return instance; }

	public void getBook(int bookId) {
		EndView.bookView(BooksDAO.getBook(bookId));
	}

	public void getallBooks() {
		EndView.allBooksView(BooksDAO.getAllBook());
	}

	public void addBook(String bookName, String categoryId) {
		BooksDAO.addBook(bookName, categoryId);
	}

	public void updateBook(int bookId, String bookName, int userId) { // 두번째파라미터뭐받지?
		BooksDAO.updateBookCategory(bookId, bookName);
		BooksDAO.updateBookName(bookId, bookName);
		BooksDAO.updateBookUserId(bookId, userId);
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