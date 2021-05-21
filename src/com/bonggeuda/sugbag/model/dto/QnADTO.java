package com.bonggeuda.sugbag.model.dto;

import java.sql.Date;

public class QnADTO {

	private int qnaNo;
	private String qnaTitle;
	private Date qnaDate;
	private String answerYn;
	private String qnaContent;
	private String writer;
	
	public QnADTO() {}

	public QnADTO(int qnaNo, String qnaTitle, Date qnaDate, String answerYn, String qnaContent, String writer) {
		super();
		this.qnaNo = qnaNo;
		this.qnaTitle = qnaTitle;
		this.qnaDate = qnaDate;
		this.answerYn = answerYn;
		this.qnaContent = qnaContent;
		this.writer = writer;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public Date getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getAnswerYn() {
		return answerYn;
	}

	public void setAnswerYn(String answerYn) {
		this.answerYn = answerYn;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "QnADTO [qnaNo=" + qnaNo + ", qnaTitle=" + qnaTitle + ", qnaDate=" + qnaDate + ", answerYn=" + answerYn
				+ ", qnaContent=" + qnaContent + ", writer=" + writer + "]";
	}
	
}
