package com.zbwx.autotest.ui;

import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zbwx.autotest.ui.base.TestBaseCase;
import com.zbwx.autotest.ui.pageobject.OrderPage;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAttribs;

public class TestOrder extends TestBaseCase {

	@BeforeClass
	public void beforeClass(){
		driver.startUiAutomator();
	}
	
	@Test(description = "打开‘定购’主页")
	public void testOpenOrder() throws Exception{
		OrderPage order = new OrderPage();
		order.mOpenOrderPage();
		mReturnHomePage();
	}
	
	@Test(description = "点击‘客服’按钮")
	public void testClickCustomerService() throws Exception{
		OrderPage order = new OrderPage();
		order.mOpenOrderPage();
		OrderPage o = new OrderPage();
		device.click(o.customerService);
		Assertion.VerityTextPresentPrecision("客服中心", "是否进入客服中心页面");
		device.click(position.findElementById("com.ylmall.app.ui:id/leftBtn"));
		mReturnHomePage();
	}
	
	@Test(description = "点击消息按钮")
	public void testClickMessage() throws Exception{
		OrderPage order = new OrderPage();
		order.mOpenOrderPage();
		OrderPage o = new OrderPage();
		device.click(o.messageButton);
		Assertion.VerityTextPresentPrecision("消息中心", "是否进入消息中心...");
		mClickReturnButton();
		Assertion.VerityTextPresentPrecision("现价定购", "是否返回定购页面...");
		mReturnHomePage();
	}
	
	@Test(description = "定购页面切换商品")
	public void testSwitchCommodity() throws Exception{
		OrderPage order = new OrderPage();
		order.mOpenOrderPage();
		OrderPage o1 = new OrderPage();
		device.click(o1.commodity_Cu);
		Assertion.VerityTextPresentPrecision("果礼铜0.02吨", "验证是否成功切换商品...");
		mReturnHomePage();
	}
	
	@Test(description = "定购首页K线选择M5")
	public void testK_lineSelectM5() throws Exception{
		OrderPage order = new OrderPage();
		order.mOpenOrderPage();
		OrderPage o1 = new OrderPage();
		device.click(o1.k_M5);
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "K线显示切换");
		mReturnHomePage();
	}
	
	@Test(description = "定购首页K线选择M15")
	public void testK_lineSelectM15() throws Exception{
		OrderPage order = new OrderPage();
		order.mOpenOrderPage();
		OrderPage o1 = new OrderPage();
		device.click(o1.k_M15);
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "K线显示切换");
		mReturnHomePage();
	}
	
	@Test(description = "定购首页K线选择H1")
	public void testK_lineSelectH1() throws Exception{
		OrderPage order = new OrderPage();
		order.mOpenOrderPage();
		OrderPage o1 = new OrderPage();
		device.click(o1.k_H1);
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "K线显示切换");
		mReturnHomePage();
	}
	
	@Test(description = "定购首页K线选择D1")
	public void testK_lineSelectD1() throws Exception{
		OrderPage order = new OrderPage();
		order.mOpenOrderPage();
		OrderPage o1 = new OrderPage();
		device.click(o1.k_D1);
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "K线显示切换");
		mReturnHomePage();
	}
	
	@Test(description = "定购首页K线选择分时线")
	public void testK_lineSelectTimeshare() throws Exception{
		OrderPage order = new OrderPage();
		order.mOpenOrderPage();
		OrderPage o1 = new OrderPage();
		device.click(o1.k_M5);
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "K线显示切换");
		device.click(o1.k_Timeshare);
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_time_hour_1", 3000), true, "K线显示切换");
		mReturnHomePage();
	}
	
	@Test(description = "点击充值按钮")
	public void testClickRecharge() throws Exception{
		OrderPage order = new OrderPage();
		order.mOpenOrderPage();
		OrderPage o = new OrderPage();
		device.click(o.rechargeButton);
		Assertion.VerityTextPresentPrecision("充值", "跳转充值页面...");
		mClickReturnButton();
		Assertion.VerityTextPresentPrecision("现价定购", "是否返回定购页面...");
		mReturnHomePage();		
	}
	
	@Test(description = "点击我的订单按钮")
	public void testClickMyOrder() throws Exception{
		OrderPage order = new OrderPage();
		order.mOpenOrderPage();
		OrderPage o = new OrderPage();
		device.click(o.myOorder);
		Assertion.VerityTextPresentPrecision("我的订单", "跳转我的订单页面...");
		mClickReturnButton();
		Assertion.VerityTextPresentPrecision("现价定购", "是否返回定购页面...");
		mReturnHomePage();
	}
}
