package com.project.run;

import com.project.view.BidMenu;


/*
 * <pre>
 * Class : Application
 * Comment : 해당 클래스는 메인 메뉴를 실행 시키기 위한 어플리케이션으로 작성둔 메뉴를 호출하는 기능만을 담당합니다.
 * author : 이현도
 */
public class Application {

	/**
	 * 
	 * @author 이현도
	 * 어플리케이션 클래스에서는 메뉴를 실행 시키기 위한 메인 메소드에
	 * 뷰에서 작성한 메소드를 객체로 호출하여서 실행시킵니다.
	 */
	public static void main(String[] args) {
		
		
		BidMenu bidMenu = new BidMenu();
		bidMenu.displayMainmenu();
		

		 
	}

}
