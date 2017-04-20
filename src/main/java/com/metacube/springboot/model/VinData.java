package com.metacube.springboot.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name="VinList")
//@XmlJavaTypeAdapter(StringAdapter.class)
@XmlType(propOrder = { "vinOld", "fin", "location"})
@JsonInclude(Include.NON_NULL)
@Region("VMI")
/*@TimeToLiveExpiration(timeout = "60", action = "LOCAL_DESTROY")
@IdleTimeoutExpiration(timeout = "60", action = "LOCAL_INVALIDATE")*/
//@Expiration(timeout = "60", action = "INVALIDATE")
public class VinData {

	
	@Id
	private String vinOld="";
	private String fin="";
	private String location="";
	
	@XmlElement(name="location")
	@JsonProperty("location")
	public String getLocation() {
		return location;
	}
	@XmlElement(name="vin")
	@JsonProperty("vin")
	public String getVinOld() {
		return vinOld;
	}
	@XmlElement(name="fin")
	@JsonProperty("fin")
	public String getFin() {
		return fin;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	public void setVinOld(String vinOld) {
		this.vinOld = vinOld;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	
	

}
