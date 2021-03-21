package org.boli.myweb.entity;

public class Itemguolv {
    private String objname;

    private Boolean bsell;

    private Boolean bstore;

    private Boolean bdrop;

    private Integer iqianghuacishu;

    private Integer imasu;

    private Integer ifangyu;

    private Integer igongji;

    private Integer ishenshangliuliang;

    private Integer iwujiangji;

    private Integer ilev;

    private Boolean blevGt;

    public String getObjname() {
        return objname;
    }

    public void setObjname(String objname) {
        this.objname = objname == null ? null : objname.trim();
    }

    public Boolean getBsell() {
        return bsell;
    }

    public void setBsell(Boolean bsell) {
        this.bsell = bsell;
    }

    public Boolean getBstore() {
        return bstore;
    }

    public void setBstore(Boolean bstore) {
        this.bstore = bstore;
    }

    public Boolean getBdrop() {
        return bdrop;
    }

    public void setBdrop(Boolean bdrop) {
        this.bdrop = bdrop;
    }

    public Integer getIqianghuacishu() {
        return iqianghuacishu;
    }

    public void setIqianghuacishu(Integer iqianghuacishu) {
        this.iqianghuacishu = iqianghuacishu;
    }

    public Integer getImasu() {
        return imasu;
    }

    public void setImasu(Integer imasu) {
        this.imasu = imasu;
    }

    public Integer getIfangyu() {
        return ifangyu;
    }

    public void setIfangyu(Integer ifangyu) {
        this.ifangyu = ifangyu;
    }

    public Integer getIgongji() {
        return igongji;
    }

    public void setIgongji(Integer igongji) {
        this.igongji = igongji;
    }

    public Integer getIshenshangliuliang() {
        return ishenshangliuliang;
    }

    public void setIshenshangliuliang(Integer ishenshangliuliang) {
        this.ishenshangliuliang = ishenshangliuliang;
    }

    public Integer getIwujiangji() {
        return iwujiangji;
    }

    public void setIwujiangji(Integer iwujiangji) {
        this.iwujiangji = iwujiangji;
    }

    public Integer getIlev() {
        return ilev;
    }

    public void setIlev(Integer ilev) {
        this.ilev = ilev;
    }

    public Boolean getBlevGt() {
        return blevGt;
    }

    public void setBlevGt(Boolean blevGt) {
        this.blevGt = blevGt;
    }
}