package view;

import controller.Controller;

public class StartView {
	/*
	 * 1. å ��ȸ & ���å ��ȸ
	 * 2. å �߰�
	 * 3. å ��������
	 * 4. å ����
	 * 5. �̿��� ��ȸ & ��� �̿��� ��ȸ
	 * 6. �̿��� �߰�
	 * 7. �̿��� ���� ����
	 * 8. �̿��� ����
	 * 9. �缭 ��ȸ & ��� �缭 ��ȸ
	 * 10. �缭 �߰�
	 * 11. �缭 ���� ����
	 * 12. �缭 ����
	 * 13. �з� ��ȸ & ��� �з� ��ȸ
	 * 14. �з� ���� ���� (���缭��)
	 * 15. å ����
	 * 16. å �ݳ�
	 * 17. �̿��� ��ü�ϼ��� �ش� å Ȯ��
	 */
	
	public static void main (String[] args) {
		Controller controller = Controller.getInstance();
		System.out.println("1. å ��ȸ  & ��� å ��ȸ");
		controller.getBook();
		controller.getallBooks();
		System.out.println("2. å �߰�");
		controller.addBook();
		System.out.println("3. å ��������");
		controller.updateBook();
		System.out.println("4. å ����");
		controller.deleteBook();
		
		System.out.println("5. �̿��� ��ȸ & ��� �̿��� ��ȸ");
		controller.getUser();
		controller.getAllUser();
		System.out.println("6. �̿��� �߰�");
		controller.addUser();
		System.out.println("7. �̿��� ���� ����");
		controller.updateUser();
		System.out.println("8. �̿��� ����");
		controller.deleteUser();
		
		System.out.println("9. �缭 ��ȸ & ��� �缭 ��ȸ");
		controller.getLibrarian();
		controller.getAllLibrarian();
		System.out.println("10. �缭 �߰�");
		controller.addLibrarian();
		System.out.println("11. �缭 ���� ����");
		controller.updateLibrarian();
		System.out.println("12. �缭 ����");
		controller.deleteLibrarian();
		
		System.out.println("13. �з� ��ȸ & ��� �з� ��ȸ");
		controller.getMainCategory();
		controller.getAllMainCategory();
		System.out.println("14. �з� ���� ���� (���缭��)");
		controller.updateMainCategory();
		
		System.out.println("15. å ����");
		controller.rentBook();
		System.out.println("16. å �ݳ�");
		controller.returnBook();

//		
//		System.out.println("\n*** 01. ��� Project �˻� ***");
//		controller.getProjectList();	
//		
//		
//		System.out.println("\n*** 02. '01������ó'��� �̸��� Project �˻� ***");
//		controller.getProject("01������ó");
//
//		System.out.println("\n*** 03. �������ϴ� Project �˻� ***");
//		controller.getProject("Ű�ٸ�������---");
//		
//		//'04Ű�ٸ�������' ��� ������Ʈ ���� �����ؼ� ���� �� �˻�		
//		System.out.println("\n*** 04. '04Ű�ٸ�������'��� ���ο� Project���� ��  ��� Project �˻� ***");
//		TalentDonationProject newProject = new TalentDonationProject("04Ű�ٸ�������", 
//				new Donator(5980, "�մٸ�", "shon@company.com", "Ű�ٸ������� ������Ʈ"),
//				new Beneficiary(106, "�����", "010-666-6666", "Ű�ٸ������� ������Ʈ"), 
//				new TalentDonationType("Ű�ٸ������� ������Ʈ",  "���丵, ���, ����, �Ῥ �о�", "�Ῥ, ���, ����, �������н����� �� ������ȸ ����, ��������, �ɸ���� �� ���丵, ���, ����, �Ῥ�о�"),
//				"2020-03-31", "2020-04-03", "�к� ���� �� ���丵");
//		
//		System.out.println("\n04-1. ���� �� ������Ʈ �˻�");
//		controller.getProjectList();
//		
//		controller.insertProject(newProject);
//		
//		System.out.println("\n04-2. ���� �� �˻�"); 
//		controller.getProjectList();
//		
//		System.out.println("\n04-3. �̹� ����� ������Ʈ ������ �õ��� ��ȿ�� ������ ���ռ� ����");
//		controller.insertProject(newProject);
//		
//		//���� ������ ��ȿ�� ó�� ���� ����
//		System.out.println("\n*** 05. �ǹ̾��� �������� null�� Project ���� �õ� �� ��ȿ�� ������ ���ռ� ���� ***");
//		controller.insertProject(null);
//		
//		
//		//�����ϴ� '04Ű�ٸ�������' ������Ʈ�� ������ ������Ʈ �� ���� ���� �˻�
//		System.out.println("\n*** 06. �����ϴ� '04Ű�ٸ�������' Project ������ ���� �� ������ ���� �˻� ***");
//		System.out.println("06-1. ���� �� ������Ʈ �˻�");
//		controller.getProject("04Ű�ٸ�������");
//		controller.updateProjectBeneficiary("04Ű�ٸ�������", new Beneficiary(110, "������", "010-333-3333", "Ű�ٸ������� ������Ʈ"));
//		
//		
//		System.out.println("\n06-2. ���� �� ������Ʈ �˻�");
//		controller.getProject("04Ű�ٸ�������");
//		
//		
//		System.out.println("\n*** 07. �ǹ̾��� �������� null�� Project�� ������ ���� ���� �õ� �� ��ȿ�� ������ ���ռ� ���� ***");
//		controller.updateProjectBeneficiary("04Ű�ٸ�������", null);
//		
//
//		//'01������ó' Project ���� �� �˻�
//		System.out.println("\n*** 08. '01������ó' Project ���� �� ������ Project �˻� ***");
//		System.out.println("08-1. ������ ������Ʈ �˻�");
//		controller.getProject("01������ó");
//		controller.deleteProject("01������ó");
//		
//		System.out.println("\n08-2. ���� �� ������Ʈ �˻� ");
//		controller.getProject("01������ó");
//		
//		System.out.println("\n08-3. ������ ������Ʈ ���� ��õ� �� ��ȿ�� ������ ���ռ� ����");
//		controller.deleteProject("01������ó");
	}
}
