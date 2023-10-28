package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {

	public WebDriver driver;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	public RegisterTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		registerPage = homePage.navigateToRegisterPage();
		
//		homePage.clickOnMyAccount();
//		registerPage = homePage.selectRegisterOption();
		 
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
//		driver.findElement(By.linkText("Register")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {
//		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeSStamp());
//		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
//		String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
//		String expectedSuccessHeading = dataProp.getProperty("accountSuccessfullyCreatedHeading");
		
		
//		registerPage.enterFirstName(dataProp.getProperty("firstName"));
//		registerPage.enterLastName(dataProp.getProperty("lastName"));
//		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeSStamp());
//		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
//		registerPage.enterPassword(prop.getProperty("validPassword"));
//		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//		registerPage.selectPrivacyPolicy();
		
		accountSuccessPage = registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeSStamp(), dataProp.getProperty("telephoneNumber"), (prop.getProperty("validPassword")), prop.getProperty("validPassword"));
		
		String actualSuccessHeading =  accountSuccessPage.retrieveAccountSuccessHeading();
		String expectedSuccessHeading = dataProp.getProperty("accountSuccessfullyCreatedHeading");

		Assert.assertEquals(actualSuccessHeading, expectedSuccessHeading);

	}

	@Test(priority = 2)
	public void verifyRegisteringAccountByProvidingAllFields() {
//		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeSStamp());
//		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
//		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();

//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//
//		String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
//		String expectedSuccessHeading = dataProp.getProperty("accountSuccessfullyCreatedHeading");
		
		
		accountSuccessPage = registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeSStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		
//		registerPage.enterFirstName(dataProp.getProperty("firstName"));
//		registerPage.enterLastName(dataProp.getProperty("lastName"));
//		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeSStamp());
//		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
//		registerPage.enterPassword(prop.getProperty("validPassword"));
//		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//		registerPage.selectYesNewsletterOption();
//		registerPage.selectPrivacyPolicy();
//		
//		accountSuccessPage = registerPage.clickOnContinueButton();
		
		String actualSuccessHeading =  accountSuccessPage.retrieveAccountSuccessHeading();
		String expectedSuccessHeading = dataProp.getProperty("accountSuccessfullyCreatedHeading");

		Assert.assertEquals(actualSuccessHeading, expectedSuccessHeading);
	}
	

	@Test(priority = 3)
	public void verifyRegisteringAccountWithExistingEmailAddress() {
//		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
//		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
//		driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
//		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();

//		String actualWarning = driver.findElement(By.xpath("//div[contains(@class,'alert')]")).getText();
//		String expectedWarning = dataProp.getProperty("duplicateEmailWarning");
		
		
		registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), "amotooricap9@gmail.com", dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		
//		registerPage.enterFirstName(dataProp.getProperty("firstName"));
//		registerPage.enterLastName(dataProp.getProperty("lastName"));
//		registerPage.enterEmailAddress("amotooricap9@gmail.com");
//		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
//		registerPage.enterPassword(prop.getProperty("validPassword"));
//		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//		registerPage.selectPrivacyPolicy();
//		registerPage.clickOnContinueButton();
		
		String actualWarning = registerPage.retrieveDuplicateEmailAddressWarning();
		String expectedWarning = dataProp.getProperty("duplicateEmailWarning");

		Assert.assertEquals(actualWarning, expectedWarning,
				"Warning message regarding duplicate email address is not displayed");

	}

	@Test(priority = 4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();

//		String actualPrivacyPolicyWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
//				.getText();		
//		Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")),
//				"Privacy Policy Warning message is not displayed");

//		String actualFirstNameWarning = driver
//				.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
//		Assert.assertEquals(actualFirstNameWarning, dataProp.getProperty("firstNameWarning"),
//				"First Name Warning message is not displayed");

		registerPage.clickOnContinueButton();
		
		Assert.assertTrue(registerPage.displayStatusOfWarningMessageText(dataProp.getProperty("privacyPolicyWarning"), dataProp.getProperty("firstNameWarning")));
		
//		String actualPrivacyPolicyWarning = registerPage.retrievePrivacyPolicyWarning();
//		Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")),
//				"Privacy Policy Warning message is not displayed");
//		
//		String actualFirstNameWarning = registerPage.retrieveFirstNameWarning();
//		Assert.assertEquals(actualFirstNameWarning, dataProp.getProperty("firstNameWarning"),
//				"First Name Warning message is not displayed");
		
	}

}
