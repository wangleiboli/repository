package org.boli.myweb.model;

import org.boli.myweb.entity.Itemguolv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Itemguolv4Config {

	@JsonProperty("ObjName")
	private String objname;
	@JsonProperty("bSell")
	private Boolean bsell;
	@JsonProperty("bStore")
	private Boolean bstore;
	@JsonProperty("bDrop")
	private Boolean bdrop;
	@JsonProperty("iQiangHuaCishu")
	private Integer iqianghuacishu;
	@JsonProperty("iMaSu")
	private Integer imasu;
	@JsonProperty("iFangyu")
	private Integer ifangyu;
	@JsonProperty("iGongji")
	private Integer igongji;
	@JsonProperty("iShenshangliuliang")
	private Integer ishenshangliuliang;
	@JsonProperty("iWujiangji")
	private Integer iwujiangji;
	@JsonProperty("iLev")
	private Integer ilev;
	@JsonProperty("bLev_gt")
	private Boolean blevGt;

	public Itemguolv4Config() {
		super();
		this.objname = "";
		this.bsell = false;
		this.bstore = false;
		this.bdrop = false;
		this.iqianghuacishu = 0;
		this.imasu = 0;
		this.ifangyu = 0;
		this.igongji = 0;
		this.ishenshangliuliang = 0;
		this.iwujiangji = 0;
		this.ilev = 0;
		this.blevGt = false;
	}

	public Itemguolv4Config(Itemguolv itemguolv) {
		super();
		this.objname = itemguolv.getObjname() == null ? "" : itemguolv.getObjname();
		this.bsell = itemguolv.getBsell() == null ? false : itemguolv.getBsell();
		this.bstore = itemguolv.getBstore() == null ? false : itemguolv.getBstore();
		this.bdrop = itemguolv.getBdrop() == null ? false : itemguolv.getBdrop();
		this.iqianghuacishu = itemguolv.getIqianghuacishu() == null ? 0 : itemguolv.getIqianghuacishu();
		this.imasu = itemguolv.getImasu() == null ? 0 : itemguolv.getImasu();
		this.ifangyu = itemguolv.getIfangyu() == null ? 0 : itemguolv.getIfangyu();
		this.igongji = itemguolv.getIgongji() == null ? 0 : itemguolv.getIgongji();
		this.ishenshangliuliang = itemguolv.getIshenshangliuliang() == null ? 0 : itemguolv.getIshenshangliuliang();
		this.iwujiangji = itemguolv.getIwujiangji() == null ? 0 : itemguolv.getIwujiangji();
		this.ilev = itemguolv.getIlev() == null ? 0 : itemguolv.getIlev();
		this.blevGt = itemguolv.getBlevGt() == null ? false : itemguolv.getBlevGt();
	}

	public Itemguolv4Config(String objname, Boolean bsell, Boolean bstore, Boolean bdrop, Integer iqianghuacishu,
			Integer imasu, Integer ifangyu, Integer igongji, Integer ishenshangliuliang, Integer iwujiangji,
			Integer ilev, Boolean blevGt) {
		super();
		this.objname = objname == null ? "" : objname;
		this.bsell = bsell == null ? false : bsell;
		this.bstore = bstore == null ? false : bstore;
		this.bdrop = bdrop == null ? false : bdrop;
		this.iqianghuacishu = iqianghuacishu == null ? 0 : iqianghuacishu;
		this.imasu = imasu == null ? 0 : imasu;
		this.ifangyu = ifangyu == null ? 0 : ifangyu;
		this.igongji = igongji == null ? 0 : igongji;
		this.ishenshangliuliang = ishenshangliuliang == null ? 0 : ishenshangliuliang;
		this.iwujiangji = iwujiangji == null ? 0 : iwujiangji;
		this.ilev = ilev == null ? 0 : ilev;
		this.blevGt = blevGt == null ? false : blevGt;
	}

	@JsonIgnore
	public String getObjname() {
		return objname;
	}

	@JsonIgnore
	public void setObjname(String objname) {
		this.objname = objname == null ? null : objname.trim();
	}

	@JsonIgnore
	public Boolean getBsell() {
		return bsell;
	}

	@JsonIgnore
	public void setBsell(Boolean bsell) {
		this.bsell = bsell;
	}

	@JsonIgnore
	public Boolean getBstore() {
		return bstore;
	}

	@JsonIgnore
	public void setBstore(Boolean bstore) {
		this.bstore = bstore;
	}

	@JsonIgnore
	public Boolean getBdrop() {
		return bdrop;
	}

	@JsonIgnore
	public void setBdrop(Boolean bdrop) {
		this.bdrop = bdrop;
	}

	@JsonIgnore
	public Integer getIqianghuacishu() {
		return iqianghuacishu;
	}

	@JsonIgnore
	public void setIqianghuacishu(Integer iqianghuacishu) {
		this.iqianghuacishu = iqianghuacishu;
	}

	@JsonIgnore
	public Integer getImasu() {
		return imasu;
	}

	@JsonIgnore
	public void setImasu(Integer imasu) {
		this.imasu = imasu;
	}

	@JsonIgnore
	public Integer getIfangyu() {
		return ifangyu;
	}

	@JsonIgnore
	public void setIfangyu(Integer ifangyu) {
		this.ifangyu = ifangyu;
	}

	@JsonIgnore
	public Integer getIgongji() {
		return igongji;
	}

	@JsonIgnore
	public void setIgongji(Integer igongji) {
		this.igongji = igongji;
	}

	@JsonIgnore
	public Integer getIshenshangliuliang() {
		return ishenshangliuliang;
	}

	@JsonIgnore
	public void setIshenshangliuliang(Integer ishenshangliuliang) {
		this.ishenshangliuliang = ishenshangliuliang;
	}

	@JsonIgnore
	public Integer getIwujiangji() {
		return iwujiangji;
	}

	@JsonIgnore
	public void setIwujiangji(Integer iwujiangji) {
		this.iwujiangji = iwujiangji;
	}

	@JsonIgnore
	public Integer getIlev() {
		return ilev;
	}

	@JsonIgnore
	public void setIlev(Integer ilev) {
		this.ilev = ilev;
	}

	@JsonIgnore
	public Boolean getBlevGt() {
		return blevGt;
	}

	@JsonIgnore
	public void setBlevGt(Boolean blevGt) {
		this.blevGt = blevGt;
	}

}
