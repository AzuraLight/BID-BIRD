package com.project.view;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;


import com.project.controller.BidController;

/**
 * @author 이현도 본 메뉴 페이지는 사용자가 직접 대면하게 되는 ui의 기본 틀이 되는 부분으로 어플리케이션에서 호출 받은 메뉴를
 *         작성하는 페이지입니다.
 */
public class BidMenu {

	// 스캐너를 이용하여서 메뉴 번호를 입력 받을 것이고,
	// 전역 필드에 static으로 선언하여 먼저 메모리상에 올려둠
	private static Scanner sc = new Scanner(System.in);

	private BidController bidController = new BidController();

	public void displayMainmenu() {
		int choice = 0;
		
		

		do {
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣷⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡻⣿⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣶⣿⣿⣷⣤⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡈⣭⣽⣿⣿⣿⣿⣿⠏⠀⣠⣶⠿⠶⠶⠤⠤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠒⠶⠿⣿⣿⣿⣿⣿⣿⣿⣧⣴⠾⠋⠀⠀⠀⣘⣤⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠿⠿⠿⠿⠋⠁⠀⠀⠀⠀⠀⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠉⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println();
			System.out.println("                   Bid & Bird");
			System.out.println();
			System.out.println();
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀1. 로   그   인");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀2. 신규 회원 가입");
			System.out.print("\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀번호를 입력하세요 : ");
			try {
			choice = sc.nextInt();
			} catch (InputMismatchException e) {
			} catch (NullPointerException e) {
			} catch (Exception e) {
				System.out.println("잘못된 값을 입력하셨습니다.");
				System.out.println("정수를 입력하세요.");
				sc = new Scanner(System.in);
			}

	

			switch (choice) {
				
				case 1: bidController.login(inputMember()); break;
				case 2: bidController.signUp(insertInfo()); break;
				default:
				
			}
			
		} while (true);
		
	}

	private static Map<String, String> inputMember() {
		
		for(int i = 0; i < 15; i++) {
			System.out.println();
		}
		
		System.out.print("아이디를 입력하세요. : ");
		String userID = sc.next().toLowerCase();
		
		System.out.print("비밀번호를 입력하세요. : ");
		String userPWD = sc.next().toLowerCase();
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("userID", userID);
		parameter.put("userPWD", userPWD);
		
		return parameter;
	}
	
	// 회원 가입을 위한 메소드 
	public Map<String, String> insertInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요: ");
		String userID = sc.nextLine();

		System.out.println("비밀번호를 입력해주세요: ");
		String userPWD = sc.nextLine();

		System.out.println("이름를 입력해주세요: ");
		String userName = sc.nextLine();

		System.out.println("나이를 입력해주세요 : ");
		String userAge = sc.nextLine();

		System.out.println("성별를 입력해주세요: ");
		String userGender = sc.nextLine().toUpperCase();

		System.out.println("이메일를 입력해주세요: ");
		String userEmail = sc.nextLine();
	
		System.out.println("주소를 입력해주세요: ");
		String userAddress = sc.nextLine();

		System.out.println("전화번호를 입력해주세요: ");
		String userPhone = sc.nextLine();

		Map<String, String> parameter = new HashMap<>();

		parameter.put("userID", userID);
		parameter.put("userPWD", userPWD);
		parameter.put("userName", userName);
		parameter.put("userAge", userAge);
		parameter.put("userGender", userGender);
		parameter.put("userEmail", userEmail);
		parameter.put("userAddress", userAddress);
		parameter.put("userPhone", userPhone);

		return parameter;

	}
	
}
