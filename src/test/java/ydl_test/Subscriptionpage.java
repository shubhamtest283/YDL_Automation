package ydl_test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Subscriptionpage {
	WebDriver driver;
	public Subscriptionpage(WebDriver driver) {
		this.driver = driver;
	}


	public int activecount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table//tbody//tr")));
		List<WebElement> ActiveStatus = driver.findElements(
				By.xpath("//span[contains(@class,'label-success') and normalize-space()='Active']\r\n" + ""));
		return ActiveStatus.size();

	}

	public int usedcount() {
		List<WebElement> usedStatus = driver.findElements(By.xpath(
				"//table//tbody//td//span[contains(@class,'label-info') and normalize-space()='Used']\r\n" + ""));
		return usedStatus.size();
	}

	public int expiredcount() {
		List<WebElement> expiredStatus = driver.findElements(By.xpath(
				"//table//tbody//td//span[contains(@class,'label-danger') and normalize-space()='Expired']\r\n" + ""));
		return expiredStatus.size();
	}

	public int pendingcount() {
		List<WebElement> pendingStatus = driver.findElements(By.xpath(
				"//table//tbody//td//span[contains(@class,'label-warning') and normalize-space()='Pending']\r\n" + ""));
		return pendingStatus.size();
	}

	public double netamount() {
		List<WebElement> netsaleamt = driver.findElements(By.xpath("//table//tbody//tr/td[8]\r\n" + ""));
		double totalsaleamt = 0;

		for (WebElement amt : netsaleamt) {
			String currency = amt.getText();
			currency = currency.replace("₹", "").trim();
			totalsaleamt = totalsaleamt + Double.parseDouble(currency);
		}
		return totalsaleamt;
	}
	
	
	public double GST_Amount() {
		List<WebElement> gstamt = driver.findElements(By.xpath("//table//tbody//tr/td[9]\r\n" + ""));
		double gstamount = 0;

		for (WebElement gamt : gstamt) {
			String GSTAMOUNT = gamt.getText();
			GSTAMOUNT = GSTAMOUNT.replace("₹", "").trim();
			gstamount = gstamount + Double.parseDouble(GSTAMOUNT);
		}
		return gstamount;
	}
	
	public double TotalAmount() {
		List<WebElement> tamt = driver.findElements(By.xpath("//table//tbody//tr/td[10]\r\n" + ""));
		double tamount = 0;

		for (WebElement toamt : tamt) {
			String TAMOUNT = toamt.getText();
			TAMOUNT = TAMOUNT.replace("₹", "").trim();
			tamount = tamount + Double.parseDouble(TAMOUNT);
		}
		return tamount;
	}
	public double receipttba() {
		List<WebElement> tba = driver.findElements(By.xpath("//table//tbody//tr/td[11]\r\n" + ""));
		double rectba = 0;

		for (WebElement tba1 : tba) {
			String tbillamt = tba1.getText();
			tbillamt = tbillamt.replaceAll("[^0-9.]", "").trim();
			rectba = rectba + Double.parseDouble(tbillamt);
		}
		return rectba;
	}
	public double receiptrpa() {
		List<WebElement> rpa = driver.findElements(By.xpath("//table//tbody//tr/td[12]\r\n" + ""));
		double recrpa = 0;

		for (WebElement rpa1 : rpa) {
			String tpaidamt = rpa1.getText();
			tpaidamt = tpaidamt.replaceAll("[^0-9.]", "").trim();
			recrpa = recrpa + Double.parseDouble(tpaidamt);
		}
		return recrpa;
	}


	public void clicknext() {
		driver.findElement(By.xpath("//input[@value='Next']")).click();
	}

	public int headercount(String text) {
		WebElement ele = driver.findElement(By.xpath("//span[contains(normalize-space(),'" + text + "')]\r\n" + ""));
		return Integer.parseInt(ele.getText().replaceAll("[^0-9]", ""));
	}
	
	public double  amount1() {
		WebElement element1 = driver.findElement(By.xpath("//span[contains(normalize-space(), 'Net Sales Amount')]"));
		return Double.parseDouble(element1.getText().replaceAll("[^0-9]", ""));
	}
	public double  amount2() {
		WebElement element2 = driver.findElement(By.xpath("//span[contains(normalize-space(), 'GST Amount')]"));
		return Double.parseDouble(element2.getText().replaceAll("[^0-9]", ""));
	}
	public double  amount3() {
		WebElement element3 = driver.findElement(By.xpath("//span[contains(normalize-space(), 'Total amount (including Pending)')]"));
		return Double.parseDouble(element3.getText().replaceAll("[^0-9]", ""));
	}

}
