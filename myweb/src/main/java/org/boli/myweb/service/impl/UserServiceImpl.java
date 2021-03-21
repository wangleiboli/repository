package org.boli.myweb.service.impl;

import java.util.List;

import org.boli.myweb.entity.User;
import org.boli.myweb.entity.UserExample;
import org.boli.myweb.entity.UserExample.Criteria;
import org.boli.myweb.mapper.UserMapper;
import org.boli.myweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public User selectById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> select(User user) {

		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if (!user.getName().isEmpty()) {
			criteria.andNameLike("%" + user.getName() + "%");
		}

		return userMapper.selectByExample(example);
	}

	@Override
	public PageInfo<User> selectAll() {

		PageHelper.startPage(1, 10);

		List<User> userList = userMapper.selectByExample(null);

		return new PageInfo<User>(userList);
	}

}
