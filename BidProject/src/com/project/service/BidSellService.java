/**
 * 
 */
package com.project.service;

import static common.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.project.model.dao.BidSellMapper;
import com.project.model.dto.BidProductDTO;


public class BidSellService {
	
	public List<BidProductDTO> sellProductAllSelect() {
		
		SqlSession sqlSession = getSqlSession();
		
		BidSellMapper bidSellMapper = sqlSession.getMapper(BidSellMapper.class);
		
		List<BidProductDTO> productList = bidSellMapper.sellProductAllSelect();
		
		sqlSession.close();
		
		
		return productList;
		
		
	}

	public boolean sellProductRegist(BidProductDTO product) {
		
		SqlSession sqlSession = getSqlSession();
		
		BidSellMapper bidSellMapper = sqlSession.getMapper(BidSellMapper.class);
		int result = bidSellMapper.insertProduct(product);
		
		if(result > 0 ) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		
		
		return result > 0? true: false;
	}

	public boolean sellProductUpdate(BidProductDTO product) {
		
		SqlSession sqlSession = getSqlSession();
		
		BidSellMapper bidSellMapper = sqlSession.getMapper(BidSellMapper.class);
		int result = bidSellMapper.updateProduct(product);
		
		if(result > 0 ) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		
		return result > 0? true: false;
	}

	public boolean sellProductDelete(String pId) {
		
		SqlSession sqlSession = getSqlSession();
		
		BidSellMapper bidSellMapper = sqlSession.getMapper(BidSellMapper.class);
		int result = bidSellMapper.deleteProduct(pId);
		
		if(result > 0 ) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		
		return result > 0? true: false;
	}

}
