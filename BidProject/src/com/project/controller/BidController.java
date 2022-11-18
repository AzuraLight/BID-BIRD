package com.project.controller;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.project.model.dto.MemberDTO;
import com.project.service.BidService;
import com.project.view.BidMenu;

import common.PrintResult;

/*
 * <pre>
 * Class : BidController
 * Comment : 해당 클래스는 주로 메뉴에서 호출하였던 객체들의 기능을 구현하고 서비스 클래스를 호출하는 역할을 담당합니다.
 * author : 이현도
 */
public class BidController {

	private MemberDTO member;
	private static Scanner sc = new Scanner(System.in);
	private final PrintResult printResult;
	private final BidService bidService;
	private static BidSellController bidSellController;

	/**
	 * 기초 생성자를 통해 주입하는 방법을 사용하여 미리 객체를 선언해둡니다.
	 */
	public BidController() {
		printResult = new PrintResult();
		bidService = new BidService();
		this.bidSellController = new BidSellController();
	}

	/*
	 * login 메소드는 메뉴에서 입력 받은 값들을 넘겨 받아 DB를 통해 아이디를 조회하고, 관리자인지 아닌지 확인 후 관리자일 경우 관리자 페이지로 이동하며
	 * 관리자가 아닌 경우 마이페이지 즉 개인 회원 페이지로 이동하는 기능을 작성하였습니다.
	 */
	public void login(Map<String, String> parameter) {

		String userID = parameter.get("userID");
		String userPWD = parameter.get("userPWD");

		MemberDTO member = bidService.login(userID, userPWD);

		// member 객체가 null 값이 아니면 로그인 성공
		if (member != null) {
			System.out.println("로그인에 성공하셨습니다.");
			System.out.println();

			//가져온 id가 입력 받은 "admin"과 동일하면 관리자이므로 관리자 페이지로 이동
			if (member.getUserID().equals("admin")) {
				System.out.println("관리자임이 확인되었습니다.");
				System.out.println("관리자 페이지로 이동합니다.");
				
				//관리자 페이지로 이동하는 메소드르 호출
				moveto();
				
			//"admin" 과 일치 하지 않으면 일반 회원이므로 일반 회원 페이지인 마이페이지로 이동
			} else {
				System.out.println("마이페이지로 이동합니다.");
				
				//마이 페이지로 이동하는 메소드를 호출
				mypage();
			}

		} else {
			
			printResult.printErrorMessage(member);
		}
	}

	/*
	 * login에서 관리자가 아닌 경우 mypage 메소드를 호출하여 넘어오고, 마이페이지에서는 회원이 사용하는 주요 기능인 1.판매 2.구매 3.사용자 정보 수정 4.탈퇴 
	 * 등의 기능을 호출하는 역할을 담당합니다. 
	 */
	private void mypage() {
		int no = 0;
		while (true) {
			System.out.println("================ 마이페이지 ================");
			System.out.println("-------------------------------------------");
			System.out.println("1.판매 페이지");
			System.out.println("2.구매 페이지");
			System.out.println("3.사용자 정보 수정");
			System.out.println("4.회원 탈퇴");
			System.out.println("-------------------------------------------");
			System.out.print("번호를 입력하세요 : ");

			try {
				no = sc.nextInt();
			} catch (InputMismatchException e) {
			} catch (NullPointerException e) {
			} catch (Exception e) {
				System.out.println("잘못된 값을 입력하셨습니다.");
				System.out.println("정수를 입력하세요.");
				sc = new Scanner(System.in);
			}
			switch (no) {

			case 1: sellProduct(); break;
			case 2: buyProduct(); break;
			case 3: updateMember(updateInfo()); break;
			case 4: deleteMemberMe(inputPWD()); break;
			default:
				break;
			}
		}
	}
	
	/**
	 * sellProduct메소드는 마이페이지에서 판매페이지로 넘어왔을때 처음으로 보여지는 메인판메페이지 메소드입니다.
	 */
	
	private void sellProduct() {
		
		int choice= 0;
		
		do {
		System.out.println("================= 물품 판매 ========================");
		System.out.println("1. 판매 물품 등록");
		System.out.println("2. 판매 물품 수정");
		System.out.println("3. 판매 물품 삭제");
		System.out.println("4. 판매 물품 확인");
		System.out.println("9. 마이페이지로");
		System.out.print("\n번호를 입력하세요 : ");

			
		try {
			 choice = sc.nextInt();
		} catch(InputMismatchException e) {
			 System.out.println("잘못된 값을 입력하셨습니다.!!!!!!!!!!!!!!!");
	         System.out.println("정수를 입력하세요.");
	         sc = new Scanner(System.in);
		}
		sc.nextLine();
			
		switch (choice) {
		case 1:
			bidSellController.sellProductRegist(inputProduct());//컨트롤러에 판매제품등록으로이동
			break;
		case 2:
			bidSellController.sellProductUpdate(inputUpdateProduct());//컨트롤러에 판매제품수정으로이동
			break;
		case 3: 
			bidSellController.sellProductDelete(inputDeleteProduct()); //컨트롤러에 판매제품삭제로이동
			break;
		case 4:
			bidSellController.sellProductAllSelect();//컨트롤러에 판매제품전체조회으로로이동
			break;
		case 9:
			System.out.println("이전메뉴로 돌아갑니다."); mypage();
		default:
			System.out.println("번호를 잘못입력하였습니다.");//잘못입력시 출력되는 문구
		}
		
		}while (true);
	} 

	public void signUp(Map<String, String> parameter) {

		String userID = parameter.get("userID");
		String userPWD = parameter.get("userPWD");
		String userName = parameter.get("userName");
		int userAge = Integer.parseInt(parameter.get("userAge"));
		String UserGender = parameter.get("userGender");
		char userGender = UserGender.charAt(0);
		String userEmail = parameter.get("userEmail");
		String userAddress = parameter.get("userAddress");
		String userPhone = parameter.get("userPhone");

		MemberDTO member = new MemberDTO();
		member.setUserID(userID);
		member.setUserPWD(userPWD);
		member.setUserName(userName);
		member.setUserAge(userAge);
		member.setUserGender(userGender);
		member.setUserEmail(userEmail);
		member.setUserAddress(userAddress);
		member.setUserPhone(userPhone);

		if (bidService.signUp(member)) {
			printResult.printSuccessMessage("insert");
		} else {
			printResult.printErrorMessage("insert");
		}

	}
	
	public void updateMember(Map<String, String> parameter) {
		String userID = parameter.get("userID");
		String userName = parameter.get("userName");
		String userPWD = parameter.get("userPWD");
		String userEmail = parameter.get("userEmail");
		String userAddress = parameter.get("userAddress");
		String userPhone = parameter.get("userPhone");
		
		
		MemberDTO member = new MemberDTO();
		member.setUserID(userID);
		member.setUserName(userName);
		member.setUserPWD(userPWD);
		member.setUserEmail(userEmail);
		member.setUserAddress(userAddress);
		member.setUserPhone(userPhone);

		if (bidService.updateMember(member)) {
			printResult.printSuccessMessage("update");
		} else {
			printResult.printErrorMessage("update");
		}
				
	}
	public Map<String, String> updateInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 아이디를 입력하세요 : ");
		String userID = sc.nextLine();
		System.out.println("변경할 이름를 입력해주세요:");
		String userName = sc.nextLine();
		System.out.println("변경할 비밀번호를 입력해주세요: ");
		String userPWD = sc.nextLine();
		System.out.println("변경할 이메일를 입력해주세요: ");
		String userEmail = sc.nextLine();
		System.out.println("변경할 전화번호를 입력해주세요: ");
		String userAddress = sc.nextLine();
		System.out.println("변경할 주소를 입력해주세요: ");
		String userPhone = sc.nextLine();

		Map<String, String> parameter = new HashMap<>();
		parameter.put("userID", userID);
		parameter.put("userName", userName);
		parameter.put("userPWD", userPWD);
		parameter.put("userEmail", userEmail);
		parameter.put("userAddress", userAddress);
		parameter.put("userPhone", userPhone);

		return parameter;

	}
	
	
	private void deleteMemberMe(Map<String, String> parameter) {
		System.out.println("ID를 다시 입력해주세요: ");
		String userID = parameter.get("userID");
		System.out.println("비밀번호를 다시 입력해주세요: ");
		String userPWD = parameter.get("userPWD");
		if (bidService.deleteMemberMe(userID, userPWD)) {
			printResult.printSuccessMessage("delete");
		} else {
			printResult.printErrorMessage("delete");
		}

	}

	private static Map<String, String> inputPWD() {
		System.out.println("아이디를 다시 입력해주세요: ");
		String userID = sc.next();
		System.out.println("비밀번호를 다시 입력해주세요: ");
		String userPWD = sc.next();
		Map<String, String> parameter = new HashMap<>();
		parameter.put("userID", userID);
		parameter.put("userPWD", userPWD);
		return parameter;
	}

	
	/**
	 * login 메소드에서 관리자 일 경우 호출하여 넘어오는 메소드로서 관리자 페이지에서는 DB에 등록되어 있는 회원 전체 조회하는 기능과 개인 회원 조회 및 회원 탈퇴 기능을 수행합니다. 
	 */
	private void moveto() {
		int no = 0;
		while (true) {
			System.out.println("================ 관리자 페이지 ================");
			System.out.println("-------------------------------------------");
			System.out.println("1.회원 전체 조회");
			System.out.println("2.개인 회원 조회");
			System.out.println("3.회원 강제 탈퇴");
			System.out.println("9.이전 페이지로");
			System.out.println("-------------------------------------------");
			System.out.print("번호를 입력하세요 : ");

			try {
				
				no = sc.nextInt();
			
			// 숫자 대신 다른 글자를 입력 할 수 있으므로 try catch 블럭으로 간단하게 예외처리를 해둡니다.	
			} catch (InputMismatchException e) {
				System.out.println("잘못된 값을 입력하셨습니다.");
				System.out.println("정수를 입력하세요.");
				sc = new Scanner(System.in);
			}
			switch (no) {
			case 1: selectAllMember(); break;
			case 2: memberInfo(); break;
			case 3: memberDel(); break;
			case 9: return;
			default: break;
				
			}
		}
	}

	
	/**
	 * selectAllMember 메소드는 회원 전체를 조회하고 출력하기 위한 메소드 입니다.
	 */
	private void selectAllMember() {
		List<MemberDTO> memberList = bidService.selectAllMember();

		if (memberList != null) {
			printResult.printMemberList(memberList);
			
			moveto();
		} else {
			printResult.printErrorMessage("selectList");
		}

	}

	/**
	 * memberDel 메소드는 회원 삭제를 위한 메소드로서 deleteMember 메소드를 호출한뒤 아이디를 입력 받은 후 해당 회원의 삭제를 실행하는 메소드입니다.
	 */
	private void memberDel() {
		int no = 0;

		System.out.println("================ 회원 강제 탈퇴 ================");
		System.out.println("-------------------------------------------");
		System.out.println("1.회원 삭제");
		System.out.println("-------------------------------------------");
		System.out.println("9.이전 메뉴로");
		System.out.println();
		System.out.print("번호를 입력하세요 : ");

		try {
			
			no = sc.nextInt();
			
		// 숫자 대신 다른 글자를 입력 할 수 있으므로 try catch 블럭으로 간단하게 예외처리를 해둡니다.	
		} catch (InputMismatchException e) {
			System.out.println("잘못된 값을 입력하셨습니다.");
			System.out.println("정수를 입력하세요.");
			sc = new Scanner(System.in);
		}
		switch (no) {
		case 1: deleteMember(inputMemberIDforDel()); break;
		case 9: moveto(); break;
		default:
		}

	}

	/**
	 * 회원 삭제 기능을 수행하기 위한 메소드로 아이디를 서비스로 넘겨주는 역할을 합니다.
	 */
	private void deleteMember(Map<String, String> parameter) {

		String userID = parameter.get("userID");

		MemberDTO member = bidService.deleteMember(userID);

	}

	/**
	 * memberDel에서 회원 삭제를 위해 정보를 입력 받는 메소드로서 아이디를 입력 받고 
	 * @return 값을 parameter로 하여 deleteMember 메소드에 저장된 정보를 넘겨주는 역할을 합니다. 
	 */
	private Map<String, String> inputMemberIDforDel() {
		System.out.print("아이디를 입력하세요. : ");
		String userID = sc.next();

		Map<String, String> parameter = new HashMap<>();
		parameter.put("userID", userID);

		return parameter;
	}

	/**
	 * memberInfo 메소드는 1.아이디 2.이름 3.이메일 검색하기를 통해 회원 개인을 조회 할 수 있도록 메소드를 호출하는 역할을 합니다. 
	 */
	private void memberInfo() {
		int no = 0;

		System.out.println("================ 회원 정보 조회 ================");
		System.out.println("-------------------------------------------");
		System.out.println("1.아이디로 검색하기");
		System.out.println("2.이름으로 검색하기");
		System.out.println("3.이메일로 검색하기");
		System.out.println("9.이전 메뉴로");
		System.out.println("-------------------------------------------");
		System.out.print("번호를 입력하세요 : ");

		try {
			
			no = sc.nextInt();

		// 숫자 대신 다른 글자를 입력 할 수 있으므로 try catch 블럭으로 간단하게 예외처리를 해둡니다.		
		} catch (InputMismatchException e) {
			System.out.println("잘못된 값을 입력하셨습니다.");
			System.out.println("정수를 입력하세요.");
			sc = new Scanner(System.in);
		}

		switch (no) {
		case 1: findMemberID(inputfindMemberID()); memberInfo();
		case 2: findMembreName(inputfindMemberName()); memberInfo();
		case 3: findMemberEmail(inputfindMemberEmail()); memberInfo();
		case 9: moveto(); break;
		default: break;
		}

	}

	/**
	 * inputfindMemberEmail 메소드에서 입력 받은 이메일을 서비스로 넘겨주는 역할을 합니다.
	 */
	private void findMemberEmail(Map<String, String> parameter) {
		String userEmail = parameter.get("userEmail");

		MemberDTO member = bidService.findMemberEmail(userEmail);

		if (member != null) {
			printResult.printmember(member);

		} else {
			printResult.printErrorMessage(member);
		}

	}

	/**
	 * memberInfo에서 개인 회원 조회를 위해 정보를 입력 받는 메소드로서 이메일을 입력 받고 
	 * @return 값을 parameter로 하여 findMemberEmail 메소드에 저장된 정보를 넘겨주는 역할을 합니다. 
	 */
	private static Map<String, String> inputfindMemberEmail() {
		System.out.print("이메일을 입력하세요. : ");
		String userEmail = sc.next();

		Map<String, String> parameter = new HashMap<>();
		parameter.put("userEmail", userEmail);

		return parameter;
	}

	
	/**
	 * inputfindMemberName 메소드에서 입력 받은 이름을 서비스로 넘겨주는 역할을 합니다.
	 */
	private void findMembreName(Map<String, String> parameter) {
		String userName = parameter.get("userName");

		MemberDTO member = bidService.findMembreName(userName);

		if (member != null) {
			printResult.printmember(member);

		} else {
			printResult.printErrorMessage(member);
		}

	}

	/**
	 * memberInfo에서 개인 회원 조회를 위해 정보를 입력 받는 메소드로서 이름을 입력 받고 
	 * @return 값을 parameter로 하여 findMembreName 메소드에 저장된 정보를 넘겨주는 역할을 합니다. 
	 */
	private static Map<String, String> inputfindMemberName() {
		System.out.print("이름을 입력하세요. : ");
		String userName = sc.next();

		Map<String, String> parameter = new HashMap<>();
		parameter.put("userName", userName);

		return parameter;
	}

	/**
	 * inputfindMemberID 메소드에서 입력 받은 아이디를 서비스로 넘겨주는 역할을 합니다.
	 */
	private void findMemberID(Map<String, String> parameter) {
		String userID = parameter.get("userID");

		MemberDTO member = bidService.findMemberID(userID);

		if (member != null) {
			printResult.printmember(member);

		} else {
			printResult.printErrorMessage(member);
		}

	}

	/**
	 * memberInfo에서 개인 회원 조회를 위해 정보를 입력 받는 메소드로서 아이디를 입력 받고 
	 * @return 값을 parameter로 하여 findMembreName 메소드에 저장된 정보를 넘겨주는 역할을 합니다. 
	 */
	private static Map<String, String> inputfindMemberID() {
		System.out.print("아이디를 입력하세요. : ");
		String userID = sc.next();

		Map<String, String> parameter = new HashMap<>();
		parameter.put("userID", userID);

		return parameter;
	}
	
	public void buyProduct() {

		int no = 0;
		BidService bidService = new BidService();

		do {
			System.out.println("=========== 구매 페이지 ============");
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
			case 1: productSearch(); break;
			case 2: purchase(); break;
			case 3: purchaseConfirm(); break;
			case 4: cancelPurchase(); break;
			case 9: System.out.println("이전메뉴로 돌아갑니다."); mypage();
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
		System.out.print("구매할 메뉴 이름을 입력하세요 :");
		String name = sc.nextLine();
		System.out.print("정말 구매 하시겠습니까(Y/N) :");
		String productableStatus = sc.nextLine().toUpperCase();
		
		Map<String, Object> changeInfo = new HashMap<>();
		
		changeInfo.put("name", name);
		changeInfo.put("productableStatus", productableStatus);
		return changeInfo;
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
	/**
	 * inputDeleteProduct메소드는 판매제품삭제 메소드입니다.
	 */
	private static Map<String, String> inputDeleteProduct() {
		
		Scanner sc= new Scanner(System.in);//스캐너 생성
		System.out.println("삭제할 제품 아이디를 입력하세요 : ");//삭제할제품아이디 출력문
		String pId = sc.nextLine();//스캐너로 입력받은값을 넣어줌
		
		
		Map<String, String> parameter = new HashMap<>();//map과 hashMap으로 parameter에 key value값에 put으로 입력
		parameter.put("pId", pId);
		
		
		return parameter; // parameter로 리턴
	}
	
	
	/**
	 * inputUpdateProduct메소드는 판매제품수정 메소드입니다.
	 */
	private static Map<String, String> inputUpdateProduct() {

		bidSellController.sellProductAllSelect();//판매중인제품전체조회메소드를 불러옴 
		System.out.println("------------------------------------");
		System.out.println("수정하실 제품 아이디를 입력하세요 : ");
		String pId = sc.next();
		
		System.out.println("제품명을 입력하세요 : ");
		String pName = sc.next();
		
		System.out.println("제품 사이즈를 입력하세요 : ");
		String pSize = sc.next().toUpperCase();
		
		System.out.println("제품 성별을 입력하세요 : ");
		String pGender = sc.next().toUpperCase();
		
		System.out.println("제품 가격을 입력하세요 : ");
		String pPrice = sc.next();
		Map<String, String> parameter = new HashMap<>();
		parameter.put("pId", pId);
		parameter.put("pName", pName);
		parameter.put("pSize", pSize);
		parameter.put("pGender", pGender);
		parameter.put("pPrice", pPrice);

		return parameter;

		
		
	}
	/**
	 * inputProduct메소드는 판매제품등록 메소드입니다.
	 */
	private static Map<String, String> inputProduct() {

		System.out.println("제품 아이디를 입력하세요 : ");
		String pId = sc.next();
		
		System.out.println("제품명을 입력하세요 : ");
		String pName = sc.next();
		
		System.out.println("제품 사이즈를 입력하세요(S,M,L) : ");
		String pSize = sc.next().toUpperCase();
		
		sc.nextLine();
		System.out.println("제품 성별을 입력하세요(M,F) : ");
		String pGender = sc.next().toUpperCase();
		
		System.out.println("제품 가격을 입력하세요 : ");
		String pPrice = sc.next();

		Map<String, String> parameter = new HashMap<>();
		parameter.put("pId", pId);
		parameter.put("pName", pName);
		parameter.put("pSize", pSize);
		parameter.put("pGender", pGender);
		parameter.put("pPrice", pPrice);

		return parameter;
	}
	
}
