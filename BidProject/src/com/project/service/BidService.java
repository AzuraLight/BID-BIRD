/**
 * 
 */
package com.project.service;

import static common.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.project.model.dao.BidDAO;
import com.project.model.dto.BidProduct;
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
	
	   public List<BidProduct> searchAll() {
		SqlSession sqlSession = getSqlSession();

		List<BidProduct> bidList = bidDAO.searchAll(sqlSession);

		if(bidList != null) {
		    System.out.println(bidList + "검색되었습니다");
			
		}

		sqlSession.close();
		return bidList;

	}

	public void searchByNameOrSize(Map<String, Object> criteria) {
		SqlSession sqlSession = getSqlSession();

		
		List<BidProduct> bidList = bidDAO.searchByNameOrSize(sqlSession, criteria);
		
		if (bidList != null && bidList.size() > 0) {
			for (BidProduct menu : bidList) {
				System.out.println(menu + "검색되었습니다");
			}
		} else {
			System.out.println("검색결과가 존재하지 않습니다");
		}

		sqlSession.close();

	}

	public void productPurchase(Map<String, Object> changeInfo) {
		SqlSession sqlSession = getSqlSession();
		
		
		List<BidProduct> result = bidDAO.productPurchase(sqlSession, changeInfo);

		if (result != null ) {
			
			System.out.println("구매에 성공하셨습니다.");
			sqlSession.commit();

		} else {
			System.out.println("다시 입력하세요");
			sqlSession.rollback();
		}
		sqlSession.close();
	}

	public void confirm() {
		SqlSession sqlSession = getSqlSession();
		List<BidProduct> bidList = bidDAO.confirm(sqlSession);
		System.out.println(bidList + "조회 되었습니다");
		
		sqlSession.close();
		

		
	}

	public void cancel(Map<String, Object> inputCancel) {
		SqlSession sqlSession = getSqlSession();
		List<BidProduct> bidList = bidDAO.cancel(sqlSession,inputCancel);
		
		List<BidProduct> result = bidDAO.productPurchase(sqlSession, inputCancel);
		
		if (result != null) {
			System.out.println("환불 되었습니다");
			sqlSession.commit();

		} else {
			System.out.println("다시 입력하세요");
			sqlSession.rollback();
		}
		sqlSession.close();
	}
}
