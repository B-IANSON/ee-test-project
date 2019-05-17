package com.equalexperts.hotelbooking.utils;

import java.util.List;

public class BookingValidator {

	public boolean checkForBookingPresence(List<List<String>> currentDataTable, List<String> activeDataRecord) {

		for (List<String> booking : currentDataTable) {
			if (booking.equals(activeDataRecord)) {
				return true;
			}
		}
		return false;
	}
}
