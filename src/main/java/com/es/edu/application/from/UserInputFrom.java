package com.es.edu.application.from;

import lombok.Data;

@Data
public class UserInputFrom {
	
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
}
