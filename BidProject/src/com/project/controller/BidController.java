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
	private final PrintResult printResult;
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
			System.out.println("로그인에 성공하셨습니다.");
			System.out.println();

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
				System.out.println("잘못된 값을 입력하셨습니다.");
				System.out.println("정수를 입력하세요.");
				sc = new Scanner(System.in);
			}
			switch (no) {
			// case 1: sellProduct(); break;
			// case 2: buyProduct(); break;
			case 3:
				updateMember(updateInfo());
				break;
			case 4:
				deleteMemberMe(inputPWD());
				break;
			default:
				break;
			}
		}
	}

	private void deleteMemberMe(Map<String, String> parameter) {
		String userID = parameter.get("userID");
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

	private void moveto() {
		int no = 0;
		while (true) {
			System.out.println("================ 관리자 페이지 ================");
			System.out.println("-------------------------------------------");
			System.out.println("1.회원 전체 조회");
			System.out.println("2.개인 회원 조회");
			System.out.println("2.회원 강제 탈퇴");
			System.out.println("9.이전 페이지로");
			System.out.println("-------------------------------------------");
			System.out.print("번호를 입력하세요 : ");

			try {
				no = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("잘못된 값을 입력하셨습니다.");
				System.out.println("정수를 입력하세요.");
				sc = new Scanner(System.in);
			}
			switch (no) {
			case 1:
				selectAllMember();
				break;
			case 2:
				memberInfo();
				break;
			case 3:
				memberDel();
				break;
			case 9:
				return;
			default:
				break;
			}
		}
	}

	private void selectAllMember() {
		List<MemberDTO> memberList = bidService.selectAllMember();

		if (memberList != null) {
			printResult.printMemberList(memberList);
			moveto();
		} else {
			printResult.printErrorMessage("selectList");
		}

	}

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
		} catch (InputMismatchException e) {
			System.out.println("잘못된 값을 입력하셨습니다.");
			System.out.println("정수를 입력하세요.");
			sc = new Scanner(System.in);
		}
		switch (no) {
		case 1:
			deleteMember(inputMemberIDforDel());
			break;
		case 9:
			moveto();
			break;
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
		} catch (InputMismatchException e) {
			System.out.println("잘못된 값을 입력하셨습니다.");
			System.out.println("정수를 입력하세요.");
			sc = new Scanner(System.in);
		}

		switch (no) {
		case 1:
			findMemberID(inputfindMemberID());
			memberInfo();
		case 2:
			findMembreName(inputfindMemberName());
			memberInfo();
		case 3:
			findMemberEmail(inputfindMemberEmail());
			memberInfo();
		case 9:
			moveto();
			break;
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

}
