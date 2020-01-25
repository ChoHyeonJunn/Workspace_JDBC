package com.controller;

import java.util.List;
import java.util.Scanner;

import com.dao.DAO;
import com.dto.DTO;

// ��û�� ������ �ش��ϴ� �������� �����Ѵ�!!

// ���⼭�� view�� ���� �ۼ����� �ʰ� ��Ʈ�ѷ����� Console ��� �ϰڽ��ϴ�!
public class Controller {

	private static Scanner sc = new Scanner(System.in);
	private static DAO dao = new DAO();

	public static int getMenu() {

		StringBuffer sb = new StringBuffer();
		int select = 0;

		sb.append("1. ��ü ���\n");
		sb.append("2. ���� ���\n");
		sb.append("3. ��       ��\n");
		sb.append("4. ��       ��\n");
		sb.append("5. ��       ��\n");
		sb.append("6. ��       ��\n");

		System.out.println(sb);
		System.out.println("��ȣ ���� : ");
		select = sc.nextInt();

		return select;
	}

	public static void main(String[] args) {

		int no = 0;

		do {
			no = getMenu();
			switch (no) {
			case 1:
				System.out.println("��ü���");
				selectList();
				break;
			case 2:
				System.out.println("�������");
				selectOne();
				break;
			case 3:
				System.out.println("��      ��");
				insert();
				break;
			case 4:
				System.out.println("��      ��");
				update();
				break;
			case 5:
				System.out.println("��      ��");
				delete();
				break;
			case 6:
				System.out.println("��      ��");
				sc.close();
				System.exit(0);
			}
		} while (no != 6);
	}

	private static void selectList() {
		List<DTO> list = dao.selectList();

		for (DTO dto : list) {
			System.out.println(dto);
		}
	}

	public static void selectOne() {
		System.out.println("����� �ѹ� �Է� : ");
		int num = sc.nextInt();

		///////////////////////////////////////
		DTO dto = dao.selectOne(num);
		System.out.println(dto);
	}

	public static void insert() {
		System.out.println("�߰��� ������ �Է� (����, �̸�, ����) : ");
		int num = sc.nextInt();
		String name = sc.next();
		String nickname = sc.next();

		///////////////////////////////////////
		DTO dto = new DTO(num, name, nickname);
		if (dao.insert(dto) > 0) {
			System.out.println("insert ����!!");
		} else {
			System.out.println("insert ����!!");
		}
	}

	public static void update() {
		System.out.println("��� �����͸� ����? : ");
		int num = sc.nextInt();

		System.out.println("������ ~ (�̸�, ����) : ");
		String name = sc.next();
		String nickname = sc.next();

		///////////////////////////////////////
		DTO dto = new DTO(num, name, nickname);
		if (dao.update(dto) > 0) {
			System.out.println("update ����!!");
		} else {
			System.out.println("update ����!!");
		}
	}

	public static void delete() {
		System.out.println("��� �����͸� ����? : ");
		int num = sc.nextInt();

		///////////////////////////////////////
		if (dao.delete(num) > 0) {
			System.out.println("delete ����!!");
		} else {
			System.out.println("delete ����!!");
		}
	}
}
