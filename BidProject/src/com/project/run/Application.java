package com.project.run;

import com.project.view.BidMenu;
import com.project.view.BidSellMenu;

/**
 * @author 이현도
 * 해당 페이지는 메인 메뉴를 실행 시키기 위한 어플리케이션으로
 * 단순 호출만을 위한 페이지입니다.
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BidMenu bidMenu = new BidMenu();
		bidMenu.displayMainmenu();
		
		
		//판매페이지 실행
		//BidSellMenu bidSellMenu = new BidSellMenu();
		//bidSellMenu.displayMainSellMenu();
		 
	}

}
