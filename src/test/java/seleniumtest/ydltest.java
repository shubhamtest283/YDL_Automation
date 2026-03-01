package seleniumtest;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class ydltest {

	public static void main(String[] args) {
      
      Scanner sc=new Scanner(System.in);
      
      System.out.println("enter your username: ");
      String username= sc.nextLine();
      
      System.out.println("enter your password: ");
      String password= sc.nextLine();
     
      ydlform ydl=new ydlform("shubham", "patil", "patilshubham9273@gmail.com", "4445556669", username, password);
      
      WebDriver driver = new ChromeDriver();
      driver.get("https://www.yourdigitallift.com/fitness-center/login/");
      
      driver.findElement(By.name("username")).sendKeys(ydl.username);
      driver.findElement(By.name("password1")).sendKeys(ydl.password);
      driver.findElement(By.xpath("/html/body/div/section/form/div[3]/input")).click();
      
      WebElement elementoHover = driver.findElement(By.xpath("//*[@id=\"top-nav\"]/ul/li[4]/a"));
      Actions action = new Actions(driver);
      action.moveToElement(elementoHover).perform();

      // Click on submenu
      driver.findElement(By.xpath("//*[@id=\"top-nav\"]/ul/li[4]/ul/li[1]/a")).click();
      
      driver.findElement(By.xpath("//*[@id=\"id_customer_first_name\"]")).sendKeys(ydl.firstname);
      driver.findElement(By.xpath("//*[@id=\"id_customer_last_name\"]")).sendKeys(ydl.lastname);
      driver.findElement(By.xpath("//*[@id=\"id_email\"]")).sendKeys(ydl.email);
      driver.findElement(By.xpath("//*[@id=\"id_mobileNo\"]")).sendKeys(ydl.mobile);
	}

}
