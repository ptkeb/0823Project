package view;

import controller.Controller;
import model.BooksDAO;

public class StartView {
	/*
	 * 1. 책 조회 & 모든책 조회                             (+알파) 대여여부 추가, 별점 추가
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
//		controller.deleteBook(11);
//		System.out.println("2. 책 추가");
//		controller.addBook("추가 책이름1", "1000");
//		controller.addBook("추가 책이름2", "200");
//		controller.addBook("추가 책이름3", "000");
		
//		System.out.println("1. 책 조회  & 모든 책 조회");
//		controller.getBook(12);
//		controller.getallBooks();
//		
//		//책의 어떤 정보를 변경할 지? - 우선 책이름 변경으로 구현
//		System.out.println("3. 책 정보변경");
//		controller.updateBook(1, "변경된 책이름");
//		System.out.println("변경된 책 정보 출력");
//		controller.getBook(1);
		
		//대여
//		BooksDAO.rentBook(12,1);
//		System.out.println("대여완료 후, 책 정보 확인");
//		controller.getBook(12);
//		
//		System.out.println("4. 책 삭제");
//		controller.deleteBook(2);
//		controller.getallBooks();
//		
//		System.out.println("5. 이용자 조회 & 모든 이용자 조회");
//		controller.getUser(1);
//		controller.getAllUser();
//		
//		System.out.println("6. 이용자 추가");
//		controller.addUser(4,"장씨","평택");
//		controller.getUser(4);
//		
//		System.out.println("7. 이용자 정보 변경");
//		controller.updateUser(4,"장씨","평양");
//		controller.getUser(4);
//		
//		System.out.println("8. 이용자 삭제");
//		controller.deleteUser(4);
//		controller.getAllUser();
//		
//		System.out.println("9. 사서 조회 & 모든 사서 조회");
//		controller.getLibrarian(1);
//		controller.getAllLibrarian();
//		
//		System.out.println("10. 사서 추가");
//		controller.addLibrarian(6, "김사서", "수요일");
//		controller.addLibrarian(7, "박사서", "목요일");
//		
//		System.out.println("11. 사서 정보 변경");
//		controller.updateLibrarian(3, "서사서", "월요일");
//		
//		System.out.println("12. 사서 삭제");
//		controller.deleteLibrarian(4);

//		
//		System.out.println("13. 분류 조회 & 모든 분류 조회");
//		controller.getMainCategory("100");
//		controller.getAllMainCategory();
//		
//		System.out.println("14. 분류 정보 변경 (담당사서만)");
//		controller.updateMainCategory("200", 5);
//		controller.getMainCategory("200");
//		System.out.println("15. 책 대출");
//		controller.rentBook();
//		System.out.println("16. 책 반납");
//		controller.returnBook();
	}
}