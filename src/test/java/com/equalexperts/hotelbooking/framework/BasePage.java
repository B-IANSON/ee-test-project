package com.equalexperts.hotelbooking.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class BasePage {
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TOLERANCE), this);
	}
	
    protected WebDriver driver;
    protected static final int WAIT_TOLERANCE = 10;
   
    protected WebDriver getDriver() {
        return driver;
    }
}
