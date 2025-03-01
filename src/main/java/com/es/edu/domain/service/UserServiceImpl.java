package com.es.edu.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.edu.domain.dto.UserInfoInputDto;
import com.es.edu.domain.dto.UserInfoOutputDto;
import com.es.edu.infra.entity.UserEntity;
import com.es.edu.infra.repository.UserRepository;

/**
 * [概要] <p>ユーザーサービスクラス。</p>
 * [説明] <p>ユーザー操作を行うサービスクラス。。</p>
 * [補充] <p>特になし。</p>
 */
@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * [概要] <p>ユーザー情報を取得。</p>
	 * [説明] <p>すべてのユーザー情報を取得。</p>
	 * [補充] <p>特になし。</p>
	 *
	 * @return　ユーザー情報リスト
	 */
	@Override
	public List<UserInfoOutputDto> selectAll() {

		List<UserEntity> userEntities = userRepository.selectAll();
		List<UserInfoOutputDto> userInfoOutputDtos = new ArrayList<>();
		userEntities.forEach(userEntity -> {
			userInfoOutputDtos.add(new UserInfoOutputDto(userEntity.getUserId(), userEntity.getUserName(),
					userEntity.getUserSex(), userEntity.getAddress()));
		});
		return userInfoOutputDtos;
	}

	/**
	 * [概要] <p>ユーザー情報を取得。</p>
	 * [説明] <p>ユーザーIdによってユーザー情報を取得。</p>
	 * [補充] <p>特になし。</p>
	 *
	 * @param userEntityId　ユーザーId
	 * @return　ユーザー情報
	 */
	@Override
	public UserInfoOutputDto selectUserEntityById(Integer userEntityId) {
		UserEntity userEntity = userRepository.selectUserEntityById(userEntityId);
		return new UserInfoOutputDto(userEntity.getUserId(), userEntity.getUserName(), userEntity.getUserSex(), userEntity.getAddress());
	}

	/**
	 * [概要] <p>ユーザー追加。</p>
	 * [説明] <p>ユーザー追加。</p>
	 * [補充] <p>特になし。</p>
	 *
	 * @param userInfoInputDto ユーザー情報
	 * @return　影響された行数
	 */
	@Override
	public int insertUserEntity(UserInfoInputDto userInfoInputDto) {
		UserEntity userEntity = new UserEntity(userInfoInputDto.getUserId(),userInfoInputDto.getUserName(),userInfoInputDto.getUserSex(),userInfoInputDto.getAddress());
		return userRepository.insertUserEntity(userEntity);
	}

	/**
	 * [概要] <p>ユーザー更新。</p>
	 * [説明] <p>ユーザーIdによってユーザー情報更新。</p>
	 * [補充] <p>特になし。</p>
	 *
	 * @param userEntity　ユーザー情報
	 * @return　影響された行数
	 */
	@Override
	public int updateUserEntity(UserInfoInputDto userInfoInputDto) {
		UserEntity userEntity = new UserEntity(userInfoInputDto.getUserId(),userInfoInputDto.getUserName(),userInfoInputDto.getUserSex(),userInfoInputDto.getAddress());
		return userRepository.updateUserEntity(userEntity);
	}

	/**
	 * [概要] <p>ユーザー削除。</p>
	 * [説明] <p>ユーザーIdによってユーザー削除。</p>
	 * [補充] <p>特になし。</p>
	 *
	 * @param userEntityId　ユーザーId
	 * @return　影響された行数
	 */
	@Override
	public int deleteUserEntity(Integer userEntityId) {
		
		return userRepository.deleteUserEntity(userEntityId);
	}
	
}
