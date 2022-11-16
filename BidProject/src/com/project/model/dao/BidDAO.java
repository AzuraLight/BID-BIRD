package com.project.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

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

	public int signUp(SqlSession sqlSession, MemberDTO member) {

		return sqlSession.insert("BidMapper.signUp", member);
	}
	

	public int updateMemebr(SqlSession sqlSession, MemberDTO member) {
		return sqlSession.update("BidMapper.updateMember", member);	
		}

	public int deleteMemberMe(SqlSession sqlSession, String userID) {
		return sqlSession.delete("BidMapper.deleteMemberMe", userID);

	}

}
