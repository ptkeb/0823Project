package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.dto.BooksDTO;
import model.util.Util;

public class BooksDAO {
	 /*1. 책 조회 & 모든책 조회
	 * 2. 책 추가
	 * 3. 책 정보변경
	 * 4. 책 삭제
	 */
	private static Properties sql = Util.getSql();
	
	//책 추가
	public static void addBook(String bookName, int categoryId, int renterId) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		BooksDTO book = new BooksDTO();
		book.setBookName(bookName);
		book.setCategoryId(categoryId);
		book.setRenterId(renterId);
		
		em.persist(book);
		
		tx.commit();
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
		em.flush();
		tx.commit();
	}
}