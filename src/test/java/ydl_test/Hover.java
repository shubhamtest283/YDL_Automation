package ydl_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Hover {
	WebDriver driver;
	Actions action;
	public Hover(WebDriver driver) {
		this.driver = driver;
		this.action = new Actions(driver);
	}

	public void hovers() {
		WebElement elementoHover = driver.findElement(By.xpath("//a[normalize-space()='Accounts']"));
		action.moveToElement(elementoHover).perform();
	}

	public void account_registers() {
		WebElement elementoHover1 = driver.findElement(By.xpath("//a[normalize-space()='Account Registers']"));
		action.moveToElement(elementoHover1).perform();
	}

	public void Subscriptions_register() {
		driver.findElement(By.xpath("//a[normalize-space()='Subscriptions Register']")).click();
	}

	public void Receipt_register() {
		driver.findElement(By.xpath("//a[normalize-space()='Receipt Register']")).click();
	}

	public void staffmenu() {
		WebElement staffhover = driver.findElement(By.xpath("//a[normalize-space()='Staff']"));
		action.moveToElement(staffhover).perform();
	}

	public void stafflistname() {
		driver.findElement(By.xpath("//a[normalize-space()='Staff List']")).click();

	}
	public void analysismenu() {
		WebElement analysishover = driver.findElement(By.xpath("//a[normalize-space()='Analysis']"));
		action.moveToElement(analysishover).perform();
	}
	public void subanalysis() {
		driver.findElement(By.xpath("//a[normalize-space()='Subscriptions Analysis']")).click();
	}

	public Actions scrollByAmount(int i, int j) {
		return null;
	}
}
