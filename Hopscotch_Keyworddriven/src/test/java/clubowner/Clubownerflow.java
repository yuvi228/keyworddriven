package clubowner;

import org.testng.annotations.Test;

import com.Baseclass;

public class Clubownerflow {

	public Baseclass base;

	@Test(priority = 1)
	public void splashTest() throws Exception {
		System.out.println("Into SPlash");
		base = new Baseclass();
		base.startExecution("Splashscreen");
	}

	@Test(priority = 2)
	public void clubSignupTest() throws Exception {
		System.out.println("Into club SignUP");
		base = new Baseclass();
		base.startExecution("clubsignuppage");

	}

	@Test(priority = 4)
	public void clubApproveTest() throws Exception {
		System.out.println("Into club Approve");
		base = new Baseclass();
		base.startExecution("clubapprove");

	}
	@Test(priority = 3)
	public void clubLoginTest() throws Exception {
		System.out.println("Into club LoginTest");

		base = new Baseclass();
		base.startExecution("clubloginpage");
	}

	

	@Test(priority = 5)
	public void createPasscodeTest() throws Exception {
		System.out.println("Into create Passcode");
		base = new Baseclass();
		base.startExecution("createpasscode");

	}

	@Test(priority = 6)
	public void createEventTest() throws Exception {
		System.out.println("Into create Passcode");
		base = new Baseclass();
		base.startExecution("createevent");

	}
}
