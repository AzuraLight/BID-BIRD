package com.project.controller;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.project.model.dto.MemberDTO;
import com.project.service.BidService;
import common.PrintResult;

public class BidController {

	private MemberDTO member;
	private static Scanner sc = new Scanner(System.in);
	private static PrintResult printResult;
	private final BidService bidService;
  
	
	public BidController() {
		printResult = new PrintResult();
		bidService = new BidService();
		
	}

	public void login(Map<String, String> parameter) {

		String userID = parameter.get("userID");
		String userPWD = parameter.get("userPWD");

		MemberDTO member = bidService.login(userID, userPWD);
		
		if (member != null) {
//			printResult.printmember(member);
			System.out.println("로그인에 성공하셨습니다.");

			if (member.getUserID().equals("admin")) {
				System.out.println("관리자임이 확인되었습니다.");
				System.out.println("관리자 페이지로 이동합니다.");
				moveto();
			} else {
				System.out.println("마이페이지로 이동합니다.");
				mypage();
			}

		} else {
			printResult.printErrorMessage(member);
		}

	}

	private void mypage() {
		System.out.println("================ 마이페이지 ================");
		System.out.println("1.판매 페이지");
		System.out.println("2.구매 페이지");
		System.out.println("3.사용자 정보 수정");
		System.out.println();
		System.out.print("번호를 입력하세요 : ");
		int no;

		no = sc.nextInt();
		switch (no) {
//		case 1: sellProduct(); break;
		case 2: buyProduct(); break;
//		case 3: updateMember(); break;
		default:
			break;
		}

	}

	private void moveto() {

		System.out.println("================ 관리자 페이지 ================");
		System.out.println("-------------------------------------------");
		System.out.println("1.회원 전체 조회");
		System.out.println("2.개인 회원 조회");
		System.out.println("2.회원 강제 탈퇴");
		System.out.println("9.이전 페이지로");
		System.out.println("-------------------------------------------");
		System.out.print("번호를 입력하세요 : ");
		int no;

		no = sc.nextInt();
		switch (no) {
		case 1: selectAllMember(); break;
		case 2: memberInfo(); break;
		case 3: memberDel(); break;
		case 9: return;
		default:
			break;
		}

	}

	private void selectAllMember() {
		List<MemberDTO> memberList = bidService.selectAllMember();
		
		if(memberList !=null) {
			printResult.printMemberList(memberList);
			moveto();
		} else {
			printResult.printErrorMessage("selectList");
		}
		
		
		
	}

	private void memberDel() {
		System.out.println("================ 회원 강제 탈퇴 ================");
		System.out.println("-------------------------------------------");
		System.out.println("삭제하실 회원의 아이디를 입력하세요 : ");
		System.out.println("-------------------------------------------");
		System.out.println("9.이전 메뉴로");
		System.out.println();
		System.out.print("번호를 입력하세요 : ");
		int no;

		no = sc.nextInt();
		
		switch (no) {
		case 1: deleteMember(inputMemberIDforDel()); break;
		case 9: moveto(); break;
		default:
		}
		
	}


	private void deleteMember(Map<String, String> parameter) {
		
		String userID = parameter.get("userID");

		MemberDTO member = bidService.deleteMember(userID);

	}

	private Map<String, String> inputMemberIDforDel() {
		System.out.print("아이디를 입력하세요. : ");
		String userID = sc.next();
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("userID", userID);
	
		return parameter;
	}

	private void memberInfo() {
		System.out.println("================ 회원 정보 조회 ================");
		System.out.println("-------------------------------------------");
		System.out.println("1.아이디로 검색하기");
		System.out.println("2.이름으로 검색하기");
		System.out.println("3.이메일로 검색하기");
		System.out.println("9.이전 메뉴로");
		System.out.println("-------------------------------------------");
		System.out.print("번호를 입력하세요 : ");
		int no;

		no = sc.nextInt();
		switch (no) {
		case 1: findMemberID(inputfindMemberID()); memberInfo();
		case 2: findMembreName(inputfindMemberName()); memberInfo();
		case 3: findMemberEmail(inputfindMemberEmail()); memberInfo();
		case 9: moveto(); break;
		default:
			break;
		}

	}

	

	private void findMemberEmail(Map<String, String> parameter) {
		String userEmail = parameter.get("userEmail");

		MemberDTO member = bidService.findMemberEmail(userEmail);

		if (member != null) {
			printResult.printmember(member);

		} else {
			printResult.printErrorMessage(member);
		}
		
	}

	private static Map<String, String> inputfindMemberEmail() {
		System.out.print("이메일을 입력하세요. : ");
		String userEmail = sc.next();
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("userEmail", userEmail);
	
		return parameter;
	}

	private void findMembreName(Map<String, String> parameter) {
		String userName = parameter.get("userName");

		MemberDTO member = bidService.findMembreName(userName);

		if (member != null) {
			printResult.printmember(member);

		} else {
			printResult.printErrorMessage(member);
		}
		
	}

	private static Map<String, String> inputfindMemberName() {
		System.out.print("이름을 입력하세요. : ");
		String userName = sc.next();
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("userName", userName);
	
		return parameter;
	}

	private void findMemberID(Map<String, String> parameter) {
		String userID = parameter.get("userID");

		MemberDTO member = bidService.findMemberID(userID);

		if (member != null) {
			printResult.printmember(member);

		} else {
			printResult.printErrorMessage(member);
		}
		
	}

	private static Map<String, String> inputfindMemberID() {
		System.out.print("아이디를 입력하세요. : ");
		String userID = sc.next();
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("userID", userID);
	
		return parameter;
	}

	public void signUp() {
		// TODO Auto-generated method stub

	}
	public static void buyProduct() {

		int no = 0;
		BidService bidService = new BidService();

		do {
		System.out.println("=======물품 구매 ======");
		System.out.println("1.물품 조회");
		System.out.println("2.물품 구매");
		System.out.println("3.구매 물품 확인");
		System.out.println("4.구매 물품 취소");
		System.out.println("9.이전 메뉴로");
		System.out.println();

		System.out.print("메뉴 선택 : ");
		try {
	         no = sc.nextInt();
	      } catch (InputMismatchException e) {
	         System.out.println("잘못된 값을 입력하셨습니다.");
	         System.out.println("정수를 입력하세요.");
	         sc = new Scanner(System.in);
	      }
		sc.nextLine();

		switch (no) {
		case 1:
		productSearch();
		break;
		case 2:
		purchase();
		break;
		case 3:
		purchaseConfirm();
		break;
		case 4:
		cancelPurchase();
		break;
		case 9:
		System.out.println("이전메뉴로 돌아갑니다.");
		break;
		}
		} while (true);

	}
	
	private static void cancelPurchase() {
		int no =0;
		BidService bidService = new BidService();
		do {
		System.out.println("=========== 구매 물품 취소 ============");
		System.out.println("1.구매 했던 목록 조회 ");
		System.out.println("2.구매 취소 ");
		System.out.println("9. 이전 메뉴로");
		System.out.print("메뉴 번호를 입력하세요 : ");
		try {
	         no = sc.nextInt();
	      } catch (InputMismatchException e) {
	         System.out.println("잘못된 값을 입력하셨습니다.");
	         System.out.println("정수를 입력하세요.");
	         sc = new Scanner(System.in);
	      }
		switch(no) {
		case 1 : bidService.confirm(); break;
		case 2 : bidService.cancel(inputCancel()); break;
		case 9 : return;
		}
		}while(true);
	}
	

	private static Map<String, Object> inputCancel() {
		Scanner sc = new Scanner(System.in);
		System.out.print("취소할 상품 이름을 입력하세요 :");
		String name = sc.nextLine();
		System.out.println("취소 하시려면 N을 입력하세요 :");
         String productableStatus = sc.nextLine().toUpperCase();
		
		Map<String, Object> inputCancel = new HashMap<>();
		inputCancel.put("name", name);
		inputCancel.put("productableStatus", productableStatus);
		
		return inputCancel;
	}

	private static void purchaseConfirm() {
		int no =0;
		BidService bidService = new BidService();
		do {
		System.out.println("=========== 구매 물품 확인 ============");
		System.out.println("1.구매 했던 목록 조회 ");
		
		System.out.println("9. 이전 메뉴로");
		System.out.print("메뉴 번호를 입력하세요 : ");
		try {
	         no = sc.nextInt();
	      } catch (InputMismatchException e) {
	         System.out.println("잘못된 값을 입력하셨습니다.");
	         System.out.println("정수를 입력하세요.");
	         sc = new Scanner(System.in);
	      }
		
		switch(no) {
		case 1 : bidService.confirm(); break;
		
		case 9 : return;
		}
		}while(true);
	}

	private static void purchase() {
		int no = 0;
		BidService bidService = new BidService();
		do {
		System.out.println("=========== 물품 구매 메뉴 ============");
		System.out.println("1.전체 목록 조회 ");
		System.out.println("2.구매 하기 ");
		System.out.println("9. 이전 메뉴로");
		System.out.print("메뉴 번호를 입력하세요 : ");
		try {
	         no = sc.nextInt();
	      } catch (InputMismatchException e) {
	         System.out.println("잘못된 값을 입력하셨습니다.");
	         System.out.println("정수를 입력하세요.");
	         sc = new Scanner(System.in);
	      }
		
		switch(no) {
		case 1 : bidService.searchAll(); break;
		case 2 : bidService.productPurchase(inputChangeInfo()); purchase();
		case 9 : return;
		}
		}while(true);
		
	}
		
	

	private static void productSearch() {
		int no = 0;
		BidService bidService = new BidService();
		do {
		System.out.println("=========== 물품 조회 메뉴 ============");
		System.out.println("1. 전체 조회");
		System.out.println("2. 이름 또는 사이즈로 검색");
		System.out.println("9. 이전 메뉴로");
		System.out.print("메뉴 번호를 입력하세요 : ");
		try {
	         no = sc.nextInt();
	      } catch (InputMismatchException e) {
	         System.out.println("잘못된 값을 입력하셨습니다.");
	         System.out.println("정수를 입력하세요.");
	         sc = new Scanner(System.in);
	      }
		
		switch(no) {
		case 1 : bidService.searchAll(); break;
		case 2 : bidService.searchByNameOrSize(inputSearchMap()); break;
		case 9 : return;
		}
		}while(true);
		
	}

	private static Map<String, Object>inputSearchMap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 조건을 입력하세요(name or size ) : ");
		String condition = sc.nextLine().toLowerCase();
		
		Map<String, Object> criteria = new HashMap<>();
		
		if("name".equals(condition)) {
		System.out.println("검색할 상품명을 입력하세요 : ");
		String nameValue = sc.nextLine();
		
		criteria.put("nameValue", nameValue);
		
		}else if("size".equals(condition)){ 
		System.out.println("검색할 사이즈를 입력하세요");
		char sizeValue = sc.nextLine().toUpperCase().charAt(0);
		criteria.put("sizeValue", sizeValue);
		
		
		
		}
		
		return criteria;
	}

	private static Map<String, Object> inputChangeInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("구매할 메뉴 이름을 입력하세요 :");
		String name = sc.nextLine();
		System.out.print("정말 구매 하시겠습니까(Y/N) :");
		String productableStatus = sc.nextLine().toUpperCase();
		
		Map<String, Object> changeInfo = new HashMap<>();
		
		changeInfo.put("name", name);
		changeInfo.put("productableStatus", productableStatus);
		return changeInfo;
	}
	

}
