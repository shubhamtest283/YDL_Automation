package members_data;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ydl_test.Hover;
import ydl_test.Login;
import ydl_test.browser;
import ydl_test.staff;
import org.openqa.selenium.TakesScreenshot;

@Listeners(members_data.mylistners.class)
public class membersdata2 {
	browser br;
	Actions action;
	List<String> deactivestafflist;

	@BeforeClass
	public void launchbrowsers() {
		br = new browser();
		br.launchbrowser("https://www.yourdigitallift.com/fitness-center/login/");
		action = new Actions(br.driver);
		Login lg = new Login(br.driver);
		lg.Logininfo("008550901147", "ydl123");
		deactivestafflist = activestaff();
		membermenu();
	}

	public String capturescreenshot(String testname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) br.driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "\\screenshots\\";
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdir();
		}
		try {
			String filename = "screenshot_" + System.currentTimeMillis() + ".png";
			File targetfile = new File(path + filename);

			FileUtils.copyFile(sourcefile, targetfile);
			System.out.println("screen shot captured");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

	public List<String> activestaff() {
		Hover hv = new Hover(br.driver);
		hv.staffmenu();
		hv.stafflistname();
		staff st = new staff(br.driver);
		// st.activestaffcount();
		st.deactivestaffcount();
		return st.deactivestaffcount();
	}

	public void membermenu() {
		WebElement members = br.driver.findElement(By.xpath("//*[@id=\"top-nav\"]/ul/li[4]/a"));
		action.moveToElement(members).perform();
		br.driver.findElement(By.xpath("//*[@id=\"top-nav\"]/ul/li[4]/ul/li[1]/a")).click();
	}

	public WebElement waitforelement(By locator) {
		WebDriverWait wait = new WebDriverWait(br.driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void checkMandatoryField(By fieldLocator, String fieldName) {
		WebElement field = br.driver.findElement(fieldLocator);
		String validationMsg = field.getAttribute("validationMessage");
		if (validationMsg == null || validationMsg.isEmpty()) {
			Assert.fail("BUG: " + fieldName + " field is NOT mandatory but it SHOULD be mandatory");
		} else {
			System.out.println(fieldName + " validation message: " + validationMsg);
			Assert.assertTrue(true);
		}
	}

	public void checkValidation(By locator, String fieldName) {
		WebElement field = br.driver.findElement(locator);
		String msg = field.getAttribute("validationMessage");
		if (msg == null || msg.isEmpty()) {
			Assert.fail(fieldName + " validation NOT shown");
		} else {
			System.out.println(fieldName + " validation shown: " + msg);
		}
	}

	public void clientrepvalidation(List<String> deactiveStaffIds, List<String> createdid) {
		Collections.sort(deactiveStaffIds);
		Collections.sort(createdid);
		for (String repid : createdid) {
			if (deactiveStaffIds.contains(repid)) {
				Assert.fail("TEST FAIL: Deactivated staff ID found in Client Rep dropdown → ");
			}
		}
	}

	@DataProvider(name = "memberdata")
	public Object[][] mobilenumberdata() {
		return new Object[][] { { "9876541245", true }, // valid
				{ "123456789", false }, // less than 10
				{ "1234901", false }, // more than 10
				{ "abcdefghij", false }, // alphabets
				{ " ", false }, // empty
				{ "98765@210", false } };
	}

	public void submit() {
		br.driver.findElement(By.xpath("//input[@type='submit' and @name='customer_save' and @value='Save & Close']"))
				.click();
	}

	@Test(priority = 1)
	public void firstnamevalidation() {
		submit();
		checkMandatoryField(By.xpath("//input[contains(@placeholder,'First name')]"), "First Name");
	}

	@Test(priority = 2)
	public void lastnamevalidation() throws IOException {
		waitforelement(By.xpath("//input[contains(@placeholder,'First name')]")).sendKeys("Shubham");
		submit();
		waitforelement(By.xpath("//input[contains(@placeholder,'Last name')]"));
		checkMandatoryField(By.xpath("//input[contains(@placeholder,'Last name')]"), "Last Name");
	}

	@Test(priority = 3)
	public void mobilenumber() {
		waitforelement(By.xpath("//input[contains(@placeholder,'Last name')]")).sendKeys("Patil");
		submit();
		checkMandatoryField(By.xpath("//input[@id='id_mobileNo']"), "Mobile No");
	}

	@Test(dataProvider = "memberdata")
	public void mobilevalidation3(String mobile, boolean isvalidexpected) {
		WebElement mobilefield = br.driver.findElement(By.xpath("//input[@id='id_mobileNo']"));
		mobilefield.clear();
		mobilefield.sendKeys(mobile);
		submit();

		if (isvalidexpected) {
			String msg = mobilefield.getAttribute("validationMessage");
			Assert.assertTrue(msg == null || msg.isEmpty(), "Validation shown for valid mobile: " + mobile);
		} else {
			checkValidation(By.xpath("//input[@id='id_mobileNo']"), "Mobile number field accepting only numric value");
		}
	}

	@Test
	public void mobilevalidation4() {
		br.driver.findElement(By.xpath("//input[@id='id_mobileNo']")).clear();
		br.driver.findElement(By.xpath("//input[@id='id_mobileNo']")).sendKeys("1237284021");
		submit();
		checkValidation(By.xpath("//input[@id='id_gender_male']"), "Please select gender");
	}

	@Test(priority = 0)
	public void clientrep() {
		List<String> deactiveStaffIds = deactivestafflist;
		List<String> createdid = new ArrayList<>();
		Select createdbyid = new Select(br.driver.findElement(By.id("id_created_by")));
		List<WebElement> options = createdbyid.getOptions();
		for (WebElement clientrepid : options) {
			String value = clientrepid.getAttribute("value");
			if (value != null && !value.trim().isEmpty()) {
				createdid.add(value);
			}
		}
		clientrepvalidation(deactiveStaffIds, createdid);
		System.out.println("TEST PASS: Client Rep dropdown contains only active staff");
		System.out.println(deactiveStaffIds);
		System.out.println(createdid);
	}

	@Test(dependsOnMethods = "mobilevalidation4")
	public void gender() {
		br.driver.findElement(By.xpath("//input[@id='id_gender_male']")).click();
		submit();
	}

	@AfterClass
	public void quit() {
		br.driver.quit();
	}
}
