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
 * ユーザー情報操作コントローラクラス。
 */
@RestController
@RequestMapping("/api/users")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * ユーザー情報を全て取得。
     * @return ユーザー情報リスト
     */
    @GetMapping
    public UserOutputForm getAllUsers() {
    	List<UserInfoOutputDto> userInfoOutputDtos = userService.selectAll();
    	UserOutputForm userForm = new UserOutputForm();
    	userForm.setUserInfoOutputList(userInfoOutputDtos);
        return userForm;
    }

    /**
     * ユーザー情報を取得（ユーザーIDによる検索）。
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
     * ユーザー情報を更新（ユーザーIDによる更新）または追加。
     * @param userInfoInputDto ユーザー情報
     * @return 更新結果メッセージ
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
     * ユーザー情報を更新（ユーザーIDによる更新）。
     * @param userInfoInputDto ユーザー情報
     * @return 更新結果メッセージ
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
     * ユーザー情報を削除（ユーザーIDによる削除）。
     * @param userEntityId ユーザーID
     * @return 削除結果メッセージ
     */
    @DeleteMapping("/{userEntityId}")
    public UserOutputForm deleteUser(@PathVariable Integer userEntityId) {
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
