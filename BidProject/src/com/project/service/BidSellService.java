/**
 * 
 */
package com.project.service;

import static common.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.project.model.dao.BidDAO;
import com.project.model.dao.BidSellMapper;
import com.project.model.dto.BidProduct;


/*
 * <pre>
 * Class : BidSellService
 * Comment : 해당 클래스는 컨트롤러에서 필요로 하는 기능을 제공하며, DAO를 통해서 데이터에 접근하고 기능을 수행하는데 필요한 로직을 수행합니다.
 * author : 김선중
 */

public class BidSellService {
	
	private final BidDAO bidDAO;
	
	public BidSellService() {
		bidDAO = new BidDAO();
	}
	
	/* 판매제품전체조회 메소드 */
	public List<BidProduct> sellProductAllSelect() {
		
		SqlSession sqlSession = getSqlSession();
		
		//리스트로 DAO의 sellProductAllSelect메소드를 호출하여 결과를 리턴받음
		List<BidProduct> productList = bidDAO.sellProductAllSelect(sqlSession);
		
		//productList가 null이 아니고 값이 있을때 전체판매물품리스트와 조회가되었다는 메세지 출력
		if(productList != null) {
	         System.out.println(productList + "전체판매물품이조회되었습니다.");
	      }
		
		sqlSession.close();
		
		//반환 받은 값을 리턴
		return productList;
		
		
	}
	/* 판매제품등록 메소드 */
	public boolean sellProductRegist(BidProduct product) {
		
		SqlSession sqlSession = getSqlSession();
		
		//DAO의 판매제품등록를 위한 메소드를 호출하여 결과를 리턴받음
		int result = bidDAO.insertProduct(sqlSession, product);
		
		if(result > 0 ) {
			System.out.println(product + "판매물품등록에 성공하셨습니다.");
			sqlSession.commit();
		}else {
			System.out.println("판매물품등록에 실패하셨습니다. 다시입력하세요.");
			sqlSession.rollback();
		}
		
		sqlSession.close();
			
		return result > 0? true: false;
	}
	/* 판매제품수정 메소드 */
	public boolean sellProductUpdate(BidProduct product) {
		
		SqlSession sqlSession = getSqlSession();
		
		//DAO의 판매제품수정를 위한 메소드를 호출하여 결과를 리턴받음
		int result = bidDAO.updateProduct(sqlSession, product);
		
		if(result > 0 ) {
			System.out.println(product +"판매물품수정에 성공하셨습니다.");
			sqlSession.commit();
		}else {
			System.out.println("판매물품수정에 실패하셨습니다. 다시입력하세요.");
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
	}
	/* 판매제품삭제를 위한 메소드 */
	public boolean sellProductDelete(String pId) {
		
		SqlSession sqlSession = getSqlSession();
		
		//DAO의 판매제품삭제를 위한 메소드를 호출하여 결과를 리턴받음
		int result = bidDAO.deleteProduct(sqlSession, pId);
		
		if(result > 0 ) {
			System.out.println("판매물품삭제에 성공하셨습니다.");
			sqlSession.commit();
		}else {
			System.out.println("판매물품삭제에 실패하셨습니다. 다시입력하세요.");
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
	}

}
