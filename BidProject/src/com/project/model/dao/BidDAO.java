package com.project.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.project.model.dto.BidProduct;
import com.project.model.dto.BidProduct;
import com.project.model.dto.MemberDTO;

/*
 * <pre> 
 * Class : BidDAO
 * Comment : Mapper와 연동하여 DB를 통하여 CRUD 작업을 처리하는 기능을 합니다.
 * (이현도) BidDAO 처음 작성
 * (이현도) DB를 조회하여 로그인처리 메소드, DB에 회원 조회 그리고 관리자용 회원 삭제 메소드 작성
 * (이지형) DB에 새로운 회원 정보 추가 & 정보 수정 & 탈퇴 메소드 작성
 * author : 이현도
 */
public class BidDAO {

	/* DB를 읽어들여 로그인을 처리하기 위한 메소드 */
	public MemberDTO login(SqlSession sqlSession, String userID) {

		return sqlSession.selectOne("BidMapper.login", userID);
	}

	/* DB를 읽어들여 아이디로 회원을 조회하는 기능을 처리하기 위한 메소드 */
	public MemberDTO findMemberID(SqlSession sqlSession, String userID) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("BidMapper.findMemberID", userID);
	}

	/* DB를 읽어들여 이름으로 회원을 조회하는 기능을 처리하기 위한 메소드 */
	public MemberDTO findMembreName(SqlSession sqlSession, String userName) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("BidMapper.findMembreName", userName);
	}

	/* DB를 읽어들여 이메일로 회원을 조회하는 기능을 처리하기 위한 메소드 */
	public MemberDTO findMemberEmail(SqlSession sqlSession, String userEmail) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("BidMapper.findMemberEmail", userEmail);
	}

	/* DB를 읽어들여 회원 삭제 기능을 처리하기 위한 메소드 */
	public MemberDTO deleteMember(SqlSession sqlSession, String userID) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("BidMapper.deleteMember", userID);
	}

	/* DB를 읽어들여 회원 전체를 조회하는 기능을 처리하기 위한 메소드 */
	public List<MemberDTO> selectAllMember(SqlSession sqlSession) {

		return sqlSession.selectList("BidMapper.selectAllMember");

	}

	/* DB에 입력받은 새로운 값들을 추가하기 위한 메소드 */
	public int signUp(SqlSession sqlSession, MemberDTO member) {

		return sqlSession.insert("BidMapper.signUp", member);
	}
	
	/* DB에 입력받은 수정된 정보을 처리하기 위한 메소드 */
	public int updateMember(SqlSession sqlSession, MemberDTO member) {
		return sqlSession.update("BidMapper.updateMemebr", member);	

	}
	
	/* DB에 회원 탈퇴를 처리하기 위한 메소드 */
	public int deleteMemberMe(SqlSession sqlSession, String userID) {
		return sqlSession.delete("BidMapper.deleteMemberMe", userID);

	}

	public List<BidProduct> searchAll(SqlSession sqlSession) {
		System.out.println(sqlSession);
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

	public List<BidProduct> sellProductAllSelect(SqlSession sqlSession) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("BidMapper.sellProductAllSelect");
	}

	public int insertProduct(SqlSession sqlSession, BidProduct product) {
		// TODO Auto-generated method stub
		return sqlSession.insert("BidMapper.insertProduct", product);
	}

	public int updateProduct(SqlSession sqlSession, BidProduct product) {
		// TODO Auto-generated method stub
		return sqlSession.update("BidMapper.updateProduct", product);
	}

	public int deleteProduct(SqlSession sqlSession, String pId) {
		// TODO Auto-generated method stub
		return sqlSession.update("BidMapper.deleteProduct", pId);
	}

}
