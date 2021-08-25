package controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;

import model.BooksDAO;
import model.LibrarianDAO;
import model.MainCategoryDAO;
import model.UserDAO;
import model.dto.LibrarianDTO;
import model.dto.UserDTO;
import model.util.Util;
import view.EndView;

public class Controller {
	private static Controller instance = new Controller();
	public static Controller getInstance() { return instance; }

	public void getBook(int bookId) {
		try {
			EndView.bookView(BooksDAO.getBook(bookId));
		} catch (NoResultException e) {
			//존재하지 않는 bookId일 경우
			System.out.println("존재하지 않는 책입니다. 책 번호를 재확인해주세요.");
		}
	}

	public void getallBooks() {
		try {
			EndView.allBooksView(BooksDAO.getAllBook());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("등록되어있는 책이 존재하지 않습니다.");
		}
	}

	public void addBook(String bookName, String categoryId) {
		try {
			List<String> list = Arrays.asList("000", "100", "200", "300", "400", "500", "600", "700", "800", "900");
			if (list.contains(categoryId)) {
				BooksDAO.addBook(bookName, categoryId);
			} else {
				System.out.println("유효하지 않은 대분류입니다. 분류 번호를 재확인해주세요.");
			}
		} catch (RollbackException e) {
			System.out.println("책 이름의 글자수를 초과하였습니다.");
		}
	}

	public void updateBookName(int bookId, String bookName) { // 두번째파라미터뭐받지? 
		try {
			BooksDAO.updateBookName(bookId, bookName);
		} catch (NoResultException e) {
			System.out.println("존재하지 않는 책입니다. 책 번호를 재확인해주세요.");
		}
	}
	
	public void updateBookCategory(int bookId, String categoryId) { // 두번째파라미터뭐받지? 
		try {
			BooksDAO.updateBookCategory(bookId, categoryId);
		} catch (NoResultException e) {
			System.out.println("존재하지 않는 책입니다. 책 번호를 재확인해주세요.");
		}
	}

	public void deleteBook(int bookId) {
		try {
			BooksDAO.deleteBook(bookId);
		} catch (NoResultException e) {
			System.out.println("존재하지 않는 책입니다. 책 번호를 재확인해주세요.");
		}
	}
	
	public void getUser(int userId) {
		try {
		EndView.userView(UserDAO.getUser(userId));
		} catch (NoResultException e) {
			System.out.println("존재하지 않는 사용자입니다. 사용자 번호를 재확인해주세요.");
		} 
	}

	public void getAllUser() {
		try {
		EndView.allUserView(UserDAO.getAllUser());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("존재하지 않는 사용자입니다. 사용자 번호를 재확인해주세요.");
		} catch (NoResultException e) {
			System.out.println("등록되어있는 사용자가 존재하지 않습니다.");
		}
	}

	public void addUser(String name, String address) {
		try	{
			UserDAO.addUser(name, address);
		} catch (RollbackException s) {
			System.out.println("글자수를 초과하였습니다.");
		}
	}

	public void updateUserName(int id, String name) {
		try {
			UserDAO.updateUserName(id, name);			
		} catch	(NullPointerException e){
			System.out.println("존재하지 않는 사용자입니다. 사용자 번호를 재확인해주세요.");
		}
	}
	
	public void updateUserAddress(int id, String add) {
		try {
		UserDAO.updateUserAddress(id, add);
		} catch	(NullPointerException e){
			System.out.println("존재하지 않는 사용자입니다. 사용자 번호를 재확인해주세요.");
		}
	}

	public void deleteUser(int id) {
		try {
			UserDAO.deleteUser(id);
		} catch (IllegalArgumentException e) {
			System.out.println("존재하지 않는 사용자입니다. 사용자 번호를 재확인해주세요.");
		}
	}

	public void getLibrarian(int librarianId) {
		try {
			EndView.librarianView((LibrarianDTO)LibrarianDAO.getLibrarian(librarianId));
		} catch (NoResultException e) {
			System.out.println("존재하지 않는 사서입니다. 사서 번호를 재확인해주세요.");
		}
	}

	public void getAllLibrarian() {
		try {
			EndView.allLibrarianView(LibrarianDAO.getAllLibrarian());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("존재하지 않는 사서입니다. 사서 번호를 재확인해주세요.");
		}
	}

	public void addLibrarian(int id, String name, String offday) {
		try {
			LibrarianDAO.addLibrarian(id, name, offday);
		} catch (RollbackException e) {
			System.out.println("중복된 사서 번호입니다. 다른 사서 번호를 이용해주세요.");
		}
	}

	public void updateLibrarianName(int librarianId, String librarianName) {
		try {
			LibrarianDAO.updateLibrarianName(librarianId, librarianName);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("존재하지 않는 사서입니다. 사서 번호를 재확인해주세요.");
		}
	}
	
	public void updateLibrarianOffDay(int librarianId, String offDay) {
		List<String> list = Arrays.asList("월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일");
		if (list.contains(offDay)) {
			try {
				LibrarianDAO.updateLibrarianOffDay(librarianId, offDay);
			} catch (NullPointerException e) {
				System.out.println("존재하지 않는 사서입니다. 사서 번호를 재확인해주세요.");
			}
		} else {
			System.out.println("휴일을 다시 입력해주세요. ex)월요일");
		}
	}
			
	public void deleteLibrarian(int librarianId) {
		try {
			LibrarianDAO.deleteLibrarian(librarianId);			
		} catch (IllegalArgumentException e) {
			System.out.println("존재하지 않는 사서입니다. 사서 번호를 재확인해주세요.");
		}
	}

	public void getMainCategory(String id) {
		try {
			EndView.categoryView(MainCategoryDAO.getCategory(id));			
		} catch (NoResultException e) {
			System.out.println("존재하지 않는 대분류입니다. 분류 번호를 재확인해주세요.");
		} 
	}

	public void getAllMainCategory() {
		try {
			EndView.allCategoryView(MainCategoryDAO.getAllCategory());			
		} catch (IndexOutOfBoundsException | NoResultException e) {
			System.out.println("대분류가 존재하지 않습니다.");
		} 
	}
	
	public void updateMainCategory(String id, int librarianId) {
		try {
			MainCategoryDAO.updateCategoryLibrarianId(id, librarianId);
		} catch (NullPointerException e) {
			System.out.println("존재하지 않는 대분류입니다. 분류 번호를 재확인해주세요.");
		}
	}

	public void rentBook(int bookId, int userId) {
		try {
			BooksDAO.rentBook(bookId, userId);
		} catch (NullPointerException e) {
			System.out.println("존재하지 않는 책입니다. 책 번호를 재확인해주세요.");
		} catch (IllegalArgumentException e) {
			System.out.println("존재하지 않는 사용자입니다. 사용자 번호를 재확인해주세요.");
		}
	}

	public void returnBook(int bookId, int userId) {
		try {
			BooksDAO.returnBook(bookId, userId);
		} catch (NoSuchElementException | IllegalArgumentException | NullPointerException e) {
			System.out.println("대여 정보가 조회되지 않습니다. 책 번호와 사용자 번호를 재확인해주세요.");
		}
	}
	
	public void returnAllBook(int userId) {
		EntityManager em = Util.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			UserDTO user = em.find(UserDTO.class, userId);
			if (user.getBooks().size() != 0) {
				try {
					BooksDAO.returnAllBook(userId);
				} catch (NullPointerException e) {
					System.out.println("존재하지 않는 사용자입니다. 사용자 번호를 재확인해주세요.");
				}
			} else {
				System.out.println("사용자가 대여한 책이 존재하지 않습니다.");
			}
		} catch (NullPointerException e) {
			System.out.println("존재하지 않는 사용자입니다. 사용자 번호를 재확인해주세요.");
		}
	}
}