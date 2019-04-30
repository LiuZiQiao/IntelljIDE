package com.lxk.common.util;

import org.apache.shiro.SecurityUtils;

import com.lxk.common.constant.Base;
import com.lxk.entity.User;

/**
 * @author lxk
 * <p>
 * 2018年1月25日
 */
public class UserUtils {

    public static User getCurrentUser() {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(Base.CURRENT_USER);
        return user;
    }
}
