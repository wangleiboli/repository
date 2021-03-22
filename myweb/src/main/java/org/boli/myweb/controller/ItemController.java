package org.boli.myweb.controller;

import org.boli.myweb.model.Config;
import org.boli.myweb.model.Result;
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
	public Result readConfig(String pathname) {

		Config config = itemService.readConfig(pathname);

		Result result = new Result(config);
		return result;

	}

	@RequestMapping("/saveConfig")
	@ResponseBody
	public Result saveConfig(Config config) {

		itemService.saveConfig(config);

		Result result = new Result();
		return result;

	}

}
