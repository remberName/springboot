package com.es.edu.application.from;

import lombok.Data;
/**
 * [概要] <p>ユーザー入力フォームクラス。</p>
 * [説明] <p>ユーザーフォームクラス。</p>
 * [補充] <p>特になし。</p>
 */
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
