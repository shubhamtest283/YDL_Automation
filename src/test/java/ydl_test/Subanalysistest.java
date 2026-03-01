package ydl_test;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Subanalysistest {
	SoftAssert softAssert = new SoftAssert();
	int monthly_sub_total_count;
	int monthly_gym_sub_count;
	int monthly_PT_sub_count;
	int GMC;
	int PMC;
	int GPMC;
	double monthly_sub_total_amount;
	double monthly_gym_sub_amount;
	double monthly_PT_sub_amount;
	double GMA;
	double PTMA;
	double GTPTMA;
	browser br = new browser();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public void monthlysub() {
		String[] Month = { " January", " February", " March", " April", " May", " June", " July", " August",
				" September", " October", " November", " December" };
		String year = "2025";
		WebElement inputyear = br.driver.findElement(By.xpath("//input[@name='stats_year']"));
		inputyear.clear();
		inputyear.sendKeys(year);
		br.driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Go!']")).click();
		for (int i = 0; i < Month.length; i++) {
			String monthyear = Month[i] + " " + year;
			YearMonth yearmonth = YearMonth.of(2025, i + 1);
			LocalDate startdate = yearmonth.atDay(1);
			LocalDate enddate = yearmonth.atEndOfMonth();
			String start = startdate.format(formatter);
			String end = enddate.format(formatter);
			br.driver.findElement(By.xpath("//input[@id='id_start_picker_date']")).clear();
			br.driver.findElement(By.xpath("//input[@id='id_start_picker_date']")).sendKeys(start);
			br.driver.findElement(By.xpath("//input[@id='id_end_picker_date']")).clear();
			br.driver.findElement(By.xpath("//input[@id='id_end_picker_date']")).sendKeys(end);
			br.driver.findElement(By.xpath("//input[contains(@onclick,'this.form.submit();')]")).click();
			List<WebElement> monthlyamt = br.driver
					.findElements(By.xpath("//span[b[contains(text(),'" + monthyear + "')]]/following-sibling::div"));
			List<WebElement> GYM = br.driver.findElements(By.xpath("//span[b[contains(text(),'" + monthyear
					+ "')]]/following::span[contains(@class,'gym-renewal')][1]"));
			List<WebElement> PT = br.driver.findElements(By.xpath("//span[b[contains(text(),'" + monthyear
					+ "')]]/following::span[contains(@class,'pt-renewal')][1]"));

			//System.out.println(monthyear);
			for (WebElement amt1 : monthlyamt) {
				String amt = amt1.getText();
				int openbracket = amt.indexOf("(");
				int closebracket = amt.indexOf(")");
				String totalsubcount = amt.substring(0, openbracket).trim();
				String Totalsubamt = amt.substring(openbracket + 1, closebracket).replace("/-", "").trim();
				monthly_sub_total_count = Integer.parseInt(totalsubcount);
				monthly_sub_total_amount = Double.parseDouble(Totalsubamt);
				//System.out.println("Total Sub Count:- " + monthly_sub_total_count);
				//System.out.println("Total Sub Amount:- " + monthly_sub_total_amount);
			}
			for (WebElement gymamt : GYM) {
				String Gamt = gymamt.getText();
				int openbracket = Gamt.indexOf("(");
				int closebracket = Gamt.indexOf(")");
				String gymcount = Gamt.substring(0, openbracket).replaceAll("[^0-9]", "").trim();
				String gymsamt = Gamt.substring(openbracket + 1, closebracket).replaceAll("[^0-9.]", "").trim();
				monthly_gym_sub_count = Integer.parseInt(gymcount);
				monthly_gym_sub_amount = Double.parseDouble(gymsamt);
				//System.out.println("Total GYM Sub Count:- " + monthly_gym_sub_count);
				//System.out.println("Total GYM Sub Amount:- " + monthly_gym_sub_amount);
			}
			for (WebElement PTamt : PT) {
				String Pamt = PTamt.getText();
				int openbracket = Pamt.indexOf("(");
				int closebracket = Pamt.indexOf(")");
				String PTcount = Pamt.substring(0, openbracket).replaceAll("[^0-9]", "").trim();
				String PTsamt = Pamt.substring(openbracket + 1, closebracket).replaceAll("[^0-9.]", "").trim();
				monthly_PT_sub_count = Integer.parseInt(PTcount);
				monthly_PT_sub_amount = Double.parseDouble(PTsamt);
				//System.out.println("Total PT Sub Count:- " + monthly_PT_sub_count);
				//System.out.println("Total PT Sub Amount:- " + monthly_PT_sub_amount);
			}
			System.out.println(monthyear);
			subscription_insight();
			count_amount_test();
		}
	}

	public void subscription_insight() {
		WebElement gym_membership_count = br.driver.findElement(By.xpath("//tr[@id='gym_tot']/td[2]"));
		String gmc = gym_membership_count.getText();
		GMC = Integer.parseInt(gmc);
		WebElement pt_membership_count = br.driver.findElement(By.xpath("//tr[@id='pt_tot']/td[2]"));
		String pmc = pt_membership_count.getText();
		PMC = Integer.parseInt(pmc);
		WebElement gym_pt_membership_count = br.driver
				.findElement(By.xpath("//tr/td[normalize-space()='Total']/following-sibling::td[1]"));
		String gpmc = gym_pt_membership_count.getText();
		GPMC = Integer.parseInt(gpmc);
		WebElement gym_membership_amount = br.driver.findElement(By.xpath("//tr[@id='gym_tot']/td[6]"));
		String gma = gym_membership_amount.getText();
		GMA = Double.parseDouble(gma.replaceAll("[^0-9.]", ""));
		//System.out.println("gym membership total amount:- " + GMA);
		WebElement pt_membership_amount = br.driver.findElement(By.xpath("//tr[@id='pt_tot']/td[6]"));
		String ptma = pt_membership_amount.getText();
		PTMA = Double.parseDouble(ptma.replaceAll("[^0-9.]", ""));
		//System.out.println("pt membership total amount:- " + PTMA);
		WebElement total_membership_amount = br.driver
				.findElement(By.xpath("//tr/td[normalize-space()='Total']/following-sibling::td[5]"));
		String gtptma = total_membership_amount.getText();
		GTPTMA = Double.parseDouble(gtptma.replaceAll("[^0-9.]", ""));
		//System.out.println("gym pt membership total amount:- " + GTPTMA);
	}
     public void count_amount_test() {
    	 int monthly_gt_pt_total_count = monthly_gym_sub_count+monthly_PT_sub_count;
    	 double monthly_gym_pt_total_amount = monthly_gym_sub_amount+monthly_PT_sub_amount;
    	 int datewisegym_pt_count = GMC+PMC;
    	 double datewisegym_pt_amount = GMA+PTMA;
    	 
    	 if(monthly_gt_pt_total_count != monthly_sub_total_count) {
    		 System.out.println("❌ monthly count is not matched");
    	     softAssert.fail("monthly count is not matched");
    	 }
    	 if(monthly_gym_pt_total_amount != monthly_sub_total_amount) {
    		 System.out.println("❌ monthly amount is not matched");
    		 softAssert.fail("monthly amount is not matched");
    	 }
    	 if(datewisegym_pt_count != monthly_gt_pt_total_count) {
    		 System.out.println("❌ monthly datewise count is not matched");
    		 softAssert.fail("monthly datewise count is not matched");
    	 }
    	 if(datewisegym_pt_amount != monthly_gym_pt_total_amount) {
    		  System.out.println("❌ monthly datewise amount is not matched");
    		  softAssert.fail("monthly datewise amount is not matched");
    		  
    	softAssert.assertAll();
    	 }
     }
}
