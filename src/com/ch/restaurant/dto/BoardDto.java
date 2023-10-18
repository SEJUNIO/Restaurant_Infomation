package com.ch.restaurant.dto;

import java.sql.Date;

public class BoardDto {
	private int bid;
	private String mid;
	private String aid;
	private String btitle;
	private String bcontent;
	private int bhit;
	private String bpw;
	private int bgroup;
	private int bstep;
	private int bindent;
	private String bip;
	private Date brdate;
	public BoardDto() {}
	public BoardDto(int bid, String mid, String aid, String btitle, String bcontent, int bhit, String bpw, int bgroup,
			int bstep, int bindent, String bip, Date brdate) {
		this.bid = bid;
		this.mid = mid;
		this.aid = aid;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bhit = bhit;
		this.bpw = bpw;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
		this.bip = bip;
		this.brdate = brdate;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public String getBpw() {
		return bpw;
	}
	public void setBpw(String bpw) {
		this.bpw = bpw;
	}
	public int getBgroup() {
		return bgroup;
	}
	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}
	public int getBstep() {
		return bstep;
	}
	public void setBstep(int bstep) {
		this.bstep = bstep;
	}
	public int getBindent() {
		return bindent;
	}
	public void setBindent(int bindent) {
		this.bindent = bindent;
	}
	public String getBip() {
		return bip;
	}
	public void setBip(String bip) {
		this.bip = bip;
	}
	public Date getBrdate() {
		return brdate;
	}
	public void setBrdate(Date brdate) {
		this.brdate = brdate;
	}
	@Override
	public String toString() {
		return "BoardDto [bid=" + bid + ", mid=" + mid + ", aid=" + aid + ", btitle=" + btitle + ", bcontent="
				+ bcontent + ", bhit=" + bhit + ", bpw=" + bpw + ", bgroup=" + bgroup + ", bstep=" + bstep
				+ ", bindent=" + bindent + ", bip=" + bip + ", brdate=" + brdate + "]";
	}
}
