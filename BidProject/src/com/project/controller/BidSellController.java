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
 * @author 이현도
 * 뷰에서 사용자가 입력한 정보를 가공 한 뒤 서비스쪽으로 전달 역할을 하는 페이지
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

	public void sellProductAllSelect() {
		
		List<BidProduct> productList = bidSellService.sellProductAllSelect();
		
		if(productList != null) {
			bidSellPrintResult.printProductList(productList);
		}else {
			bidSellPrintResult.printErrorMessage("selectList");
		}
		
		
	}

	public void sellProductRegist(Map<String, String> parameter) {
		
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
		
		
		if(bidSellService.sellProductRegist(product)) {
			bidSellPrintResult.printSuccessMessage("insert");
		}else {
			bidSellPrintResult.printErrorMessage("insert");
		}
		
		
	}

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

	public void sellProductDelete(Map<String, String> parameter) {
		
		String pId = parameter.get("pId");
		
		
		
		if(bidSellService.sellProductDelete(pId)) {
			bidSellPrintResult.printSuccessMessage("delete");
		}else {
			bidSellPrintResult.printErrorMessage("delete");
		}
		
	}
	


	
}
