package com.wpw.mybatisannotation.service;

import com.wpw.mybatisannotation.entity.User;

import java.util.List;

/**
 * 业务处理类
 *
 * @author wpw
 */
public interface UserService {
    /**
     * 获取用户列表信息
     *
     * @return 用户列表信息
     */
    List<User> listUser();

    /**
     * 根据用户名称获取用户列表
     *
     * @param userName 用户名称
     * @retur 用户列表
     */
    List<User> listUserByUserName(String userName);

    /**
     * 根据用户名称和密码查询用户信息
     *
     * @param userName 用户名称
     * @param passWord 用户密码
     * @return user用户信息
     */
    User select(String userName, String passWord);

    /**
     * 根据用户名称和用户密码查询用户信息
     *
     * @param userName 用户名称
     * @param passWord 用户密码
     * @return 用户信息
     */
    User selectUser(String userName, String passWord);

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 自增主键
     */
    Integer saveUser(User user);

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return 更新成功与否
     */
    Integer updateUser(User user);

    /**
     * 根据用户id删除用户信息
     *
     * @param user 用户信息
     * @return 删除是否成功
     */
    Integer deleteUser(User user);

    /**
     * 分页查询用户信息
     *
     * @param user 用户信息
     * @return 分页后的数据信息
     */
    List<User> listPagination(User user);
}
