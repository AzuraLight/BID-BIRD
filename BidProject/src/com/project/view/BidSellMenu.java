package com.project.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.project.controller.BidSellController;
import com.project.model.dto.BidProductDTO;

public class BidSellMenu {

	// 스캐너를 이용하여서 메뉴 번호를 입력 받을 것이고,
	// 전역 필드에 static으로 선언하여 먼저 메모리상에 올려둠
	private static Scanner sc = new Scanner(System.in);

	private static BidSellController bidSellController = new BidSellController();

	
	//판매페이지 메인화면
	public void displayMainSellMenu() {

		int choice;// 변수하나선언

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
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀1. 판매 물품 등록");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀2. 판매 물품 수정");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀3. 판매 물품 삭제");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀4. 판매 물품 확인");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀8. 종료하기");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀9. 마이페이지로");
			System.out.print("\n  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  번호를 입력하세요 : ");

			choice = sc.nextInt();//스캐너로 입력받을값을 choice에 담기

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
			case 8:
				System.out.println("프로그램을 종료합니다");// 프로그램 종료
				return;
			case 9:
				//뒤로가기 마이페이지로 이동인데 아직 연결을 못하였다
				break;
			default:
				System.out.println("번호를 잘못입력하였습니다.");//잘못입력시 출력되는 문구
			}
		} while (true);

	}
	
	
	//판매제품삭제
	private static Map<String, String> inputDeleteProduct() {
		
		Scanner sc= new Scanner(System.in);//스캐너 생성
		System.out.println("삭제할 제품 아이디를 입력하세요 : ");//삭제할제품아이디 출력문
		String pId = sc.nextLine();//스캐너로 입력받은값을 넣어줌
		
		
		Map<String, String> parameter = new HashMap<>();//map과 hashMap으로 parameter에 key value값에 put으로 입력
		parameter.put("pId", pId);
		
		
		return parameter; // parameter로 리턴
	}
	
	
	//판매제품수정
	private static Map<String, String> inputUpdateProduct() {

		bidSellController.sellProductAllSelect();//판매중인제품전체조회메소드를 불러옴 
		System.out.println("------------------------------------");
		System.out.println("수정할 물품 id선택 : ");

		String productId = sc.nextLine();

		
			System.out.println("제품 아이디를 입력하세요 : ");
			String pId = sc.nextLine();
			System.out.println("제품명을 입력하세요 : ");
			String pName = sc.nextLine();
			System.out.println("제품 사이즈를 입력하세요 : ");
			String pSize = sc.nextLine().toUpperCase();
			System.out.println("제품 성별을 입력하세요 : ");
			String pGender = sc.nextLine().toUpperCase();
			System.out.println("제품 가격을 입력하세요 : ");
			String pPrice = sc.nextLine();

			Map<String, String> parameter = new HashMap<>();
			parameter.put("pId", pId);
			parameter.put("pName", pName);
			parameter.put("pSize", pSize);
			parameter.put("pGender", pGender);
			parameter.put("pPrice", pPrice);

			return parameter;

		
		
	}
	//판매제품등록
	private static Map<String, String> inputProduct() {

		Scanner sc = new Scanner(System.in);
		System.out.println("제품 아이디를 입력하세요 : ");
		String pId = sc.nextLine();
		System.out.println("제품명을 입력하세요 : ");
		String pName = sc.nextLine();
		System.out.println("제품 사이즈를 입력하세요(S,M,L) : ");
		String pSize = sc.nextLine();
		System.out.println("제품 성별을 입력하세요(M,F) : ");
		String pGender = sc.nextLine();
		System.out.println("제품 가격을 입력하세요 : ");
		String pPrice = sc.nextLine();

		Map<String, String> parameter = new HashMap<>();
		parameter.put("pId", pId);
		parameter.put("pName", pName);
		parameter.put("pSize", pSize);
		parameter.put("pGender", pGender);
		parameter.put("pPrice", pPrice);

		return parameter;
	}
}
