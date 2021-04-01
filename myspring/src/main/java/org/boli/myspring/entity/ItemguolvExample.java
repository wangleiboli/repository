package org.boli.myspring.entity;

import java.util.ArrayList;
import java.util.List;

public class ItemguolvExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ItemguolvExample() {
		oredCriteria = new ArrayList<>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andObjnameIsNull() {
			addCriterion("ObjName is null");
			return (Criteria) this;
		}

		public Criteria andObjnameIsNotNull() {
			addCriterion("ObjName is not null");
			return (Criteria) this;
		}

		public Criteria andObjnameEqualTo(String value) {
			addCriterion("ObjName =", value, "objname");
			return (Criteria) this;
		}

		public Criteria andObjnameNotEqualTo(String value) {
			addCriterion("ObjName <>", value, "objname");
			return (Criteria) this;
		}

		public Criteria andObjnameGreaterThan(String value) {
			addCriterion("ObjName >", value, "objname");
			return (Criteria) this;
		}

		public Criteria andObjnameGreaterThanOrEqualTo(String value) {
			addCriterion("ObjName >=", value, "objname");
			return (Criteria) this;
		}

		public Criteria andObjnameLessThan(String value) {
			addCriterion("ObjName <", value, "objname");
			return (Criteria) this;
		}

		public Criteria andObjnameLessThanOrEqualTo(String value) {
			addCriterion("ObjName <=", value, "objname");
			return (Criteria) this;
		}

		public Criteria andObjnameLike(String value) {
			addCriterion("ObjName like", value, "objname");
			return (Criteria) this;
		}

		public Criteria andObjnameNotLike(String value) {
			addCriterion("ObjName not like", value, "objname");
			return (Criteria) this;
		}

		public Criteria andObjnameIn(List<String> values) {
			addCriterion("ObjName in", values, "objname");
			return (Criteria) this;
		}

		public Criteria andObjnameNotIn(List<String> values) {
			addCriterion("ObjName not in", values, "objname");
			return (Criteria) this;
		}

		public Criteria andObjnameBetween(String value1, String value2) {
			addCriterion("ObjName between", value1, value2, "objname");
			return (Criteria) this;
		}

		public Criteria andObjnameNotBetween(String value1, String value2) {
			addCriterion("ObjName not between", value1, value2, "objname");
			return (Criteria) this;
		}

		public Criteria andBsellIsNull() {
			addCriterion("bSell is null");
			return (Criteria) this;
		}

		public Criteria andBsellIsNotNull() {
			addCriterion("bSell is not null");
			return (Criteria) this;
		}

		public Criteria andBsellEqualTo(Boolean value) {
			addCriterion("bSell =", value, "bsell");
			return (Criteria) this;
		}

		public Criteria andBsellNotEqualTo(Boolean value) {
			addCriterion("bSell <>", value, "bsell");
			return (Criteria) this;
		}

		public Criteria andBsellGreaterThan(Boolean value) {
			addCriterion("bSell >", value, "bsell");
			return (Criteria) this;
		}

		public Criteria andBsellGreaterThanOrEqualTo(Boolean value) {
			addCriterion("bSell >=", value, "bsell");
			return (Criteria) this;
		}

		public Criteria andBsellLessThan(Boolean value) {
			addCriterion("bSell <", value, "bsell");
			return (Criteria) this;
		}

		public Criteria andBsellLessThanOrEqualTo(Boolean value) {
			addCriterion("bSell <=", value, "bsell");
			return (Criteria) this;
		}

		public Criteria andBsellIn(List<Boolean> values) {
			addCriterion("bSell in", values, "bsell");
			return (Criteria) this;
		}

		public Criteria andBsellNotIn(List<Boolean> values) {
			addCriterion("bSell not in", values, "bsell");
			return (Criteria) this;
		}

		public Criteria andBsellBetween(Boolean value1, Boolean value2) {
			addCriterion("bSell between", value1, value2, "bsell");
			return (Criteria) this;
		}

		public Criteria andBsellNotBetween(Boolean value1, Boolean value2) {
			addCriterion("bSell not between", value1, value2, "bsell");
			return (Criteria) this;
		}

		public Criteria andBstoreIsNull() {
			addCriterion("bStore is null");
			return (Criteria) this;
		}

		public Criteria andBstoreIsNotNull() {
			addCriterion("bStore is not null");
			return (Criteria) this;
		}

		public Criteria andBstoreEqualTo(Boolean value) {
			addCriterion("bStore =", value, "bstore");
			return (Criteria) this;
		}

		public Criteria andBstoreNotEqualTo(Boolean value) {
			addCriterion("bStore <>", value, "bstore");
			return (Criteria) this;
		}

		public Criteria andBstoreGreaterThan(Boolean value) {
			addCriterion("bStore >", value, "bstore");
			return (Criteria) this;
		}

		public Criteria andBstoreGreaterThanOrEqualTo(Boolean value) {
			addCriterion("bStore >=", value, "bstore");
			return (Criteria) this;
		}

		public Criteria andBstoreLessThan(Boolean value) {
			addCriterion("bStore <", value, "bstore");
			return (Criteria) this;
		}

		public Criteria andBstoreLessThanOrEqualTo(Boolean value) {
			addCriterion("bStore <=", value, "bstore");
			return (Criteria) this;
		}

		public Criteria andBstoreIn(List<Boolean> values) {
			addCriterion("bStore in", values, "bstore");
			return (Criteria) this;
		}

		public Criteria andBstoreNotIn(List<Boolean> values) {
			addCriterion("bStore not in", values, "bstore");
			return (Criteria) this;
		}

		public Criteria andBstoreBetween(Boolean value1, Boolean value2) {
			addCriterion("bStore between", value1, value2, "bstore");
			return (Criteria) this;
		}

		public Criteria andBstoreNotBetween(Boolean value1, Boolean value2) {
			addCriterion("bStore not between", value1, value2, "bstore");
			return (Criteria) this;
		}

		public Criteria andBdropIsNull() {
			addCriterion("bDrop is null");
			return (Criteria) this;
		}

		public Criteria andBdropIsNotNull() {
			addCriterion("bDrop is not null");
			return (Criteria) this;
		}

		public Criteria andBdropEqualTo(Boolean value) {
			addCriterion("bDrop =", value, "bdrop");
			return (Criteria) this;
		}

		public Criteria andBdropNotEqualTo(Boolean value) {
			addCriterion("bDrop <>", value, "bdrop");
			return (Criteria) this;
		}

		public Criteria andBdropGreaterThan(Boolean value) {
			addCriterion("bDrop >", value, "bdrop");
			return (Criteria) this;
		}

		public Criteria andBdropGreaterThanOrEqualTo(Boolean value) {
			addCriterion("bDrop >=", value, "bdrop");
			return (Criteria) this;
		}

		public Criteria andBdropLessThan(Boolean value) {
			addCriterion("bDrop <", value, "bdrop");
			return (Criteria) this;
		}

		public Criteria andBdropLessThanOrEqualTo(Boolean value) {
			addCriterion("bDrop <=", value, "bdrop");
			return (Criteria) this;
		}

		public Criteria andBdropIn(List<Boolean> values) {
			addCriterion("bDrop in", values, "bdrop");
			return (Criteria) this;
		}

		public Criteria andBdropNotIn(List<Boolean> values) {
			addCriterion("bDrop not in", values, "bdrop");
			return (Criteria) this;
		}

		public Criteria andBdropBetween(Boolean value1, Boolean value2) {
			addCriterion("bDrop between", value1, value2, "bdrop");
			return (Criteria) this;
		}

		public Criteria andBdropNotBetween(Boolean value1, Boolean value2) {
			addCriterion("bDrop not between", value1, value2, "bdrop");
			return (Criteria) this;
		}

		public Criteria andIqianghuacishuIsNull() {
			addCriterion("iQiangHuaCishu is null");
			return (Criteria) this;
		}

		public Criteria andIqianghuacishuIsNotNull() {
			addCriterion("iQiangHuaCishu is not null");
			return (Criteria) this;
		}

		public Criteria andIqianghuacishuEqualTo(Integer value) {
			addCriterion("iQiangHuaCishu =", value, "iqianghuacishu");
			return (Criteria) this;
		}

		public Criteria andIqianghuacishuNotEqualTo(Integer value) {
			addCriterion("iQiangHuaCishu <>", value, "iqianghuacishu");
			return (Criteria) this;
		}

		public Criteria andIqianghuacishuGreaterThan(Integer value) {
			addCriterion("iQiangHuaCishu >", value, "iqianghuacishu");
			return (Criteria) this;
		}

		public Criteria andIqianghuacishuGreaterThanOrEqualTo(Integer value) {
			addCriterion("iQiangHuaCishu >=", value, "iqianghuacishu");
			return (Criteria) this;
		}

		public Criteria andIqianghuacishuLessThan(Integer value) {
			addCriterion("iQiangHuaCishu <", value, "iqianghuacishu");
			return (Criteria) this;
		}

		public Criteria andIqianghuacishuLessThanOrEqualTo(Integer value) {
			addCriterion("iQiangHuaCishu <=", value, "iqianghuacishu");
			return (Criteria) this;
		}

		public Criteria andIqianghuacishuIn(List<Integer> values) {
			addCriterion("iQiangHuaCishu in", values, "iqianghuacishu");
			return (Criteria) this;
		}

		public Criteria andIqianghuacishuNotIn(List<Integer> values) {
			addCriterion("iQiangHuaCishu not in", values, "iqianghuacishu");
			return (Criteria) this;
		}

		public Criteria andIqianghuacishuBetween(Integer value1, Integer value2) {
			addCriterion("iQiangHuaCishu between", value1, value2, "iqianghuacishu");
			return (Criteria) this;
		}

		public Criteria andIqianghuacishuNotBetween(Integer value1, Integer value2) {
			addCriterion("iQiangHuaCishu not between", value1, value2, "iqianghuacishu");
			return (Criteria) this;
		}

		public Criteria andImasuIsNull() {
			addCriterion("iMaSu is null");
			return (Criteria) this;
		}

		public Criteria andImasuIsNotNull() {
			addCriterion("iMaSu is not null");
			return (Criteria) this;
		}

		public Criteria andImasuEqualTo(Integer value) {
			addCriterion("iMaSu =", value, "imasu");
			return (Criteria) this;
		}

		public Criteria andImasuNotEqualTo(Integer value) {
			addCriterion("iMaSu <>", value, "imasu");
			return (Criteria) this;
		}

		public Criteria andImasuGreaterThan(Integer value) {
			addCriterion("iMaSu >", value, "imasu");
			return (Criteria) this;
		}

		public Criteria andImasuGreaterThanOrEqualTo(Integer value) {
			addCriterion("iMaSu >=", value, "imasu");
			return (Criteria) this;
		}

		public Criteria andImasuLessThan(Integer value) {
			addCriterion("iMaSu <", value, "imasu");
			return (Criteria) this;
		}

		public Criteria andImasuLessThanOrEqualTo(Integer value) {
			addCriterion("iMaSu <=", value, "imasu");
			return (Criteria) this;
		}

		public Criteria andImasuIn(List<Integer> values) {
			addCriterion("iMaSu in", values, "imasu");
			return (Criteria) this;
		}

		public Criteria andImasuNotIn(List<Integer> values) {
			addCriterion("iMaSu not in", values, "imasu");
			return (Criteria) this;
		}

		public Criteria andImasuBetween(Integer value1, Integer value2) {
			addCriterion("iMaSu between", value1, value2, "imasu");
			return (Criteria) this;
		}

		public Criteria andImasuNotBetween(Integer value1, Integer value2) {
			addCriterion("iMaSu not between", value1, value2, "imasu");
			return (Criteria) this;
		}

		public Criteria andIfangyuIsNull() {
			addCriterion("iFangyu is null");
			return (Criteria) this;
		}

		public Criteria andIfangyuIsNotNull() {
			addCriterion("iFangyu is not null");
			return (Criteria) this;
		}

		public Criteria andIfangyuEqualTo(Integer value) {
			addCriterion("iFangyu =", value, "ifangyu");
			return (Criteria) this;
		}

		public Criteria andIfangyuNotEqualTo(Integer value) {
			addCriterion("iFangyu <>", value, "ifangyu");
			return (Criteria) this;
		}

		public Criteria andIfangyuGreaterThan(Integer value) {
			addCriterion("iFangyu >", value, "ifangyu");
			return (Criteria) this;
		}

		public Criteria andIfangyuGreaterThanOrEqualTo(Integer value) {
			addCriterion("iFangyu >=", value, "ifangyu");
			return (Criteria) this;
		}

		public Criteria andIfangyuLessThan(Integer value) {
			addCriterion("iFangyu <", value, "ifangyu");
			return (Criteria) this;
		}

		public Criteria andIfangyuLessThanOrEqualTo(Integer value) {
			addCriterion("iFangyu <=", value, "ifangyu");
			return (Criteria) this;
		}

		public Criteria andIfangyuIn(List<Integer> values) {
			addCriterion("iFangyu in", values, "ifangyu");
			return (Criteria) this;
		}

		public Criteria andIfangyuNotIn(List<Integer> values) {
			addCriterion("iFangyu not in", values, "ifangyu");
			return (Criteria) this;
		}

		public Criteria andIfangyuBetween(Integer value1, Integer value2) {
			addCriterion("iFangyu between", value1, value2, "ifangyu");
			return (Criteria) this;
		}

		public Criteria andIfangyuNotBetween(Integer value1, Integer value2) {
			addCriterion("iFangyu not between", value1, value2, "ifangyu");
			return (Criteria) this;
		}

		public Criteria andIgongjiIsNull() {
			addCriterion("iGongji is null");
			return (Criteria) this;
		}

		public Criteria andIgongjiIsNotNull() {
			addCriterion("iGongji is not null");
			return (Criteria) this;
		}

		public Criteria andIgongjiEqualTo(Integer value) {
			addCriterion("iGongji =", value, "igongji");
			return (Criteria) this;
		}

		public Criteria andIgongjiNotEqualTo(Integer value) {
			addCriterion("iGongji <>", value, "igongji");
			return (Criteria) this;
		}

		public Criteria andIgongjiGreaterThan(Integer value) {
			addCriterion("iGongji >", value, "igongji");
			return (Criteria) this;
		}

		public Criteria andIgongjiGreaterThanOrEqualTo(Integer value) {
			addCriterion("iGongji >=", value, "igongji");
			return (Criteria) this;
		}

		public Criteria andIgongjiLessThan(Integer value) {
			addCriterion("iGongji <", value, "igongji");
			return (Criteria) this;
		}

		public Criteria andIgongjiLessThanOrEqualTo(Integer value) {
			addCriterion("iGongji <=", value, "igongji");
			return (Criteria) this;
		}

		public Criteria andIgongjiIn(List<Integer> values) {
			addCriterion("iGongji in", values, "igongji");
			return (Criteria) this;
		}

		public Criteria andIgongjiNotIn(List<Integer> values) {
			addCriterion("iGongji not in", values, "igongji");
			return (Criteria) this;
		}

		public Criteria andIgongjiBetween(Integer value1, Integer value2) {
			addCriterion("iGongji between", value1, value2, "igongji");
			return (Criteria) this;
		}

		public Criteria andIgongjiNotBetween(Integer value1, Integer value2) {
			addCriterion("iGongji not between", value1, value2, "igongji");
			return (Criteria) this;
		}

		public Criteria andIshenshangliuliangIsNull() {
			addCriterion("iShenshangliuliang is null");
			return (Criteria) this;
		}

		public Criteria andIshenshangliuliangIsNotNull() {
			addCriterion("iShenshangliuliang is not null");
			return (Criteria) this;
		}

		public Criteria andIshenshangliuliangEqualTo(Integer value) {
			addCriterion("iShenshangliuliang =", value, "ishenshangliuliang");
			return (Criteria) this;
		}

		public Criteria andIshenshangliuliangNotEqualTo(Integer value) {
			addCriterion("iShenshangliuliang <>", value, "ishenshangliuliang");
			return (Criteria) this;
		}

		public Criteria andIshenshangliuliangGreaterThan(Integer value) {
			addCriterion("iShenshangliuliang >", value, "ishenshangliuliang");
			return (Criteria) this;
		}

		public Criteria andIshenshangliuliangGreaterThanOrEqualTo(Integer value) {
			addCriterion("iShenshangliuliang >=", value, "ishenshangliuliang");
			return (Criteria) this;
		}

		public Criteria andIshenshangliuliangLessThan(Integer value) {
			addCriterion("iShenshangliuliang <", value, "ishenshangliuliang");
			return (Criteria) this;
		}

		public Criteria andIshenshangliuliangLessThanOrEqualTo(Integer value) {
			addCriterion("iShenshangliuliang <=", value, "ishenshangliuliang");
			return (Criteria) this;
		}

		public Criteria andIshenshangliuliangIn(List<Integer> values) {
			addCriterion("iShenshangliuliang in", values, "ishenshangliuliang");
			return (Criteria) this;
		}

		public Criteria andIshenshangliuliangNotIn(List<Integer> values) {
			addCriterion("iShenshangliuliang not in", values, "ishenshangliuliang");
			return (Criteria) this;
		}

		public Criteria andIshenshangliuliangBetween(Integer value1, Integer value2) {
			addCriterion("iShenshangliuliang between", value1, value2, "ishenshangliuliang");
			return (Criteria) this;
		}

		public Criteria andIshenshangliuliangNotBetween(Integer value1, Integer value2) {
			addCriterion("iShenshangliuliang not between", value1, value2, "ishenshangliuliang");
			return (Criteria) this;
		}

		public Criteria andIwujiangjiIsNull() {
			addCriterion("iWujiangji is null");
			return (Criteria) this;
		}

		public Criteria andIwujiangjiIsNotNull() {
			addCriterion("iWujiangji is not null");
			return (Criteria) this;
		}

		public Criteria andIwujiangjiEqualTo(Integer value) {
			addCriterion("iWujiangji =", value, "iwujiangji");
			return (Criteria) this;
		}

		public Criteria andIwujiangjiNotEqualTo(Integer value) {
			addCriterion("iWujiangji <>", value, "iwujiangji");
			return (Criteria) this;
		}

		public Criteria andIwujiangjiGreaterThan(Integer value) {
			addCriterion("iWujiangji >", value, "iwujiangji");
			return (Criteria) this;
		}

		public Criteria andIwujiangjiGreaterThanOrEqualTo(Integer value) {
			addCriterion("iWujiangji >=", value, "iwujiangji");
			return (Criteria) this;
		}

		public Criteria andIwujiangjiLessThan(Integer value) {
			addCriterion("iWujiangji <", value, "iwujiangji");
			return (Criteria) this;
		}

		public Criteria andIwujiangjiLessThanOrEqualTo(Integer value) {
			addCriterion("iWujiangji <=", value, "iwujiangji");
			return (Criteria) this;
		}

		public Criteria andIwujiangjiIn(List<Integer> values) {
			addCriterion("iWujiangji in", values, "iwujiangji");
			return (Criteria) this;
		}

		public Criteria andIwujiangjiNotIn(List<Integer> values) {
			addCriterion("iWujiangji not in", values, "iwujiangji");
			return (Criteria) this;
		}

		public Criteria andIwujiangjiBetween(Integer value1, Integer value2) {
			addCriterion("iWujiangji between", value1, value2, "iwujiangji");
			return (Criteria) this;
		}

		public Criteria andIwujiangjiNotBetween(Integer value1, Integer value2) {
			addCriterion("iWujiangji not between", value1, value2, "iwujiangji");
			return (Criteria) this;
		}

		public Criteria andIlevIsNull() {
			addCriterion("iLev is null");
			return (Criteria) this;
		}

		public Criteria andIlevIsNotNull() {
			addCriterion("iLev is not null");
			return (Criteria) this;
		}

		public Criteria andIlevEqualTo(Integer value) {
			addCriterion("iLev =", value, "ilev");
			return (Criteria) this;
		}

		public Criteria andIlevNotEqualTo(Integer value) {
			addCriterion("iLev <>", value, "ilev");
			return (Criteria) this;
		}

		public Criteria andIlevGreaterThan(Integer value) {
			addCriterion("iLev >", value, "ilev");
			return (Criteria) this;
		}

		public Criteria andIlevGreaterThanOrEqualTo(Integer value) {
			addCriterion("iLev >=", value, "ilev");
			return (Criteria) this;
		}

		public Criteria andIlevLessThan(Integer value) {
			addCriterion("iLev <", value, "ilev");
			return (Criteria) this;
		}

		public Criteria andIlevLessThanOrEqualTo(Integer value) {
			addCriterion("iLev <=", value, "ilev");
			return (Criteria) this;
		}

		public Criteria andIlevIn(List<Integer> values) {
			addCriterion("iLev in", values, "ilev");
			return (Criteria) this;
		}

		public Criteria andIlevNotIn(List<Integer> values) {
			addCriterion("iLev not in", values, "ilev");
			return (Criteria) this;
		}

		public Criteria andIlevBetween(Integer value1, Integer value2) {
			addCriterion("iLev between", value1, value2, "ilev");
			return (Criteria) this;
		}

		public Criteria andIlevNotBetween(Integer value1, Integer value2) {
			addCriterion("iLev not between", value1, value2, "ilev");
			return (Criteria) this;
		}

		public Criteria andBlevGtIsNull() {
			addCriterion("bLev_gt is null");
			return (Criteria) this;
		}

		public Criteria andBlevGtIsNotNull() {
			addCriterion("bLev_gt is not null");
			return (Criteria) this;
		}

		public Criteria andBlevGtEqualTo(Boolean value) {
			addCriterion("bLev_gt =", value, "blevGt");
			return (Criteria) this;
		}

		public Criteria andBlevGtNotEqualTo(Boolean value) {
			addCriterion("bLev_gt <>", value, "blevGt");
			return (Criteria) this;
		}

		public Criteria andBlevGtGreaterThan(Boolean value) {
			addCriterion("bLev_gt >", value, "blevGt");
			return (Criteria) this;
		}

		public Criteria andBlevGtGreaterThanOrEqualTo(Boolean value) {
			addCriterion("bLev_gt >=", value, "blevGt");
			return (Criteria) this;
		}

		public Criteria andBlevGtLessThan(Boolean value) {
			addCriterion("bLev_gt <", value, "blevGt");
			return (Criteria) this;
		}

		public Criteria andBlevGtLessThanOrEqualTo(Boolean value) {
			addCriterion("bLev_gt <=", value, "blevGt");
			return (Criteria) this;
		}

		public Criteria andBlevGtIn(List<Boolean> values) {
			addCriterion("bLev_gt in", values, "blevGt");
			return (Criteria) this;
		}

		public Criteria andBlevGtNotIn(List<Boolean> values) {
			addCriterion("bLev_gt not in", values, "blevGt");
			return (Criteria) this;
		}

		public Criteria andBlevGtBetween(Boolean value1, Boolean value2) {
			addCriterion("bLev_gt between", value1, value2, "blevGt");
			return (Criteria) this;
		}

		public Criteria andBlevGtNotBetween(Boolean value1, Boolean value2) {
			addCriterion("bLev_gt not between", value1, value2, "blevGt");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(String value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(String value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(String value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(String value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(String value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(String value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLike(String value) {
			addCriterion("type like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotLike(String value) {
			addCriterion("type not like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<String> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<String> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(String value1, String value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(String value1, String value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andSubtypeIsNull() {
			addCriterion("subType is null");
			return (Criteria) this;
		}

		public Criteria andSubtypeIsNotNull() {
			addCriterion("subType is not null");
			return (Criteria) this;
		}

		public Criteria andSubtypeEqualTo(String value) {
			addCriterion("subType =", value, "subtype");
			return (Criteria) this;
		}

		public Criteria andSubtypeNotEqualTo(String value) {
			addCriterion("subType <>", value, "subtype");
			return (Criteria) this;
		}

		public Criteria andSubtypeGreaterThan(String value) {
			addCriterion("subType >", value, "subtype");
			return (Criteria) this;
		}

		public Criteria andSubtypeGreaterThanOrEqualTo(String value) {
			addCriterion("subType >=", value, "subtype");
			return (Criteria) this;
		}

		public Criteria andSubtypeLessThan(String value) {
			addCriterion("subType <", value, "subtype");
			return (Criteria) this;
		}

		public Criteria andSubtypeLessThanOrEqualTo(String value) {
			addCriterion("subType <=", value, "subtype");
			return (Criteria) this;
		}

		public Criteria andSubtypeLike(String value) {
			addCriterion("subType like", value, "subtype");
			return (Criteria) this;
		}

		public Criteria andSubtypeNotLike(String value) {
			addCriterion("subType not like", value, "subtype");
			return (Criteria) this;
		}

		public Criteria andSubtypeIn(List<String> values) {
			addCriterion("subType in", values, "subtype");
			return (Criteria) this;
		}

		public Criteria andSubtypeNotIn(List<String> values) {
			addCriterion("subType not in", values, "subtype");
			return (Criteria) this;
		}

		public Criteria andSubtypeBetween(String value1, String value2) {
			addCriterion("subType between", value1, value2, "subtype");
			return (Criteria) this;
		}

		public Criteria andSubtypeNotBetween(String value1, String value2) {
			addCriterion("subType not between", value1, value2, "subtype");
			return (Criteria) this;
		}

		public Criteria andSeqIsNull() {
			addCriterion("seq is null");
			return (Criteria) this;
		}

		public Criteria andSeqIsNotNull() {
			addCriterion("seq is not null");
			return (Criteria) this;
		}

		public Criteria andSeqEqualTo(Integer value) {
			addCriterion("seq =", value, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqNotEqualTo(Integer value) {
			addCriterion("seq <>", value, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqGreaterThan(Integer value) {
			addCriterion("seq >", value, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqGreaterThanOrEqualTo(Integer value) {
			addCriterion("seq >=", value, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqLessThan(Integer value) {
			addCriterion("seq <", value, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqLessThanOrEqualTo(Integer value) {
			addCriterion("seq <=", value, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqIn(List<Integer> values) {
			addCriterion("seq in", values, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqNotIn(List<Integer> values) {
			addCriterion("seq not in", values, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqBetween(Integer value1, Integer value2) {
			addCriterion("seq between", value1, value2, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqNotBetween(Integer value1, Integer value2) {
			addCriterion("seq not between", value1, value2, "seq");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {
		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}
