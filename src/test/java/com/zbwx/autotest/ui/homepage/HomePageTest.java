package com.zbwx.autotest.ui.homepage;



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
import com.zbwx.autotest.ui.utils.Assertion;

public class HomePageTest extends TestBaseCase{
    
	public static HomePage mHomePage = new HomePage();
	
	@BeforeClass
	public void beforeclass() throws Exception{
	
		Thread.sleep(3000);
	}
	
	@Test(description = "点击客服")
	public void testHomePageService() throws Exception{
		HomePage mHomePage1 = new HomePage();
		Thread.sleep(3000);
		Assertion.VerityTextPresentPrecision("热门商品", "当前处在首页");
		device.click(mHomePage1.img_homeService);
		
		Thread.sleep(3000);
		
		if (position.waitForElement(ElementAttribs.TEXT, "交易规则",3000)) {
//			ElementAdb mServiceBack = position.findElementById("com.ylmall.app.ui:id/leftBtn");
			device.click(mHomePage1.mBack);
			
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
		Thread.sleep(5000);
		HomePage mHomePage3 = new HomePage();
		device.click(mHomePage3.img_homeMessage);
		Thread.sleep(3000);
		if (position.findElementByText("公告提醒") != null) {
//			ElementAdb mMessageBack =position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mHomePage3.mBack);
		}
	}
	@Test(description = "首页轮播")
	public void testHomePageViewPager()  throws Exception{
		Thread.sleep(3000);
		HomePage mHomePage3 = new HomePage();
		for (int i = 0; i < 3; i++) {
			Thread.sleep(3000);
			if (position.findElementByText("热门商品") != null) {
				device.click(mHomePage3.vp_homeCbLoopViewPager);
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
		HomePage mHomePage3 = new HomePage();
		if (position.waitForElement(ElementAttribs.TEXT, "热门商品", 3000)) {
			
			device.click(mHomePage3.tv_homeMoreylName);
		}
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT, "排名", 3000)) {
//			ElementAdb mMoreylBack = position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mHomePage3.mBack);
		}
	}
	
	@Test(description = "热门商品")
	public void testHomeHotCommodity()  throws Exception{
		Thread.sleep(3000);
		HomePage mHomePage3 = new HomePage();
		
		device.click(mHomePage3.tv_homeAllProduct);
		Thread.sleep(3000);
		if (position.findElementByText ("商品列表") != null) {
			ElementAdb mAllProductBack = position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mAllProductBack);
		}
		
		Thread.sleep(3000);
	
		device.click(mHomePage3.tv_homeNie);
		Thread.sleep(3000);
		if (position.findElementByText("定购") != null) {
			ElementAdb mNieBack = position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mNieBack);
		}
		
		Thread.sleep(3000);
	    device.click(mHomePage3.tv_homeTong);
		Thread.sleep(3000);
		if (position.findElementByText("定购") != null) {
			ElementAdb mTongBack =  position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mTongBack);
		}
		
		Thread.sleep(3000);
		device.click(mHomePage3.tv_homeYin);
		Thread.sleep(3000);
		if (position.findElementByText("定购") != null) {
			ElementAdb mYinBack =  position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mYinBack);
		}
		
		Thread.sleep(3000);
		
		device.click(mHomePage3.tv_homeJapan);
		Thread.sleep(3000);
		if (position.findElementByText("定购") != null) {
			ElementAdb mJapanBack =  position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mJapanBack);
		}
		
		Thread.sleep(3000);
		
		device.click(mHomePage3.tv_homeEngland);
		Thread.sleep(3000);
		if (position.findElementByText("定购") != null) {
			ElementAdb mEnglandBack =  position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mEnglandBack);
		}
		
		Thread.sleep(3000);
		
		device.click(mHomePage3.tv_homeEurope);
		Thread.sleep(3000);
		if (position.findElementByText("定购") != null) {
			ElementAdb mEuropeBack =  position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mEuropeBack);
		}
	}
	
	@Test(description = "商城精选")
	public void testHomeMallSelected()  throws Exception{
		//新品上架
		Thread.sleep(3000);
		HomePage mHomePage3 = new HomePage();
		device.click(mHomePage3.ll_homeShow1);
		Thread.sleep(3000);
		
	}
   
	@Test(description = "为您推荐")
	public void testHomeForTuiJian()  throws Exception{
		
		Thread.sleep(3000);
		HomePage mHomePage3 = new HomePage();
		device.click(mHomePage3.ll_homeBuyZhiNan);//购买指南
		
		Thread.sleep(3000);
		if (position.findElementByText( "特朗普乱挥贸易大棒致全球市场闪崩，黄金日元意外迎来第二春") != null) {
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/zixun_item_title"));
		}
		Thread.sleep(3000);
		if (position.findElementByText("资讯") != null) {
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/baseweb_back"));
		}
		Thread.sleep(3000);
		
		device.click(mHomePage3.ll_homeStoreInfo);//商城情报
		
		Thread.sleep(3000);
		if (position.findElementByText("7月27日-汇市日报") != null) {
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/zixun_item_context"));
		}
		Thread.sleep(3000);
		if (position.findElementByText("资讯") != null) {
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/baseweb_back"));
		}
		
		device.click(mHomePage3.ll_homeGongGao);//公告
		
		Thread.sleep(3000);
		if (position.findElementByText("今日最新中国银行汇率") != null) {
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/zixun_item_context"));
		}
		Thread.sleep(3000);
		if (position.findElementByText("资讯") != null) {
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/baseweb_back"));
		}
		
	}
	
	@AfterClass
	public void afterClassResult() {
		
	}
}
