package com.accenture.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterVehicleData {
	
	protected static WebDriver driver;
	protected WebDriverWait wait;
	
	
	public EnterVehicleData(WebDriver driver) {
		EnterVehicleData.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "make")
	WebElement comboMakeWB;
	
	@FindBy(how = How.ID, using = "engineperformance")
	WebElement campoEnginePerformance;
	
	@FindBy(how = How.ID, using = "dateofmanufacture")
	WebElement campoDateOfManufacture;
	
	@FindBy(how = How.ID, using = "numberofseats")
	WebElement comboNumberOfSeats;
	
	@FindBy(how = How.ID, using = "fuel")
	WebElement comboFuelType;
	
	@FindBy(how = How.ID, using = "listprice")
	WebElement campoListPrice;
	
	@FindBy(how = How.ID, using = "licenseplatenumber")
	WebElement campoLicenseNumber;
	
	@FindBy(how = How.ID, using = "annualmileage")
	WebElement campoAnnualMileage;
	
	@FindBy(how = How.ID, using = "nextenterinsurantdata")
	WebElement botaoNext;
				

	public void selecionarMake(String make) {	
		Select comboMake = new Select(comboMakeWB);
		comboMake.selectByVisibleText(make);
		
	}
	
	public void preencherEngine(String engine) {	
		wait.until(ExpectedConditions.visibilityOf(campoEnginePerformance)).sendKeys(engine);
	
    }
	
	public void preencheDateOfManufacturee(String date) {	
		wait.until(ExpectedConditions.visibilityOf(campoDateOfManufacture)).sendKeys(date);
	
    }
	
	public void selecionarNumberOfSeats(String seats) {	
		Select comboSeats = new Select(comboNumberOfSeats);
		comboSeats.selectByVisibleText(seats);
		
	}
	
	public void selecionarFuelType(String type) {	
		Select comboType = new Select(comboFuelType);
		comboType.selectByVisibleText(type);
		
	}
	
	public void preencherListPrice(String price) {	
		wait.until(ExpectedConditions.visibilityOf(campoListPrice)).sendKeys(price);
	
    }
	
	public void preencherLicenseNumber(String license) {	
		wait.until(ExpectedConditions.visibilityOf(campoLicenseNumber)).sendKeys(license);
	
    }
	
	public void preencherAnnualMileage(String mileage) {
		wait.until(ExpectedConditions.visibilityOf(campoAnnualMileage)).sendKeys(mileage);
	
    }
	
	public void clicarNext() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoNext)).click();
	}
	 
	
}
