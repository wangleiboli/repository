package org.boli.myweb.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 摆摊
 * 
 * @author Administrator
 *
 */
public class Baitan {
	/**
	 * 标题
	 */
	String Title = "";
	/**
	 * 物品
	 */
	List<Item> Items = new ArrayList<Item>();

	/**
	 * 物品
	 * 
	 * @author Administrator
	 *
	 */
	class Item {
		/**
		 * 价格
		 */
		int price = 0;
		/**
		 * 数量
		 */
		int count = 0;
		/**
		 * 物品ID
		 */
		int id = 0;
		int t1 = 0;
		int t2 = 0;
	}
}
