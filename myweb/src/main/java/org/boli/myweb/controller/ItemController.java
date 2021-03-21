package org.boli.myweb.controller;

import org.boli.myweb.model.Config;
import org.boli.myweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping("/readConfig")
	@ResponseBody
	public Config readConfig(String pathname) {

		return itemService.readConfig(pathname);

	}

}
