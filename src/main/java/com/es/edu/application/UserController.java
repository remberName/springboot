package com.es.edu.application;

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
    public List<UserInfoOutputDto> getAllUsers() {
    	List<UserInfoOutputDto> userInfoOutputDtos = userService.selectAll();
        return userInfoOutputDtos;
    }

    /**
     * ユーザー情報を取得（ユーザーIDによる検索）。
     * @param userEntityId ユーザーID
     * @return ユーザー情報
     */
    @GetMapping("/{userEntityId}")
    public ResponseEntity<UserInfoOutputDto> getUserById(@PathVariable Integer userEntityId) {
        UserInfoOutputDto userInfoOutputDto = userService.selectUserEntityById(userEntityId);
        if (userInfoOutputDto != null) {
            return ResponseEntity.ok(userInfoOutputDto);
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
    public ResponseEntity<String> addUser(@RequestBody UserInfoInputDto userInfoInputDto) {
        // 追加処理
        int result = userService.insertUserEntity(userInfoInputDto);
        if (result == 0) {
            return ResponseEntity.status(500).body("追加失敗しました。");
        } else {
            return ResponseEntity.status(201).body("追加成功しました。");
        }
    }

    /**
     * ユーザー情報を更新（ユーザーIDによる更新）。
     * @param userInfoInputDto ユーザー情報
     * @return 更新結果メッセージ
     */
    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody UserInfoInputDto userInfoInputDto) {
        // 更新処理
        int result = userService.updateUserEntity(userInfoInputDto);
        if (result == 0) {
            return ResponseEntity.status(500).body("更新失敗しました。");
        } else {
            return ResponseEntity.ok("更新成功しました。");
        }
    }

    /**
     * ユーザー情報を削除（ユーザーIDによる削除）。
     * @param userEntityId ユーザーID
     * @return 削除結果メッセージ
     */
    @DeleteMapping("/{userEntityId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userEntityId) {
        int result = userService.deleteUserEntity(userEntityId);
        if (result == 0) {
            return ResponseEntity.status(500).body("削除失敗しました。");
        } else {
            return ResponseEntity.ok("削除成功しました。");
        }
    }
}
