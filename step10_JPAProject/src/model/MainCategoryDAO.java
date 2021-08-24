package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.dto.MainCategoryDTO;
import model.dto.UserDTO;
import model.util.Util;

public class MainCategoryDAO {

	public static MainCategoryDTO getCategory(int id) {
		EntityManager em = Util.getEntityManager();
		MainCategoryDTO category = em.createNamedQuery("category.findById",MainCategoryDTO.class)
							.setParameter("mainCategoryId", id).getSingleResult();
		return category;
	}
	
	public static List<MainCategoryDTO> getAllCategory() {
		EntityManager em = Util.getEntityManager();
		List<MainCategoryDTO> category = em.createNamedQuery("category.findAllById",MainCategoryDTO.class)
							.getResultList();
		return category;
	}
	
	public static void updateCategoryLibrarianId(int id, int librarianId) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		MainCategoryDTO category = em.find(MainCategoryDTO.class, id);
		category.setLibrarianId(librarianId);
		tx.commit();
	}
	
}
