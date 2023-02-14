package com.speaking.clock.model;

import java.time.LocalDateTime;

public class ApiResponseModel {

	String msg;
	LocalDateTime dateTime;
//	String statusCode;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
}
