package com;

import java.io.File;


import java.io.FileInputStream;

import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import adminpanel.Loginpage;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Baseclass {

	public static Workbook workbook;
	public static Sheet sheet;
	public MobileElement element;

	public static IOSDriver<MobileElement> driver;
	public static WebDriver webdriver;
	public static File propfile;
	public static FileInputStream fileInput;
	public static Properties prop;

	String propfilepath = "/Users/yuvraj.rajput/Desktop/Yuvraj/Simform work/Automation/Learning/Hopscotch/Hopscotch_Keyworddriven/src/main/resources/hopscotch.properties";

	
	public void applaunch() throws Exception {
		propfile = new File(propfilepath);

		fileInput = new FileInputStream(propfile);

		prop = new Properties();
		// load properties file
		prop.load(fileInput);

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("app", prop.getProperty("appPath") + "Hopscotch.app");
		desiredCapabilities.setCapability("automationName", "XCUITest");

		if (prop.getProperty("runnable_device").equalsIgnoreCase("simulator")) {
			desiredCapabilities.setCapability("deviceName", "iPhone 6s Plus (12.2)");
			desiredCapabilities.setCapability("udid", "F0D1378E-5C99-494E-9C5D-4C7BC5661276");
			desiredCapabilities.setCapability("platformVersion", "12.3.1");

		} else {
			desiredCapabilities.setCapability("deviceName", "iPhone ios 12.3.1");
			desiredCapabilities.setCapability("udid", "bf692f81d806756bd2232271f80f15fd20c2c2a1");
			desiredCapabilities.setCapability("platformVersion", "12.2");
		}
		desiredCapabilities.setCapability("platformName", "iOS");

		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		System.out.println("Application Launched");

	}

	public void startExecution(String sheetname) throws Exception {

		// property file code
		propfile = new File(propfilepath);

		fileInput = new FileInputStream(propfile);

		prop = new Properties();
		// load properties file
		prop.load(fileInput);

		// excel code
		FileInputStream file = null;
		file = new FileInputStream(prop.getProperty("sheet_path"));

		workbook = WorkbookFactory.create(file);
		sheet = workbook.getSheet(sheetname);

		int k = 0;
		for (int i = 0; i < sheet.getLastRowNum(); i++) {

			String locatorType = sheet.getRow(i + 1).getCell(k + 1).toString().trim();

			String locatorValue = sheet.getRow(i + 1).getCell(k + 2).toString().trim();

			String action = sheet.getRow(i + 1).getCell(k + 3).toString().trim();

			String value = sheet.getRow(i + 1).getCell(k + 4).toString().trim();

			switch (locatorType) {

			case "AccessibilityId":
				element = driver.findElement(MobileBy.AccessibilityId(locatorValue));
				if (action.equalsIgnoreCase("sendkeys")) {

					element.sendKeys(value);
				} else if (action.equalsIgnoreCase("click")) {
					element.click();
				}
				locatorType = null;
				break;

			case "xpath":

				if (action.equalsIgnoreCase("dropdownvalue")) {

					driver.findElement(MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"Night Club\"]")).click();
					;

				}

				break;

			case "name":
				element = driver.findElement(MobileBy.name(locatorValue));
				if (action.equalsIgnoreCase("sendkeys")) {

					element.sendKeys(value);
				} else if (action.equalsIgnoreCase("click")) {
					element.click();
				}
				locatorType = null;
				break;

			case "wait":
				if (action.equalsIgnoreCase("wait")) {
					Util.implecitwait(driver);
				}
				break;

			case "waittill":
				By tonight = MobileBy.AccessibilityId(locatorValue);
				if (action.equalsIgnoreCase("waittill")) {
					Util.waittillElementvisible(driver, tonight);
				}
				break;

			case "next":
				if (action.equalsIgnoreCase("next")) {
					Util.nextclick();
				}
				break;
			case "scroll":
				MobileElement startElement = driver.findElement(MobileBy.AccessibilityId(locatorValue));
				MobileElement endElement = driver.findElement(MobileBy.AccessibilityId(action));

				Scroll.scrollDown(startElement, endElement);
				break;

			case "browser":
				if (value.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", prop.getProperty("driverpath"));
					webdriver = new ChromeDriver();
					webdriver.get(prop.getProperty("adminurl"));
					webdriver.manage().window().maximize();
				}

				break;

			case "approveclub":
				Loginpage login = new Loginpage();
				login.adminLogin(locatorValue);

				break;
			}
		}

	}

}
