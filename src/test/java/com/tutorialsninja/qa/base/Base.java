package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public Base() throws IOException
	{
	    prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		
		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		FileInputStream datafis = new FileInputStream(dataPropFile);
		dataProp.load(datafis);
	}	
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName)
	{
		  if(browserName.equalsIgnoreCase("Chrome"))
		  {
			  driver = new ChromeDriver(); 
		  }
		  else if(browserName.equalsIgnoreCase("FireFox"))
		  {
			  driver = new FirefoxDriver(); 
		  }
		  else if(browserName.equalsIgnoreCase("edge"))
		  {
			  driver = new EdgeDriver(); 
		  }
		 driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME)); 
		 driver.get(prop.getProperty("URL"));
		 
		 return driver;
		 
	}
	
	
}
