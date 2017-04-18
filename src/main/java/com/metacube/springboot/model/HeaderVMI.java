package com.metacube.springboot.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name="header")
//@XmlJavaTypeAdapter(StringAdapter.class)
@XmlType(propOrder = { "errCode", "errMsg", "vin", "fin", "owner", "engineNo",
		"transmission", "noOfOwner", "noOfLine", "optnCount", "campCount",
		"servCount", "histCount", "manfact", "prodDate", "upHolstery", "uPain",
		"lPain", "dlvyDate", "invDate", "invDealer", "dlvyType", "prstatDesc",
		"lsRepairs", "vehInfos", "warrSales", "odoMeters", "indicators",
		"optionCodes", "campaigns", "servPackages", "vehHistorys", "vehStats", "csiInfos"})
@JsonInclude(Include.NON_NULL)
@Region("VMI")
public class HeaderVMI {
	
	private String errCode="";
	private String errMsg;
	
	@Id
	private String vin="";
	private String fin="";
	private String owner="";
	private String engineNo="";
	private String transmission="";
	private String noOfOwner="";
	private String noOfLine="";
	private String optnCount="";
	private String campCount="";
	private String servCount="";
	private String histCount="";
	private String manfact="";
	private String prodDate="";
	private String upHolstery="";
	private String uPain="";
	private String lPain="";
	private String dlvyDate="";
	private String invDate="";
	private String invDealer="";
	private String dlvyType="";
	private String prstatDesc="";
	
	
	
	@XmlElement(name="errCode")
	@JsonProperty("errCode")
	public String getErrCode() {
		return errCode;
	}
	@XmlElement(name="vin")
	@JsonProperty("vin")
	public String getVin() {
		return vin;
	}
	@XmlElement(name="fin")
	@JsonProperty("fin")
	public String getFin() {
		return fin;
	}
	@XmlElement(name="owner")
	@JsonProperty("owner")
	public String getOwner() {
		return owner;
	}
	@XmlElement(name="engineNo")
	@JsonProperty("engineNo")
	public String getEngineNo() {
		return engineNo;
	}
	@XmlElement(name="transmission")
	@JsonProperty("transmission")
	public String getTransmission() {
		return transmission;
	}
	@XmlElement(name="noOfOwner")
	@JsonProperty("noOfOwner")
	public String getNoOfOwner() {
		return noOfOwner;
	}
	@XmlElement(name="noOfLine")
	@JsonProperty("noOfLine")
	public String getNoOfLine() {
		return noOfLine;
	}
	@XmlElement(name="optnCount")
	@JsonProperty("optnCount")
	public String getOptnCount() {
		return optnCount;
	}
	@XmlElement(name="campCount")
	@JsonProperty("campCount")
	public String getCampCount() {
		return campCount;
	}
	@XmlElement(name="servCount")
	@JsonProperty("servCount")
	public String getServCount() {
		return servCount;
	}
	@XmlElement(name="histCount")
	@JsonProperty("histCount")
	public String getHistCount() {
		return histCount;
	}
	@XmlElement(name="manfact")
	@JsonProperty("manfact")
	public String getManfact() {
		return manfact;
	}
	@XmlElement(name="prodDate")
	@JsonProperty("prodDate")
	public String getProdDate() {
		return prodDate;
	}
	@XmlElement(name="upHolstery")
	@JsonProperty("upHolstery")
	public String getUpHolstery() {
		return upHolstery;
	}
	@XmlElement(name="uPain")
	@JsonProperty("uPain")
	public String getuPain() {
		return uPain;
	}
	@XmlElement(name="lPain")
	@JsonProperty("lPain")
	public String getlPain() {
		return lPain;
	}
	@XmlElement(name="dlvyDate")
	@JsonProperty("dlvyDate")
	public String getDlvyDate() {
		return dlvyDate;
	}
	@XmlElement(name="invDate")
	@JsonProperty("invDate")
	public String getInvDate() {
		return invDate;
	}
	@XmlElement(name="invDealer")
	@JsonProperty("invDealer")
	public String getInvDealer() {
		return invDealer;
	}
	@XmlElement(name="dlvyType")
	@JsonProperty("dlvyType")
	public String getDlvyType() {
		return dlvyType;
	}
	@XmlElement(name="prstatDesc")
	@JsonProperty("prstatDesc")
	public String getPrstatDesc() {
		return prstatDesc;
	}
	
	@XmlElement(name="errMsg")
	@JsonProperty("errMsg")
	public String getErrMsg() {
		return errMsg;
	}
	
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public void setNoOfOwner(String noOfOwner) {
		this.noOfOwner = noOfOwner;
	}
	public void setNoOfLine(String noOfLine) {
		this.noOfLine = noOfLine;
	}
	public void setOptnCount(String optnCount) {
		this.optnCount = optnCount;
	}
	public void setCampCount(String campCount) {
		this.campCount = campCount;
	}
	public void setServCount(String servCount) {
		this.servCount = servCount;
	}
	public void setHistCount(String histCount) {
		this.histCount = histCount;
	}
	public void setManfact(String manfact) {
		this.manfact = manfact;
	}
	public void setProdDate(String prodDate) {
		this.prodDate = prodDate;
	}
	public void setUpHolstery(String upHolstery) {
		this.upHolstery = upHolstery;
	}
	public void setuPain(String uPain) {
		this.uPain = uPain;
	}
	public void setlPain(String lPain) {
		this.lPain = lPain;
	}
	public void setDlvyDate(String dlvyDate) {
		this.dlvyDate = dlvyDate;
	}
	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}
	public void setInvDealer(String invDealer) {
		this.invDealer = invDealer;
	}
	public void setDlvyType(String dlvyType) {
		this.dlvyType = dlvyType;
	}
	public void setPrstatDesc(String prstatDesc) {
		this.prstatDesc = prstatDesc;
	}
	
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
}
