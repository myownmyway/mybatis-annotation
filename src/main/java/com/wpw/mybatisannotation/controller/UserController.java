package com.wpw.mybatisannotation.controller;

import com.wpw.mybatisannotation.config.CountTime;
import com.wpw.mybatisannotation.constant.URLConstant;
import com.wpw.mybatisannotation.entity.User;
import com.wpw.mybatisannotation.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 *
 * @author wpw
 */
@RestController
public class UserController {
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @return 用户列表
     */
    @CountTime
    @GetMapping(value = URLConstant.LIST)
    public List<User> listUser() {
        return userService.listUser();
    }

    /**
     * 获取用户列表
     *
     * @param userName 用户名称
     * @return 用户列表
     */
    @CountTime
    @GetMapping(value = URLConstant.SEARCH)
    public List<User> listUserByUserName(@RequestParam(value = "userName") String userName) {
        return userService.listUserByUserName(userName);
    }

    /**
     * @param userName 用户名称
     * @param passWord 用户密码
     * @return 用户信息
     */
    @CountTime
    @GetMapping(value = URLConstant.GET)
    public User search(@RequestParam(value = "userName") String userName, @RequestParam(value = "passWord") String passWord) {
        return userService.select(userName, passWord);
    }

    /**
     * 根据用户名称和用户密码获取用户信息
     *
     * @param userName 用户名称
     * @param passWord 用户密码
     * @return 用户信息
     */
    @CountTime
    @GetMapping(value = URLConstant.OPTION)
    public User searchUser(@RequestParam(value = "userName") String userName, @RequestParam(value = "passWord") String passWord) {
        return userService.selectUser(userName, passWord);
    }

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 是否成功
     */
    @PostMapping(value = URLConstant.INSERT)
    public Integer saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return 更新是否成功
     */
    @PutMapping(value = URLConstant.UPDATE)
    public Integer updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * 根据用户id删除用户信息
     *
     * @param user 用户信息
     * @return 删除是否成功
     */
    @DeleteMapping(value = URLConstant.DELETE)
    public Integer deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }

    @GetMapping(value = "/list-pagination")
    public List<User> listPagination(@RequestBody User user) {
        return userService.listPagination(user);
    }
}
