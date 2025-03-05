package com.es.edu.domain.service;

import java.util.List;

import com.es.edu.domain.dto.UserInfoInputDto;
import com.es.edu.domain.dto.UserInfoOutputDto;

/**
 * [概要] <p>ユーザーサービスインスタンス。</p>
 * [説明] <p>ユーザーサービスインスタンス。</p>
 * [補充] <p>特になし。</p>
 */
public interface UserService {

	/**
	 * [概要] <p>ユーザー情報を取得。</p>
	 * [説明] <p>すべてのユーザー情報を取得。</p>
	 * [補充] <p>特になし。</p>
	 *
	 * @return　ユーザー情報リスト
	 */
	List<UserInfoOutputDto> selectAll();
	
	/**
	 * [概要] <p>ユーザー情報を取得。</p>
	 * [説明] <p>ユーザーIdによってユーザー情報を取得。</p>
	 * [補充] <p>特になし。</p>
	 *
	 * @param userId　ユーザーId
	 * @return　ユーザー情報
	 */
	UserInfoOutputDto selectUserEntityById(Integer userId);
	
	/**
	 * [概要] <p>ユーザー追加。</p>
	 * [説明] <p>ユーザー追加。</p>
	 * [補充] <p>特になし。</p>
	 *
	 * @param userInfoInputDto ユーザー情報
	 * @return　影響された行数
	 */
	int insertUserEntity(UserInfoInputDto userInfoInputDto);
	
	/**
	 * [概要] <p>ユーザー更新。</p>
	 * [説明] <p>ユーザーIdによってユーザー情報更新。</p>
	 * [補充] <p>特になし。</p>
	 *
	 * @param userEntity　ユーザー情報
	 * @return　影響された行数
	 */
	int updateUserEntity(UserInfoInputDto userInfoInputDto);
	
	/**
	 * [概要] <p>ユーザー削除。</p>
	 * [説明] <p>ユーザーIdによってユーザー削除。</p>
	 * [補充] <p>特になし。</p>
	 *
	 * @param userId　ユーザーId
	 * @return　影響された行数
	 */
	int deleteUserEntity(Integer userId);
}
