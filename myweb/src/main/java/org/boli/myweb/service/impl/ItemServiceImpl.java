package org.boli.myweb.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.boli.myweb.entity.Itemguolv;
import org.boli.myweb.mapper.ItemguolvMapper;
import org.boli.myweb.model.Config;
import org.boli.myweb.model.ConfigFile;
import org.boli.myweb.model.Itemguolv4Config;
import org.boli.myweb.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ItemServiceImpl implements ItemService {

	private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

	@Autowired
	ItemguolvMapper itemguolvMapper;

	@Override
	public Config readConfig(String pathname, MultipartFile[] files) {

		Config config = new Config();

		Map<String, Itemguolv> itemguolvMap = new HashMap<String, Itemguolv>();

		// 读物品文件
		for (MultipartFile multipartFile : files) {
			itemguolvMap.putAll(readItemguolv(multipartFile));
		}

		// 读配置文件
		List<File> configFileList = getConfigFile(pathname);

		for (File file : configFileList) {

			String parentName = file.getParentFile().getName();

			String[] arr = parentName.split("\\-");

			ConfigFile configFile = new ConfigFile(arr[0], arr[1], file.getName(), file.getAbsolutePath());

			config.getConfigFileList().add(configFile);

			itemguolvMap.putAll(readItemguolv(file));

		}

		// 读数据库
		itemguolvMap.putAll(readItemguolv());

		List<Itemguolv> itemguolvList = new ArrayList<Itemguolv>(itemguolvMap.values());

		Collections.sort(itemguolvList, new Comparator<Itemguolv>() {

			@Override
			public int compare(Itemguolv o1, Itemguolv o2) {

				o1.setType(o1.getType() == null ? "" : o1.getType());
				o2.setType(o2.getType() == null ? "" : o2.getType());
				o1.setSubtype(o1.getSubtype() == null ? "" : o1.getSubtype());
				o2.setSubtype(o2.getSubtype() == null ? "" : o2.getSubtype());
				o1.setSeq(o1.getSeq() == null ? 0 : o1.getSeq());
				o2.setSeq(o2.getSeq() == null ? 0 : o2.getSeq());

				if (o1.getType().compareTo(o2.getType()) > 0) {
					return 1;
				} else if (o1.getType().compareTo(o2.getType()) == 0) {
					if (o1.getSubtype().compareTo(o2.getSubtype()) > 0) {
						return 1;
					} else if (o1.getSubtype().compareTo(o2.getSubtype()) == 0) {
//						if (o1.getSeq().compareTo(o2.getSeq()) == 0) {
							return o1.getObjname().compareTo(o2.getObjname());
//						} else {
//							return o1.getSeq().compareTo(o2.getSeq());
//						}
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			}
		});

		config.setItemguolvList(itemguolvList);

		return config;
	}

	/**
	 * 从物品文件读取物品信息
	 * 
	 * @param multipartFile
	 * @return
	 */
	public Map<String, Itemguolv> readItemguolv(MultipartFile multipartFile) {

		Map<String, Itemguolv> itemguolvMap = new HashMap<String, Itemguolv>();

		try (InputStream inputStream = multipartFile.getInputStream();

				Reader reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));

				BufferedReader bufferedReader = new BufferedReader(reader);) {

			String[] items;
			String line;
			while ((line = bufferedReader.readLine()) != null) {

				items = line.split("。|\\.|,|\\，|、|\\-|\\s+");

				for (String item : items) {
					if(item.contains("<") || item.contains(">") || item.contains("《") || item.contains("》")) {
						continue;
					}
					itemguolvMap.put(item.trim(), new Itemguolv(item.trim()));
				}

			}

		} catch (Exception e) {
			logger.error("", e);
		}

		itemguolvMap.remove("");
		return itemguolvMap;
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
	 * 从配置文件读取物品过滤信息
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

			Map map = mapper.readValue(reader, Map.class);

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
							iGongji, iShenshangliuliang, iWujiangji, iLev, bLev_gt, null, null, 0);

					itemguolvMap.put(ObjName, itemguolv);
				}

			}

		} catch (Exception e) {
			logger.error("", e);
		}

		return itemguolvMap;
	}

	/**
	 * 从数据库读取物品过滤信息
	 * 
	 * @return
	 */
	public Map<String, Itemguolv> readItemguolv() {

		Map<String, Itemguolv> itemguolvMap = new HashMap<String, Itemguolv>();

		List<Itemguolv> itemguolvList = itemguolvMapper.selectByExample(null);

		for (Itemguolv itemguolv : itemguolvList) {

			itemguolvMap.put(itemguolv.getObjname(), itemguolv);

		}

		return itemguolvMap;

	}

	@Override
	public void saveConfig(Config config) {

		List<Itemguolv> itemguolvList = config.getItemguolvList();

		saveItemguolv(itemguolvList);

		List<Itemguolv4Config> itemguolv4ConfigList = new ArrayList<Itemguolv4Config>();
		for (Itemguolv itemguolv : itemguolvList) {
			itemguolv4ConfigList.add(new Itemguolv4Config(itemguolv));
		}

		for (ConfigFile configFile : config.getConfigFileList()) {
			saveItemguolv(configFile, itemguolv4ConfigList);
		}

	}

	/**
	 * 物品过滤信息写入配置文件
	 * 
	 * @param config
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void saveItemguolv(ConfigFile configFile, List<Itemguolv4Config> itemguolv4ConfigList) {

		ObjectMapper mapper = new ObjectMapper();

		File file = new File(configFile.getFilePath());

		try {
			InputStream inputStream = new FileInputStream(file);

			Reader reader = new InputStreamReader(inputStream, Charset.forName("GBK"));

			Map map = mapper.readValue(reader, Map.class);

			reader.close();

			inputStream.close();

			map.put("ItemGuolv", itemguolv4ConfigList);

			OutputStream outputStream = new FileOutputStream(file, false);

			Writer writer = new OutputStreamWriter(outputStream, Charset.forName("GBK"));

			mapper.writeValue(writer, map);

			writer.close();

			outputStream.close();

		} catch (Exception e) {
			logger.error("", e);
		}
	}

	/**
	 * 物品过滤信息写入数据库
	 * 
	 * @param itemguolvList
	 */
	public void saveItemguolv(List<Itemguolv> itemguolvList) {

		itemguolvMapper.deleteByExample(null);

		for (Itemguolv itemguolv : itemguolvList) {
			itemguolvMapper.insertSelective(itemguolv);
		}

	}

}
