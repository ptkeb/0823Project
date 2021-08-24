package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.dto.LibrarianDTO;
import model.dto.UserDTO;
import model.util.Util;

/*  9. 사서 조회 & 모든 사서 조회
 * 10. 사서 추가
 * 11. 사서 정보 변경
 * 12. 사서 삭제
 */ 


public class LibrarianDAO {
	
	    
	
	//9. 사서 조회 
//	@Test
	public static void getLibrarian(int id) {
		EntityManager em = Util.getEntityManager();
		
		LibrarianDTO v = (LibrarianDTO)em.createNamedQuery("LibrarianDTO.findByLibrarianId").setParameter("librarianId", id).getSingleResult();
		System.out.println(v);
		
		em.close();
		em = null;
//		return v;
	}
		
	
	//& 모든 사서 조회
//	@Test
	public static void getAllLibrarian() {
		EntityManager em = Util.getEntityManager();
		
		List<LibrarianDTO> v = em.createNamedQuery("LibrarianDTO.findAllByLibrarianId",LibrarianDTO.class).getResultList();
		System.out.println(v);
		
		em.close();
		em = null;
	}
	
	
	
	//10. 사서 추가
//	@Test
	public static void addLibrarian(int id, String name, String offday) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		LibrarianDTO Librarian = new LibrarianDTO(id, name, offday);
		tx.begin();
		em.persist(Librarian);
		tx.commit();
	}
	
	
	
	//11. 사서 정보 변경
//	@Test
	public static void updateLibrarian(int librarianId, String librarianName, String offDay) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		LibrarianDTO librarian = em.find(LibrarianDTO.class, librarianId);
		librarian.setLibrarianName(librarianName);
		librarian.setOffDay(offDay);
		
		em.persist(librarian);
		
		tx.commit();
	}
	
	
	
	// 12. 사서 삭제
//	@Test
	public static void deleteLibrarian(int id) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		LibrarianDTO librarian = em.find(LibrarianDTO.class, id);
		em.remove(librarian);
		em.flush();
		tx.commit();
	}
	
	public static void main(String[] args) {
		addLibrarian(1, "김", "수요일");
		getLibrarian(1);
		getAllLibrarian();
		updateLibrarian(1, "강", "월요일");
		getLibrarian(1);
		deleteLibrarian(1);
		getAllLibrarian();
	}
}
