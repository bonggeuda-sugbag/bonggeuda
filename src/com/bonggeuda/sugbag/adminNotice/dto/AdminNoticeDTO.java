package com.bonggeuda.sugbag.adminNotice.dto;

import java.sql.Date;

public class AdminNoticeDTO {

	private int noticeNo; // 공지번호
	private String content; //내용
	private String title; // 제목 
	private String writer; // 구분자
	private java.sql.Date writeDate; // 작성날짜	
	
	public AdminNoticeDTO() {

	}

	public AdminNoticeDTO(int noticeNo, String content, String title, String writer, Date writeDate) {
		super();
		this.noticeNo = noticeNo;
		this.content = content;
		this.title = title;
		this.writer = writer;
		this.writeDate = writeDate;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public java.sql.Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(java.sql.Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "AdminNoticeDTO [noticeNo=" + noticeNo + ", content=" + content + ", title=" + title + ", writer="
				+ writer + ", writeDate=" + writeDate + "]";
	}

	
	
}
