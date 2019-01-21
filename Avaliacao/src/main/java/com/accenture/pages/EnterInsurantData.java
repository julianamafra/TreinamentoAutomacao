package com.accenture.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterInsurantData {
	
	protected static WebDriver driver;
	protected WebDriverWait wait;
	
	
	public EnterInsurantData(WebDriver driver) {
		EnterInsurantData.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "firstname")
	WebElement campoFirstName;
	
	@FindBy(how = How.ID, using = "lastname")
	WebElement campoLasttName;
	
	@FindBy(how = How.ID, using = "birthdate")
	WebElement campoDateOfBirth;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"insurance-form\"]/div/section[2]/div[4]/p/label[2]/span")
	WebElement radioGender;
	
	@FindBy(how = How.ID, using = "streetaddress")
	WebElement campoStreetAddress;
	
	@FindBy(how = How.ID, using = "country")
	WebElement comboCountry;
	
	@FindBy(how = How.ID, using = "zipcode")
	WebElement campoZipCode;
	
	@FindBy(how = How.ID, using = "city")
	WebElement campoCity;
	
	@FindBy(how = How.ID, using = "occupation")
	WebElement comboOccupation;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'insurance-form\']/div/section[2]/div[10]/p/label[1]/span")
	WebElement checkHobbies;
	
	@FindBy(how = How.ID, using = "website")
	WebElement campoWebSite;
	
	@FindBy(how = How.ID, using = "picture")
	WebElement campoPicture;
	
	@FindBy(how = How.ID, using = "nextenterproductdata")
	WebElement botaoNext;
				
				

	public void preencherFirstName(String firstName) {	
		wait.until(ExpectedConditions.visibilityOf(campoFirstName)).sendKeys(firstName);
    }
	
	public void preencherLastName(String lastName) {	
		wait.until(ExpectedConditions.visibilityOf(campoLasttName)).sendKeys(lastName);
    }
	
	public void preencheDateOfBirth(String date) {	
		wait.until(ExpectedConditions.visibilityOf(campoDateOfBirth)).sendKeys(date);
	
    }
	
	
	public void preencherGender() {	
		wait.until(ExpectedConditions.elementToBeClickable(radioGender)).click();
    }
	
	public void preencherStreet(String street) {	
		wait.until(ExpectedConditions.visibilityOf(campoStreetAddress)).sendKeys(street);
    }
	
	public void selecionarCountry(String country) {	
		Select comboCountry2 = new Select(comboCountry);
		comboCountry2.selectByVisibleText(country);
		
	}
	
	public void preencherZipCode(String zip) {	
		wait.until(ExpectedConditions.visibilityOf(campoZipCode)).sendKeys(zip);
    }
	
	
	public void preencherCity(String city) {	
		wait.until(ExpectedConditions.visibilityOf(campoCity)).sendKeys(city);
    }
	
	public void selecionarOccupation(String occupation) {	
		Select comboOccupation2 = new Select(comboOccupation);
		comboOccupation2.selectByVisibleText(occupation);
		
	}
	
	public void selecionarHobbies() {	
		wait.until(ExpectedConditions.elementToBeClickable(checkHobbies)).click();
		
	}
	
	public void preencherWebSite(String site) {	
		wait.until(ExpectedConditions.visibilityOf(campoWebSite)).sendKeys(site);
    }
	
	public void carregarFoto(String foto) throws AWTException {	
		driver.findElement(By.id("open")).click();

		StringSelection ss = new StringSelection(foto);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot = new Robot();
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(1000);
    }
	
	
	public void clicarNext() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoNext)).click();
	}	 
	
}
