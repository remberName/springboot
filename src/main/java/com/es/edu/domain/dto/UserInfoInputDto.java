package com.es.edu.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * [概要] <p>ユーザー情報入力クラス。</p>
 * [説明] <p>ユーザー情報入力クラス。</p>
 * [補充] <p>特になし。</p>
 */
@Data
@AllArgsConstructor
public class UserInfoInputDto {

	/**
	 * ユーザーId
	 */
	private Integer userId;
	
	/**
	 * ユーザー名
	 */
	private String userName;
	
	/**
	 * ユーザー性別
	 */
	private int userSex;
	
	/**
	 * ユーザーアドレス
	 */
	private String address;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		if(userSex.equals("男"))
			this.userSex = 1;
		else 
			this.userSex = 0;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserInfoInputDto(int userId, String userName, String userSex, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		if(userSex.equals("男"))
			this.userSex = 1;
		else 
			this.userSex = 0;
		this.address = address;
	}

	public UserInfoInputDto() {
	}
}
