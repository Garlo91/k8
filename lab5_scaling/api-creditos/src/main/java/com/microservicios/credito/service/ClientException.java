package com.microservicios.credito.service;

public class ClientException extends RuntimeException {
	private final int errorStatus;
	private final String payload;

	public ClientException(String message, int errorStatus, String payload) {
		super(message);
		this.errorStatus = errorStatus;
		this.payload = payload;
	}

	public int getErrorStatus() {
		return errorStatus;
	}

	public String getPayload() {
		return payload;
	}

}
