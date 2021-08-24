package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.jupiter.api.Test;

import model.dto.UserDTO;
import model.util.Util;

public class UserDAO {

	public static UserDTO FindUser(int id) {
		EntityManager em = Util.getEntitymanager();
		UserDTO user = em.createNamedQuery("user.findById",UserDTO.class)
							.setParameter("userId", id).getSingleResult();
		return user;
	}
	
	public static List<UserDTO> FindAllUser() {
		EntityManager em = Util.getEntitymanager();
		List<UserDTO> user = em.createNamedQuery("user.findAllById",UserDTO.class)
							.getResultList();
		return user;
	}
	
	public static void DeleteUser(int id) {
		EntityManager em = Util.getEntitymanager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		UserDTO user = em.find(UserDTO.class, id);
		em.remove(user);
		tx.commit();
	}
	
	public static void UpdateUserAddress(int id, String add) {
		EntityManager em = Util.getEntitymanager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		UserDTO user = em.find(UserDTO.class, id);
		user.setUserAddress(add);
		tx.commit();
	}
	
	public static void UpdateUserName(int id, String name) {
		EntityManager em = Util.getEntitymanager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		UserDTO user = em.find(UserDTO.class, id);
		user.setUserName(name);
		tx.commit();
	}
	
	public static void AddUser(int id, String name, String address) {
		EntityManager em = Util.getEntitymanager();
		EntityTransaction tx = em.getTransaction();
		UserDTO user = new UserDTO(id,name,address, null);
		tx.begin();
		em.persist(user);
		tx.commit();
	}
	
	public static void main (String[] args) {
		EntityManager em = Util.getEntitymanager();
		
		AddUser(1,"홍길동", "서울");
		System.out.println(FindUser(1));
		System.out.println(FindAllUser());
		UpdateUserAddress(2, "울릉도");
		UpdateUserName(2, "김씨");
		System.out.println(FindUser(2));
		DeleteUser(1);
		System.out.println(FindAllUser());
		
		

	}
}
