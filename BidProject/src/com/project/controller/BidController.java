package com.project.controller;

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
//		case 2: buyProduct(); break;
//		case 3: updateMember(); break;
		default:
			break;
		}

	}

	private void moveto() {

		System.out.println("================ 관리자 페이지 ================");
		System.out.println("-------------------------------------------");
		System.out.println("1.회원 정보 조회");
		System.out.println("2.회원 강제 탈퇴");
		System.out.println("3.공지 사항 등록");
		System.out.println("4.공지 사항 수정");
		System.out.println("5.공지 사항 삭제");
		System.out.println("-------------------------------------------");
		System.out.print("번호를 입력하세요 : ");
		int no;

		no = sc.nextInt();
		switch (no) {
		case 1: memberInfo(); break;
//		case 2: memberDel(); break
//		case 3: addNotify(); break;
//		case 4: updateNotify(); break;
//		case 5: deleteNotify(); break;
		default:
			break;
		}

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
//		case 1: findMemberID(); break;
//		case 2: findMembreName(); break;
//		case 3: findMemberEmail(); break;
		case 9: moveto(); break;
		default:
			break;
		}

	}

	public void signUp() {
		// TODO Auto-generated method stub

	}

}
