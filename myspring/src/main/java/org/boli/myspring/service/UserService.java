package org.boli.myspring.service;

import java.util.List;

import org.boli.myspring.entity.User;

import com.github.pagehelper.PageInfo;

public interface UserService {

	User selectById(long id);

	List<User> select(User user);

	PageInfo<User> selectAll();

}
