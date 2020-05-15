package ioTasksAndOperations;



import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class WebUI 
{
	static WebDriver driver;
	static String xpath = null;
	static String css= null;
	public static void template()
	{
		try 
    	{ 
			
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
		
	}
	
	public static String getText(ArrayList<String> object)
	{
		String returnedText = null;
		try 
    	{ 
			if(object.get(0).equals("xpath"))
			{
			xpath = object.get(1);
			returnedText = driver.findElement(By.xpath(xpath)).getText();
			}
			
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
		return returnedText;
		
	}
	
	public static void maximizeWindow()
	{
		try 
    	{ 
			driver.manage().window().maximize();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
		
	}
	
	public static void selectOptionByLabel(ArrayList<String> object,String text, boolean bool)
	{
		try 
    	{ 
			if(object.get(0).equals("xpath"))
			{
				xpath = object.get(1);
				new Select(driver. findElement(By.xpath(xpath))).selectByVisibleText(text);
			}
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
		
	}
	
	public static void acceptAlert()
	{
		try 
    	{ 
			driver.switchTo().alert().accept();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
		
	}
	
	public static void back()
	{
		try 
    	{ 
			driver.navigate().back();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
		
	}
	
	public static void check(ArrayList<String> object)
	{
		try 
    	{ 	
			if(object.get(0).equals("xpath"))
			{
				xpath = object.get(1);
			if(driver.findElement(By.xpath(xpath)).isSelected())
			{
				driver.findElement(By.xpath(xpath)).click();
			}
			}
			else if(object.get(0).equals("css"))
			{
				css = object.get(1);
				if(driver.findElement(By.cssSelector(css)).isSelected())
				{
					driver.findElement(By.cssSelector(css)).click();
				}	
			}
			
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
		
	}
	
	public static void closeBrowser(String flowControl)
	{
		try 
    	{ 
			driver.close();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
	}
	
	public static void closeBrowser()
	{
		try 
    	{ 
    		driver.close();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
	}
	
	public static void closeWindowIndex(int windowIndex)
	{
		try 
    	{ 
			List<String> handles = (List<String>) driver.getWindowHandles();
			driver.switchTo().window(handles.get(windowIndex));
			driver.close();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
		
	}
	
	public static void closeWindowTitle(String title)
	{
		try 
    	{ 
			driver.switchTo().window(title);
			driver.close();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
	}
	
	
	
	//public static void openBrowser(java.lang.String rawUrl, com.kms.katalon.core.model.FailureHandling flowControl)
	public static void openBrowser(String rawUrl, String flowControl)
	{
		try 
    	{ 
			//perform below in try catch - Failure Handling
			System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
	    	driver=new ChromeDriver();
			driver.get(rawUrl);	
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
	}
	
	public static void openBrowser(String rawUrl)
	{
		
		try 
    	{ 
			System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
	    	driver=new ChromeDriver();
			driver.get(rawUrl);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
	}
	
	public static void openBrowser()
	{
		
    	try 
    	{ 
    		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
        	driver=new ChromeDriver();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
	}
		
	
	
	
    
    public static void navigateToUrl(String url)
    {
    	
    	try 
    	{ 
    		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
        	driver=new ChromeDriver();
        	driver.get(url);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public static void click(ArrayList<String> object)
    {
    	try 
    	{ 
    		
			if(object.get(0).equals("xpath"))
			{
				xpath = object.get(1);
				driver.findElement(By.xpath(xpath)).click();
			}
			else if(object.get(0).equals("css"))
			{
			css = object.get(1);
			driver.findElement(By.cssSelector(css)).click();
			}
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void setText(ArrayList<String> object,String text)
    {
    	try 
    	{ 
			if(object.get(0).equals("xpath"))
			{
				xpath = object.get(1);
    		driver.findElement(By.xpath(xpath)).sendKeys(text);
			}
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void takeScreenshot()
    {
//    	Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
////    	 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//    	 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
//    	    Date date = new Date();    
//    	  try {                 
//    	  ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir")+"/Screenshots/"+formatter.format(date)+".png"));             
//    	} 
//    	  catch (IOException e) 
//    	  {
//    		e.printStackTrace();             
//    	  }                          

    }
    
    
}
