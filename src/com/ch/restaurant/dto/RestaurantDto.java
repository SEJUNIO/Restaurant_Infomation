package com.ch.restaurant.dto;

import java.sql.Date;

public class RestaurantDto {
	private int rno;
	private String rname;
	private String cno;
	private String raddress;
	private String rtel;
	private String rholiday;
	private Date rhours;
	private String rparking;
	public RestaurantDto() {}
	public RestaurantDto(int rno, String rname, String cno, String raddress, String rtel, String rholiday, Date rhours,
			String rparking) {
		this.rno = rno;
		this.rname = rname;
		this.cno = cno;
		this.raddress = raddress;
		this.rtel = rtel;
		this.rholiday = rholiday;
		this.rhours = rhours;
		this.rparking = rparking;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getRaddress() {
		return raddress;
	}
	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
	public String getRtel() {
		return rtel;
	}
	public void setRtel(String rtel) {
		this.rtel = rtel;
	}
	public String getRholiday() {
		return rholiday;
	}
	public void setRholiday(String rholiday) {
		this.rholiday = rholiday;
	}
	public Date getRhours() {
		return rhours;
	}
	public void setRhours(Date rhours) {
		this.rhours = rhours;
	}
	public String getRparking() {
		return rparking;
	}
	public void setRparking(String rparking) {
		this.rparking = rparking;
	}
	@Override
	public String toString() {
		return "RestaurantDto [rno=" + rno + ", rname=" + rname + ", cno=" + cno + ", raddress=" + raddress + ", rtel="
				+ rtel + ", rholiday=" + rholiday + ", rhours=" + rhours + ", rparking=" + rparking + "]";
	}
}
