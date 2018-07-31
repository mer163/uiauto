package com.zbwx.autotest.ui;

import org.junit.BeforeClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.zbwx.autotest.ui.base.TestBaseCase;
import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.utils.Assertion;

public class HomePageTest extends TestBaseCase{
    
	public HomePage mHomePage = new HomePage();
	@BeforeClass
	public void beforeclass() throws Exception{
		driver.startUiAutomator();
		Thread.sleep(3000);
	}
	
	@Test(description = "点击搜索")
	public void testHomePageSearch()  throws Exception{
		
		driver.startUiAutomator();
//		Thread.sleep(3000);
//		mHomePage.home_bottom.click();
//		Assertion.VerityTextPresentPrecision("热门商品", "当前处在首页");
//		mHomePage.btn_search.click();
//		mHomePage.homePageSearch();
		
	}
	
	@Test(description = "点击客服")
	public void testHomePageService() throws Exception{
		
//		driver.startUiAutomator();
//		Thread.sleep(3000);
//		mHomePage.home_bottom.click();
//		Assertion.VerityTextPresentPrecision("热门商品", "当前处在首页");
//		mHomePage.img_service.click();
		
	}
	
	@AfterSuite
	public void openResult() {
		driver.startUiAutomator();
	}
}
