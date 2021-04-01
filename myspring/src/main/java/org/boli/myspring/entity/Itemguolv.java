package org.boli.myspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Itemguolv {
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
	@JsonProperty("type")
	private String type;
	@JsonProperty("subType")
	private String subtype;
	@JsonProperty("seq")
	private Integer seq;

	public Itemguolv() {
	}

	public Itemguolv(String objname, boolean bsell) {
		super();
		this.objname = objname;
		this.bsell = bsell;
	}

	public Itemguolv(String objname, Boolean bsell, Boolean bstore, Boolean bdrop, Integer iqianghuacishu,
			Integer imasu, Integer ifangyu, Integer igongji, Integer ishenshangliuliang, Integer iwujiangji,
			Integer ilev, Boolean blevGt, String type, String subtype, Integer seq) {
		super();
		this.objname = objname;
		this.bsell = bsell;
		this.bstore = bstore;
		this.bdrop = bdrop;
		this.iqianghuacishu = iqianghuacishu;
		this.imasu = imasu;
		this.ifangyu = ifangyu;
		this.igongji = igongji;
		this.ishenshangliuliang = ishenshangliuliang;
		this.iwujiangji = iwujiangji;
		this.ilev = ilev;
		this.blevGt = blevGt;
		this.type = type;
		this.subtype = subtype;
		this.seq = seq;
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

	@JsonIgnore
	public String getType() {
		return type;
	}

	@JsonIgnore
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	@JsonIgnore
	public String getSubtype() {
		return subtype;
	}

	@JsonIgnore
	public void setSubtype(String subtype) {
		this.subtype = subtype == null ? null : subtype.trim();
	}

	@JsonIgnore
	public Integer getSeq() {
		return seq;
	}

	@JsonIgnore
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
}
