package com.qa.automaton.MakeMyTrip;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import io.github.bonigarcia.wdm.WebDriverManager;


public class OpenHomepage {
	
	public WebDriver driver;
	public WebElement logo;
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	
	}
	
	@Test
	public void openUrl() {
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		 logo=driver.findElement(By.xpath("//a[@class='mmtLogo makeFlex']//img"));
		
	}
	
	@AfterClass
	public void teatDown() {
		takesScreenShort(logo, "makemyTrip");
		takePageScreenshort(driver, "fullpage");
		Shutterbug.shootPage(driver,ScrollStrategy.BOTH_DIRECTIONS).withName("expect").save("./screenShort/");
	
	}
	
	public void takesScreenShort(WebElement element,String fileName) {
		File src=element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./screenShort/"+fileName+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void takePageScreenshort(WebDriver driver,String fileName) {
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File("./screenShort/"+fileName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
