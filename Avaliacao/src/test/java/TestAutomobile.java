import static org.junit.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accenture.pages.EnterInsurantData;
import com.accenture.pages.EnterProductData;
import com.accenture.pages.EnterVehicleData;
import com.accenture.pages.SelectPriceOption;
import com.accenture.pages.SendQuote;
import com.accenture.utils.Constants;

public class TestAutomobile {

	static WebDriver driver;
	static WebElement element;
	static WebDriverWait wait;
	static EnterVehicleData vehicle;
	static EnterInsurantData insurant;
	static EnterProductData product;
	static SelectPriceOption price;
	static SendQuote quote;
	

	@Before
	public void setUp() throws Exception {
		File browser = new File(Constants.PATH_CHROMEDRIVER);
		System.setProperty("webdriver.chrome.driver", browser.getAbsolutePath());
		driver   = new ChromeDriver();		
		wait     = new WebDriverWait(driver, 200);
		vehicle  = new EnterVehicleData(driver);
		insurant = new EnterInsurantData(driver);
		product  = new EnterProductData(driver);
		price    = new SelectPriceOption(driver);
		quote    = new SendQuote(driver);
		
		
	}

	@After
	public void tearDownAfterClass() throws Exception {
	//	driver.close();
	}
	
	

	@Test
	public void test() throws Exception {
		driver.get("http://sampleapp.tricentis.com/101/");
		driver.manage().window().maximize();		
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"nav_automobile\"]")))).click();
				
		
		vehicle.selecionarMake("Honda");
		vehicle.preencherEngine("2000");
		vehicle.preencheDateOfManufacturee("11/07/2018");
		vehicle.selecionarNumberOfSeats("4");
		vehicle.selecionarFuelType("Gas");
		vehicle.preencherListPrice("500");
		vehicle.preencherLicenseNumber("ABC123");
		vehicle.preencherAnnualMileage("100");
		vehicle.clicarNext();
		
		insurant.preencherFirstName("Juliana");
		insurant.preencherLastName("Mafra");
        insurant.preencheDateOfBirth("11/13/2000");
        insurant.preencherGender();
        insurant.preencherStreet("Av Domingos Ferreira");
        insurant.selecionarCountry("Brazil");
        insurant.preencherZipCode("50000");
        insurant.preencherCity("Recife");
        insurant.selecionarOccupation("Farmer");
        insurant.selecionarHobbies();    		
        insurant.preencherWebSite("http://www.google.com");
        insurant.carregarFoto(Constants.PATH_FOTO);       
	    insurant.clicarNext();	    
	 
                
        product.preencherStartDate("02/01/2019");
        product.selecionarInsuranceSum("3.000.000,00");
        product.selecionarMeritRating("Bonus 7");
        product.selecionarDamageInsurance("Partial Coverage");
        product.selecionarOptionalProducts();
        product.selecionarCourtesyCar("Yes");
        product.clicarNext();
        
        price.selecionarPriceOption();
        price.clicarNext();
        
        
        quote.preencherEmail("mafra@gmail.com");
        quote.preencherPhone("88888888");
        quote.preencherUserName("Juliana");
        quote.preencherPassword("JMafra123");     
        quote.preencherConfirmPassword("JMafra123");
        quote.preencherComments("Comentarios adicionais");
        quote.clicarSend();
        
      //  Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[1]/h1")).getText().contains("Suporte do Kindle"));
		
       
       String condicao = "Mensagem de Erro!";
       
       Assert.assertEquals("Sending e-mail success!", condicao);
		
		//Thread.sleep(100000);
		
	
		
	}

}
