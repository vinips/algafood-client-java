package com.vinips.algafood.client.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Problem {

	private Integer status;
	private OffsetDateTime timestamp;
	private String userMessage;
	private List<Field> fields = new ArrayList<>();
	
	public static class Field {
		  
		private String name;
		private String userMessage;

		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getUserMessage() {
			return userMessage;
		}
		
		public void setUserMessage(String userMessage) {
			this.userMessage = userMessage;
		}

		@Override
		public String toString() {
			return "Object [name=" + name + ", userMessage=" + userMessage + "]";
		}
		  
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public OffsetDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(OffsetDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "Problem [status=" + status + ", timestamp=" + timestamp + ", userMessage=" + userMessage + ", fields="
				+ fields + "]";
	}
	
}
