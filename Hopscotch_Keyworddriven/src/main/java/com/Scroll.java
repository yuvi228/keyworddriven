package com;

import java.time.Duration;
import io.appium.java_client.MobileElement;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Scroll extends Baseclass{
	
	static MobileElement startElement ;
	static MobileElement endElement ;
	
	public static void scrollDown(MobileElement startElement, MobileElement endElement) throws InterruptedException {
		System.out.println("Into scroll");

		
		
		int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
		int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

		int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
		int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

		System.out.println(startX + " ::::::: " + startY + " ::::::: " + endX + " ::::::: " + endY);
		TouchAction tAction = new TouchAction((PerformsTouchActions) driver);
		tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(endX, endY)).release().perform();
		System.out.println("scroll done");
		

	}

}
