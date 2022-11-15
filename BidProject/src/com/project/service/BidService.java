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
}
