package com.equalexperts.hotelbooking.framework;

import static java.lang.System.getProperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

	private String desiredDriver;

	public DriverFactory() {
		
		try {
			desiredDriver = getProperty("browser").toLowerCase();
		} catch (NullPointerException e) {
			desiredDriver = "empty";
		}
	}

	public WebDriver getWebDriver() {

		switch (desiredDriver) {

		case "chrome":
			return new ChromeDriver();

		case "headless-chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setHeadless(true);
			return new ChromeDriver(chromeOptions);

		case "firefox":
			return new FirefoxDriver();

		case "headless-firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setHeadless(true);
			return new FirefoxDriver(firefoxOptions);

		default:
			System.err.println("****************************************************************" + "\n"
					+ "You have requested an invalid browser type " + "\n" + "Your request was " + "\"" + desiredDriver
					+ "\"" + "\n" + "Options are chrome, headless-chrome, firefox or headless-firefox" + "\n"
					+ "Build aborted..." + "\n" + "****************************************************************");
			System.exit(1);
			return null;
		}
	}
}