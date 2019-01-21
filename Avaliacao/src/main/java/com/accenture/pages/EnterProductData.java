package com.accenture.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterProductData {
	
	protected static WebDriver driver;
	protected WebDriverWait wait;
	
	
	public EnterProductData(WebDriver driver) {
		EnterProductData.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "startdate")
	WebElement campoStartDate;
	
	@FindBy(how = How.ID, using = "insurancesum")
	WebElement comboInsuranceSum;
	
	@FindBy(how = How.ID, using = "meritrating")
	WebElement comboMeritRating;
	
	@FindBy(how = How.ID, using = "damageinsurance")
	WebElement comboDamageInsurance;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[1]/span")
	WebElement checkOptionalProducts;
	
	@FindBy(how = How.ID, using = "courtesycar")
	WebElement comboCourtesyCar;	
	
	@FindBy(how = How.ID, using = "nextselectpriceoption")
	WebElement botaoNext;
				

	public void preencherStartDate(String date) {	
		wait.until(ExpectedConditions.visibilityOf(campoStartDate)).sendKeys(date);
	
    }
	
	
	public void selecionarInsuranceSum(String sum) {	
		Select comboInsurance = new Select(comboInsuranceSum);
		comboInsurance.selectByVisibleText(sum);
		
	}
	
	public void selecionarMeritRating(String rating) {	
		Select comboRating = new Select(comboMeritRating);
		comboRating.selectByVisibleText(rating);
		
	}
	
	public void selecionarDamageInsurance(String damage) {	
		Select comboDamage = new Select(comboDamageInsurance);
		comboDamage.selectByVisibleText(damage);
		
	}
	
	public void selecionarOptionalProducts() {	
		wait.until(ExpectedConditions.elementToBeClickable(checkOptionalProducts)).click();
		
	}
	
	
	public void selecionarCourtesyCar(String cars) {	
		Select comboCourtesy = new Select(comboCourtesyCar);
		comboCourtesy.selectByVisibleText(cars);
		
	}	
	
	
	public void clicarNext() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoNext)).click();
	}
	 
	
}
