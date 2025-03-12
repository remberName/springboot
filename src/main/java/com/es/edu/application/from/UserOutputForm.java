package com.es.edu.application.from;

import java.util.List;

import com.es.edu.domain.dto.UserInfoInputDto;
import com.es.edu.domain.dto.UserInfoOutputDto;

import lombok.Data;

/**
 * [概要] <p>ユーザーフォームクラス。</p>
 * [説明] <p>ユーザーフォームクラス。</p>
 * [補充] <p>特になし。</p>
 */
@Data
public class UserOutputForm {

	/**
	 * ユーザー入力リスト
	 */
	private List<UserInfoInputDto> userInfoInputList;
	
	/**
	 * 実行結果メッセージ
	 */
	private String message;
	
	/**
	 * ユーザー出力リスト
	 */
	private List<UserInfoOutputDto> userInfoOutputList;
	
	/**
	 * 実行して影響された行数
	 */
	private Integer rows;
	
	/**
	 * 実行状態
	 */
	private Integer status;
	
}
