package org.boli.myweb.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.boli.myweb.entity.Itemguolv;
import org.boli.myweb.model.Config;
import org.boli.myweb.model.ConfigFile;
import org.boli.myweb.service.ItemService;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ItemServiceImpl implements ItemService {

	@Override
	public Config readConfig(String pathname) {

		Config config = new Config();

		List<File> configFileList = getConfigFile(pathname);

		for (File file : configFileList) {

			String parentName = file.getParentFile().getName();

			String[] arr = parentName.split("\\-");

			ConfigFile configFile = new ConfigFile(arr[0], arr[1], file.getName(), file.getAbsolutePath());

			config.getConfigFileList().add(configFile);

			Map<String, Itemguolv> itemguolvMap = readItemguolv(file);

			config.getItemguolvMap().putAll(itemguolvMap);

		}

		return config;
	}

	/**
	 * 获取配置目录下所有用户配置文件
	 * 
	 * @param pathname
	 * @return
	 */
	public List<File> getConfigFile(String pathname) {

		File file = new File(pathname);

		return getConfigFile(file);

	}

	/**
	 * 获取配置目录下所有用户配置文件
	 * 
	 * @param file
	 * @return
	 */
	public List<File> getConfigFile(File file) {

		List<File> configFileList = new ArrayList<File>();

		if (file.exists()) {

			if (file.isDirectory()) {

				File[] files = file.listFiles();

				for (File subFile : files) {

					configFileList.addAll(getConfigFile(subFile));
				}

			} else if (file.isFile()) {

				if (file.getName().equals("config.xml")) {

					configFileList.add(file);

				}

			}
		}

		return configFileList;

	}

	/**
	 * 读取物品过滤信息
	 * 
	 * @param file
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Itemguolv> readItemguolv(File file) {

		ObjectMapper mapper = new ObjectMapper();

		Map<String, Itemguolv> itemguolvMap = new HashMap<String, Itemguolv>();

		try {
			InputStream inputStream = new FileInputStream(file);

			Reader reader = new InputStreamReader(inputStream, Charset.forName("GBK"));

			Map<?, ?> map = mapper.readValue(reader, Map.class);

			reader.close();

			inputStream.close();

			if (map.containsKey("ItemGuolv")) {

				for (Map ItemGuolv : (List<Map>) map.get("ItemGuolv")) {

					String ObjName = (String) ItemGuolv.get("ObjName");
					Boolean bSell = (Boolean) ItemGuolv.get("bSell");
					Boolean bStore = (Boolean) ItemGuolv.get("bStore");
					Boolean bDrop = (Boolean) ItemGuolv.get("bDrop");
					Integer iQiangHuaCishu = (Integer) ItemGuolv.get("iQiangHuaCishu");
					Integer iMaSu = (Integer) ItemGuolv.get("iMaSu");
					Integer iFangyu = (Integer) ItemGuolv.get("iFangyu");
					Integer iGongji = (Integer) ItemGuolv.get("iGongji");
					Integer iShenshangliuliang = (Integer) ItemGuolv.get("iShenshangliuliang");
					Integer iWujiangji = (Integer) ItemGuolv.get("iWujiangji");
					Integer iLev = (Integer) ItemGuolv.get("iLev");
					Boolean bLev_gt = (Boolean) ItemGuolv.get("bLev_gt");

					Itemguolv itemguolv = new Itemguolv(ObjName, bSell, bStore, bDrop, iQiangHuaCishu, iMaSu, iFangyu,
							iGongji, iShenshangliuliang, iWujiangji, iLev, bLev_gt);

					itemguolvMap.put(ObjName, itemguolv);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return itemguolvMap;
	}

}
