package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;


public class LoginTest extends Base{
	
	 public WebDriver driver;
	 LoginPage loginPage;
	 
	 public LoginTest() throws IOException {
		super();
	 }


	@BeforeMethod
	  public void setUp() throws IOException
	   {
		 driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		 HomePage homePage = new HomePage(driver);
		 loginPage = homePage.navigateToLoginPage();
		 
//		 homePage.clickOnMyAccount();
//		 loginPage = homePage.selectLoginOption();
		 
//		 driver.findElement(By.xpath("//span[text()='My Account']")).click();
//		 driver.findElement(By.linkText("Login")).click();
	   }
	 
	 
       @AfterMethod
	   public void tearDown()
	   {
		   driver.quit();
	   }
	
	
	@Test(priority = 1, dataProvider = "validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password)
	{
	
//        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		
//        driver.findElement(By.id("input-email")).sendKeys(email);
//        driver.findElement(By.id("input-password")).sendKeys(password);
//        driver.findElement(By.xpath("//input[@value='Login']")).click();
//		  Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		AccountPage accountPage = loginPage.login(email, password);
//		loginPage.enterEmailAddress(email);
//        loginPage.enterPassword(password);
//        AccountPage accountPage = loginPage.clickOnLoginButton();
		
        Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption());
	}
	
	
	
	@DataProvider(name = "validCredentialsSupplier")
	public Object[][] supplyTestData() throws IOException
	{
		Object [][] data = Utilities .getTestDataFromExcel("Login");
		return data;
	}
	
	
	@Test(priority = 2)
//	@Test(priority = 2, invocationCount = 4)
	public void verifyLoginWithInValidCredentials()
	{
//	
//        driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeSStamp());
//        driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
//        driver.findElement(By.xpath("//input[@value='Login']")).click();
		
//        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
//        String expectedWarningMessage = dataProp.getProperty("emailInvalidPasswordWarning");
		
        
        loginPage.login(Utilities.generateEmailWithTimeSStamp(), dataProp.getProperty("invalidPassword"));
        
//		loginPage.enterEmailAddress(Utilities.generateEmailWithTimeSStamp());
//        loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
//        loginPage.clickOnLoginButton();
        
        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
        String expectedWarningMessage = dataProp.getProperty("emailInvalidPasswordWarning");
        
		Assert.assertTrue(actualWarningMessage.equals(expectedWarningMessage),"Expected Warning message is not displayed");
	}
	
	
	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword()
	{

//        driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeSStamp());
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.xpath("//input[@value='Login']")).click();

//        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
//        String expectedWarningMessage = dataProp.getProperty("emailInvalidPasswordWarning");
		
		loginPage.login(Utilities.generateEmailWithTimeSStamp(), prop.getProperty("validPassword"));
        
//		loginPage.enterEmailAddress(Utilities.generateEmailWithTimeSStamp());
//        loginPage.enterPassword(prop.getProperty("validPassword"));
//        loginPage.clickOnLoginButton();
        
        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
        String expectedWarningMessage = dataProp.getProperty("emailInvalidPasswordWarning");
        
		Assert.assertTrue(actualWarningMessage.equals(expectedWarningMessage),"Expected Warning message is not displayed");
	}
	
	
	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword()
	{
		
//        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
//        driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
//        driver.findElement(By.xpath("//input[@value='Login']")).click();
		
//		 String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
//		 String expectedWarningMessage = dataProp.getProperty("emailInvalidPasswordWarning");
		
		loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		
//		  loginPage.enterEmailAddress(prop.getProperty("validEmail"));
//        loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
//        loginPage.clickOnLoginButton();
        
        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessage = dataProp.getProperty("emailInvalidPasswordWarning");
        
		Assert.assertTrue(actualWarningMessage.equals(expectedWarningMessage),"Expected Warning message is not displayed");
	}
	
	
	@Test(priority = 5)
	public void verifyLoginWithoutProvidingCredentials()
	{

//        driver.findElement(By.xpath("//input[@value='Login']")).click();
//        
//        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
//        String expectedWarningMessage = dataProp.getProperty("emailInvalidPasswordWarning");
        
		loginPage.clickOnLoginButton();
        
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessage = dataProp.getProperty("emailInvalidPasswordWarning");
        
		Assert.assertTrue(actualWarningMessage.equals(expectedWarningMessage),"Expected Warning message is not displayed");
	}
	
}
