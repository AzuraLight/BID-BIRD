/**
 * 
 */
package com.project.controller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.project.model.dto.BidProduct;
import com.project.service.BidSellService;

import common.BidSellPrintResult;

/**
 * @author 김선중
 * 뷰와 BidController에서 사용자가 입력한 정보를 가공 한 뒤 서비스쪽으로 전달 역할을 하는 페이지
 *
 */
public class BidSellController {

	private final BidSellService bidSellService;
	private final BidSellPrintResult bidSellPrintResult;
	private static Scanner sc = new Scanner(System.in);
	
	public BidSellController() {
		bidSellService = new BidSellService();
		bidSellPrintResult = new BidSellPrintResult();
		
	
	}
	/**
	 * sellProductAllSelect메소드는 판매제품전체조회 메소드입니다.
	 */
	public void sellProductAllSelect() {
		
		List<BidProduct> productList = bidSellService.sellProductAllSelect();
		
		if(productList != null) {
			bidSellPrintResult.printProductList(productList);
		}else {
			bidSellPrintResult.printErrorMessage("selectList");
		}
		
		
	}
	/**
	 * sellProductRegist메소드는 판매제품등록 메소드로 inputProduct메소드에서 parameter로 넘어온값을 
	 * product에 set으로 입력해줍니다.
	 */
	public void sellProductRegist(Map<String, String> parameter) {
		
		String pId = parameter.get("pId");
		String pName = parameter.get("pName");
		String psize = parameter.get("pSize");//먼저 parameter에서 가져온값을 String변수psize에 넣어준뒤
		char pSize = psize.charAt(0);//char자료형 변수인 pSize에 charAt()으로 psize를 형변환 시켜 넣어준다.
		String pgender = parameter.get("pGender");//==
		char pGender = pgender.charAt(0);//==
		int pPrice = Integer.parseInt(parameter.get("pPrice"));
		
		//pSize와 pGender는 char 자료형이라 char 형태로 넣어주어야한다.
		BidProduct product = new BidProduct();
		product.setpId(pId);
		product.setpName(pName);
		product.setpSize(pSize);
		product.setpGender(pGender);
		product.setpPrice(pPrice);
		
		
		if(bidSellService.sellProductRegist(product)) {
			bidSellPrintResult.printSuccessMessage("insert");
		}else {
			bidSellPrintResult.printErrorMessage("insert");
		}
		
		
	}
	/**
	 * sellProductUpdate메소드는 판매제품수정 메소드로 inputUpdateProduct메소드에서 parameter로 넘어온값을 
	 * product에 set으로 입력해줍니다.
	 */
	public void sellProductUpdate(Map<String, String> parameter) {
		String pId = parameter.get("pId");
		String pName = parameter.get("pName");
		String psize = parameter.get("pSize");
		char pSize = psize.charAt(0);
		String pgender = parameter.get("pGender");
		char pGender = pgender.charAt(0);
		int pPrice = Integer.parseInt(parameter.get("pPrice"));
		
		BidProduct product = new BidProduct();
		product.setpId(pId);
		product.setpName(pName);
		product.setpSize(pSize);
		product.setpGender(pGender);
		product.setpPrice(pPrice);
		
		if(bidSellService.sellProductUpdate(product)) {
			bidSellPrintResult.printSuccessMessage("update");
		}else {
			bidSellPrintResult.printErrorMessage("update");
		}
		
		
		
	}
	/**
	 * sellProductDelete메소드는 판매제품삭제 메소드로 inputDeleteProduct메소드에서 parameter로 값을받습니다.
	 * 
	 */
	public void sellProductDelete(Map<String, String> parameter) {
		
		String pId = parameter.get("pId");
		
		
		
		if(bidSellService.sellProductDelete(pId)) {
			bidSellPrintResult.printSuccessMessage("delete");
		}else {
			bidSellPrintResult.printErrorMessage("delete");
		}
		
	}
	


	
}
