package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.dto.BooksDTO;
import model.dto.UserDTO;
import model.util.Util;

public class BooksDAO {
	//책 추가
	public static void addBook(String bookName, String categoryId) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		BooksDTO book = new BooksDTO();
		book.setBookName(bookName);
		book.setCategoryId(categoryId);
		book.setUserId(null); //null 들어가나?
		
		em.persist(book);
		
		tx.commit();
	}
	
	public static void rentBook(int bookId, int userId) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		UserDTO user = em.find(UserDTO.class, userId);
		BooksDTO book = em.find(BooksDTO.class, bookId);

		book.setUserId(user);
		em.persist(user);
		em.persist(book);
		
		tx.commit();
	}
	
	public static void returnBook(int bookId, int userId) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		UserDTO user = em.find(UserDTO.class, userId);
		Optional<BooksDTO> bookOpt = (Optional<BooksDTO>)(user.getBooks().stream().filter(v -> v.getBookId()==bookId).findAny());
		BooksDTO book = bookOpt.get();
		book.setUserId(null);
		user.getBooks().remove(book);
		
		tx.commit();
	}
	
	public static void returnAllBook(int userId) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<BooksDTO> B1 = new ArrayList<>();
		
		tx.begin();
		UserDTO user = em.find(UserDTO.class, userId);
		Object[] book = user.getBooks().stream().filter(v -> v.getUserId().getUserId()==userId).toArray();
		
		for(Object i : book) {
			B1.add((BooksDTO)i); 
		}
		for (BooksDTO i : B1) {
			user.getBooks().remove(i);
			i.setUserId(null);
		}
		em.persist(user);
		tx.commit();
	}
	
	
	public static BooksDTO getBook(int bookId) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		BooksDTO findBook = (BooksDTO)em.createNamedQuery("BOOKS.findByBookId").setParameter("bookId", bookId).getSingleResult();
		
		return findBook;
	}
	
	public static List<BooksDTO> getAllBook() {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		List<BooksDTO> findBook = em.createNamedQuery("BOOKS.findAllBooks").getResultList();
		
		return findBook;
	}
	
	public static void updateBookName(int bookId, String bookName) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		BooksDTO book = em.find(BooksDTO.class, bookId);
		book.setBookName(bookName);
		
		em.persist(book);
		
		tx.commit();
	}
	
	public static void updateBookCategory(int bookId, String categoryId) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		BooksDTO book = em.find(BooksDTO.class, bookId);
		book.setCategoryId(categoryId);
		
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
	
	public static void main (String[] args) {
	}
	
	/*
	 * List<BooksDTO> B1 = new ArrayList<>();
		UserDTO user = em.find(UserDTO.class, 5);
		B1.add(v.getBookId(),v.getBookName(),v.getCategoryId(),v.getRenterId());
		Object[] book = user.getBooks().stream().filter(v -> v.getRenterId().getUserId()==5).toArray();
		
		for(Object i : book) {
			B1.add((BooksDTO)i); 
		}
		System.out.println(B1);
	 * 
	 */
}