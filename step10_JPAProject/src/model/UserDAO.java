package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.jupiter.api.Test;

import model.dto.UserDTO;
import model.util.Util;

public class UserDAO {

	public static UserDTO getUser(int id) {
		EntityManager em = Util.getEntityManager();
		UserDTO user = em.createNamedQuery("user.findById", UserDTO.class).setParameter("userId", id).getSingleResult();
		return user;
	}

	public static List<UserDTO> getAllUser() {
		EntityManager em = Util.getEntityManager();
		List<UserDTO> user = em.createNamedQuery("user.findAllById", UserDTO.class).getResultList();
		return user;
	}

	public static void deleteUser(int id) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		UserDTO user = em.find(UserDTO.class, id);
		em.remove(user);
		em.flush();
		
		tx.commit();
	}

	public static void updateUserAddress(int id, String add) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		UserDTO user = em.find(UserDTO.class, id);
		user.setUserAddress(add);
		
		tx.commit();
	}

	public static void updateUserName(int id, String name) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		UserDTO user = em.find(UserDTO.class, id);
		user.setUserName(name);
		
		tx.commit();
	}

	public static void addUser(String name, String address) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		UserDTO user = new UserDTO();
		user.setUserName(name);
		user.setUserAddress(address);
		user.setBooks(null);
		
		tx.begin();
		
		em.persist(user);
		
		tx.commit();
	}
}
