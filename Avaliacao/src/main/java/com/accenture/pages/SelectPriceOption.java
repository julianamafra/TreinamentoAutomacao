package com.accenture.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectPriceOption {
	
	protected static WebDriver driver;
	protected WebDriverWait wait;
	
	
	public SelectPriceOption(WebDriver driver) {
		SelectPriceOption.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[3]/span")
	WebElement radioOptionPlatinum;
	
	@FindBy(how = How.ID, using = "nextsendquote")
	WebElement botaoNext;	
	
				
	public void selecionarPriceOption() {	
		wait.until(ExpectedConditions.elementToBeClickable(radioOptionPlatinum)).click();
		
	}	
	
	
	public void clicarNext() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoNext)).click();
	}	 
	
}
