package seleniumtest; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Browser setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yourdigitallift.com/fitness-center/login/");
    }

    @Test
    public void loginTest() {
        // Enter username
        driver.findElement(By.xpath("/html/body/div/section/form/div[1]/input"))
              .sendKeys("008550901147");

        // Enter password
        driver.findElement(By.id("myInput"))
              .sendKeys("ydl123");

        // Click Login button
        driver.findElement(By.xpath("/html/body/div/section/form/div[3]/input"))
              .click();

        // Check login result
        String pageSource = driver.getPageSource();

        if (pageSource.toLowerCase().contains("the password that you've entered is incorrect.")) {
            System.out.println("❌ Invalid login: Invalid credentials");
        } else {
            System.out.println("✅ Login successful");
        }
    }

    @AfterMethod
    public void tearDown() {
        // Close browser
        driver.quit();
    }
}

