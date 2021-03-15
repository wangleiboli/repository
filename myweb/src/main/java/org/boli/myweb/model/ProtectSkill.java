package org.boli.myweb.model;

/**
 * 保护技能
 * 
 * @author Administrator
 *
 */
public class ProtectSkill {
	/**
	 * 技能名称
	 */
	String ObjName = "";
	/**
	 * 仅当技力>=[]使用
	 */
	boolean bJiliLDayu = false;
	/**
	 * 仅当技力>=[]使用
	 */
	int iJiliDayu = 0;
	/**
	 * 仅当技力<[]使用
	 */
	boolean bJiliXiaoyu = false;
	/**
	 * 仅当技力<[]使用
	 */
	int iJiliXiaoyu = 0;
	/**
	 * 仅当怒气>=[]使用
	 */
	boolean bNuqiDayu = false;
	/**
	 * 仅当怒气>=[]使用
	 */
	int iNuqiDayu = 0;
	/**
	 * 仅当怒气<[]使用
	 */
	boolean bNuqiXiaoyu = false;
	/**
	 * 仅当怒气<[]使用
	 */
	int iNuqiXiaoyu = 0;
	/**
	 * 使用前瞬移
	 */
	boolean bShiyongqianshunyi = false;
	/**
	 * 优先使用物品
	 */
	boolean bYouxianshiyongwupin = false;
	/**
	 * 使用对象：[自己]
	 */
	boolean bUseforself = true;
	/**
	 * 在城内使用
	 */
	boolean bZaiChengNeiShiYong = true;
	/**
	 * 不攻击时使用
	 */
	boolean bBuGongJiShiYong = false;
	/**
	 * 自动打怪时使用
	 */
	boolean bZidongdaguaishiyong = false;
	/**
	 * 仅杀王时使用
	 */
	boolean bShawangshishiyong = false;
	/**
	 * 不杀王时使用
	 */
	boolean bBushawangshishiyong = false;

}
