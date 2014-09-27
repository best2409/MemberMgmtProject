package com.example.membermgmtproject;

public class Member {
	private String userName;
	private String userPwd;
	private String userEmail;
	
	public Member(String userName, String userPwd, String userEmail) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
