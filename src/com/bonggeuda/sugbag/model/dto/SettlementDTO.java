package com.bonggeuda.sugbag.model.dto;

import java.util.Date;

public class SettlementDTO {

	private int reqStlNo;
	private int accomoNo;
	private Date reqDate;
	private String stlYn;

	public SettlementDTO() {
		super();
	}

	public SettlementDTO(int reqStlNo, int accomoNo, Date reqDate, String stlYn) {
		super();
		this.reqStlNo = reqStlNo;
		this.accomoNo = accomoNo;
		this.reqDate = reqDate;
		this.stlYn = stlYn;
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

	@Override
	public String toString() {
		return "SettlementDTO [reqStlNo=" + reqStlNo + ", accomoNo=" + accomoNo + ", reqDate=" + reqDate + ", stlYn="
				+ stlYn + "]";
	}

}
