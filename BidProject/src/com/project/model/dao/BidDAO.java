package com.project.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.project.model.dto.BidProduct;
import com.project.model.dto.MemberDTO;


public class BidDAO {

	public MemberDTO login(SqlSession sqlSession, String userID) {
		
		return sqlSession.selectOne("BidMapper.login", userID);
	}

	public MemberDTO findMemberID(SqlSession sqlSession, String userID) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("BidMapper.findMemberID", userID);
	}

	public MemberDTO findMembreName(SqlSession sqlSession, String userName) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("BidMapper.findMembreName", userName);
	}

	public MemberDTO findMemberEmail(SqlSession sqlSession, String userEmail) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("BidMapper.findMemberEmail", userEmail);
	}

	public MemberDTO deleteMember(SqlSession sqlSession, String userID) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("BidMapper.deleteMember", userID);
	}

	public List<MemberDTO> selectAllMember(SqlSession sqlSession) {
		
		return sqlSession.selectList("BidMapper.selectAllMember");
		
	}

	public int updateMember(SqlSession sqlSession, MemberDTO member) {
		// TODO Auto-generated method stub
		return sqlSession.update("BidMapper.updateMember", member);
				
	}

	public List<BidProduct> searchAll(SqlSession sqlSession) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("BidMapper.searchAll");
	}

	public List<BidProduct> searchByNameOrSize(SqlSession sqlSession, Map<String, Object> criteria) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("BidMapper.searchByNameOrSize", criteria);
	}

	public List<BidProduct> productPurchase(SqlSession sqlSession, Map<String, Object> changeInfo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("BidMapper.productPurchase", changeInfo);
	}

	public List<BidProduct> confirm(SqlSession sqlSession) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("BidMapper.confirm");
	}

	public List<BidProduct> cancel(SqlSession sqlSession, Map<String, Object> inputCancel) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("BidMapper.cancel",inputCancel);
	}





}
