package seleniumtest;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class datepicker {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yourdigitallift.com/fitness-center/login/");

        // ✅ Normal Selenium (no AIHelper now)
        WebElement username = driver.findElement(By.xpath("//*[@name='username']"));
        username.sendKeys("008550901146");

        WebElement password = driver.findElement(By.xpath("//*[@name='password1']"));
        password.sendKeys("fit123");

        WebElement loginBtn = driver.findElement(By.xpath("/html/body/div/section/form/div[3]/input"));
        loginBtn.click();

        // ✅ Hover Members menu
        WebElement elementoHover = driver.findElement(By.xpath("//*[@id=\"top-nav\"]/ul/li[4]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(elementoHover).perform();

        WebElement myMembers = driver.findElement(By.xpath("//*[@id=\"top-nav\"]/ul/li[4]/ul/li[1]/a"));
        myMembers.click();

        // ✅ Fill form fields
        driver.findElement(By.xpath("//*[@id=\"id_customer_first_name\"]")).sendKeys("shubham");
        driver.findElement(By.xpath("//*[@id=\"id_customer_last_name\"]")).sendKeys("patil");
        driver.findElement(By.xpath("//*[@id=\"id_email\"]")).sendKeys("shubham@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"id_mobileNo\"]")).sendKeys("2523263632");

        // ✅ Datepicker
        driver.findElement(By.xpath("//*[@id=\"datetimepicker_dob\"]")).click();

        String expectedMonth = "August";
        String expectedYear = "2024";
        String expectedDay = "15";

        while (true) {
            String currentMonth = driver.findElement(By.className("datepicker-switch")).getText();

            if (currentMonth.contains(expectedMonth) && currentMonth.contains(expectedYear)) {
                break;
            } else {
                driver.findElement(By.className("next")).click();
                Thread.sleep(500);
            }
        }

        List<WebElement> allDays = driver.findElements(By.xpath("//td[@class='day' or contains(@class,'day')]"));
        for (WebElement day : allDays) {
            if (day.getText().equals(expectedDay)) {
                day.click();
                break;
            }
        }

        System.out.println("✅ DOB selected: 15 August 2024");

        Thread.sleep(2000);
        driver.quit();
    }
}