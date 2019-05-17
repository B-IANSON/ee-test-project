package com.equalexperts.hotelbooking.framework;

public enum Urls {

	HOTEL_BOOKING_HOME("http://hotel-test.equalexperts.io");

	private String url;

	private Urls(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}
}
