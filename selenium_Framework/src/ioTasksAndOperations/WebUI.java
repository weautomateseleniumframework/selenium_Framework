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
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.Date;
import java.util.List;
public class WebUI 
{
	static WebDriver driver;
	
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
	
	public static void check(String xpath)
	{
		try 
    	{ 
			if(driver.findElement(By.xpath(xpath)).isSelected())
			{
				driver.findElement(By.xpath(xpath)).click();
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
		
	
	
	
    
    public static void navigateToURL(String url)
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
    public static void click(String xpath)
    {
    	try 
    	{ 
    		driver.findElement(By.xpath(xpath)).click();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void setText(String xpath,String text)
    {
    	try 
    	{ 
    		driver.findElement(By.xpath(xpath)).sendKeys(text);
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
