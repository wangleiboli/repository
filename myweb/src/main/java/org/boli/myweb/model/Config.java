package org.boli.myweb.model;

import java.util.ArrayList;
import java.util.List;

import org.boli.myweb.entity.Itemguolv;

public class Config {

	List<ConfigFile> configFileList = new ArrayList<ConfigFile>();

	List<Itemguolv> itemguolvList = new ArrayList<Itemguolv>();

	public List<ConfigFile> getConfigFileList() {
		return configFileList;
	}

	public void setConfigFileList(List<ConfigFile> configFileList) {
		this.configFileList = configFileList;
	}

	public List<Itemguolv> getItemguolvList() {
		return itemguolvList;
	}

	public void setItemguolvList(List<Itemguolv> itemguolvList) {
		this.itemguolvList = itemguolvList;
	}

}
