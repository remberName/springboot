package com.es.edu.infra.entity.gen;

import lombok.Data;

/**
 * [概要] <p>ユーザーエンティティ拡張クラス。</p>
 * [説明] <p>ユーザーエンティティ拡張クラス。</p>
 * [補充] <p>特になし。</p>
 */
@Data
public class UserExpEntity {

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
	
	/**
	 * 拡張フェルト追加
	 */
	
}
