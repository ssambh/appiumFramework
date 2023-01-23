package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppMenuItem {

	WebDriver driver;
	public AppMenuItem(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@text=\"Views\"]")
	public WebElement viewsMenuItem;
	
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Controls\"]")
	public WebElement viewsMenuItemControls;
	
	@FindBy(id="Status Bar")
	public WebElement appMenuItemStatusBar;
	
	@FindBy(id="io.appium.android.apis:id/happy")
	public WebElement appMenuItemStatusBarHappyface;
	
	@FindBy(xpath="//*[@text=\"Visibility\"]")
	public WebElement ele;
	
}
