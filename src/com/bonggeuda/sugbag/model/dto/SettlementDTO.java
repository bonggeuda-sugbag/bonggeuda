package com.bonggeuda.sugbag.model.dto;

import java.util.Date;

public class SettlementDTO {

	private int reqStlNo;
	private int accomoNo;
	private Date reqDate;
	private String stlYn;
	private String accomoName;

	public SettlementDTO() {
		super();
	}

	public SettlementDTO(int reqStlNo, int accomoNo, Date reqDate, String stlYn, String accomoName) {
		super();
		this.reqStlNo = reqStlNo;
		this.accomoNo = accomoNo;
		this.reqDate = reqDate;
		this.stlYn = stlYn;
		this.accomoName = accomoName;
	}

	public int getReqStlNo() {
		return reqStlNo;
	}

	public void setReqStlNo(int reqStlNo) {
		this.reqStlNo = reqStlNo;
	}

	public int getAccomoNo() {
		return accomoNo;
	}

	public void setAccomoNo(int accomoNo) {
		this.accomoNo = accomoNo;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public String getStlYn() {
		return stlYn;
	}

	public void setStlYn(String stlYn) {
		this.stlYn = stlYn;
	}

	public String getAccomoName() {
		return accomoName;
	}

	public void setAccomoName(String accomoName) {
		this.accomoName = accomoName;
	}

	@Override
	public String toString() {
		return "SettlementDTO [reqStlNo=" + reqStlNo + ", accomoNo=" + accomoNo + ", reqDate=" + reqDate + ", stlYn="
				+ stlYn + ", accomoName=" + accomoName + "]";
	}

}
