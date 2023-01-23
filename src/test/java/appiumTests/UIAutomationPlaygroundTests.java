package appiumTests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseMain.BaseClass;
import pageObjects.UITestAutomationPlayground;

public class UIAutomationPlaygroundTests extends BaseClass{

	UITestAutomationPlayground uiAutomationPage;
	WebDriverWait wait;
	JavascriptExecutor js;
	@Test
	public void testDynamicId() {
		uiAutomationPage = new UITestAutomationPlayground(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		String url = "http://uitestingplayground.com/";
		driver.get(url);
	
		Assert.assertEquals(uiAutomationPage.title.getText(), "UI Test Automation\nPlayground");
		uiAutomationPage.dynamicIdLink.click();
		System.out.println("Clicked Dynamic Id Link");
		Assert.assertEquals(driver.getTitle(), "Dynamic ID");
		System.out.println("Dynamic Id Page is opened");

		for(int i = 0; i < 50; i++) {
			uiAutomationPage.dynamicIdPageButton.click();
		}
	}
	
	@Test
	public void testclassAttribute() {
		uiAutomationPage = new UITestAutomationPlayground(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		String url = "http://uitestingplayground.com/";
		driver.get(url);
	
		Assert.assertEquals(uiAutomationPage.title.getText(), "UI Test Automation\nPlayground");
		uiAutomationPage.classAttributeLink.click();
		System.out.println("Clicked Class Attribute Link");
		Assert.assertEquals(driver.getTitle(), "Class Attribute");
		System.out.println("Class Page is opened");
		uiAutomationPage.classAttributeButton.click();
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void testHiddenLayers() {
		uiAutomationPage = new UITestAutomationPlayground(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		String url = "http://uitestingplayground.com/";
		driver.get(url);
	
		Assert.assertEquals(uiAutomationPage.title.getText(), "UI Test Automation\nPlayground");
		uiAutomationPage.hiddenLayersLink.click();
		System.out.println("Clicked Hidden Layers Link");
		Assert.assertEquals(driver.getTitle(), "Hidden Layers");
		System.out.println("Hidden Layers Page is opened");

		for(int i = 0; i < 5; i++) {
			try{
				if(uiAutomationPage.hiddenLayersButton.isEnabled()) {
			
			uiAutomationPage.hiddenLayersButton.click();
			System.out.println("The button is clicked " + i + " times");
			}
			}catch(WebDriverException e) {
				System.out.println(e.getLocalizedMessage());
				System.out.println("Button can only be clicked once");
				//break;
			}
		}
	}
	
	@Test
	public void testScrollAndClickButton() {
		uiAutomationPage = new UITestAutomationPlayground(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		js = (JavascriptExecutor)driver;
		String url = "http://uitestingplayground.com/";
		driver.get(url);
	
		Assert.assertEquals(uiAutomationPage.title.getText(), "UI Test Automation\nPlayground");
		uiAutomationPage.scrollBarLink.click();
		System.out.println("Clicked scrollbars Link");
		Assert.assertEquals(driver.getTitle(), "Scrollbars");
		System.out.println("Scrollbars page is opened");
		js.executeScript("arguments[0].scrollIntoView();", uiAutomationPage.scrollBarButton);
		uiAutomationPage.scrollBarButton.click();
		System.out.println("Successfully clicked the hidden button");
	}
	@Test
	public void testPractice() {
		Actions act = new Actions(driver);
		uiAutomationPage.scrollBarButton.sendKeys(Keys.ENTER);
	}
}
