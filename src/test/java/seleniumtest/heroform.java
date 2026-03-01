package seleniumtest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class heroform {

	public static void main(String[] args) {
    superhero myhero=new superhero("shubham", "automation testing", 99);
    myhero.showdetails();
    
    WebDriver driver=new ChromeDriver();
    driver.get("file:///C:/Users/patil/OneDrive/Desktop/hero_form.html");
    
    driver.findElement(By.id("name")).sendKeys(myhero.name);
    driver.findElement(By.id("power")).sendKeys(myhero.power);
    driver.findElement(By.id("strength")).sendKeys(String.valueOf(myhero.strength));
	}

}
