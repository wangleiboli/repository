package org.boli.myweb.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 攻防技能
 * @author Administrator
 *
 */
public class GongfangSkill {
	/**
	 * 技能名称
	 */
	String ObjName = "";
	/**
	 * 等级
	 */
	int iSkillLev = 0;
	/**
	 * 当怪物数>[] 使用范围攻击
	 */
	int iGuaiwushuliang = 5;
	/**
	 * 第[]次攻击怪物使用
	 */
	int iGongjicishu = 0;
	/**
	 * 只用于指定怪
	 */
	List<String> vZhidingguai = new ArrayList<String>();
	/**
	 * 仅用于身边多个怪
	 */
	boolean bJinyongyushenbianguai = false;
	/**
	 * 怒气小于[] 停止使用
	 */
	boolean bNuqixiaoyutingzhi = false;
	/**
	 * 怒气小于[] 停止使用
	 */
	int iNuqixiaoyutingzhi = 0;
	/**
	 * 怪物HP百分比[>=][]使用
	 */
	boolean bGuaiwuhpdayu = true;
	/**
	 * 怪物HP百分比[>=][]使用
	 */
	int iGuaiwuhpdayu = 0;
	/**
	 * 技力>=[] 开始使用
	 */
	int iJilidayu = 0;
	/**
	 * 怒气>=[] 开始使用
	 */
	int iNuqidayu = 0;

}
