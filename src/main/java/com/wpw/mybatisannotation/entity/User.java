package com.wpw.mybatisannotation.entity;

import com.wpw.mybatisannotation.config.PageVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author wpw
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class User extends PageVo implements Serializable {
    private Integer id;
    private String userName;
    private String passWord;
    private String mobileNum;
}
