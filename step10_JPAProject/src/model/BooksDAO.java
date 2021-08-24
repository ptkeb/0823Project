package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.dto.BooksDTO;
import model.dto.UserDTO;
import model.util.Util;

public class BooksDAO {
	//책 추가
	public static void addBook(String bookName, int categoryId) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		BooksDTO book = new BooksDTO();
		book.setBookName(bookName);
		book.setCategoryId(categoryId);
		book.setRenterId(null); //null 들어가나?
		
		em.persist(book);
		
		tx.commit();
	}
	
	//대여 -> 서비스에 추가?
	public static void rentBook(int bookId, int userId) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		UserDTO user = em.find(UserDTO.class, userId);
		System.out.println(user);
		BooksDTO book = em.find(BooksDTO.class, bookId);
		System.out.println(book);
		
////		user.getBooks().add(book);
//		
////		em.persist(user);
		em.persist(book);
		
		System.out.println("하하");
		
		tx.commit();
		
		System.out.println("대여완료");
	}
	
	
	public static BooksDTO getBook(int bookId) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		List<BooksDTO> findBook = em.createNamedQuery("Books.findByBookId").setParameter("bookId", bookId).getResultList();
		
		BooksDTO findBookResult = findBook.get(0);
		
		return findBookResult;
	}
	
	public static List<BooksDTO> getAllBook() {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		List<BooksDTO> findBook = em.createNamedQuery("Books.findAllBooks").getResultList();
		
		return findBook;
	}
	
	public static void updateBook(int bookId, String bookName) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		BooksDTO book = em.find(BooksDTO.class, bookId);
		book.setBookName(bookName);
		
		em.persist(book);
		
		tx.commit();
	}
	
	public static void deleteBook(int bookId) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		
		BooksDTO book = em.find(BooksDTO.class, bookId);
		em.remove(book);
		tx.commit();
	}
}