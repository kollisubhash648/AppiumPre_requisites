
package Android;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities; //Used to set device properties:device name, platform, version, app package name, activity name, etc. It has various methods eg. setCapability()-> used to set the device name, platform version, platform name, absolute path of the app under test (the .apk file of the app(Android) under test), app Activity (in Android) and appPackage(java).
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest; //@AfterTest annotated method will be executed when all @Test annotated methods completed its execution
import org.testng.annotations.BeforeTest; //@Before Test annotated method will be executed before any @Test method
import org.testng.annotations.Test;
public class Test1 {
	
	AndroidDriver driver;
	//RemoteWebDriver driver;
	//AppiumDriver driver;
	//WebDriver driver;
	//SwipeableWebDriver driver;
	//@SuppressWarnings("deprecation")
	//Iosdriver
	
	@BeforeTest
	public void SetCapabilities() throws MalformedURLException, InterruptedException {
	DesiredCapabilities capabilities = new DesiredCapabilities();	
	//File appDir = new File("C:\\Subhash\\KOKO-APK File\\" );
	//File app = new File(appDir, "com.cathyaybk.koko-1.apk");
	
	//capabilities.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"4100819d90d2b000");
	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.2.2");
	capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 200);

	capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.cathaybk.koko");
	capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.cathaybk.koko.KokoActivity");

	
	
	
	driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
	//driver = Adriver;
	//driver.context("NATIVE_APP");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	//TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
	//Dimension size = driver.manage().window().getSize();
	//Find swipe start and end point from screen's.
	 //Find startx point which is at right side of screen.
	 //int startx = (int) (size.width * 0.70);
	 
	 //Find endx point which is at left side of screen.
	// int endx = (int) (size.width * 0.30);
	 
	// int starty = (size.height / 2) ;
	 //driver.swipe(startx, starty, endx, starty, 3000);
	 //driver.swipe(startx, starty, endx, starty, 3000);
	 //driver.swipe(startx, starty, endx, starty, 3000);
	 
	 
	
	TouchAction action = new TouchAction((PerformsTouchActions) driver);
	Dimension size = driver.manage().window().getSize();
    int startY = (size.height / 2) ;
    int startX = (int) (size.width * 0.70);
    int endX =(int) (size.width * 0.30);
    int endY = (size.height / 2) ;
    action.press(startX, startY).waitAction(2000).moveTo(endX, endY).release().perform();
	
	
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 
	//touchAction.press(startX, startY).moveTo(endX, endY).release().perform();
	//DesiredCapabilities capabilities = new DesiredCapabilities();
	//capabilities.setCapability(CapabilityType.VERSION, "4.2.2");
	//capabilities.setCapability("udid", Properties.udid);
	//capabilities.setCapability("appPackage", "com.cathaybk.koko");
	//capabilities.setCapability("appActivity", "com.cathybk.koko.KokoActivity");

	//other caps
	//
	
	/*
	capabilities.setCapability("deviceName", "VICKY"); //obtained from the command "adb devices"
	capabilities.setCapability("browserName", "Android");
	
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("device", "selendroid");
	//capabilities.setCapability(CapabilityType.PLATFORM, "Android");
	
	*/
	//driver = new AndroidDriver(new URL("http://127.0.0.1:8080/wd/hub"), capabilities);
	 
	// Dimension size = driver.manage().window().getSize();
     //int startY = (size.height / 2) ;
     //int startX = (int) (size.width * 0.70);

     //int endX =(int) (size.width * 0.30);
     //int endY = (size.height / 2) ;
     //String start = Integer.toString(startX) +"," +Integer.toString(startY);
     //String end =  Integer.toString(endX) +"," +Integer.toString(endY);
     //mobileSwipe((RemoteWebDriver)driver,start ,end  );
     
	}
	
	
    public static void mobileSwipe(RemoteWebDriver driver, String start, String end)
    {
        //System.co("Mobile Swipe from " + start + " to " + end);
        //System.WriteLine();
        String command = "mobile:touch:swipe";
        Map<String, Object> Parms = new HashMap<String, Object>();
        Parms.put("start", start);
        Parms.put("end", end);
        driver.executeScript(command, Parms);
    }
    
	@Test
	public void Login(){
		/*
	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'mas_account_verification_country')]")).click(); //Open drop down country menu
	driver.findElement(By.name("India")).click(); //Select one country
	driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id, 'et_account_verification_phone_number')]")).sendKeys("9999999999"); //Enter Mobile No
	//driver.hideKeyboard(); //Hide keyboard
	driver.findElement(By.name("Enter your name")).sendKeys("Parul"); //Enter name
	//driver.hideKeyboard(); //Hide keyboard
	driver.findElement(By.className("android.widget.Button")).click(); //Click on submit button
	driver.findElement(By.className("android.widget.EditText")).sendKeys("123456"); //Enter password in next screen
	//driver.hideKeyboard(); //Hide Keyboard, since keyboard hides the Submit button in this case
	driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click(); //Click on submit button
	*/
	}
	

}
