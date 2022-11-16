/**
 * 
 */
package com.project.model.dto;

import java.sql.Date;

import org.apache.ibatis.session.SqlSession;

/**
 * @author MSI
 *
 */
public class MemberDTO {

	private String userID;
	private String userPWD;
	private String userName;
	private int userAge;
	private char userGender;
	private String userEmail;
	private String userPhone;
	private String userAddress;
	private char memberStatus;
	private char mcStatus;
	private Date enrollDate;
	private char adminStatus; 
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}



	public MemberDTO(String userID, String userPWD, String userName, int userAge, char userGender, String userEmail,
			String userPhone, String userAddress, char memberStatus, char mcStatus, Date enrollDate, char adminStatus) {
		super();
		this.userID = userID;
		this.userPWD = userPWD;
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.memberStatus = memberStatus;
		this.mcStatus = mcStatus;
		this.enrollDate = enrollDate;
		this.adminStatus = adminStatus;
	}
	
	

	public String getUserID() {
		return userID;
	}



	public void setUserID(String userID) {
		this.userID = userID;
	}



	public String getUserPWD() {
		return userPWD;
	}



	public void setUserPWD(String userPWD) {
		this.userPWD = userPWD;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public int getUserAge() {
		return userAge;
	}



	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}



	public char getUserGender() {
		return userGender;
	}



	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public String getUserPhone() {
		return userPhone;
	}



	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}



	public String getUserAddress() {
		return userAddress;
	}



	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}



	public char getMemberStatus() {
		return memberStatus;
	}



	public void setMemberStatus(char memberStatus) {
		this.memberStatus = memberStatus;
	}



	public char getMcStatus() {
		return mcStatus;
	}



	public void setMcStatus(char mcStatus) {
		this.mcStatus = mcStatus;
	}



	public Date getEnrollDate() {
		return enrollDate;
	}



	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}



	public char getAdminStatus() {
		return adminStatus;
	}



	public void setAdminStatus(char adminStatus) {
		this.adminStatus = adminStatus;
	}



//	@Override
//	public String toString() {
//		return "| 회원 아이디 : " + userID + " | 회원 비밀번호 : " + userPWD + " | 회원명 : " + userName + " | 회원 나이 : "
//				+ userAge + " | 회원 성별 : " + userGender + " | 회원 이메일 : " + userEmail + " | 회원 주소 : "+ userAddress + " | 회원 휴대폰 번호 : " + userPhone
//				+ " | 회원 가입 상태 : " + memberStatus + " | 쿠폰 상태 : " + mcStatus + " | 가입일 : " + enrollDate + "|";
//	}	
	
	@Override
	public String toString() {
		return "| 회원 아이디 : " + userID + " | 회원명 : " + userName + " | 회원 나이 : "
				+ userAge + " | 회원 성별 : " + userGender + " | 회원 이메일 : " + userEmail + " | 회원 주소 : "+ userAddress + " | 회원 휴대폰 번호 : " + userPhone
				+ " | 회원 가입 상태 : " + memberStatus + " | 가입일 : " + enrollDate + "|";
	}	
	
}
