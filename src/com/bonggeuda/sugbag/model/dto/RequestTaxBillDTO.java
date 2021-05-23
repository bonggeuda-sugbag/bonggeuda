package com.bonggeuda.sugbag.model.dto;

public class RequestTaxBillDTO {
	
	private int requestNo;
	private String requestStartDate;
	private String requestEndDate;
	private String requestDate;
	private int accomoNo;
	private String responseYn;
	
	private String accomoName;
	
	public RequestTaxBillDTO() {}

	public RequestTaxBillDTO(int requestNo, String requestStartDate, String requestEndDate, String requestDate,
			int accomoNo, String responseYn, String accomoName) {
		super();
		this.requestNo = requestNo;
		this.requestStartDate = requestStartDate;
		this.requestEndDate = requestEndDate;
		this.requestDate = requestDate;
		this.accomoNo = accomoNo;
		this.responseYn = responseYn;
		this.accomoName = accomoName;
	}

	public int getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(int requestNo) {
		this.requestNo = requestNo;
	}

	public String getRequestStartDate() {
		return requestStartDate;
	}

	public void setRequestStartDate(String requestStartDate) {
		this.requestStartDate = requestStartDate;
	}

	public String getRequestEndDate() {
		return requestEndDate;
	}

	public void setRequestEndDate(String requestEndDate) {
		this.requestEndDate = requestEndDate;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public int getAccomoNo() {
		return accomoNo;
	}

	public void setAccomoNo(int accomoNo) {
		this.accomoNo = accomoNo;
	}

	public String getResponseYn() {
		return responseYn;
	}

	public void setResponseYn(String responseYn) {
		this.responseYn = responseYn;
	}

	public String getAccomoName() {
		return accomoName;
	}

	public void setAccomoName(String accomoName) {
		this.accomoName = accomoName;
	}

	@Override
	public String toString() {
		return "RequestTaxBillDTO [requestNo=" + requestNo + ", requestStartDate=" + requestStartDate
				+ ", requestEndDate=" + requestEndDate + ", requestDate=" + requestDate + ", accomoNo=" + accomoNo
				+ ", responseYn=" + responseYn + ", accomoName=" + accomoName + "]";
	}

	
	

}
