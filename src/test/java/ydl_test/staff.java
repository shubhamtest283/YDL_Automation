package ydl_test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class staff {
	WebDriver driver;
	Actions action;
	public staff(WebDriver driver) {
		this.driver = driver;
	}
	public void datepicker(String day, String month, String year) {
		driver.findElement(By.xpath("//select[@id='dropdown']")).click();
		driver.findElement(By.xpath("//select[@id='dropdown']//option[@value='Custom']")).click();
	}

	public List<String> activestaffcount() {
		List<String> activeids = new ArrayList<>();
		List<WebElement> active = driver.findElements(
				By.xpath("//tr[.//span[contains(@class, 'label-success') and normalize-space()='Active']]//td[2]"));
		for (WebElement id : active) {
			String Stringid = id.getText().replaceAll("[^0-9]", "");
			activeids.add(Stringid);
		}
		return activeids;
	}

	public List<String> deactivestaffcount() {
		List<String> deactivateids = new ArrayList<>();
		List<WebElement> deactive = driver.findElements(By.xpath(
				"//tr[.//span[contains(@class,'label-danger') and normalize-space()='Deactivated'] and not(.//span[contains(@class,'label-success')])]//td[2]"));
		for (WebElement sid : deactive) {
			String Stringids = sid.getText().replaceAll("[^0-9]", "");
			deactivateids.add(Stringids);
		}
		return deactivateids;
	}

}
