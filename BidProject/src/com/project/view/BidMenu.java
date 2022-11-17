package com.project.view;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;


import com.project.controller.BidController;


/*
 * <pre>
 * Class : BidMenu
 * Comment : 본 메뉴 클래스는 사용자가 직접 대면하게 되는 ui의 기본 틀이 되는 부분으로 어플리케이션에서 호출 받은 메뉴를 작성하는 페이지입니다.
 * History
 * (이현도) BidMenu 처음 작성 & 메인메뉴 작성 & 로그인 메소드 작성
 * (이지형) 가입을 위한 정보를 입력 받는 메소드 작성
 * author : 이현도
 */ 
public class BidMenu {

	//스캐너를 이용하여서 메뉴 번호를 입력 받을 것이고, 전역 필드에 static으로 작성으로써 다른 메소드에서도 사용 가능하게 선언해둡니다.
	private static Scanner sc = new Scanner(System.in);

	//컨트롤러 객체를 호출해서 쓰기 위해 미리 선언해둡니다.
	private BidController bidController = new BidController();

	/**
	 * 
	 * disPlayMainMenu() 메소드는 콘솔 창을 시작 했을 때 첫 화면을 담당하는 부분이고
	 * 해당 메소드는 컨트롤러에 있는 로그인 기능과 회원가입 기능을 호출합니다.
	 * 
     */
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
			
				// 숫자 대신 다른 글자를 입력 할 수 있으므로 try catch 블럭으로 간단하게 예외처리를 해둡니다.
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

	/**
	 * inputMember에서는 로그인을 위한 아이디와 비밀번호 값을 입력 받고 값을 넘겨줍니다.
	 * for문은 공백을 반복문으로 찍어 첫 화면인 Memu 창과 간격을 두기 위한 부분입니다. 
	 * @return parameter에 입력 받은 아이디와 비밀번호를 받아서 리턴합니다. 
	 */
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
	
	/*새로운 회원의 정보 값을 받기 위한 메소드 */
	public Map<String, String> insertInfo() {
		
		//스캐너로 값을 입력 받음
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

		//입력받은 키값을 파라미터로 키값 저장. 
		Map<String, String> parameter = new HashMap<>();

		parameter.put("userID", userID);
		parameter.put("userPWD", userPWD);
		parameter.put("userName", userName);
		parameter.put("userAge", userAge);
		parameter.put("userGender", userGender);
		parameter.put("userEmail", userEmail);
		parameter.put("userAddress", userAddress);
		parameter.put("userPhone", userPhone);

		//파라미터 값 반환
		return parameter;

	}
	
}
