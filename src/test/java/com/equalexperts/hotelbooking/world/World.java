package com.equalexperts.hotelbooking.world;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.equalexperts.hotelbooking.domain.ActiveData;
import com.equalexperts.hotelbooking.framework.DriverFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class World {

	private WebDriver driver;
	private DriverFactory driverFactory;
	public ActiveData activeData;

	@Before(order = 0)
	public void setUp() throws Throwable {
		driverFactory = new DriverFactory();
		driver = driverFactory.getWebDriver();
	}

	@After
	public void tearDown(Scenario scenario) throws Throwable {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		driver.quit();
	}

	public WebDriver getWebDriver() {
		return driver;
	}
}
