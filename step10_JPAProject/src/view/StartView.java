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
		
		//�Ϸ�
		System.out.println("2. å �߰�");
		controller.addBook("å�̸�1", 22, 33);
		controller.addBook("å�̸�2", 33, 44);
		controller.addBook("å�̸�3", 44, 55);
		
		System.out.println("1. å ��ȸ  & ��� å ��ȸ");
		controller.getBook(1);
		controller.getallBooks();
		
		//å�� � ������ ������ ��? - �켱 å�̸� �������� ����
		System.out.println("3. å ��������");
		controller.updateBook(1, "����� å�̸�");
		System.out.println("����� å ���� ���");
		controller.getBook(1);
		
		System.out.println("4. å ����");
		controller.deleteBook(2);
		controller.getallBooks();
//		
//		System.out.println("5. �̿��� ��ȸ & ��� �̿��� ��ȸ");
//		controller.getUser();
//		controller.getAllUser();
//		System.out.println("6. �̿��� �߰�");
//		controller.addUser();
//		System.out.println("7. �̿��� ���� ����");
//		controller.updateUser();
//		System.out.println("8. �̿��� ����");
//		controller.deleteUser();
//		
//		System.out.println("9. �缭 ��ȸ & ��� �缭 ��ȸ");
//		controller.getLibrarian();
//		controller.getAllLibrarian();
//		System.out.println("10. �缭 �߰�");
//		controller.addLibrarian();
//		System.out.println("11. �缭 ���� ����");
//		controller.updateLibrarian();
//		System.out.println("12. �缭 ����");
//		controller.deleteLibrarian();
//		
//		System.out.println("13. �з� ��ȸ & ��� �з� ��ȸ");
//		controller.getMainCategory();
//		controller.getAllMainCategory();
//		System.out.println("14. �з� ���� ���� (���缭��)");
//		controller.updateMainCategory();
//		
//		System.out.println("15. å ����");
//		controller.rentBook();
//		System.out.println("16. å �ݳ�");
//		controller.returnBook();
	}
}