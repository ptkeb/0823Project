package view;

import controller.Controller;

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
		System.out.println("1. 책 조회  & 모든 책 조회");
		controller.getBook();
		controller.getallBooks();
		System.out.println("2. 책 추가");
		controller.addBook();
		System.out.println("3. 책 정보변경");
		controller.updateBook();
		System.out.println("4. 책 삭제");
		controller.deleteBook();
		
		System.out.println("5. 이용자 조회 & 모든 이용자 조회");
		controller.getUser();
		controller.getAllUser();
		System.out.println("6. 이용자 추가");
		controller.addUser();
		System.out.println("7. 이용자 정보 변경");
		controller.updateUser();
		System.out.println("8. 이용자 삭제");
		controller.deleteUser();
		
		System.out.println("9. 사서 조회 & 모든 사서 조회");
		controller.getLibrarian();
		controller.getAllLibrarian();
		System.out.println("10. 사서 추가");
		controller.addLibrarian();
		System.out.println("11. 사서 정보 변경");
		controller.updateLibrarian();
		System.out.println("12. 사서 삭제");
		controller.deleteLibrarian();
		
		System.out.println("13. 분류 조회 & 모든 분류 조회");
		controller.getMainCategory();
		controller.getAllMainCategory();
		System.out.println("14. 분류 정보 변경 (담당사서만)");
		controller.updateMainCategory();
		
		System.out.println("15. 책 대출");
		controller.rentBook();
		System.out.println("16. 책 반납");
		controller.returnBook();

//		
//		System.out.println("\n*** 01. 모든 Project 검색 ***");
//		controller.getProjectList();	
//		
//		
//		System.out.println("\n*** 02. '01슈바이처'라는 이름의 Project 검색 ***");
//		controller.getProject("01슈바이처");
//
//		System.out.println("\n*** 03. 미존재하는 Project 검색 ***");
//		controller.getProject("키다리아저씨---");
//		
//		//'04키다리아저씨' 라는 프로젝트 새로 생성해서 저장 및 검색		
//		System.out.println("\n*** 04. '04키다리아저씨'라는 새로운 Project저장 후  모든 Project 검색 ***");
//		TalentDonationProject newProject = new TalentDonationProject("04키다리아저씨", 
//				new Donator(5980, "손다리", "shon@company.com", "키다리아저씨 프로젝트"),
//				new Beneficiary(106, "나빈곤", "010-666-6666", "키다리아저씨 프로젝트"), 
//				new TalentDonationType("키다리아저씨 프로젝트",  "멘토링, 상담, 교육, 결연 분야", "결연, 상담, 멘토, 독서ㆍ학습지도 및 교육기회 제공, 장학지원, 심리상담 등 멘토링, 상담, 교육, 결연분야"),
//				"2020-03-31", "2020-04-03", "학비 지원 및 멘토링");
//		
//		System.out.println("\n04-1. 저장 전 프로젝트 검색");
//		controller.getProjectList();
//		
//		controller.insertProject(newProject);
//		
//		System.out.println("\n04-2. 저장 후 검색"); 
//		controller.getProjectList();
//		
//		System.out.println("\n04-3. 이미 저장된 프로젝트 재저장 시도후 유효성 검증의 적합성 검증");
//		controller.insertProject(newProject);
//		
//		//저장 로직의 유효성 처리 로직 검증
//		System.out.println("\n*** 05. 의미없는 데이터인 null로 Project 저장 시도 후 유효성 로직의 적합성 검증 ***");
//		controller.insertProject(null);
//		
//		
//		//존재하는 '04키다리아저씨' 프로젝트의 수혜자 업데이트 및 갱신 내용 검색
//		System.out.println("\n*** 06. 존재하는 '04키다리아저씨' Project 수혜자 변경 후 수정한 내용 검색 ***");
//		System.out.println("06-1. 수정 전 프로젝트 검색");
//		controller.getProject("04키다리아저씨");
//		controller.updateProjectBeneficiary("04키다리아저씨", new Beneficiary(110, "맘여리", "010-333-3333", "키다리아저씨 프로젝트"));
//		
//		
//		System.out.println("\n06-2. 수정 후 프로젝트 검색");
//		controller.getProject("04키다리아저씨");
//		
//		
//		System.out.println("\n*** 07. 의미없는 데이터인 null로 Project의 수혜자 정보 수정 시도 후 유효성 로직의 적합성 검증 ***");
//		controller.updateProjectBeneficiary("04키다리아저씨", null);
//		
//
//		//'01슈바이처' Project 삭제 후 검색
//		System.out.println("\n*** 08. '01슈바이처' Project 삭제 후 삭제한 Project 검색 ***");
//		System.out.println("08-1. 삭제전 프로젝트 검색");
//		controller.getProject("01슈바이처");
//		controller.deleteProject("01슈바이처");
//		
//		System.out.println("\n08-2. 삭제 후 프로젝트 검색 ");
//		controller.getProject("01슈바이처");
//		
//		System.out.println("\n08-3. 삭제된 프로젝트 삭제 재시도 후 유효성 로직의 적합성 검증");
//		controller.deleteProject("01슈바이처");
	}
}
