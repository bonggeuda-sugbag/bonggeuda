package com.bonnggeuda.sugbag.user.dto;

import java.util.List;

public class UserInfoDTO {

	private int userNo;
	private String name;
	private String email;
	private String phoneNumber;
	private String detail;
	
	public UserInfoDTO() {}

	public UserInfoDTO(int userNo, String name, String email, String phoneNumber, String detail) {
		super();
		this.userNo = userNo;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.detail = detail;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getDetail() {
		return detail;
	}



	public void setDetail(String detail) {
		this.detail = detail;
	}



	@Override
	public String toString() {
		return "UserInfoDTO [userNo=" + userNo + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", detail=" + detail + "]";
	}

	
	
	
	
	
}
