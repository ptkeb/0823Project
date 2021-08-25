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
//		controller.returnBook(2,2);
//		
//		System.out.println("2. 책 추가");
//		controller.addBook("추가 책이름1", "000");
//		controller.addBook("추가 책이름2", "200");
//		controller.addBook("추가 책이름3", "000");
//		
//		controller.deleteBook(3);
//		System.out.println("1. 책 조회  & 모든 책 조회");
//		controller.getBook(31);
//		controller.getallBooks();
//		
//		//책의 어떤 정보를 변경할 지? - 우선 책이름 변경으로 구현
//		System.out.println("3. 책 정보변경");
//		controller.updateBook(1, "변경된 책이름", 1); // parentkey
//		System.out.println("변경된 책 정보 출력");
//		controller.getBook(23);
//		
//		//대여
//		BooksDAO.rentBook(21,1);
//		System.out.println("대여완료 후, 책 정보 확인");
//		controller.getBook(23);
//		
//		System.out.println("4. 책 삭제");
//		controller.deleteBook(2);
//		controller.getallBooks();
//		
//		System.out.println("5. 이용자 조회 & 모든 이용자 조회");
//		controller.getUser(21);
//		controller.getAllUser();
//		
//		System.out.println("6. 이용자 추가");
//		controller.addUser("장씨","평택");
//		controller.getUser(7);
//		
//		System.out.println("7. 이용자 정보 변경");
//		controller.updateUserAddress(1,"미국");
//		controller.updateUserName(1,"장씨");
//		controller.getUser(24);
//		
//		System.out.println("8. 이용자 삭제");
//		controller.deleteUser(1);
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
		controller.updateLibrarian(99, "서사서", "월요일");
//		
//		System.out.println("12. 사서 삭제");
//		controller.deleteLibrarian(1);
//		
//		System.out.println("13. 분류 조회 & 모든 분류 조회");
//		controller.getMainCategory("100");
//		controller.getAllMainCategory();
//		
//		System.out.println("14. 분류 정보 변경 (담당사서만)");
//		controller.updateMainCategory("100", 1);
//		controller.getMainCategory("200");
//		
//		System.out.println("15. 책 대출");
//		controller.rentBook(30,23);
		
		
//		System.out.println("16. 책 반납");
//		controller.returnBook(30,23);
//		controller.getBook(30);
//		System.out.println("17. 모든 책 반납");
//		controller.getUser(22);
//		controller.rentBook(21, 22);
//		controller.rentBook(22, 22);
//		controller.rentBook(23, 22);
//		controller.returnAllBook(22);
//		controller.getUser(22);
	}
}