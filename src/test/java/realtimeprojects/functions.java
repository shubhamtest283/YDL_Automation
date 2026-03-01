package realtimeprojects;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class functions {
     public static WebDriver driver;
     public static WebDriver browserlaunch(String url) {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get(url);
       return driver;
     }
     public static String[] credential(){
    	 String[] data = new String[2];
    	 data[0] = "008550901147";
    	 data[1] = "ydl123";
    	 return data;
     }
     public static void hover() {
    	 WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
    	 Actions action = new Actions(driver);
     }
}
