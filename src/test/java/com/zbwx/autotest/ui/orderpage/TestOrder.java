package com.zbwx.autotest.ui.orderpage;

import com.zbwx.autotest.ui.base.BaseAction;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zbwx.autotest.ui.base.BaseTest;
import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.pageobject.orderobject.DSa_Method;
import com.zbwx.autotest.ui.pageobject.orderobject.OrderPage;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAttribs;

public class TestOrder extends BaseTest {
	
	DSa_Method ds = new DSa_Method();
	
	@BeforeClass//所有方法开始前执行
	public void beforeClass() throws Exception {
		
		BaseAction.position.waitForElement(ElementAttribs.TEXT, "首页", 10000);
	}
	
	@BeforeMethod//每个方法执行前执行
	public void beforeMethod() throws Exception{
		//
		HomePage.verify().order.click();
		OrderPage.verify().mCommodity_1.click();
	}

	@AfterMethod//每个方法执行完后执行
	public void aftermthod() throws Exception{
		//恢复下单页面初始(返回上一页面重新进入)
		HomePage.verify().home_bottom.click();
	}

	@AfterClass//所有测试方法执行完后执行
	public void afterClass() {
		
	}
	
	@Test(description = "进入‘客服’页面")
	public void testClickCustomerService() throws Exception{
		//点击客服按钮
		OrderPage.verify().mCustomerService.click();
		Assertion.VerityTextPresentPrecision("客服中心", "是否进入客服中心页面");
		//返回上一页面
		BaseAction.mReturn();
	}
	
	@Test(description = "进入‘消息’页面")
	public void testClickMessage() throws Exception{
		//点击消息按钮
		OrderPage.verify().mMessageButton.click();
		Assertion.VerityTextPresentPrecision("消息中心", "是否进入消息中心...");
		//返回上一页面
		BaseAction.mReturn();
	}
	
	@Test(description = "定购页面切换商品")
	public void testSwitchCommodity() throws Exception{
		//获取当前商品规格名称
		String str1 = OrderPage.verify().mTypeName.getText();
		//切换第二个商品
		OrderPage.verify().mCommodity_2.click();
		//获取第二个商品的商品规格名称
		String str2 = OrderPage.verify().mTypeName.getText();
		Assertion.VerityBoolean(str1.equals(str2), false, "验证是否成功切换商品...");
	}
	
	@Test(description = "定购首页K线选择M5")
	public void testK_lineSelectM5() throws Exception{
		//点击K线_M5
		OrderPage.verify().mK_M5.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "K线显示切换");
	}
	
	@Test(description = "定购首页K线选择M15")
	public void testK_lineSelectM15() throws Exception{
		//点击K线_M15
		OrderPage.verify().mK_M15.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "K线显示切换");
	}
	
	@Test(description = "定购首页K线选择H1")
	public void testK_lineSelectH1() throws Exception{
		//点击K线_H1
		OrderPage.verify().mK_H1.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "K线显示切换");
	}
	
	@Test(description = "定购首页K线选择D1")
	public void testK_lineSelectD1() throws Exception{
		//点击K线_D1
		OrderPage.verify().mK_D1.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "K线显示切换");
	}
	
	@Test(description = "定购首页K线选择分时线")
	public void testK_lineSelectTimeshare() throws Exception{
		//点击K线_M5
		OrderPage.verify().mK_M15.click();
		//点击K线_分时线
		OrderPage.verify().mK_Timeshare.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_time_hour_1", 3000), true, "K线显示切换");
	}
	
//	@Test(description = "滚动喜报校验")//没有id，暂时无法精确定位
//	public void testHappyNews(){
//		OrderPage order_page = new OrderPage();
//		
//	}
	
	@Test(description = "进入‘充值’页面")
	public void testClickRecharge() throws Exception{
		OrderPage.verify().mRechargeButton.click();
		Assertion.VerityTextPresentPrecision("充值查询", "跳转充值页面...");
		//返回上一页面
		BaseAction.mReturn();	
	}
	
	@Test(description = "进入‘我的订单’")
	public void testClickMyOrder() throws Exception{
		OrderPage.verify().mMyOrder.click();
		Assertion.VerityTextPresentPrecision("我的订单", "跳转我的订单页面...");
		//返回上一页面
		BaseAction.mReturn();
	}
	
	@Test(description = "定购页面选择商品种类")
	public void testSelectType() throws Exception{
		//选择商品规格为第二个
		OrderPage.verify().mType_2.click();
		Assertion.VerityTextPresentPrecision("果礼镍0.08吨", "选择80KG...");
		//选择商品规格为第三个
		OrderPage.verify().mType_3.click();
		Assertion.VerityTextPresentPrecision("果礼镍0.4吨", "选择400KG...");
		//选择商品规格为第一个
		OrderPage.verify().mType_1.click();
		Assertion.VerityTextPresentPrecision("果礼镍0.01吨", "选择10KG...");
	}
	
	@Test(description = "进入‘下单’页面_点击‘现价定购’")
	public void testPresentPriceOrder() throws Exception{
		//点击现价购买按钮
		OrderPage.verify().mPresentPriceOrder.click();
		Assertion.VerityTextPresentPrecision("下单", "是否进入下单页面...");
		BaseAction.mReturn();
	}
	
	@Test(description = "进入‘下单’页面_点击‘结算价定购’")
	public void testSettlementPriceOrder() throws Exception{
		//点击结算价购买按钮
		OrderPage.verify().mSettlementPriceOrder.click();
		Assertion.VerityTextPresentPrecision("下单", "是否进入下单页面...");
		BaseAction.mReturn();
	}
}
