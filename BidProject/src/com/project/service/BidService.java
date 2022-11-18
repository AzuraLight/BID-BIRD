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


/*
 * <pre>
 * Class : BidService
 * Comment : 해당 클래스는 컨트롤러에서 필요로 하는 기능을 제공하며, DAO를 통해서 데이터에 접근하고 기능을 수행하는데 필요한 로직을 수행합니다.
 * author : 이현도
 */
public class BidService {

	private final BidDAO bidDAO;

	public BidService() {
		bidDAO = new BidDAO();
	}

	/* 로그인 처리용 메소드 */
	public MemberDTO login(String userID, String userPWD) {

		
		SqlSession sqlSession = getSqlSession();

		// DAO의 로그인 메소드를 호출하여 결과를 리턴 받음
		MemberDTO member = bidDAO.login(sqlSession, userID);

		// 유저가 입력한 비밀번호가 DB에 존재하는 비밀번호와 일치하는지 확인
		if (userPWD.equals(member.getUserPWD())) {
			
			//일치하는 경우 반환 받은 값을 리턴
			return member;

		}
		
		sqlSession.close();
		return null;
	}

	/* 아이디로 회원을 조회하기 위한 메소드 */
	public MemberDTO findMemberID(String userID) {

		SqlSession sqlSession = getSqlSession();

		// DAO의 아이디로 회원을 조회하는 메소드를 호출하여 결과를 리턴 받음
		MemberDTO member = bidDAO.findMemberID(sqlSession, userID);

		sqlSession.close();

		//반환 받은 값을 리턴
		return member;
	}

	/* 이름으로 회원을 조회하기 위한 메소드 */
	public MemberDTO findMembreName(String userName) {
		
		SqlSession sqlSession = getSqlSession();

		// DAO의 이름으로 회원을 조회하는 메소드를 호출하여 결과를 리턴 받음
		MemberDTO member = bidDAO.findMembreName(sqlSession, userName);

		sqlSession.close();

		//반환 받은 값을 리턴
		return member;
	}

	/* 이메일로 회원을 조회하기 위한 메소드 */
	public MemberDTO findMemberEmail(String userEmail) {
		SqlSession sqlSession = getSqlSession();

		// DAO의 이메일로 회원을 조회하는 메소드를 호출하여 결과를 리턴 받음
		MemberDTO member = bidDAO.findMemberEmail(sqlSession, userEmail);

		sqlSession.close();

		//반환 받은 값을 리턴
		return member;
	}

	/* 회원 삭제를 위한 메소드 */
	public MemberDTO deleteMember(String userID) {
		
		SqlSession sqlSession = getSqlSession();

		// DAO의 회원 삭제를 위한 메소드를 호출하여 결과를 리턴 받음
		MemberDTO member = bidDAO.deleteMember(sqlSession, userID);

		sqlSession.close();

		//반환 받은 값을 리턴
		return member;
	}

	/* 전체 회원을 조회하기 위한 메소드 */
	public List<MemberDTO> selectAllMember() {

		SqlSession sqlSession = getSqlSession();

		// DAO의 회원 전체 조회용 메소드를 호출하여 결과를 리턴 받음
		List<MemberDTO> memberList = bidDAO.selectAllMember(sqlSession);

		sqlSession.close();

		//반환 받은 값을 리턴
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

	/* 전체 상품을 조회하기 위한 메소드 */
	public List<BidProduct> searchAll() {
		SqlSession sqlSession = getSqlSession();

		// DAO의 상품 전체 조회용 메소드를 호출하여 결과를 리턴 받음
		List<BidProduct> bidList = bidDAO.searchAll(sqlSession);

		if (bidList != null) {
			System.out.println(bidList + "검색되었습니다");

		}

		sqlSession.close();
		
		//반환 받은 값을 리턴
		return bidList;

	}
	/*  상품을 사이즈, 이름으로  조회하기 위한 메소드 */
	public void searchByNameOrSize(Map<String, Object> criteria) {
		SqlSession sqlSession = getSqlSession();

		// DAO의 사이즈,이름으로 상품 조회용 메소드를 호출하여 출력
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
	/*  상품을 구매 하기 위한 메소드 */

	public void productPurchase(Map<String, Object> changeInfo) {
		SqlSession sqlSession = getSqlSession();

		// DAO의  상품 구매용 메소드를 호출하여 출력
		List<BidProduct> result = bidDAO.productPurchase(sqlSession, changeInfo);

		if (result != null) {

			System.out.println("구매에 성공하셨습니다.");
			sqlSession.commit();

		} else {
			System.out.println("다시 입력하세요");
			sqlSession.rollback();
		}
		sqlSession.close();
	}
	/*  구매 했던 상품을 조회하기 위한 메소드 */
	public void confirm() {
		SqlSession sqlSession = getSqlSession();
		
		// DAO의 구매했던 상품 조회용 메소드를 호출하여 출력
		List<BidProduct> bidList = bidDAO.confirm(sqlSession);
		System.out.println(bidList + "조회 되었습니다");

		sqlSession.close();

	}
	/*  구매 했던 상품을 취소하기 위한 메소드 */

	public void cancel(Map<String, Object> inputCancel) {
		SqlSession sqlSession = getSqlSession();
		
		// DAO의 구매했던 상품 취소용 메소드를 호출하여 출력
		List<BidProduct> bidList = bidDAO.cancel(sqlSession, inputCancel);

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
