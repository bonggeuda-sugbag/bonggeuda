package com.bonggeuda.adminEvent.dto;

import java.sql.Date;

public class EventDTO {
	
	private int rnum;
	private int number;
	private String title;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	
	public EventDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventDTO(int rnum, int number, String title, Date startDate, Date endDate) {
		super();
		this.rnum = rnum;
		this.number = number;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public java.sql.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}

	public java.sql.Date getEndDate() {
		return endDate;
	}

	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "EventDTO [rnum=" + rnum + ", number=" + number + ", title=" + title + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
	
	
}
