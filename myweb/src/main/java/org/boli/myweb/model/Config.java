package org.boli.myweb.model;

import java.util.List;

/**
 * 用户配置
 * 
 * @author Administrator
 *
 */
public class Config {

	/**
	 * 物品过滤
	 */
	List<ItemGuolv> ItemGuolv;
	/**
	 * 保护技能
	 */
	List<ProtectSkill> ProtectSkills;
	/**
	 * 攻防技能
	 */
	List<GongfangSkill> GongfangSkills;
	/**
	 * 买物品设定
	 */
	List<Buyset> buyset;
	/**
	 * 宠物设定
	 */
	List<Petset> petset;
	/**
	 * 躲怪
	 */
	List<String> duoguai;
	/**
	 * 吃魂
	 */
	List<String> chihun;
	/**
	 * 指定人员
	 */
	List<String> Zhidingrenyuan;
	/**
	 * 黑名单
	 */
	List<String> Heimingdan;
	/**
	 * 跟随名单
	 */
	List<String> Gensuimingdan;
	/**
	 * 复活指定
	 */
	List<String> FuhuoZhiding;
	/**
	 * 摆摊
	 */
	Baitan Baitan;
	/**
	 * 聊天回复
	 */
	List<Liaotianhuifu> Liaotianhuifu;
	/**
	 * 聊天发言
	 */
	List<Liaotianfayan> Liaotianfayan;
	/**
	 * 屏蔽黑名单内人物发言
	 */
	List<String> liaotianheimingdan;
	/**
	 * 仅执行指定人命令
	 */
	List<String> vLiaoTianMingLingMingDan;
	/**
	 * 优先攻击
	 */
	List<String> youxiangongji;
	/**
	 * 只攻击
	 */
	List<String> zhigongji;
	/**
	 * 不攻击
	 */
	List<String> bugongji;
}
