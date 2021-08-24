package view;

import controller.Controller;
import model.BooksDAO;

public class StartView {
	/*
	 * 1. 책 조회 & 모든책 조회
	 * 2. 책 추가
	 * 3. 책 정보변경
	 * 4. 책 삭제
	 * 5. 이용자 조회 & 모든 이용자 조회
	 * 6. 이용자 추가
	 * 7. 이용자 정보 변경
	 * 8. 이용자 삭제
	 * 9. 사서 조회 & 모든 사서 조회
	 * 10. 사서 추가
	 * 11. 사서 정보 변경
	 * 12. 사서 삭제
	 * 13. 분류 조회 & 모든 분류 조회
	 * 14. 분류 정보 변경 (담당사서만)
	 * 15. 책 대출
	 * 16. 책 반납
	 * 17. 이용자 연체일수및 해당 책 확인
	 */
	
	public static void main (String[] args) {
		Controller controller = Controller.getInstance();
		
		//완료
//		System.out.println("2. 책 추가");
//		controller.addBook("책이름1", 22, 33);
//		controller.addBook("책이름2", 33, 44);
//		controller.addBook("책이름3", 44, 55);
		BooksDAO.rentBook(1,1);
		
		System.out.println("1. 책 조회  & 모든 책 조회");
		controller.getBook(1);
		controller.getallBooks();
		
		//책의 어떤 정보를 변경할 지? - 우선 책이름 변경으로 구현
		System.out.println("3. 책 정보변경");
		controller.updateBook(1, "변경된 책이름");
		System.out.println("변경된 책 정보 출력");
		controller.getBook(1);
		
		System.out.println("4. 책 삭제");
		controller.deleteBook(2);
		controller.getallBooks();
//		
//		System.out.println("5. 이용자 조회 & 모든 이용자 조회");
//		controller.getUser();
//		controller.getAllUser();
//		System.out.println("6. 이용자 추가");
//		controller.addUser();
//		System.out.println("7. 이용자 정보 변경");
//		controller.updateUser();
//		System.out.println("8. 이용자 삭제");
//		controller.deleteUser();
//		
//		System.out.println("9. 사서 조회 & 모든 사서 조회");
//		controller.getLibrarian();
//		controller.getAllLibrarian();
//		System.out.println("10. 사서 추가");
//		controller.addLibrarian();
//		System.out.println("11. 사서 정보 변경");
//		controller.updateLibrarian();
//		System.out.println("12. 사서 삭제");
//		controller.deleteLibrarian();
//		
//		System.out.println("13. 분류 조회 & 모든 분류 조회");
//		controller.getMainCategory();
//		controller.getAllMainCategory();
//		System.out.println("14. 분류 정보 변경 (담당사서만)");
//		controller.updateMainCategory();
//		
//		System.out.println("15. 책 대출");
//		controller.rentBook();
//		System.out.println("16. 책 반납");
//		controller.returnBook();
	}
}