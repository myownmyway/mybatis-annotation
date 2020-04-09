package com.wpw.mybatisannotation.mapper;

import com.wpw.mybatisannotation.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * dao操作类
 *
 * @author wpw
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 获取用户列表信息
     *
     * @return 用户列表信息
     */
    @Select(value = "select * from user")
    List<User> listUser();

    /**
     * 根据用户名称获取用户列表
     *
     * @param userName 用户名称
     * @retur 用户列表
     */
    @SelectProvider(type = UserSqlProvider.class, method = "listUserByUserName")
    List<User> listUserByUserName(@Param("userName") String userName);

    /**
     * 根据用户名称和密码查询用户信息
     *
     * @param userName 用户名称
     * @param passWord 用户密码
     * @return user用户信息
     */
    @Select(value = "select * from user where username=#{username} and password=#{password}")
    User select(@Param(value = "username") String userName, @Param(value = "password") String passWord);

    /**
     * 根据用户名称和用户密码查询用户信息
     *
     * @param userName 用户名称
     * @param passWord 用户密码
     * @return 用户信息
     */
    @SelectProvider(value = UserSqlProvider.class, method = "selectUser")
    User selectUser(String userName, String passWord);

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 自增主键
     */
    @InsertProvider(value = UserSqlProvider.class, method = "saveUser")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer saveUser(User user);

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return 更新成功与否
     */
    @UpdateProvider(type = UserSqlProvider.class, method = "updateUser")
    Integer updateUser(User user);

    /**
     * 删除用户信息
     *
     * @param user 用户信息
     * @return 删除是否成功
     */
    @DeleteProvider(type = UserSqlProvider.class, method = "deleteUser")
    Integer deleteUser(User user);

    /**
     * 分页查询用户信息
     *
     * @param user 用户信息
     * @return 分页查询后的信息
     */
    @SelectProvider(type = UserSqlProvider.class, method = "listPagination")
    List<User> listPagination(User user);
}
