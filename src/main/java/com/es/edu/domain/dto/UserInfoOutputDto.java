package com.es.edu.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * [概要] <p>ユーザー情報出力クラス。</p>
 * [説明] <p>ユーザー情報出力クラス。</p>
 * [補充] <p>特になし。</p>
 */
@Data
@AllArgsConstructor
public class UserInfoOutputDto {

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
	private String userSex;
	
	/**
	 * ユーザーアドレス
	 */
	private String address;

	public int getUserId() {
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

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(int userSex) {
		if (userSex == 1)
			this.userSex = "男";
		else 
			this.userSex = "女";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserInfoOutputDto(int userId, String userName, int userSex, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		if (userSex == 1)
			this.userSex = "男";
		else 
			this.userSex = "女";
		this.address = address;
	}

	public UserInfoOutputDto() {
	}
}
