package org.boli.myweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.boli.myweb.model.Config;
import org.boli.myweb.model.Result;
import org.boli.myweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping("/readConfig")
	@ResponseBody
	public Result readConfig(String pathname, MultipartFile[] files) {

		Config config = itemService.readConfig(pathname, files);

		Result result = new Result(config);
		return result;

	}

	@RequestMapping("/saveConfig")
	@ResponseBody
	public Result saveConfig(Config config, HttpServletRequest req) {

		itemService.saveConfig(config);

		Result result = new Result();
		return result;

	}

	/**
	 * 设置需要包裹的元素个数，默认为256<br>
	 * Tomcat中设置post方式请求的参数大小和个数 maxPostSize="-1" maxParameterCount="-1"
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initListBinder(WebDataBinder binder) {
		// 设置需要包裹的元素个数，默认为256
		binder.setAutoGrowCollectionLimit(100000);
	}

}
