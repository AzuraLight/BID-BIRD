package com.project.view;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

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
				System.out.println("잘못된 값을 입력하셨습니다.");
				System.out.println("정수를 입력하세요.");
				sc = new Scanner(System.in);
			}

			switch (choice) {
				case 1: bidController.login(inputMember()); break;
				case 2: bidController.signUp(); break;
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

	
}
