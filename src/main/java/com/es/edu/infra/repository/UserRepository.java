package com.es.edu.infra.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.es.edu.infra.entity.UserEntity;

/**
 * [概要] <p>ユーザーマップインスタンス。</p>
 * [説明] <p>ユーザーマップインスタンス。</p>
 * [補充] <p>特になし。</p>
 */
@Mapper
public interface UserRepository {
	
	/**
	 * [概要] <p>ユーザー情報を取得。</p>
	 * [説明] <p>すべてのユーザー情報を取得。</p>
	 * [補充] <p>特になし。</p>
	 *
	 * @return　ユーザー情報リスト
	 */
	List<UserEntity> selectAll();
	
	/**
	 * [概要] <p>ユーザー情報を取得。</p>
	 * [説明] <p>ユーザーIdによってユーザー情報を取得。</p>
	 * [補充] <p>特になし。</p>
	 *
	 * @param userEntityId　ユーザーId
	 * @return　ユーザー情報
	 */
	UserEntity selectUserEntityById(Integer userEntityId);
	
	/**
	 * [概要] <p>ユーザー追加。</p>
	 * [説明] <p>ユーザー追加。</p>
	 * [補充] <p>特になし。</p>
	 *
	 * @param userEntity ユーザー情報
	 * @return　影響された行数
	 */
	int insertUserEntity(UserEntity userEntity);
	
	/**
	 * [概要] <p>ユーザー更新。</p>
	 * [説明] <p>ユーザーIdによってユーザー情報更新。</p>
	 * [補充] <p>特になし。</p>
	 *
	 * @param userEntity　ユーザー情報
	 * @return　影響された行数
	 */
	int updateUserEntity(UserEntity userEntity);
	
	/**
	 * [概要] <p>ユーザー削除。</p>
	 * [説明] <p>ユーザーIdによってユーザー削除。</p>
	 * [補充] <p>特になし。</p>
	 *
	 * @param userEntityId　ユーザーId
	 * @return　影響された行数
	 */
	int deleteUserEntity(Integer userEntityId);
	
}
