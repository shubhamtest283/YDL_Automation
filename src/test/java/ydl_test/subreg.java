package ydl_test;

public class subreg {

	public static void main(String[] args) {
      browser br = new browser();
      br.launchbrowser("https://www.yourdigitallift.com/fitness-center/login/");
      Login lg = new Login(br.driver);
		lg.Logininfo("008550901147", "ydl123");
		Hover hv = new Hover(br.driver);
		hv.hovers();
		hv.account_registers();
		hv.Subscriptions_register();
		staff st = new staff(br.driver);
		st.datepicker("01", "01", "2026");
	}

}
