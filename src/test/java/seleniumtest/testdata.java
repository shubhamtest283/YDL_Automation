package seleniumtest;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testdata {

	public static WebDriver driver;
    public static WebDriver launchbrowser(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public static String[] credentials() {
        String[] data = new String[2];
        data[0] = "008550901146";
        data[1] = "fit123";
        return data;
    }
    
    public static void hover() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	Actions action = new Actions(driver);
    	
    	WebElement elementoHover = driver.findElement(By.xpath("//*[@id=\"top-nav\"]/ul/li[4]/a"));
    	action.moveToElement(elementoHover).perform();
    	
    	WebElement addmember = driver.findElement(By.xpath("//*[@id=\"top-nav\"]/ul/li[4]/ul/li[1]/a"));
        addmember.click();
        }
    
    public static void scroll() {
    	Actions action = new Actions(driver);
    	action.scrollByAmount(0, 2000).perform();
    }

    public static List<String[]> getallmembersdata(String filepath) {
        List<String[]> alldata = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(new File(filepath));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                String[] rowdata = new String[colCount];

                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    rowdata[j] = (cell == null) ? "" : formatter.formatCellValue(cell).trim();
                }
                alldata.add(rowdata);
            }

            workbook.close();
            file.close();
        } catch (Exception e) {
            System.out.println("❌ Excel read error: " + e.getMessage());
        }

        return alldata;
    }
}
