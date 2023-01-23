package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UITestAutomationPlayground {

	WebDriver driver;
	
	public UITestAutomationPlayground(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="title")
	public WebElement title;
	
	@FindBy(xpath="//a[text()='Dynamic ID']")
	public WebElement dynamicIdLink;
		
	@FindBy(xpath="//button[text()='Button with Dynamic ID']")
	public WebElement dynamicIdPageButton;
	
	@FindBy(xpath="//a[text()='Class Attribute']")
	public WebElement classAttributeLink;
		
	@FindBy(xpath="//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]")
	public WebElement classAttributeButton;
	
	@FindBy(xpath="//a[text()='Hidden Layers']")
	public WebElement hiddenLayersLink;
		
	@FindBy(id="greenButton")
	public WebElement hiddenLayersButton;
	
	@FindBy(xpath="//a[text()='Scrollbars']")
	public WebElement scrollBarLink;
		
	@FindBy(id="hidingButton")
	public WebElement scrollBarButton;
	
	@FindBy(xpath="//a[text()='Shadow DOM']")
	public WebElement shadowDomLink;
		
	@FindBy(id="editField")
	public WebElement shadowDomTextField;
	
	@FindBy(id="buttonGenerate")
	public WebElement shadowDomGenerateButton;
	
	@FindBy(id="buttonCopy")
	public WebElement shadowDomCopyButton;
	
	
	
}
