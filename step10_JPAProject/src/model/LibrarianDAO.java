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

public class LibrarianDAO {
	public static LibrarianDTO getLibrarian(int id) {
		EntityManager em = Util.getEntityManager();

		LibrarianDTO librarian = (LibrarianDTO) em.createNamedQuery("LIBRARIAN.findByLibrarianId").setParameter("librarianId", id).getSingleResult();

		em.close();
		em = null;

		return librarian;
	}

	public static List<LibrarianDTO> getAllLibrarian() {
		EntityManager em = Util.getEntityManager();

		List<LibrarianDTO> librarian = em.createNamedQuery("LIBRARIAN.findAllByLibrarianId", LibrarianDTO.class).getResultList();

		em.close();
		em = null;

		return librarian;
	}

	public static void addLibrarian(int id, String name, String offday) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();

		LibrarianDTO Librarian = new LibrarianDTO(id, name, offday);
		em.persist(Librarian);

		tx.commit();
	}

	public static void updateLibrarianName(int librarianId, String librarianName) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		LibrarianDTO librarian = em.find(LibrarianDTO.class, librarianId);
		librarian.setLibrarianName(librarianName);

		em.persist(librarian);

		tx.commit();
	}

	public static void updateLibrarianOffDay(int librarianId, String offDay) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		LibrarianDTO librarian = em.find(LibrarianDTO.class, librarianId);
		librarian.setOffDay(offDay);

		em.persist(librarian);

		tx.commit();
	}

	public static void deleteLibrarian(int id) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();

		LibrarianDTO librarian = em.find(LibrarianDTO.class, id);
		em.remove(librarian);
		em.flush();
		
		tx.commit();
	}
}
