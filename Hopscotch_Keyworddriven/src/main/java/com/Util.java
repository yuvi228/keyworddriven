package com;

import java.io.FileInputStream;


import java.io.FileOutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

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
	
	@Test
	public static void sendEmail() {
		// Create object of Property file
				Properties props = new Properties();
		 
				// this will set host of server- you can change based on your requirement 
				props.put("mail.smtp.host", "smtp.gmail.com");
		 
				// set the port of socket factory 
				props.put("mail.smtp.socketFactory.port", "465");
		 
				// set socket factory
				props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		 
				// set the authentication to true
				props.put("mail.smtp.auth", "true");
		 
				// set the port of SMTP server
				props.put("mail.smtp.port", "465");
		 
				// This will handle the complete authentication
				Session session = Session.getDefaultInstance(props,
		 
						new javax.mail.Authenticator() {
		 
							protected PasswordAuthentication getPasswordAuthentication() {
		 
							return new PasswordAuthentication("travrogersmith@gmail.com", "Simform.123");
		 
							}
		 
						});
		 
				try {
		 
					// Create object of MimeMessage class
					Message message = new MimeMessage(session);
		 
					// Set the from address
					message.setFrom(new InternetAddress("travrogersmith@gmail.com"));
		 
					// Set the recipient address
					message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("yuvraj.r@simformsolutions.com"));
		            
		                        // Add the subject link
					message.setSubject("Testing Subject");
		 
					// Create object to add multimedia type content
					BodyPart messageBodyPart1 = new MimeBodyPart();
		 
					// Set the body of email
					messageBodyPart1.setText("This is message body");
		 
					// Create another object to add another content
					MimeBodyPart messageBodyPart2 = new MimeBodyPart();
		 
					// Mention the file which you want to send
					String filename = "/Users/yuvraj.rajput/Desktop/Yuvraj/Simform work/Automation/Learning/Hopscotch/Hopscotch_Keyworddriven/Extent.html";
		 
					// Create data source and pass the filename
					DataSource source = new FileDataSource(filename);
		 
					// set the handler
					messageBodyPart2.setDataHandler(new DataHandler(source));
		 
					// set the file
					messageBodyPart2.setFileName(filename);
		 
					// Create object of MimeMultipart class
					Multipart multipart = new MimeMultipart();
		 
					// add body part 1
					multipart.addBodyPart(messageBodyPart2);
		 
					// add body part 2
					multipart.addBodyPart(messageBodyPart1);
		 
					// set the content
					message.setContent(multipart);
		 
					// finally send the email
					Transport.send(message);
		 
					System.out.println("=====Email Sent=====");
		 
				} catch (MessagingException e) {
		 
					throw new RuntimeException(e);
		 
				}
	}
}
