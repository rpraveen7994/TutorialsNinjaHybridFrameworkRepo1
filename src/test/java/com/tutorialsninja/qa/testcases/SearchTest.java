package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends Base {

	public WebDriver driver;
	SearchPage searchPage;
	HomePage homePage;
	
	public SearchTest() throws IOException {
		super();
	}

	

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		
		
//		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));
//		 //driver.findElement(By.name("search")).sendKeys(Keys.ENTER);
//		 //driver.findElement(By.xpath("//div[@id='search']/span/button")).click();
//		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();

//		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
//		HomePage homePage = new HomePage(driver);
		
		searchPage = homePage.searchForAProduct(dataProp.getProperty("validProduct"));
//		homePage.enterProductIntoSearchBoxField(dataProp.getProperty("validProduct"));
//		searchPage = homePage.clickOnSearchButton();
		
		Assert.assertTrue(searchPage.displayStatusOfHPValidProduct());
	}
	
	

	@Test(priority = 2, dependsOnMethods = "verifySearchWithValidProduct")
	public void verifySearchWithInvalidProduct() {
//		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("InValidProduct"));
//		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
//		//String actualMessage = driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText();
//		String actualMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
//		String expectedMessage = dataProp.getProperty("NoProductTextInSearchResults");
		
		
//		HomePage homePage = new HomePage(driver);
		
		searchPage = homePage.searchForAProduct(dataProp.getProperty("InValidProduct"));
//		homePage.enterProductIntoSearchBoxField(dataProp.getProperty("InValidProduct"));
//		searchPage = homePage.clickOnSearchButton();
		
		String actualMessage = searchPage.retrieveNoProductText();
		String expectedMessage = dataProp.getProperty("NoProductTextInSearchResults");
		
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	

	@Test(priority = 3)
	public void verifySearchWithoutAnyProduct() {
//		//driver.findElement(By.name("search")).sendKeys("");
//		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();

//		String actualMessage = driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p"))
//				.getText();
//		 //String actualMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
//		String expectedMessage = dataProp.getProperty("NoProductTextInSearchResults");
		
//		HomePage homePage = new HomePage(driver);
		searchPage=homePage.clickOnSearchButton();
		
		String actualMessage = searchPage.retrieveNoProductText();
		String expectedMessage = dataProp.getProperty("NoProductTextInSearchResults");
		
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
}
