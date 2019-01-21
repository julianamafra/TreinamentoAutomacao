package com.accenture.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendQuote {
	
	protected static WebDriver driver;
	protected WebDriverWait wait;
	
	
	public SendQuote(WebDriver driver) {
		SendQuote.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "email")
	WebElement campoEmail;
	
	@FindBy(how = How.ID, using = "phone")
	WebElement campoPhone;
	
	@FindBy(how = How.ID, using = "username")
	WebElement campoUsername;
	
	@FindBy(how = How.ID, using = "password")
	WebElement campoPassword;
	
	@FindBy(how = How.ID, using = "confirmpassword")
	WebElement campoConfirmPassword;
	
	@FindBy(how = How.ID, using = "Comments")
	WebElement campoCommets;	
		
	@FindBy(how = How.ID, using = "sendemail")
	WebElement botaoSend;
				
				

	public void preencherEmail(String email) {	
		wait.until(ExpectedConditions.visibilityOf(campoEmail)).sendKeys(email);
    }
	
	public void preencherPhone(String phone) {	
		wait.until(ExpectedConditions.visibilityOf(campoPhone)).sendKeys(phone);
    }
	
	public void preencherUserName(String date) {	
		wait.until(ExpectedConditions.visibilityOf(campoUsername)).sendKeys(date);
	
    }	
	
	public void preencherPassword(String password) {	
		wait.until(ExpectedConditions.visibilityOf(campoPassword)).sendKeys(password);
    }
	
	
	public void preencherConfirmPassword(String confirm) {	
		wait.until(ExpectedConditions.visibilityOf(campoConfirmPassword)).sendKeys(confirm);
    }
	
	public void preencherComments(String comments) {	
		wait.until(ExpectedConditions.visibilityOf(campoCommets)).sendKeys(comments);
    }
		
	
	public void clicarSend() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoSend)).click();
	}	 
	
}
