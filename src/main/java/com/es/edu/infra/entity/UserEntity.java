package com.es.edu.infra.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * [概要] <p>ユーザーエンティティクラス。</p>
 * [説明] <p>ユーザーエンティティクラス。</p>
 * [補充] <p>特になし。</p>
 */
@Data
@AllArgsConstructor
@JsonSerialize
public class UserEntity {

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

	public int getUserSex() {
		return userSex;
	}

	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserEntity(int userId, String userName, int userSex, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.address = address;
	}

	public UserEntity() {
		super();
	}
	
}
