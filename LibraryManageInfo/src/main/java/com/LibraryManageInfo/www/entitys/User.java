package com.LibraryManageInfo.www.entitys;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/10 19:11
 */

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userid;
    private String username;
    private String password;
    private String sex;
}
