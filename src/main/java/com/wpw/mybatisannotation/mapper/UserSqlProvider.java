package com.wpw.mybatisannotation.mapper;

import com.wpw.mybatisannotation.entity.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author wpw
 */
public class UserSqlProvider {
    /**
     * 根据用户名称查询用户列表
     *
     * @param userName 用户名称
     * @return sql
     */
    public String listUserByUserName(String userName) {
        return "select * from user where username=#{userName}";
    }

    /**
     * 根据用户名称和用户密码查询用户
     *
     * @param userName 用户名称
     * @param passWord 用户密码
     * @return sql
     */
    public String selectUser(String userName, String passWord) {
        return new SQL() {{
            SELECT("*");
            FROM("user");
            if (userName != null && passWord != null) {
                WHERE("username =#{userName} and password=#{passWord}");
            } else {
                WHERE("1=2");
            }
        }}.toString();
    }

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return sql
     */
    public String saveUser(User user) {
        return new SQL() {
            {
                INSERT_INTO("user");
                if (user.getUserName() != null) {
                    VALUES("username", "#{userName}");
                }
                if (user.getPassWord() != null) {
                    VALUES("password", "#{passWord}");
                }
                if (user.getMobileNum() != null) {
                    VALUES("mobile_num", "#{mobileNum}");
                }
            }
        }.toString();
    }

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return sql
     */
    public String updateUser(User user) {
        return new SQL() {
            {
                UPDATE("user");
                if (user.getUserName() != null) {
                    SET("username = #{userName}");
                }
                if (user.getPassWord() != null) {
                    SET("password = #{passWord}");
                }
                if (user.getMobileNum() != null) {
                    SET("mobile_num=#{mobileNum}");
                }
                WHERE("id= #{id}");
            }
        }.toString();
    }

    /**
     * 删除用户信息
     *
     * @param user 用户信息
     * @return sql语句
     */
    public String deleteUser(User user) {
        SQL sql = new SQL() {{
            DELETE_FROM("user");
            if (user.getId() != null) {
                WHERE("id=#{id}");
            }
        }};
        return sql.toString();
    }

    /**
     * 分页查询用户列表信息
     *
     * @param user 用户信息
     * @return 用户列表信息
     */
    public String listPagination(User user) {
        SQL sql = new SQL() {{
            SELECT("*");
            FROM("user");
            if (user.getUserName() != null) {
                SET("username=#{userName}");
            }
            if (user.getPassWord() != null) {
                SET("password=#{passWord}");
            }
            if (user.getMobileNum() != null) {
                SET("mobile_num=#{mobileNum}");
            }
            if (user.getPageNumber() != null && user.getPageSize() != null) {
                LIMIT(user.getPageSize());
            }
        }};
        return sql.toString();
    }
}
