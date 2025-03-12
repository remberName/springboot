package com.es.edu.domain.dto;

import lombok.Data;

/**
 * [概要] <p>ユーザー情報入力クラス。</p>
 * [説明] <p>ユーザー情報入力クラス。</p>
 * [補充] <p>特になし。</p>
 */
@Data
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


	public void setUserSex(String userSex) {
		if(userSex.equals("男"))
			this.userSex = 1;
		else 
			this.userSex = 0;
	}

	public UserInfoInputDto(Integer userId, String userName, String userSex, String address) {
		this.userId = userId;
		this.userName = userName;
		if(userSex.equals("男"))
			this.userSex = 1;
		else 
			this.userSex = 0;
		this.address = address;
	}

}
