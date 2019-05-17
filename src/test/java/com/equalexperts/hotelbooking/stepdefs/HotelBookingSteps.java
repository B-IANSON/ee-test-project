package com.equalexperts.hotelbooking.stepdefs;

import org.openqa.selenium.WebDriver;

import com.equalexperts.hotelbooking.domain.ActiveData;
import com.equalexperts.hotelbooking.pages.HotelBooking;
import com.equalexperts.hotelbooking.utils.BookingValidator;
import com.equalexperts.hotelbooking.world.World;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import static org.assertj.core.api.Assertions.assertThat;

public class HotelBookingSteps {

	private WebDriver driver;
	private World world;
	private HotelBooking hotelBooking;

	public HotelBookingSteps(World world) {
		this.world = world;
	}

	@Before(order = 1)
	public void defineWebDriver() throws Throwable {
		driver = world.getWebDriver();
	}

	@Before(order = 2)
	public void initPages() throws Throwable {
		hotelBooking = new HotelBooking(driver);
	}

	@Given("^a web browser is on the hotel booking page$")
	public void navigateToHomePage() throws Throwable {
		hotelBooking.navigateToHomePage();
	}

	@When("^the user provides the required details to make a valid booking$")
	public void enterDetailsIntoBookingTable(DataTable dataTable) throws Throwable {
		world.activeData = new ActiveData();
		world.activeData.setActiveDataRecord(dataTable.asList(String.class));
		hotelBooking.sendDataRecord(dataTable.asList(String.class));
	}

	@When("^the user creates a new booking$")
	public void createBooking(DataTable dataTable) throws Throwable {
		world.activeData = new ActiveData();
		hotelBooking.sendDataRecord(dataTable.asList(String.class));
		hotelBooking.submitRequest();
	}

	@And("^then deletes the request$")
	public void deleteBooking() throws Throwable {
		hotelBooking.deleteLastRow();
	}

	@And("^submits the request$")
	public void submitRequest() throws Throwable {
		hotelBooking.submitRequest();
	}

	@Then("^the booking is successfully displayed in the Bookings table$")
	public void validateBooking() throws Throwable {
		BookingValidator validateBooking = new BookingValidator();
		boolean bookingPresent = validateBooking.checkForBookingPresence(hotelBooking.getCurrentTableData(),
				world.activeData.getActiveDataRecord());
		assertThat(bookingPresent).isTrue();
	}

	@Then("^the booking is successfully removed from the Bookings table$")
	public void validateBookingRemoval() throws Throwable {
		BookingValidator validateBooking = new BookingValidator();
		boolean bookingPresent = validateBooking.checkForBookingPresence(hotelBooking.getCurrentTableData(),
				world.activeData.getActiveDataRecord());
		assertThat(bookingPresent).isFalse();
	}
}
