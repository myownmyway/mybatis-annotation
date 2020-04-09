package com.wpw.mybatisannotation.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户请求类，暂时用作分页请求的类
 *
 * @author wpw
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Accessors(chain = true)
public class PageVo implements Serializable {
    private Integer pageNumber;
    private Integer pageSize;
}
