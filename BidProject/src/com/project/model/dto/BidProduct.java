package com.project.model.dto;

public class BidProduct {

	private String pId;
	private String pName;
	private char pSize;
	private char pGender;
	private int pPrice;
	
	public BidProduct() {
		// TODO Auto-generated constructor stub
	}

	public BidProduct(String pId, String pName, char pSize, char pGender, int pPrice) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pSize = pSize;
		this.pGender = pGender;
		this.pPrice = pPrice;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public char getpSize() {
		return pSize;
	}

	public void setpSize(char pSize) {
		this.pSize = pSize;
	}

	public char getpGender() {
		return pGender;
	}

	public void setpGender(char pGender) {
		this.pGender = pGender;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	@Override
	public String toString() {
		return "BidProduct [P_ID=" + pId + ", P_Name=" + pName + ", P_Size=" + pSize + 
				", P_Gender=" + pGender + ", P_Price=" + pPrice +"]";
	}
	
}
