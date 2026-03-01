package ydl_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	public void Logininfo(String user, String pass)
	{
		WebElement Username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement Password = driver.findElement(By.xpath("//input[@name='password1']"));
		WebElement submit = driver.findElement(By.xpath("//input[@value='LOGIN']"));
		Username.sendKeys(user);
		Password.sendKeys(pass);
		submit.click();
	}
	}
