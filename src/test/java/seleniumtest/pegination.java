package seleniumtest;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class pegination {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yourdigitallift.com/fitness-center/login/");
        driver.manage().window().maximize();

        // Login
        driver.findElement(By.xpath("/html/body/div/section/form/div[1]/input")).sendKeys("5125123636");
        driver.findElement(By.xpath("//*[@id=\"myInput\"]")).sendKeys("ydl123");
        driver.findElement(By.xpath("/html/body/div/section/form/div[3]/input")).click();

        // Hover
        WebElement elementoHover = driver.findElement(By.xpath("//*[@id=\"top-nav\"]/ul/li[4]/a"));
        WebElement addmember = driver.findElement(By.xpath("//*[@id=\"top-nav\"]/ul/li[4]/ul/li[1]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(elementoHover).moveToElement(addmember).click().build().perform();

        // Click on submenu
        driver.findElement(By.xpath("//*[@id=\"top-nav\"]/ul/li[4]/ul/li[3]/a")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Get list of pagination links
        List<WebElement> paginationLinks = driver.findElements(By.xpath("//*[@id='new-pagination']/ul/li/a"));
        System.out.println("Total Pages: " + paginationLinks.size());

        // Loop through each page
        for (int i = 1; i <= paginationLinks.size(); i++) {
            // Scroll down
            action.scrollByAmount(0, 1500).perform();
            Thread.sleep(2000);

            // Re-fetch pagination links after each click (important!)
            paginationLinks = driver.findElements(By.xpath("//*[@id='new-pagination']/ul/li/a"));

            // Click on the page link if it's clickable
            if (i < paginationLinks.size()) {
                WebElement pageLink = paginationLinks.get(i);
                wait.until(ExpectedConditions.elementToBeClickable(pageLink));
                pageLink.click();
                Thread.sleep(2000); // Wait for page to load
                
                List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
                System.out.println("Page " + pageLink.getText() + " has " + rows.size() + " rows.");
            }
        }

         // driver.quit();
    }
}

