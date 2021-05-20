package com.bonggeuda.sugbag.model.dto;

import java.sql.Date;

public class OwnerQnADTO {
	
	private int qnaAo;
	private String title;
	private String content;
	private Date writeDate;
	private String answerYN;
	private int ownerNo;
	private int userNo;
	
	public OwnerQnADTO() {}

	public OwnerQnADTO(int qnaAo, String title, String content, Date writeDate, String answerYN, int ownerNo,
			int userNo) {
		super();
		this.qnaAo = qnaAo;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.answerYN = answerYN;
		this.ownerNo = ownerNo;
		this.userNo = userNo;
	}

	public int getQnaAo() {
		return qnaAo;
	}

	public void setQnaAo(int qnaAo) {
		this.qnaAo = qnaAo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getAnswerYN() {
		return answerYN;
	}

	public void setAnswerYN(String answerYN) {
		this.answerYN = answerYN;
	}

	public int getOwnerNo() {
		return ownerNo;
	}

	public void setOwnerNo(int ownerNo) {
		this.ownerNo = ownerNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "OwnerQnADTO [qnaAo=" + qnaAo + ", title=" + title + ", content=" + content + ", writeDate=" + writeDate
				+ ", answerYN=" + answerYN + ", ownerNo=" + ownerNo + ", userNo=" + userNo + "]";
	}
}
