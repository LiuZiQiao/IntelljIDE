package com.lxk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lxk.entity.User;

/**
 * @author lxk
 * <p>
 * 2018年1月23日
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByAccount(String account);

}
