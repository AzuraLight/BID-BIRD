package com.project.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.project.model.dto.MemberDTO;


public class BidDAO {

	public MemberDTO login(SqlSession sqlSession, String userID) {
		
		return sqlSession.selectOne("BidMapper.login", userID);
	}
	
//	public List<MemberDTO> printAll(SqlSession sqlSession, String userID) {
//		
//		return sqlSession.selectList("BidMapper.login");
//	}




}
