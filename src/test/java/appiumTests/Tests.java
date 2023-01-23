package appiumTests;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import baseMain.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import pageObjects.AppMenuItem;

public class Tests extends BaseClass {

	@Test(enabled=false)
	public void testApk() throws AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Menu']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Inflate from XML']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("io.appium.android.apis:id/spinner"))));
		WebElement ele = driver.findElement(By.id("io.appium.android.apis:id/spinner"));
		ele.click();

		List<WebElement> list = driver.findElements(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView"));
		for (WebElement e : list) {
			e.click();
			ele.click();
		}
	}
	
	@Test
	public void scrollMenu() {
		AppMenuItem mi = new AppMenuItem(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(mi.viewsMenuItem)).click();
		wait.until(ExpectedConditions.visibilityOf(mi.viewsMenuItemControls));
		WebElement scrollToVisibility = driver.findElement(AppiumBy.androidUIAutomator(
		  "new UiScrollable(new UiSelector()).scrollIntoView("
		  +"new UiSelector().text(\"Visibility\"));")); scrollToVisibility.click();
		  
		/* TO SCROLL IN IOS DEVICES. USE W3C AS TOUCH ACTIONS HAS BEEN DEPRECATED.
		 * 
		 * Dimension d = driver.manage().window().getSize(); int height = d.getHeight();
		 * int width = d.getWidth();
		 * 
		 * int x1 = width/2; int x2 = width/2; int y1 = (int) (height*.40); int y2 =
		 * (int) (height*.10); JavascriptExecutor js = (JavascriptExecutor) driver;
		 * TouchAction ac = new TouchAction((PerformsTouchActions) driver);
		 * 
		 * ac.press(PointOption.point(x1,
		 * y1)).moveTo(PointOption.point(x2,y2)).release().perform();
		 */
	}
}
