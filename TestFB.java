package Android;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class TestFB {
	WebDriver driver;
	//AndroidDriver driver;
	//SwipeableWebDriver driver;
	//@SuppressWarnings("deprecation")
	
	@BeforeTest
	public void SetCapabilities() throws MalformedURLException, InterruptedException {
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	//File appDir = new File("C:\\Subhash\\KOKO-APK File\\" );
	//File app = new File(appDir, "com.xe.currency.apk");	
	//capabilities.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
	
	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"4100819d90d2b000");
	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.2.2");	
	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);

	capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "nexti.android.bustaiwan");
	capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "nexti.android.bustaiwan.activities.SplashActivity");

	//driver.
	
	
	//capabilities.setCapability("device","Android");
	
	
	
	//capabilities.setCapability("app", app.getAbsolutePath());
	//driver = new RemoteWebDriver(new URL("http://127.0.0.1:8080/wd/hub"), capabilities);
	
	
	
	driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
	//driver.context("NATIVE_APP");
	
	Thread.sleep(1000*20);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
	 
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 
	
	//driver = new AndroidDriver(new URL("http://127.0.0.1:8080/wd/hub"), capabilities);
	
	}
	
	
	@Test
	public void Login(){
	
		List<WebElement> MenuOptions = driver.findElements(By.xpath("//android.widget.TextView"));
		System.out.println("Menu Options Size:" + MenuOptions.size());
		int element_index=-1;
		for(int i=0;i<MenuOptions.size();i++)
		{
			System.out.println("Menu Options: " + MenuOptions.get(i).getText());
			if(MenuOptions.get(i).getText().equals("Directions"))
			{
				//MenuOptions.get(i).click();
				element_index = i;
				break;
			}
		}
		MenuOptions.get(element_index).click();
		try 
		{
			Thread.sleep(1000*5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> Directions = driver.findElements(By.xpath("//android.widget.TextView"));
		int Startpoint=-1;
		int endpoint =-1;
		for(int i=0;i<Directions.size();i++)
		{
			System.out.println("Location Options: " + Directions.get(i).getText());
		}
		for(int i=0;i<Directions.size();i++)
		{
			System.out.println("Location Options: " + Directions.get(i).getText());
			//if(Directions.get(i).getText().equals("My location"))
			if(Directions.get(i).getText().equals("My location"))
			{
				Directions.get(i).sendKeys("Taipei 101");
				Startpoint= i;
				break;				
				//driver.findElements(By.xpath("android.widget.ImageButton")).get(1).click();
			}
		}
		System.out.println("Starting Point Index:" + Startpoint );
		List<WebElement> Input = driver.findElements(By.xpath("//android.widget.EditText"));
		for(int i=0;i<Input.size();i++)
		{
			System.out.println("Input Options: " + Input.get(i).getText());
			if(Input.get(i).getText().equals("Input place keyword"))
			{
				//Input.get(i).sendKeys("Taipei 101");				
				driver.findElements(By.xpath("//android.widget.EditText")).get(i).sendKeys("Taipei 101");
				break;
				//driver.findElements(By.xpath("android.widget.ImageButton")).get(1).click();
			}
		}
		
		driver.findElements(By.xpath("//android.widget.ImageButton")).get(1).click();
		String Taipei101Add = driver.findElements(By.xpath("//android.widget.TextView")).get(1).getText();
		driver.findElements(By.xpath("//android.widget.TextView")).get(1).click();
		//Directions.get(Startpoint).sendKeys(Taipei101Add);
		
		//For Destination
		Directions.get(4).click();
		
		List<WebElement> Input1 = driver.findElements(By.xpath("//android.widget.EditText"));
		for(int i=0;i<Input1.size();i++)
		{
			System.out.println("Input1 Options: " + Input1.get(i).getText());
			if(Input1.get(i).getText().equals("Input place keyword"))
			{
				//Input.get(i).sendKeys("Taipei 101");				
				driver.findElements(By.xpath("//android.widget.EditText")).get(i).sendKeys("RT-Mart");
				break;
				//driver.findElements(By.xpath("android.widget.ImageButton")).get(1).click();
			}
		}
		String RtMart = driver.findElements(By.xpath("//android.widget.TextView")).get(1).getText();
		driver.findElements(By.xpath("//android.widget.ImageButton")).get(1).click();
		
		List<WebElement> Destelements= driver.findElements(By.xpath("//android.widget.TextView"));
		
		/*
		for(int i=0;i<Destelements.size();i++)
		{
			System.out.println("Destelements Options: " + Destelements.get(i).getText());
		}
		*/
		Destelements.get(1).click(); 
		try {
			Thread.sleep(1000*5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> Search =driver.findElements(By.xpath("//android.widget.ImageButton[@index='2']"));
		
		for(int i=0;i<Search.size();i++)
		{
			System.out.println("Search button: " + Search.get(i).getText());
			System.out.println("Search button: " + Search.get(i).getLocation());
		}
		//driver.findElements(By.xpath("//android.widget.ImageButton")).get(1).click(); //selecting first element from the list
		Search.get(2).click();
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
