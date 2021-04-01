package org.boli.myspring.service;

import org.boli.myspring.model.Config;
import org.springframework.web.multipart.MultipartFile;

public interface ItemService {

	/**
	 * 读取物品过滤信息
	 * 
	 * @param pathname
	 * @param files
	 * @return
	 */
	Config readConfig(String pathname, MultipartFile[] files);

	/**
	 * 保存物品过滤信息
	 * 
	 * @param config
	 */
	void saveConfig(Config config);

}
