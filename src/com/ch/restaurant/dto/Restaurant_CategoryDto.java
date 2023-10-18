package com.ch.restaurant.dto;

public class Restaurant_CategoryDto {
	private String cno;
	private String cfood;
	public Restaurant_CategoryDto() {}
	public Restaurant_CategoryDto(String cno, String cfood) {
		this.cno = cno;
		this.cfood = cfood;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCfood() {
		return cfood;
	}
	public void setCfood(String cfood) {
		this.cfood = cfood;
	}
	@Override
	public String toString() {
		return "Restaurant_CategoryDto [cno=" + cno + ", cfood=" + cfood + "]";
	}
}
