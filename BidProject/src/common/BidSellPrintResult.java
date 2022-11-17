package common;

import java.util.List;

import com.project.model.dto.BidProduct;

public class BidSellPrintResult {

	
	public void printProductList(List<BidProduct> productList) {
		
		for(BidProduct product : productList) {
			System.out.println(product);
			
		} 
	
		
	}
	
	
	public void printErrorMessage(String errorCode) {
		
		
		String errorMessage = "";
		switch(errorCode) {
			case "selectList" : errorMessage = "판매 물품 목록 조회에 실패하셨습니다."; break;
			case "insert" : errorMessage = "판매 물품 등록이 실패하였습니다."; break;
			case "update" : errorMessage = "판매 물품 수정이 실패하였습니다."; break;
			case "delete" : errorMessage = "판매 물품 삭제가 실패하였습니다."; break;
		}
		
		System.out.println(errorMessage);
			
	}
	
	
	public void printSuccessMessage(String successCode) {
		
		String successMessage = "";
		switch(successCode) {
			case "insert" : successMessage = "판매 물품 등록이 완료되었습니다."; break;
			case "update" : successMessage = "판매 물품 수정이 완료외었습니다."; break;
			case "delete" : successMessage = "판매 물품 삭제가 완료외었습니다."; break;
		
		}
		
		System.out.println(successMessage);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
