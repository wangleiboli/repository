package org.boli.myweb.service;

import java.util.List;

import org.boli.myweb.entity.User;

import com.github.pagehelper.PageInfo;

public interface UserService {

	User selectById(int id);

	List<User> select(User user);

	PageInfo<User> selectAll();

}
