package ydl_test;

public class Receipt_Register {

	public static void main(String[] args) throws InterruptedException {

		double rrtba = 0, rrrpa = 0;

		browser br = new browser();
		br.launchbrowser("https://www.yourdigitallift.com/fitness-center/login/");
		Login lg = new Login(br.driver);
		lg.Logininfo("008550901147", "ydl123");

		Hover hv = new Hover(br.driver);
		hv.hovers();
		hv.account_registers();
		hv.Receipt_register();

		Subscriptionpage sb = new Subscriptionpage(br.driver);
		for (int i = 0; i < 3; i++) {
			rrtba += sb.receipttba();
			rrrpa += sb.receiptrpa();

			hv.scrollByAmount(0, 1500);
			Thread.sleep(2000);
			sb.clicknext();
		}
		System.out.println("Total Bill Amount: " + rrtba);
		System.out.println("Total Paid Amount: " + rrrpa);

	}

}
