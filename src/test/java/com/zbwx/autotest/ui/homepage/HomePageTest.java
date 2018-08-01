package com.zbwx.autotest.ui.homepage;



import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import atx.client.adb.AdbDevice;
import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;
import atx.client.adb.UiDump;
import atx.client.common.ElementObj;
import atx.client.enums.AttributeMask;

import com.zbwx.autotest.ui.base.TestBaseCase;
import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.pageobject.QuotationPage;
import com.zbwx.autotest.ui.utils.Assertion;

public class HomePageTest extends TestBaseCase{
    
//	public static HomePage mHomePage = new HomePage();
	
	@BeforeClass
	public void beforeclass() throws Exception{
	
		Thread.sleep(3000);
	}
	
	@Test(description = "点击客服")
	public void testHomePageService() throws Exception{
		HomePage mHomePage1 = new HomePage();
		Thread.sleep(3000);
		Assertion.VerityTextPresentPrecision("热门商品", "当前处在首页");
		HomePage mHomePage2 = new HomePage();
		device.click(mHomePage2.img_homeService);
		
		Thread.sleep(3000);
		
		if (position.waitForElement(ElementAttribs.TEXT, "交易规则",3000)) {
			ElementAdb mServiceBack = position.findElementById("com.ylmall.app.ui:id/leftBtn");
			device.click(mServiceBack);
			
		}
	
		
	}
	
	@Test(description = "点击搜索")
	public void testHomePageSearch()  throws Exception{
		Thread.sleep(3000);
		HomePage mHomePage2 = new HomePage();
		mHomePage2.search();
		
	}
	@Test(description = "点击消息")
	public void testHomePageMessage()  throws Exception{
		Thread.sleep(3000);
		HomePage mHomePage3 = new HomePage();
		device.click(mHomePage3.img_homeMessage);
		Thread.sleep(3000);
		if (position.findElementByText("公告提醒") != null) {
			ElementAdb mMessageBack =position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mMessageBack);
		}
	}
	@Test(description = "首页轮播")
	public void testHomePageViewPager()  throws Exception{
		Thread.sleep(3000);
		HomePage mHomePage4 = new HomePage();
		for (int i = 0; i < 3; i++) {
			Thread.sleep(3000);
			if (position.findElementByText("热门商品") != null) {
				device.click(mHomePage4.vp_homeCbLoopViewPager);
				Thread.sleep(3000);
				
			}
			Thread.sleep(3000);
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/baseweb_back"));
		}
	}
	@Test(description = "首页盈利播报")
	public void testHomePageMoreylName()  throws Exception{
		Thread.sleep(3000);
		/*ElementAdb mBBaoOne =position.findElementByText("恭喜****4419果礼镍0.08吨盈利+511.28");
		Thread.sleep(3000);
		ElementAdb mBBaoTwo = position.findElementByText("恭喜****2998祖玛香水盈利+7.30");
		if (mBBaoOne!=mBBaoTwo) {
			Thread.sleep(3000);
			device.click(mHomePage.tv_homeMoreylName);
		}*/
		
		ArrayList<ElementAdb> buoBao0 = position.findElementsByText("恭喜****4419果礼镍0.08吨盈利+511.28");
		Thread.sleep(3000);
		ArrayList<ElementAdb> buoBao1 = position.findElementsByText("恭喜****2998祖玛香水盈利+7.30");
		Assertion.VerityBoolean(buoBao0.equals(buoBao1), false, "播报切换成功");
		
		HomePage mHomePage3 = new HomePage();
		if (position.waitForElement(ElementAttribs.TEXT, "热门商品", 3000)) {			
			device.click(mHomePage3.tv_homeMoreylName);
		}
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT, "排名", 3000)) {
			ElementAdb mMoreylBack = position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mMoreylBack);
		}
	}
	
	@Test(description = "热门商品")
	public void testHomeHotCommodity()  throws Exception{
		Thread.sleep(3000);
		HomePage mHomePage3 = new HomePage();
		mHomePage3.hotCommodity();
		Assertion.VerityTextPresentPrecision("热门商品", "已返回首页");
		
	}
	
	@Test(description = "商城精选")
	public void testHomeMallSelected()  throws Exception{
		//新品上架
		Thread.sleep(3000);
		HomePage mHomePage3 = new HomePage();
		mHomePage3.mallSeclect();
		Assertion.VerityTextPresentPrecision("热门商品", "已返回首页");
		
	}
   
	@Test(description = "为您推荐")
	public void testHomeForTuiJian()  throws Exception{
		
		Thread.sleep(3000);
		HomePage mHomePage3 = new HomePage();
		mHomePage3.forYouTuiJian();
		Assertion.VerityTextPresentPrecision("首页", "已返回首页");
	}
	
	@AfterClass
	public void afterClassResult() {
		
	}
}
