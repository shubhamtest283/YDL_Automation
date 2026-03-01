package ydl_test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class members {

	public static void main(String[] args) {

		browser br = new browser();
		br.launchbrowser("https://www.yourdigitallift.com/fitness-center/login/");
		Login lg = new Login(br.driver);
		WebDriverWait wait = new WebDriverWait(br.driver, Duration.ofSeconds(3000));
		lg.Logininfo("8097391552", "Anagha");
		Actions action = new Actions(br.driver);
		Hover hv = new Hover(br.driver);
		WebElement element = br.driver.findElement(By.xpath(
				"//body/div[@class='container body']/div[@class='main_container']/nav[@id='top-nav']/ul[@class='menu']/li[4]/a[1]"));
		action.moveToElement(element).perform();

		br.driver.findElement(By.xpath("//a[normalize-space()='My Members']")).click();
		List<String> validno = new ArrayList();
		List<String> invalidno = new ArrayList();


		while (true) {
			try {
				
				List<WebElement> data = br.driver.findElements(By.xpath("//table//tbody//tr//td//div[contains(@class,'center-title-list')]//a/following-sibling::span[1]"));
				for (WebElement no : data) {
					String mobno = no.getText().replaceAll("[^0-9]", "");
				
					if(mobno.length()==10) {
						validno.add(mobno);
					}
					else {
						invalidno.add(mobno);
					}
				}
				
				
				WebElement nextbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Next']")));
				nextbtn.click();
				hv.scrollByAmount(0, 1500);
			} catch (Exception e) {
				break;
			}
		}
		System.out.println("valid" + validno);
		System.out.println("invalid" + invalidno);
		System.out.println("valid" + validno.size());
		System.out.println("invalid" + invalidno.size());

	}

}
