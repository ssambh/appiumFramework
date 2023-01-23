package baseMain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseClass {
	public AppiumDriver driver;
	public AppiumDriverLocalService service;
	public FileReader fr;
	Properties properties;
	@BeforeSuite
	public void startAppiumService() throws IOException {
		fr = new FileReader("./src/test/resources/config.properties");
		properties = new Properties();
		properties.load(fr);
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\saran\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(properties.getProperty("ServerAddress"))
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                .usingPort(4723)
                .withLogFile(new File("./src/test/resources/AppiumServerLogs.txt")));
		
		System.out.println("Starting Appium Server............");
		
		service.start();
		
	}
	
	@BeforeTest
	public void appiumSetup() throws IOException {
		File f = new File("src/test/java");
		File fs = new File(f, "ApiDemos-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		properties = new Properties();
		fr = new FileReader("./src/test/resources/config.properties");
		properties.load(fr);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		if(properties.getProperty("Platform").equalsIgnoreCase("Chrome")) {
			
			cap .setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap .setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
			cap .setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6");
			cap .setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			cap .setCapability(MobileCapabilityType.UDID, "emulator-5554");		//cmd adb devices
			cap .setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			driver = new AndroidDriver(url, cap);
			
		}
		
		else if(properties.getProperty("Platform").equalsIgnoreCase("Android")) {
			cap .setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap .setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
			cap .setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6");
			cap .setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			cap .setCapability(MobileCapabilityType.UDID, "emulator-5554");		//cmd adb devices
			//cap .setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());	//Only run to install the app on the device
			cap .setCapability("appPackage", "io.appium.android.apis");
			cap .setCapability("appActivity", "io.appium.android.apis.ApiDemos");
			driver = new AndroidDriver(url, cap);
		}
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@AfterSuite
	public void quitAppiumService() {
		System.out.println("Stopping Appium Server............bye bye");
		service.stop();
	}
}
