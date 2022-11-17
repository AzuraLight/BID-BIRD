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


public class BidSellService {
	
	private final BidDAO bidDAO;
	
	public BidSellService() {
		bidDAO = new BidDAO();
	}
	
	public List<BidProduct> sellProductAllSelect() {
		
		SqlSession sqlSession = getSqlSession();
		
		
		List<BidProduct> productList = bidDAO.sellProductAllSelect(sqlSession);
		
		if(productList != null) {
	         System.out.println(productList + "전체판매물품이조회되었습니다.");
	      }
		
		sqlSession.close();
		
		
		return productList;
		
		
	}

	public boolean sellProductRegist(BidProduct product) {
		
		SqlSession sqlSession = getSqlSession();
		
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

	public boolean sellProductUpdate(BidProduct product) {
		
		SqlSession sqlSession = getSqlSession();
		
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

	public boolean sellProductDelete(String pId) {
		
		SqlSession sqlSession = getSqlSession();
		
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
