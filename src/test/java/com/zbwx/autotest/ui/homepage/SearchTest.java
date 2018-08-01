package com.zbwx.autotest.ui.homepage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import atx.client.adb.ElementAttribs;

import com.zbwx.autotest.ui.base.TestBaseCase;
import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.pageobject.homeobject.HomePageSearch;
import com.zbwx.autotest.ui.utils.Assertion;

public class SearchTest extends TestBaseCase{
	
	@BeforeClass
	public void beforeclass() throws Exception{
		driver.startUiAutomator();
		Thread.sleep(3000);
	}
	
	@Test(description = "首页搜索测试")
	public void testHomeSearch()  throws Exception{
		HomePageSearch homePageSearch = new HomePageSearch();
		homePageSearch.searchClick();
		Thread.sleep(3000);
		HomePageSearch homePageSearch1 = new HomePageSearch();
		device.click(homePageSearch1.et_search);
		//输入查找内容
    	device.sendText("bbb");
    	Thread.sleep(3000); 
    	//点击搜索
    	device.click(homePageSearch1.img_right);    	
    	//搜索失败重新输入
    	if (position.waitForElement(ElementAttribs.CONTENTDESC, "暂无内容", 3000)) {
    		//点击输入框   		
    		device.clearText("bbb");
    		Thread.sleep(3000);     		
		}
    	device.click(homePageSearch1.et_search); 
    	device.sendText("a");
    	Thread.sleep(3000); 
    	device.click(homePageSearch1.img_right);
		Thread.sleep(3000);
    	//搜索成功点击返回
    	device.click(homePageSearch1.img_left);
    	Assertion.VerityTextPresentPrecision("热门商品", "已返回首页");	
    		

    	
	}
	
	@AfterClass
	public void afterClassResult() {
		
	}
}
