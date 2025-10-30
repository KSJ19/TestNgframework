package com.orangehrm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	protected Properties prop;

	protected WebDriver driver;

	@BeforeMethod
	public void setup() throws IOException {

		// load config files

		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
		prop.load(fis);

		// initialize the web driver

		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firfox")) {

			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		}

		else {
			throw new IllegalArgumentException("no browser found/not supprted" + browser);
		}

//implicit wait
		int implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

		// maximize the driver

		driver.manage().window().maximize();

		// navigate the ur:
		driver.get(prop.getProperty("url"));

	}
@AfterMethod
public void teardown() {
	if(driver!=null) {
		driver.quit();
	}

}

}
