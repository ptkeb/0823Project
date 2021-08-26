package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Controller;
import model.BooksDAO;

public class StartView {
	public static void main(String[] args) {
		Controller controller = Controller.getInstance();
		StringBuilder builder = new StringBuilder();
		builder.append(" 1. 책 조회 & 모든 책 조회 \n "); 
		builder.append("2. 책 추가 \n ");
		builder.append("3. 책 정보변경 \n ");
		builder.append("4. 책 삭제 \n ");
		builder.append("5. 이용자 조회 & 모든 이용자 조회 \n ");
		builder.append("6. 이용자 추가 \n ");
		builder.append("7. 이용자 정보 변경 \n ");
		builder.append("8. 이용자 삭제 \n ");
		builder.append("9. 사서 조회 & 모든 사서 조회 \n ");
		builder.append("10. 사서 추가 \n ");
		builder.append("11. 사서 정보 변경 \n ");
		builder.append("12. 사서 삭제 \n ");
		builder.append("13. 분류 조회 & 모든 분류 조회 \n ");
		builder.append("14. 분류 정보 변경 (담당사서만) \n ");
		builder.append("15. 책 대출 \n ");
		builder.append("16. 모든 책 반납 \n ");
		builder.append("17. 종료 \n ");
		
		Scanner sc = new Scanner(System.in);
		System.out.println(builder.toString());
		System.out.println("!!! 문자를 입력할떄 띄어쓰기는 하지마세요 !!!");
		System.out.println("명령어를 확인하려면 0을 입력해주세요");

		boolean trialEnd = false;
		while (!trialEnd) {
			try { 	int num = sc.nextInt();
					
				if (num == 0) {
					System.out.println(builder.toString());
					
				} else if (num == 1) {
					// 1. 책 조회
					System.out.println("책 조회중");
					controller.getallBooks();
					System.out.println("책 번호를 입력해주세요");
					int bookId = sc.nextInt();
					controller.getBook(bookId);
					
				} else if (num == 2) {
					// 2. 책 추가
					System.out.println("책 이름을 입력해 주세요");
					String bookName = sc.next();
					System.out.println("책의 분류번호를 입력해주세요");
					String categoryId = sc.next();
					controller.addBook(bookName, categoryId);
					System.out.println("책이 추가되었습니다.");
					
				} else if (num == 3) {
					// 3. 책 정보변경
					System.out.println("변경할 책 번호를 입력해주세요");
					int bookId = sc.nextInt();
					controller.getBook(bookId);
					System.out.println("어떤 이름으로 변경하시겠습니까?");
					String bookName = sc.next();
					controller.updateBookName(bookId, bookName);
					System.out.println("어떤 대분류로 변경하시겠습니까?");
					String categoryId = sc.next();
					controller.updateBookCategory(bookId, categoryId);
					controller.getBook(bookId);
					System.out.println("정보가 변경되었습니다.");
					
				} else if (num == 4) {
					// 4. 책 삭제
					System.out.println("삭제할 책 번호를 입력해주세요.");
					int bookId = sc.nextInt();
					controller.getBook(bookId);
					System.out.println("진짜로 지우시겠습니까? 지우시려면 1를 입력하세요.");
					int temp = sc.nextInt();
					if (temp == 1) {
						controller.deleteBook(bookId);
						System.out.println("삭제되었습니다.");
					} else {
						System.out.println("삭제를 취소하였습니다.");
					}
					
				} else if (num == 5) {
					// 5. 이용자 조회 & 모든 이용자 조회
					System.out.println("사용자 조회중");
					controller.getAllUser();
					System.out.println("조회할 사용자 번호를 입력하세요.");
					int userId = sc.nextInt();
					controller.getUser(userId);
					
				} else if (num == 6) {
					// 6. 이용자 추가
					System.out.println("추가할 사용자 이름을 입력하세요.");
					String userName = sc.next();
					System.out.println("사용자 주소를 입력해주세요.");
					String userAddress = sc.next();
					controller.addUser(userName, userAddress);
					System.out.println("사용자가 추가되었습니다.");
					
				} else if (num == 7) {
					// 7. 이용자 정보 변경
					System.out.println("변경할 사용자 번호를 입력해 주세요.");
					int userId = sc.nextInt();
					controller.getUser(userId);
					System.out.println("어떤 이름으로 변경하시겠습니까?");
					String userName = sc.next();
					System.out.println("어떤 주소로 변경하시겠습니까?");
					String userAddress = sc.next();
					controller.updateUserAddress(userId, userAddress);
					controller.updateUserName(userId, userName);
					controller.getUser(userId);
					
				} else if (num == 8) {
					// 8. 이용자 삭제
					System.out.println("삭제할 사용자 번호를 입력해 주세요");
					int userId = sc.nextInt();
					controller.getUser(userId);
					System.out.println("진짜로 지우시겠습니까? 지우시려면 1를 입력하세요.");
					int temp = sc.nextInt();
					if (temp == 1) {
						controller.deleteUser(userId);;
						System.out.println("삭제되었습니다.");
					} else {
						System.out.println("삭제를 취소하였습니다.");
					}
					
				} else if (num == 9) {
					// 9. 사서 조회 & 모든 사서 조회
					System.out.println("사서 조회중");
					controller.getAllLibrarian();
					System.out.println("조회할 사서 번호를 입력해주세요");
					int librarianId = sc.nextInt();
					controller.getLibrarian(librarianId);
					
				} else if (num == 10) {
					// 10. 사서 추가
					System.out.println("추가할 사서 번호를 입력해주세요. 6번이후만 가능합니다.");
					int librarianId = sc.nextInt();
					System.out.println("추가할 사서 이름을 입력해주세요.");
					String librarianName = sc.next();
					System.out.println("휴무일을 입력해주세요. ex)월요일");
					String offDay = sc.next();
					controller.addLibrarian(librarianId, librarianName, offDay);
					controller.getLibrarian(librarianId);
					
				} else if (num == 11) {
					// 11. 사서 정보 변경
					System.out.println("변경할 사서번호를 입력해주세요.");
					int librarianId = sc.nextInt(); 
					controller.getLibrarian(librarianId);
					System.out.println("어떤 이름으로 변경하시겠습니까?");
					String librarianName = sc.next();
					System.out.println("휴무일을 어떤 요일로 변경하시겠습니까? 입력해 주세요. ex)월요일");
					String offDay = sc.next();
					controller.updateLibrarianName(librarianId, librarianName);
					controller.updateLibrarianOffDay(librarianId, offDay);
					controller.getLibrarian(librarianId);
					
				} else if (num == 12) {
					// 12. 사서 삭제
					System.out.println("삭제할 사서번호를 입력하세요");
					int librarianId = sc.nextInt();
					System.out.println("진짜로 지우시겠습니까? 지우시려면 1를 입력하세요.");
					int temp = sc.nextInt();
					if (temp == 1) {
						controller.deleteLibrarian(librarianId);
						System.out.println("삭제되었습니다.");
					} else {
						System.out.println("삭제를 취소하였습니다.");
					}
					
				} else if (num == 13) {
					// 13. 분류 조회 & 모든 분류 조회
					System.out.println("분류 조회중");
					controller.getAllMainCategory();
					System.out.println("조회할 분류번호를 입력해주세요.");
					String id = sc.next();
					controller.getMainCategory(id);
					
				} else if (num == 14) {
					// 14. 분류 정보 변경 (담당사서만)
					System.out.println("변경할 분류번호를 입력해주세요.");
					String id = sc.next();
					System.out.println("변경할 담당 사서 번호를 입력해주세요.");
					int librarianId = sc.nextInt();
					controller.updateMainCategory(id, librarianId);
					controller.getMainCategory(id);
					
				} else if (num == 15) {
					// 15. 책 대출
					System.out.println("대출할 책 번호를 입력해주세요.");
					int bookId = sc.nextInt();
					System.out.println("대출받을 사용자 번호를 입력해주세요.");
					int userId = sc.nextInt();
					controller.rentBook(bookId, userId);
				
				} else if (num == 16) {
					// 16. 모든 책 반납
					System.out.println("반납할 사용자 번호를 입력해주세요.");
					int userId = sc.nextInt();
					controller.returnAllBook(userId);
					
				} else if (num == 17) {
					trialEnd = true;
					
				} else {
					trialEnd = true;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다. 실행을 중단합니다.");
				trialEnd = true;
			}
		}
	}
}