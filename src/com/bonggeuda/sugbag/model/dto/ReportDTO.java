package com.bonggeuda.sugbag.model.dto;

import java.sql.Date;

public class ReportDTO {

	private int reportNo;
	private String writerType;
	private String reportReason;
	private int memberNo;
	private Date reportDate;
	private String reportTitle;
	private String reportStatus;
	private String reportedType;
	private int reportedNo;
	private String accomoName;

	public ReportDTO() {}

	public ReportDTO(int reportNo, String writerType, String reportReason, int memberNo, Date reportDate,
			String reportTitle, String reportStatus, String reportedType, int reportedNo, String accomoName) {
		super();
		this.reportNo = reportNo;
		this.writerType = writerType;
		this.reportReason = reportReason;
		this.memberNo = memberNo;
		this.reportDate = reportDate;
		this.reportTitle = reportTitle;
		this.reportStatus = reportStatus;
		this.reportedType = reportedType;
		this.reportedNo = reportedNo;
		this.accomoName = accomoName;
	}



	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public String getWriterType() {
		return writerType;
	}

	public void setWriterType(String writerType) {
		this.writerType = writerType;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public String getReportedType() {
		return reportedType;
	}

	public void setReportedType(String reportedType) {
		this.reportedType = reportedType;
	}

	public int getReportedNo() {
		return reportedNo;
	}

	public void setReportedNo(int reportedNo) {
		this.reportedNo = reportedNo;
	}

	public String getAccomoName() {
		return accomoName;
	}

	public void setAccomoName(String accomoName) {
		this.accomoName = accomoName;
	}

	@Override
	public String toString() {
		return "ReportDTO [reportNo=" + reportNo + ", writerType=" + writerType + ", reportReason=" + reportReason
				+ ", memberNo=" + memberNo + ", reportDate=" + reportDate + ", reportTitle=" + reportTitle
				+ ", reportStatus=" + reportStatus + ", reportedType=" + reportedType + ", reportedNo=" + reportedNo
				+ ", accomoName=" + accomoName + "]";
	}
	
}
