package com.cg.mms.model;

import java.util.Date;

public class PurchaseDetails {

	private Integer purchaseId;
	private String cName;
	private String mailId;
	private Long phoneNumber;
	private Date purchaseDate;
	private Integer mobile_id; 
	
	public PurchaseDetails() {
		// TODO Auto-generated constructor stub
	}

	public PurchaseDetails(Integer purchaseId, String cName, String mailId, Long phoneNumber, Date purchaseDate,
			Integer mobile_id) {
		super();
		this.purchaseId = purchaseId;
		this.cName = cName;
		this.mailId = mailId;
		this.phoneNumber = phoneNumber;
		this.purchaseDate = purchaseDate;
		this.mobile_id = mobile_id;
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getMobile_id() {
		return mobile_id;
	}

	public void setMobile_id(Integer mobile_id) {
		this.mobile_id = mobile_id;
	}
	
	
}
