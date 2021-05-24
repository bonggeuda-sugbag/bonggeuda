package com.bonggeuda.sugbag.model.dto;

public class UserBookContentDTO {

	private String bookCheckDate;
	private String checkoutDate;
	private String bookCheckIn;
	private String checkOut;
	private int bookNo;
	private String bookUserName;
	private String bookPhone;
	private int cancleAmount;
	private String thumbnailPath;
	private String accomoName;
	private String roomName;
	private int paymentAmount;
	
	public UserBookContentDTO() {}

	public UserBookContentDTO(String bookCheckDate, String checkoutDate, String bookCheckIn, String checkOut,
			int bookNo, String bookUserName, String bookPhone, int cancleAmount, String thumbnailPath,
			String accomoName, String roomName, int paymentAmount) {
		super();
		this.bookCheckDate = bookCheckDate;
		this.checkoutDate = checkoutDate;
		this.bookCheckIn = bookCheckIn;
		this.checkOut = checkOut;
		this.bookNo = bookNo;
		this.bookUserName = bookUserName;
		this.bookPhone = bookPhone;
		this.cancleAmount = cancleAmount;
		this.thumbnailPath = thumbnailPath;
		this.accomoName = accomoName;
		this.roomName = roomName;
		this.paymentAmount = paymentAmount;
	}

	public String getBookCheckDate() {
		return bookCheckDate;
	}

	public void setBookCheckDate(String bookCheckDate) {
		this.bookCheckDate = bookCheckDate;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getBookCheckIn() {
		return bookCheckIn;
	}

	public void setBookCheckIn(String bookCheckIn) {
		this.bookCheckIn = bookCheckIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookUserName() {
		return bookUserName;
	}

	public void setBookUserName(String bookUserName) {
		this.bookUserName = bookUserName;
	}

	public String getBookPhone() {
		return bookPhone;
	}

	public void setBookPhone(String bookPhone) {
		this.bookPhone = bookPhone;
	}

	public int getCancleAmount() {
		return cancleAmount;
	}

	public void setCancleAmount(int cancleAmount) {
		this.cancleAmount = cancleAmount;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public String getAccomoName() {
		return accomoName;
	}

	public void setAccomoName(String accomoName) {
		this.accomoName = accomoName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	@Override
	public String toString() {
		return "UserBookContentDTO [bookCheckDate=" + bookCheckDate + ", checkoutDate=" + checkoutDate
				+ ", bookCheckIn=" + bookCheckIn + ", checkOut=" + checkOut + ", bookNo=" + bookNo + ", bookUserName="
				+ bookUserName + ", bookPhone=" + bookPhone + ", cancleAmount=" + cancleAmount + ", thumbnailPath="
				+ thumbnailPath + ", accomoName=" + accomoName + ", roomName=" + roomName + ", paymentAmount="
				+ paymentAmount + "]";
	}

}
