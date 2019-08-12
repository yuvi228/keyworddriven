package com;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Util extends Baseclass {

	public FileInputStream finput;
	public HSSFWorkbook workbook;
	public HSSFSheet sheet;
	public static String numberAsString;
	public FileOutputStream fout;
	public static String testdatafilePath = "/Users/yuvraj.rajput/Desktop/Yuvraj/Simform work/Automation/Learning/keyworddriven/src/test/resources/keyworddriven.xls";

	public static void nextclick() {
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Next:\"]")).click();

	}

	public void generateNumber() throws Exception {
		long randomNumber = (long) (Math.random() * 100000 + 3333300000L);
		System.out.println(randomNumber);
		numberAsString = Long.toString(randomNumber);

	}

	public void permission() {

		MobileElement setpermission = driver.findElement(MobileBy.AccessibilityId("SET PERMISSION"));

		if (setpermission.isDisplayed() == true) {
			setpermission.click();
			driver.findElement(MobileBy.AccessibilityId("Always Allow")).click();

		}
	}
	
	public static void waittillElementvisible(IOSDriver<MobileElement> driver,By element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public static void implecitwait(IOSDriver<MobileElement> driver) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}
}
