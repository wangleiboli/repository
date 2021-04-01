package org.boli.myspring.service.impl;

import java.util.List;

import org.boli.myspring.entity.User;
import org.boli.myspring.entity.UserExample;
import org.boli.myspring.entity.UserExample.Criteria;
import org.boli.myspring.mapper.UserMapper;
import org.boli.myspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * {@link Component @Component}注解的类，相当于xml中配置的bean<br>
 * Spring提供了{@link Component @Component}的三个衍生注解<br>
 * {@link Controller @Controller}通常用于Controller类，也就是控制层<br>
 * {@link Service @Service}通常用于注解Service类，也就是服务层<br>
 * {@link Repository @Repository}通常用于注解DAO类，也就是我们常说的持久层<br>
 * 
 * <p>
 * 自动装配出现多个bean候选者时，被注解为{@link Primary @Primary}的bean将作为首选者，否则将抛出异常。
 */
@Service
@Primary
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public User selectById(long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> select(User user) {

		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if (user.getId() > 0) {
			criteria.andIdEqualTo(user.getId());
		}
		if (user.getName() != null) {
			criteria.andNameLike("%" + user.getName() + "%");
		}

		return userMapper.selectByExample(example);
	}

	@Override
	public PageInfo<User> selectAll() {

		PageHelper.startPage(1, 10);
		List<User> usersList = userMapper.selectByExample(null);
		PageInfo<User> pageInfo = new PageInfo<User>(usersList);

		return pageInfo;
	}

}
