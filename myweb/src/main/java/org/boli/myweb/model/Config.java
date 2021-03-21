package org.boli.myweb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.boli.myweb.entity.Itemguolv;

public class Config {

	List<ConfigFile> configFileList = new ArrayList<ConfigFile>();

	Map<String, Itemguolv> itemguolvMap = new HashMap<String, Itemguolv>();

	Collection<Itemguolv> itemguolvList = new ArrayList<Itemguolv>();

	public List<ConfigFile> getConfigFileList() {
		return configFileList;
	}

	public void setConfigFileList(List<ConfigFile> configFileList) {
		this.configFileList = configFileList;
	}

	public Map<String, Itemguolv> getItemguolvMap() {
		return itemguolvMap;
	}

	public void setItemguolvMap(Map<String, Itemguolv> itemguolvMap) {
		this.itemguolvMap = itemguolvMap;
	}

	public Collection<Itemguolv> getItemguolvList() {
		return itemguolvMap.values();
	}

	public void setItemguolvList(Collection<Itemguolv> itemguolvList) {
		this.itemguolvList = itemguolvList;
	}

}
