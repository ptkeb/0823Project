package controller;

import model.BooksDAO;
import model.LibrarianDAO;
import view.EndView;

public class Controller {
	private static Controller instance = new Controller();
	public static Controller getInstance() { return instance; }

	public void getBook(int bookId) {
		EndView.bookView(BooksDAO.getBook(bookId));
	}

	public void getallBooks() {
		EndView.AllBooksView(BooksDAO.getAllBook());
	}

	public void addBook(String bookName, int categoryId, int renterId) {
		BooksDAO.addBook(bookName, categoryId, renterId);
	}

	public void updateBook(int bookId, String bookName) {
		BooksDAO.updateBook(bookId, bookName);
	}

	public void deleteBook(int bookId) {
		BooksDAO.deleteBook(bookId);
	}

	public void getUser() {
		// TODO Auto-generated method stub
		
	}

	public void getAllUser() {
		// TODO Auto-generated method stub
		
	}

	public void addUser() {
		// TODO Auto-generated method stub
		
	}

	public void updateUser() {
		// TODO Auto-generated method stub
		
	}

	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}

	public void getLibrarian(int id) {
		EndView.LibrarianView(LibrarianDAO.getLibrarian(1));
		
	}

	public void getAllLibrarian() {
		EndView.AllLibrarianView(LibrarianDAO.getAllLibrarian());
		
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

	public void getMainCategory() {
		// TODO Auto-generated method stub
		
	}

	public void getAllMainCategory() {
		// TODO Auto-generated method stub
		
	}

	public void updateMainCategory() {
		// TODO Auto-generated method stub
		
	}

	public void rentBook() {
		// TODO Auto-generated method stub
		
	}

	public void returnBook() {
		// TODO Auto-generated method stub
		
	}
}
