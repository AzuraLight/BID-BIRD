package com.project.model.dto;

public class BidProduct {

	private String pId;
	private String pName;
	private char pSize;
	private char pGender;
	private int pPrice;
	
	private char productableStatus;
	public BidProduct() {
		// TODO Auto-generated constructor stub
	}
	public BidProduct(String pId, String pName, char pSize, char pGender, int pPrice, char productableStatus) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pSize = pSize;
		this.pGender = pGender;
		this.pPrice = pPrice;
		this.productableStatus = productableStatus;
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
	public char getProductableStatus() {
		return productableStatus;
	}
	public void setProductableStatus(char productableStatus) {
		this.productableStatus = productableStatus;
	}
	@Override
	public String toString() {
		return "BidProduct [pId=" + pId + ", pName=" + pName + ", pSize=" + pSize + ", pGender=" + pGender + ", pPrice="
				+ pPrice + ", productableStatus=" + productableStatus + "]";
	}
	
	
	
}
	
