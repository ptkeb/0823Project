package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.dto.LibrarianDTO;
import model.dto.MainCategoryDTO;
import model.util.Util;

public class MainCategoryDAO {

	public static MainCategoryDTO getCategory(String id) {
		EntityManager em = Util.getEntityManager();
		MainCategoryDTO category = em.createNamedQuery("category.findById", MainCategoryDTO.class).setParameter("mainCategoryId", id).getSingleResult();
		return category;
	}

	public static List<MainCategoryDTO> getAllCategory() {
		EntityManager em = Util.getEntityManager();
		List<MainCategoryDTO> category = em.createNamedQuery("category.findAllById", MainCategoryDTO.class).getResultList();
		return category;
	}

	public static void updateCategoryLibrarianId(String id, int librarianId) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<LibrarianDTO> Lib = LibrarianDAO.getAllLibrarian();
		ArrayList<Integer> list = new ArrayList<>();
		Lib.forEach(v -> list.add(v.getLibrarianId()));
		
		if (list.contains(librarianId)) {
			tx.begin();
			
			MainCategoryDTO category = em.find(MainCategoryDTO.class, id);
			category.setLibrarianId(librarianId);
			
			tx.commit();
		} else {
			System.out.println("존재하지 않는 사서번호 입니다.");
		}
	}

}