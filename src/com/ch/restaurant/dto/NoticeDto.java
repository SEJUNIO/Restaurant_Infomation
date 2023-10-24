package com.ch.restaurant.dto;

import java.sql.Date;

public class NoticeDto {
	private int nid;
	private String aid;
	private String ntitle;
	private String ncontent;
	private int nhit;
	private int ngroup;
	private int nstep;
	private int nindent;
	private String nip;
	private Date nrdate;
	public NoticeDto() {}
	public NoticeDto(int nid, String aid, String ntitle, String ncontent, int nhit, int ngroup, int nstep, int nindent,
			String nip, Date nrdate) {
		this.nid = nid;
		this.aid = aid;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.nhit = nhit;
		this.ngroup = ngroup;
		this.nstep = nstep;
		this.nindent = nindent;
		this.nip = nip;
		this.nrdate = nrdate;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public int getNhit() {
		return nhit;
	}
	public void setNhit(int nhit) {
		this.nhit = nhit;
	}
	public int getNgroup() {
		return ngroup;
	}
	public void setNgroup(int ngroup) {
		this.ngroup = ngroup;
	}
	public int getNstep() {
		return nstep;
	}
	public void setNstep(int nstep) {
		this.nstep = nstep;
	}
	public int getNindent() {
		return nindent;
	}
	public void setNindent(int nindent) {
		this.nindent = nindent;
	}
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}
	public Date getNrdate() {
		return nrdate;
	}
	public void setNrdate(Date nrdate) {
		this.nrdate = nrdate;
	}
	@Override
	public String toString() {
		return "NoticeDto [nid=" + nid + ", aid=" + aid + ", ntitle=" + ntitle + ", ncontent=" + ncontent + ", nhit="
				+ nhit + ", ngroup=" + ngroup + ", nstep=" + nstep + ", nindent=" + nindent + ", nip=" + nip
				+ ", nrdate=" + nrdate + "]";
	}
}