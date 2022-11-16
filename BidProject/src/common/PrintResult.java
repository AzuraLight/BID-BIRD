package common;

import java.util.List;

import com.project.model.dto.BidProduct;
import com.project.model.dto.MemberDTO;

public class PrintResult {
	
	public void printMemberList(List<MemberDTO> memberList) {
		
		for(MemberDTO member : memberList) {
			System.out.println(member);
		}
	}
	
	public void printmember(MemberDTO member) {
		System.out.println(member);
	}
	
	public void printSuccessMessage(String successCode) {
		
		String successMessage = "";
		switch(successCode) {
			case "insert" : successMessage = "신규 등록에 성공하셨습니다."; break;
			case "update" : successMessage = "수정에 성공하셨습니다."; break;
			case "delete" : successMessage = "삭제에 성공하셨습니다."; break;
		}
		
		System.out.println(successMessage);
	}
	
	public void printErrorMessage(String errorCode) {// 각 메소드에서 호출시케이스마다 추가하면서 하자
		
		String errorMessage = "";
		switch(errorCode) {
			case "selectList" : errorMessage = "목록 조회에 실패하셨습니다."; break;
			case "selectOne" : errorMessage = "조회에 실패하셨습니다."; break;
			case "insert" : errorMessage = "등록에 실패하셨습니다."; break;
			case "update" : errorMessage = "수정에 실패하셨습니다."; break;
			case "delete" : errorMessage = "삭제에 실패하셨습니다."; break;
		}
		
		System.out.println(errorMessage);
	}

	public void printErrorMessage(MemberDTO member) {
		// TODO Auto-generated method stub
		
	}
	

	public void printProductList(List<BidProduct> productList) {

		for (BidProduct product : productList) {
			System.out.println(product);

		}

	}

	public void printErrorMessage1(String errorCode) {

		String errorMessage = "";
		switch (errorCode) {
		case "buyList":
			errorMessage = "구매 물품 목록 조회에 실패하셨습니다.";
			break;

		}

		System.out.println(errorMessage);

	}

	public void printSuccessMessage1(String successCode) {

		String successMessage = "";
		switch (successCode) {
		case "insert":
			successMessage = "구매가  완료되었습니다.";
			break;

		}
	}
	
}
