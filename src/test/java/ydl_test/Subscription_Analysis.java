package ydl_test;

import org.testng.annotations.Test;

public class Subscription_Analysis {
	@Test
	void app() {
	browser br = new browser();
	br.launchbrowser("https://www.yourdigitallift.com/fitness-center/login/");
	Login lg = new Login(br.driver);
	lg.Logininfo("008550901147", "ydl123");
	Hover hv = new Hover(br.driver);
	hv.analysismenu();
	hv.subanalysis();
	Subanalysistest sa = new Subanalysistest();
	sa.monthlysub();
    }
 }