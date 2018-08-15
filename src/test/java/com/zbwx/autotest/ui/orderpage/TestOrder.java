package com.zbwx.autotest.ui;

import com.zbwx.autotest.ui.base.BaseAction;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zbwx.autotest.ui.base.BaseTest;
import com.zbwx.autotest.ui.pageobject.DSa_Method;
import com.zbwx.autotest.ui.pageobject.OrderPage;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAttribs;

public class TestOrder extends BaseTest {
	
	DSa_Method ds = new DSa_Method();
	
	@BeforeClass//所有方法开始前执行
	public void beforeClass() throws Exception {
		//点击‘现价定购’进入下单页面(果礼镍)
		ds.mOpenOrderPage();
	}
	
	@BeforeMethod//每个方法执行前执行
	public void beforeMethod() throws Exception{
		//检查当前是否处于下单页面,如果不是,则返回首页后点击‘现价定购’进入下单页面(果礼镍)
		ds.mCheckTestOrderPage();
	}

	@AfterMethod//每个方法执行完后执行
	public void aftermthod() throws Exception{
		//恢复下单页面初始(返回上一页面重新进入)
		ds.mRecoveryOrderPage();
	}

	@AfterClass//所有测试方法执行完后执行
	public void afterClass() {
		
	}
	
	@Test(description = "点击‘客服’按钮")
	public void testClickCustomerService() throws Exception{
		//点击客服按钮
		OrderPage.verify().mClickCustomerService();
		Assertion.VerityTextPresentPrecision("客服中心", "是否进入客服中心页面");
		ds.mClickReturnButton();
	}
	
	@Test(description = "点击消息按钮")
	public void testClickMessage() throws Exception{
		//点击消息按钮
		OrderPage.verify().mClickMessage();
		Assertion.VerityTextPresentPrecision("消息中心", "是否进入消息中心...");
		ds.mClickReturnButton();
	}
	
	@Test(description = "定购页面切换商品")
	public void testSwitchCommodity() throws Exception{
		//切换商品（果礼铜）
		ds.mSwitchCu();
		Assertion.VerityTextPresentPrecision("果礼铜0.02吨", "验证是否成功切换商品...");
	}
	
	@Test(description = "定购首页K线选择M5")
	public void testK_lineSelectM5() throws Exception{
		//点击K线_M5
		ds.mClickKX("M5");
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "K线显示切换");
	}
	
	@Test(description = "定购首页K线选择M15")
	public void testK_lineSelectM15() throws Exception{
		//点击K线_M15
		ds.mClickKX("M15");
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "K线显示切换");
	}
	
	@Test(description = "定购首页K线选择H1")
	public void testK_lineSelectH1() throws Exception{
		//点击K线_H1
		ds.mClickKX("H1");
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "K线显示切换");
	}
	
	@Test(description = "定购首页K线选择D1")
	public void testK_lineSelectD1() throws Exception{
		//点击K线_D1
		ds.mClickKX("D1");
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "K线显示切换");
	}
	
	@Test(description = "定购首页K线选择分时线")
	public void testK_lineSelectTimeshare() throws Exception{
		//点击K线_M5
		ds.mClickKX("M5");
		//点击K线_分时线
		ds.mClickKX("分时线");
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_time_hour_1", 3000), true, "K线显示切换");
	}
	
//	@Test(description = "滚动喜报校验")//没有id，暂时无法精确定位
//	public void testHappyNews(){
//		OrderPage order_page = new OrderPage();
//		
//	}
	
	@Test(description = "点击充值按钮")
	public void testClickRecharge() throws Exception{
		OrderPage.verify().mClickRecharge();
		Assertion.VerityTextPresentPrecision("充值查询", "跳转充值页面...");
		ds.mClickReturnButton();		
	}
	
	@Test(description = "点击我的订单按钮")
	public void testClickMyOrder() throws Exception{
		OrderPage.verify().mClickMyOrder();
		Assertion.VerityTextPresentPrecision("我的订单", "跳转我的订单页面...");
		ds.mClickReturnButton();
	}
	
	@Test(description = "定购页面选择商品种类")
	public void testSelectType() throws Exception{
		//选择商品规格为80KG
		OrderPage.verify().mClickSelectType("80");
		Assertion.VerityTextPresentPrecision("果礼镍0.08吨", "选择80KG...");
		//选择商品规格为400KG
		OrderPage.verify().mClickSelectType("400");
		Assertion.VerityTextPresentPrecision("果礼镍0.4吨", "选择400KG...");
		//选择商品规格为10KG
		OrderPage.verify().mClickSelectType("10");
		Assertion.VerityTextPresentPrecision("果礼镍0.01吨", "选择10KG...");
	}
	
	@Test(description = "点击现价购买按钮")
	public void testPresentPriceOrder() throws Exception{
		//点击现价购买按钮
		ds.mClickPresentPrice();
		Assertion.VerityTextPresentPrecision("下单", "是否进入下单页面");
	}
	
	@Test(description = "点击结算价购买按钮")
	public void testSettlementPriceOrder() throws Exception{
		//点击结算价购买按钮
		ds.mClickSettlementPrice();
		Assertion.VerityTextPresentPrecision("下单", "是否进入下单页面");
	}
}
