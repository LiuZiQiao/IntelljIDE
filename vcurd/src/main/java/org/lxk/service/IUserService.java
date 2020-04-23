package org.lxk.service;

import org.lxk.entity.User;

import java.util.List;

/**
 * @author xiaokun-liu
 * @version 1.0
 * @date 2020/4/20 20:09
 */
public interface IUserService {
    void save(User user);

    void update(User user);

    List<User> listUser(String filter);

    void deleteByPrimarykey(String userId);
}
