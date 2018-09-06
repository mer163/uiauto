package com.zbwx.autotest.ui.orderpage;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BaseTest;
import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.pageobject.orderobject.DSa_Method;
import com.zbwx.autotest.ui.pageobject.orderobject.OrderPage;
import com.zbwx.autotest.ui.pageobject.orderobject.QuotesPage;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAttribs;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestQuotes extends BaseTest {
	
	DSa_Method ds = new DSa_Method();
	
	@BeforeClass//所有方法开始前执行
	public void beforeClass() throws Exception {
		BaseAction.position.waitForElement(ElementAttribs.TEXT, "首页", 10000);
	}
	
	@BeforeMethod//每个方法执行前执行
	public void beforeMethod() throws Exception{
		//检查当前是否处于行情页面,如果不是,则返回首页后重新进入果礼镍的行情页面
		//ds.mCheckQuotesPage();
		HomePage.verify().tv_homeNie.click();
	}

	@AfterMethod//每个方法执行完后执行
	public void aftermthod() throws Exception{
		//恢复下单页面初始(返回上一页面重新进入)
		//ds.mRecoveryOrderPage();
		BaseAction.mReturn();
	}

	@AfterClass//所有测试方法执行完后执行
	public void afterClass() {
		
	}
		
	@Test(description = "行情页面切换商品")
	public void testSwitchCommodity() throws Exception{
		//获取当前商品价格
		String e1 = QuotesPage.verify().mMogenPrice.getText();
		//切换商品到第二个商品
		QuotesPage.verify().mCommodity_2.click();
		//获取切换商品后价格
		String e2= QuotesPage.verify().mMogenPrice.getText();
		Assertion.VerityBoolean(e1.equals(e2), false, "成功切换商品后价格会有变动...");
	}
	
	@Test(description = "进入‘消息’页面")
	public void testClickMessage() throws Exception{
		//点击消息按钮
		QuotesPage.verify().mMessageButton.click();BaseAction.driver.sleep(2000);
		Assertion.VerityTextPresentPrecision("消息中心", "已进入消息中心页面...");
		//返回行情页面
		BaseAction.mReturn();
	}
	
	@Test(description = "行情页面K线选择M5")//除‘分时线’图ID不一样外，其它四个标签显示图ID都一样
	public void testK_lineSelectM5() throws Exception{
		//点击K线M5
		QuotesPage.verify().mK_M5.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "切换成功...");
	}
	
	@Test(description = "行情页面K线选择M15")//除‘分时线’图ID不一样外，其它四个标签显示图ID都一样
	public void testK_lineSelectM15() throws Exception{
		//点击K线M15
		QuotesPage.verify().mK_M15.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "切换成功...");
	}
	
	@Test(description = "行情页面K线选择H1")//除‘分时线’图ID不一样外，其它四个标签显示图ID都一样
	public void testK_lineSelectH1() throws Exception{
		//点击K线H1
		QuotesPage.verify().mK_H1.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "切换成功...");
	}
	
	@Test(description = "行情页面K线选择D1")//除‘分时线’图ID不一样外，其它四个标签显示图ID都一样
	public void testK_lineSelectD1() throws Exception{
		//点击K线D1
		QuotesPage.verify().mK_D1.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "切换成功...");
	}
	
	@Test(description = "行情页面K线选择‘分时线’")//除‘分时线’图ID不一样外，其它四个标签显示图ID都一样
	public void testK_lineSelectTimeshare() throws Exception{
		//点击K线D1
		QuotesPage.verify().mK_D1.click();
		//点击分时线
		QuotesPage.verify().mK_Timeshare.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_time_hour_1", 3000), true, "切换成功...");
	}
	
	@Test(description = "进入定购页面")
	public void testClickOrder() throws Exception{
		//点击定购按钮
		QuotesPage.verify().mOrderButton.click();
		Assertion.VerityTextPresentPrecision("现价定购", "是否进入定购页面...");
	}	
}
