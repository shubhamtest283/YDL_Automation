package ydl_test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActiveCount {

	public static void main(String[] args) throws InterruptedException {
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		double nsa = 0, gst = 0, tsa = 0;
		browser br = new browser();
		br.launchbrowser("https://www.yourdigitallift.com/fitness-center/login/");
		Login lg = new Login(br.driver);
		lg.Logininfo("008550901147", "ydl123");

		Hover hv = new Hover(br.driver);
		staff st = new staff(br.driver);

		// System.out.println(st.activestaffcount());
		// System.out.println(st.deactivestaffcount());

		hv.hovers();
		hv.account_registers();
		hv.Subscriptions_register();

		Subscriptionpage sb = new Subscriptionpage(br.driver);

		for (int i = 0; i < 3; i++) {

			a += sb.activecount();
			b += sb.expiredcount();
			c += sb.pendingcount();
			d += sb.usedcount();
			nsa += sb.netamount();
			gst += sb.GST_Amount();
			tsa += sb.TotalAmount();

			hv.scrollByAmount(0, 1500);
			Thread.sleep(2000);
			sb.clicknext();
		}

		System.out.println("Active Count: " + a);
		System.out.println("Expired Count: " + b);
		System.out.println("Pending Count: " + c);
		System.out.println("Used Count: " + d);
		System.out.println("Net Sale Amount: " + nsa);
		System.out.println("GST Amount: " + gst);
		System.out.println("Total Amount: " + tsa);

		int totalcount = a + b + c + d;
		WebElement totalscount = br.driver
				.findElement(By.xpath("//span[contains(normalize-space(),'Total Subscriptions')]"));
		int totalsubcount = Integer.parseInt(totalscount.getText().replaceAll("[^0-9]", ""));

		System.out.println("Total subs count: " + totalcount);
		System.out.println("Total subscription count: " + totalsubcount);

		List<String> deactivateids = st.deactivestaffcount();
		List<String> createdid = new ArrayList<>();

		Select createdbyid = new Select(br.driver.findElement(By.id("id_created_by")));
		List<WebElement> options = createdbyid.getOptions();

		for (WebElement dropid : options) {
			String value = dropid.getAttribute("value");
			if (value != null && !value.trim().isEmpty()) {
				createdid.add(value);
			}
		}
		hv.staffmenu();
		hv.stafflistname();
        
		System.out.println("Deactivated IDs: " + st.deactivestaffcount());

		for (int i = 0; i < createdid.size(); i++) {
			for (int j = 0; j < st.deactivestaffcount().size(); j++) {
				if (createdid.get(i).equals(st.deactivestaffcount().get(j))) {
					System.out.println("deactivate staff found test is fail");
				}
			}
		}
	}
}
