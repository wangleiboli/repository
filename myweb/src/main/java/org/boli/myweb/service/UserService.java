package org.boli.myweb.service;

import java.util.List;

import org.boli.myweb.entity.User;

import com.github.pagehelper.PageInfo;

public interface UserService {

	PageInfo<User> queryAll();

	List<User> query(User user);

	User get(long id);

}
