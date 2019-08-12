package adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginpage {

	public static WebDriver driver1;

	public void adminLogin(String email) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"/Users/yuvraj.rajput/Desktop/Yuvraj/Automation/Hopscotch/src/main/resources/chromedriver");
		driver1 = new ChromeDriver();
		driver1.get("http://simform.solutions:40200/login");
		driver1.manage().window().maximize();

		driver1.findElement(By.name("name")).sendKeys("juhi.d@simformsolutions.com");
		driver1.findElement(By.name("password")).sendKeys("123456");
		driver1.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div[2]/form/button")).click();

		Thread.sleep(2500);
		driver1.findElement(By.xpath(
				"/html/body/app-root/app-layout/section/app-dashboard/div/div[2]/div[1]/div/div/div/div[2]/div[2]"))
				.click();
		Thread.sleep(2500);

		driver1.findElement(By.name("search")).sendKeys(email);

		Thread.sleep(2500);

		WebElement approveicon = driver1.findElement(By.xpath(
				"/html/body/app-root/app-layout/section/app-clubowner/div/div/div/div/div[2]/table[1]/tbody/tr/td[8]/button[1]"));
		approveicon.click();

		driver1.navigate().refresh();

		System.out.println("Club Approved");

		driver1.quit();
	}

	public void searchClub(String email) {
		driver1.findElement(By.name("search")).sendKeys(email);

	}
}
