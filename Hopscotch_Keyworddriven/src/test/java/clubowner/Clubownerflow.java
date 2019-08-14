package clubowner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Baseclass;
import com.Util;

import adminpanel.Loginpage;

public class Clubownerflow {

	public Baseclass base;

	@BeforeTest
	public void setUp() {
		base = new Baseclass();
	}

	@Test(priority = 1)
	public void applauchTest() throws Exception {
		System.out.println("Into App lauch");
		base.applaunch();
	}

	@Test(priority = 2)
	public void splashTest() throws Exception {
		System.out.println("Into SPlash");
		base.startExecution("Splashscreen");
	}

	@Test(priority = 3)
	public void clubSignupTest() throws Exception {
		System.out.println("Into club SignUP");

		base.startExecution("clubsignuppage");

	}

	@Test(priority = 4)
	public void clubApproveTest() throws Exception {
		System.out.println("Into club Approve");

//		base.startExecution("clubapprove");
		Loginpage login = new Loginpage();
		login.adminLogin("automation1user@mailanator.com");


	}

	@Test(priority = 5)
	public void clubLoginTest() throws Exception {
		System.out.println("Into club LoginTest");

		base.startExecution("clubloginpage");
	}

	@Test(priority = 6)
	public void createPasscodeTest() throws Exception {
		System.out.println("Into create Passcode");

		base.startExecution("createpasscode");

	}

	@Test(priority = 7)
	public void createEventTest() throws Exception {
		System.out.println("Into create Event");

		base.startExecution("createevent");

	}
	
	@AfterSuite
	public void emailReport() {
		Util.sendEmail();
	}
}
