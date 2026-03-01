package seleniumtest;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class tabhandeling {

	public static void main(String[] args) throws InterruptedException {
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.yourdigitallift.com/fitness-center/login/");
       
       driver.findElement(By.name("username")).sendKeys("008550901146");
       driver.findElement(By.name("password1")).sendKeys("fit123");
       driver.findElement(By.xpath("/html/body/div/section/form/div[3]/input")).click();
       
       String tabs = driver.getWindowHandle();
       System.out.println("Parent Tab ID: " + tabs);
       
       driver.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div/a/div/span")).click();
       driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div[2]/div/table/tbody/tr[1]/td[2]/a[1]")).click();
       
     
       
//       driver.findElement(By.id("tabButton")).click();
//       Thread.sleep(1000);
//       driver.findElement(By.id("windowButton")).click();
//       Thread.sleep(1000);
//       
//       WebElement winBtn = driver.findElement(By.id("windowButton"));
//       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", winBtn);
//       Thread.sleep(1000);
//       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", winBtn);
          Set<String> alltabs = driver.getWindowHandles();
       
       for(String TABID : alltabs) {
    	   driver.switchTo().window(TABID);
    	   System.out.println("Current Tab ID: " + TABID);
    	   System.out.println("Page Title: " + driver.getTitle());
       
       
       try {
    	   String content = driver.findElement(By.tagName("h1")).getText();
    	   System.out.println("Content: " + content);
       }
       catch (Exception e){
    	   System.out.println("No visible content on this page");
       }
       System.out.println("----------------------------------------------");
       }
       driver.switchTo().window(tabs);
       System.out.println("✅ Switched back to parent tab: " + driver.getCurrentUrl());
       
       driver.quit();
	}
	

}
