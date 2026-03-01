package seleniumtest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class aitestcases {
    public static void main(String[] args) {
    	 WebDriver driver=new ChromeDriver();
	     driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Actions actions = new Actions(driver);

        try {
            // 1) Login
            driver.manage().window().maximize();
            driver.get("https://www.yourdigitallift.com/fitness-center/login/");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username"))).sendKeys("7150871508");
            driver.findElement(By.name("password1")).sendKeys("Sandhya");
            driver.findElement(By.cssSelector("input[type='submit'][value='LOGIN']")).click();

            // 2) Go to My Members
            // Wait for top menu to be present, then hover on "Members"
            WebElement membersMenu = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//a[contains(@class,'top-menu-link')][contains(normalize-space(.),'Members')]")));
            actions.moveToElement(membersMenu).perform();

            WebElement myMembers = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[contains(@href,'/merchant/fitness-centers/customers/') and contains(.,'My Members')]")));
            myMembers.click();

            // 3) Wait for table to be ready
            By tableBody = By.cssSelector("table tbody");
            wait.until(ExpectedConditions.presenceOfElementLocated(tableBody));

            int total = 0;
            int pageIndex = 1;
            List<Integer> perPageCounts = new ArrayList<>();

            while (true) {
                // --- COUNT VISIBLE ROWS ON CURRENT PAGE ---
                // Exclude "empty" placeholder rows if DataTables is used
                List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));
                int pageCount = 0;
                for (WebElement r : rows) {
                    if (!r.isDisplayed()) continue;
                    String cls = r.getAttribute("class") == null ? "" : r.getAttribute("class");
                    if (cls.contains("dataTables_empty")) continue; // skip placeholder rows
                    pageCount++;
                }

                System.out.println("Page " + pageIndex + " count: " + pageCount);
                perPageCounts.add(pageCount);
                total += pageCount;

                // --- FIND THE 'NEXT' BUTTON IN THE SAME PAGINATION WIDGET ---
                // Try common DataTables patterns first
                WebElement nextBtn = null;
                List<By> nextLocators = List.of(
                        By.cssSelector("a.paginate_button.next"),                         // DataTables
                        By.xpath("//a[contains(@class,'paginate_button')][contains(.,'Next')]"),
                        By.xpath("//a[normalize-space()='Next']")
                );

                for (By loc : nextLocators) {
                    List<WebElement> cand = driver.findElements(loc);
                    if (!cand.isEmpty()) {
                        nextBtn = cand.get(0);
                        break;
                    }
                }

                // If no next button at all, break
                if (nextBtn == null) {
                    break;
                }

                // If disabled (DataTables adds 'disabled' class), stop
                String nextCls = nextBtn.getAttribute("class") == null ? "" : nextBtn.getAttribute("class");
                if (nextCls.contains("disabled") || !nextBtn.isDisplayed()) {
                    break;
                }

                // Prepare a robust wait: wait until current first row becomes stale after clicking Next
                WebElement firstRowForStaleness = null;
                List<WebElement> currentRows = driver.findElements(By.cssSelector("table tbody tr"));
                if (!currentRows.isEmpty()) {
                    firstRowForStaleness = currentRows.get(0);
                }

                // Click Next (use JS to avoid overlay/interception)
                try {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextBtn);
                } catch (Exception clickEx) {
                    nextBtn.click();
                }

                // Wait for table redraw:
                if (firstRowForStaleness != null) {
                    try {
                        wait.until(ExpectedConditions.stalenessOf(firstRowForStaleness));
                    } catch (TimeoutException te) {
                        // fallback: wait for tbody to be visible again
                        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
                    }
                } else {
                    // No row existed (rare) -> small pause + wait tbody present
                    wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
                }

                // Optional: tiny pause to let rows settle
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}

                pageIndex++;
            }

            System.out.println("Per-page counts: " + perPageCounts);
            System.out.println("TOTAL members across all pages: " + total);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}