package com.equalexperts.hotelbooking.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.equalexperts.hotelbooking.framework.BasePage;
import com.equalexperts.hotelbooking.framework.Urls;

public class HotelBooking extends BasePage {

	public HotelBooking(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TOLERANCE), this);
	}

	@FindBy(id = "firstname")
	private WebElement firstNameField;

	@FindBy(id = "lastname")
	private WebElement lastNameField;

	@FindBy(id = "totalprice")
	private WebElement priceField;

	@FindBy(id = "depositpaid")
	private WebElement depositPaidDropDown;

	@FindBy(id = "checkin")
	private WebElement checkInField;

	@FindBy(id = "checkout")
	private WebElement checkOutField;

	@FindBy(css = "#form > div input[value=' Save ']")
	private WebElement saveButton;

	@FindBy(css = "div input[value='Delete']")
	private List<WebElement> deleteButtons;

	@FindBy(id = "bookings")
	private WebElement dataTable;

	@FindBy(className = "row")
	private List<WebElement> allDataTableRows;

	private By getRow = By.className("row");
	private By getCells = By.cssSelector("div [class*='col']");

	public void navigateToHomePage() {

		getDriver().navigate().to(Urls.HOTEL_BOOKING_HOME.getUrl());
	}

	public void sendDataRecord(List<String> dataRecord) {

		Select dropDown = new Select(depositPaidDropDown);
		firstNameField.sendKeys(dataRecord.get(0));
		lastNameField.sendKeys(dataRecord.get(1));
		priceField.sendKeys(dataRecord.get(2));
		dropDown.selectByVisibleText(dataRecord.get(3));
		checkInField.sendKeys(dataRecord.get(4));
		checkOutField.sendKeys(dataRecord.get(5));
	}

	public void submitRequest() {

		int preSaveRowCount = allDataTableRows.size();
		saveButton.click();
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TOLERANCE);
		wait.until(ExpectedConditions.numberOfElementsToBe(getRow, preSaveRowCount + 1));
	}

	public void deleteLastRow() {

		int preDeleteRowCount = allDataTableRows.size();
		WebElement lastRowDeleteButton = deleteButtons.get(deleteButtons.size() - 1);
		lastRowDeleteButton.click();
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TOLERANCE);
		wait.until(ExpectedConditions.numberOfElementsToBe(getRow, preDeleteRowCount - 1));
	}

	public List<List<String>> getCurrentTableData() {

		WebDriverWait wait = new WebDriverWait(driver, WAIT_TOLERANCE);
		wait.until(ExpectedConditions.visibilityOfAllElements(allDataTableRows));

		List<List<String>> listOfTableEntries = new ArrayList<>();
		List<WebElement> allRows = dataTable.findElements(getRow);

		for (WebElement row : allRows) {
			List<WebElement> allCells = row.findElements(getCells);
			List<String> entry = new ArrayList<>();

			for (WebElement cell : allCells) {
				entry.add(cell.getText());
			}

			entry.remove(entry.size() - 1);
			listOfTableEntries.add(entry);
		}

		return listOfTableEntries;
	}
}
