package com.es.edu.infra.entity;

import lombok.Data;

/**
 * [概要] <p>ユーザーエンティティクラス。</p>
 * [説明] <p>ユーザーエンティティクラス。</p>
 * [補充] <p>特になし。</p>
 */
@Data
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

	public UserEntity(Integer userId, String userName, int userSex, String address) {
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.address = address;
	}
	
}
