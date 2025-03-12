package com.es.edu.domain.dto;

import lombok.Data;

/**
 * [概要] <p>ユーザー情報出力クラス。</p>
 * [説明] <p>ユーザー情報出力クラス。</p>
 * [補充] <p>特になし。</p>
 */
@Data
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

	public void setUserSex(int userSex) {
		if (userSex == 1)
			this.userSex = "男";
		else 
			this.userSex = "女";
	}

	public UserInfoOutputDto(int userId, String userName, int userSex, String address) {
		this.userId = userId;
		this.userName = userName;
		if (userSex == 1)
			this.userSex = "男";
		else 
			this.userSex = "女";
		this.address = address;
	}
}
