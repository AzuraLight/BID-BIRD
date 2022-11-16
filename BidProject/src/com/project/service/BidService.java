/**
 * 
 */
package com.project.service;

import static common.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.project.model.dao.BidDAO;
import com.project.model.dto.MemberDTO;

/**
 * @author 이현도
 *
 */
public class BidService {

	private final BidDAO bidDAO;

	public BidService() {
		bidDAO = new BidDAO();
	}

	public MemberDTO login(String userID, String userPWD) {

		SqlSession sqlSession = getSqlSession();
	
		MemberDTO member = bidDAO.login(sqlSession, userID);

		if (userPWD.equals(member.getUserPWD())) {
			return member;

		} 
		sqlSession.close();
		return null;
		
	}

	public MemberDTO findMemberID(String userID) {
		
		SqlSession sqlSession = getSqlSession();
		
		MemberDTO member = bidDAO.findMemberID(sqlSession, userID);
		
		sqlSession.close();
		
		return member;
	}

	public MemberDTO findMembreName(String userName) {
		SqlSession sqlSession = getSqlSession();
		
		MemberDTO member = bidDAO.findMembreName(sqlSession, userName);
		
		sqlSession.close();
		
		return member;
	}

	public MemberDTO findMemberEmail(String userEmail) {
		SqlSession sqlSession = getSqlSession();
		
		MemberDTO member = bidDAO.findMemberEmail(sqlSession, userEmail);
		
		sqlSession.close();
		
		return member;
	}
	
	

	public MemberDTO deleteMember(String userID) {
		SqlSession sqlSession = getSqlSession();
		
		MemberDTO member = bidDAO.deleteMember(sqlSession, userID);
		
		sqlSession.close();
		
		return member;
	}

	public List<MemberDTO> selectAllMember() {
		
		SqlSession sqlSession = getSqlSession();
		
		List<MemberDTO> memberList = bidDAO.selectAllMember(sqlSession);
		
		sqlSession.close();
		
		return memberList;
	}
	
	public boolean signUp(MemberDTO member) {
		SqlSession sqlSession = getSqlSession();

		int result = bidDAO.signUp(sqlSession, member);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0 ? true : false;
	}

	public boolean updateMember(MemberDTO member) {
		SqlSession sqlSession = getSqlSession();

		int result = bidDAO.updateMember(sqlSession, member);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0 ? true : false;
	}

	public boolean deleteMemberMe(String userID, String userPWD) {
		SqlSession sqlSession = getSqlSession();

		int result = bidDAO.deleteMemberMe(sqlSession, userID);

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0 ? true : false;
	}

	



}
