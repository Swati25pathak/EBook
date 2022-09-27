package com.Ebook.Exception;

import java.util.Date;

public class ErrorDetails {

	private Date timestamp;
	private String message;
	private String Description;

	public ErrorDetails(Date timestamp, String message, String description) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		Description = description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "ErrorDetails [timestamp=" + timestamp + ", message=" + message + ", Description=" + Description + "]";
	}

}
