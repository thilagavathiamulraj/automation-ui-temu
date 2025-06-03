package com.magento;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MagentoApplication {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/mohanponnusamy/Software/chromedriver-mac-arm64/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@class ='authorization-link']/a")).click();
		System.out.println(driver.getTitle());
		//driver.findElement(By.name("login[username]")).sendKeys("thilagavathi.amulraj90@gmail.com");
		driver.findElement(By.xpath("//input[@title = 'Email']")).sendKeys("thilagavathi.amulraj90@gmail.com");
		driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("Thilaga123");
		driver.findElement(By.xpath("//button[@class= 'action login primary']")).click();
		driver.getPageSource();
		// create webElement of woMen
		
		WebElement woMen = driver.findElement(By.xpath("//span[text()= 'Women']"));
		// mouse siulation using Actions class
		Actions act = new Actions(driver);
		// Mouse hover to Women webElement
		act.moveToElement(woMen).build().perform();
		System.out.println(driver.getTitle());
		WebElement tops = driver.findElement(By.xpath("//span[text()= 'Tops']"));
		
		// conditional wait implemenmtation
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(null)));
		
		act.moveToElement(tops).build().perform();
		WebElement jackets = driver.findElement(By.xpath("//span[text()= 'Jackets']"));
		act.moveToElement(jackets).build().perform();
		jackets.click();
		System.out.println(driver.getTitle());
	}

}
