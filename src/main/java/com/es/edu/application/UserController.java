package com.es.edu.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es.edu.application.from.UserInputFrom;
import com.es.edu.application.from.UserOutputForm;
import com.es.edu.domain.dto.UserInfoInputDto;
import com.es.edu.domain.dto.UserInfoOutputDto;
import com.es.edu.domain.service.UserService;

import lombok.RequiredArgsConstructor;

/**
 * [概要] <p>ユーザー情報操作コントローラクラス。</p>
 * [説明] <p>ユーザー情報操作コントローラクラス。</p>
 * [補充] <p>特になし。</p>
 */
@RestController
@RequestMapping("/api/users")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * [概要] <p>ユーザー情報を全て取得。</p>
     * [説明] <p>ユーザー情報を全て取得。</p>
     * [補充] <p>特になし。</p>
     *
     * @return ユーザーフォーム
     */
    @GetMapping
    public UserOutputForm getAllUsers() {
    	
    	List<UserInfoOutputDto> userInfoOutputDtos = userService.selectAll();
    	UserOutputForm userForm = new UserOutputForm();
    	userForm.setUserInfoOutputList(userInfoOutputDtos);
        return userForm;
    }

    /**
     * [概要] <p>ユーザー情報を取得（ユーザーIDによる検索）。</p>
     * [説明] <p>。</p>
     * [補充] <p>特になし。</p>
     *
     * @param userId ユーザーID
     * @return ユーザー情報
     */
    @GetMapping("/{userId}")
    public ResponseEntity<UserOutputForm> getUserById(@PathVariable Integer userId) {
    	
    	UserInfoOutputDto userInfoOutputDto = userService.selectUserEntityById(userId);
        UserOutputForm userForm = new UserOutputForm();
        List<UserInfoOutputDto> userInfoOutputDtos = new ArrayList<>();
        userInfoOutputDtos.add(userInfoOutputDto);
        userForm.setUserInfoOutputList(userInfoOutputDtos);
        if (userInfoOutputDto != null) {
            return ResponseEntity.ok(userForm);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * [概要] <p>ユーザー情報を追加。</p>
     * [説明] <p>ユーザー情報を追加。</p>
     * [補充] <p>特になし。</p>
     *
     * @param userInputFrom ユーザー情報
     * @return　ユーザーフォーム
     */
    @PutMapping("/addUser")
    public UserOutputForm addUser(@RequestBody UserInputFrom userInputFrom) {
    	
    	UserInfoInputDto userInfoInputDto = new UserInfoInputDto(userInputFrom.getUserId(), userInputFrom.getUserName(), userInputFrom.getUserSex(), userInputFrom.getAddress());
        // 追加処理
        int rows = userService.insertUserEntity(userInfoInputDto);
        UserOutputForm userForm = new UserOutputForm();
        userForm.setRows(rows);
        if (rows == 0) {
        	userForm.setStatus(500);
        	userForm.setMessage("追加失敗しました。");
        } else {
        	userForm.setStatus(201);
        	userForm.setMessage("追加成功しました。");
        }
        return userForm;
    }

    /**
     * [概要] <p>ユーザー情報を更新。</p>
     * [説明] <p>ユーザー情報を更新（ユーザーIDによる更新）。</p>
     * [補充] <p>特になし。</p>
     *
     * @param userInputFrom　ユーザー情報
     * @return ユーザーフォーム
     */
    @PutMapping("/updateUser")
    public UserOutputForm updateUser(@RequestBody UserInputFrom userInputFrom) {
    	
    	UserInfoInputDto userInfoInputDto = new UserInfoInputDto(userInputFrom.getUserId(), userInputFrom.getUserName(), userInputFrom.getUserSex(), userInputFrom.getAddress());
        // 更新処理
        int rows = userService.updateUserEntity(userInfoInputDto);
        UserOutputForm userForm = new UserOutputForm();
        userForm.setRows(rows);
        if (rows == 0) {
        	userForm.setStatus(500);
        	userForm.setMessage("更新失敗しました。");
        } else {
        	userForm.setStatus(201);
        	userForm.setMessage("更新成功しました。");
        }
        return userForm;
    }

    /**
     * [概要] <p>ユーザー情報を削除</p>
     * [説明] <p>ユーザー情報を削除（ユーザーIDによる削除）。</p>
     * [補充] <p>特になし。</p>
     *
     * @param userEntityId ユーザーID
     * @return ユーザーフォーム
     */
    @DeleteMapping("/{userEntityId}")
    public UserOutputForm deleteUser(@PathVariable Integer userEntityId) {
    	
    	// 削除処理
        int rows = userService.deleteUserEntity(userEntityId);
        UserOutputForm userForm = new UserOutputForm();
        userForm.setRows(rows);
        if (rows == 0) {
        	userForm.setStatus(500);
        	userForm.setMessage("削除失敗しました。"); 
        } else {
        	userForm.setStatus(201);
        	userForm.setMessage("削除成功しました。");
        }
        return userForm;
    }
}
