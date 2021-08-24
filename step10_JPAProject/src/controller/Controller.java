package controller;

import model.BooksDAO;
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
		BooksDAO.addBook(bookName, categoryId);
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

	public void getLibrarian() {
		// TODO Auto-generated method stub
		
	}

	public void getAllLibrarian() {
		// TODO Auto-generated method stub
		
	}

	public void addLibrarian() {
		// TODO Auto-generated method stub
		
	}

	public void updateLibrarian() {
		// TODO Auto-generated method stub
		
	}

	public void deleteLibrarian() {
		// TODO Auto-generated method stub
		
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
