package org.boli.myweb.service;

import org.boli.myweb.model.Config;

public interface ItemService {

	/**
	 * 读取物品过滤信息
	 * 
	 * @param pathname
	 * @return
	 */
	Config readConfig(String pathname);

	/**
	 * 保存物品过滤信息
	 * 
	 * @param config
	 */
	void saveConfig(Config config);

}
