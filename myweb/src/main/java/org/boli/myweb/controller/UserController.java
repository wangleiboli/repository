package org.boli.myweb.controller;

import org.boli.myweb.entity.User;
import org.boli.myweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("select/{id}")
	@ResponseBody
	public User selectById(@PathVariable int id) {
		return userService.selectById(id);
	}

}
