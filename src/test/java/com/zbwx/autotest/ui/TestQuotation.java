package com.zbwx.autotest.ui;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BaseTest;
import com.zbwx.autotest.ui.pageobject.QuotesPage;
import com.zbwx.autotest.ui.pageobject.DSa_Method;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAttribs;
import atx.client.model.AndroidElement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestQuotation extends BaseTest {

	DSa_Method ds = new DSa_Method();
	
	@BeforeClass
	public void beforeClass() throws Exception{
		BaseAction.driver.startUiAutomator();
		ds.mOpenQuotationPage();
	}
	
	@AfterClass
	public void afterClass() throws Exception{
		ds.mReturnHomePage();
	}
		
	@Test(description = "行情页面切换商品")
	public void testSwitchCommodity() throws Exception{
		QuotesPage quotes_page = new QuotesPage();
		AndroidElement e1= BaseAction.driver.findElementById("com.ylmall.app.ui:id/mogen_price");
		System.out.println(e1.getText());
		quotes_page.mCommodity_Cu.click();
		AndroidElement e2= BaseAction.driver.findElementById("com.ylmall.app.ui:id/mogen_price");
		System.out.println(e2.getText());
		Assertion.VerityBoolean(e1.getText().equals(e2.getText()), false, "成功切换商品后价格会有变动...");
		ds.mRecoveryQuotesPgae();
	}
	
	@Test(description = "行情页面点击消息按钮")
	public void testClickMessage() throws Exception{
		QuotesPage quotes_page = new QuotesPage();
		quotes_page.mMessageButton.click();
		Assertion.VerityTextPresentPrecision("消息中心", "已进入消息中心页面...");
		ds.mClickReturnButton();
		Assertion.VerityTextPresentPrecision("行情", "已返回行情页面...");
		ds.mRecoveryQuotesPgae();
	}
	
	@Test(description = "行情页面K线选择M5")//除‘分时线’图ID不一样外，其它四个标签显示图ID都一样
	public void testK_lineSelectM5() throws Exception{
		QuotesPage quotes_page = new QuotesPage();
		quotes_page.mK_M5.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "切换成功");
		ds.mRecoveryQuotesPgae();
	}
	
	@Test(description = "行情页面K线选择M15")//除‘分时线’图ID不一样外，其它四个标签显示图ID都一样
	public void testK_lineSelectM15() throws Exception{
		QuotesPage quotes_page = new QuotesPage();
		quotes_page.mK_M15.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "切换成功");
		ds.mRecoveryQuotesPgae();
	}
	
	@Test(description = "行情页面K线选择H1")//除‘分时线’图ID不一样外，其它四个标签显示图ID都一样
	public void testK_lineSelectH1() throws Exception{
		QuotesPage quotes_page = new QuotesPage();
		quotes_page.mK_H1.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "切换成功");
		ds.mRecoveryQuotesPgae();
	}
	
	@Test(description = "行情页面K线选择D1")//除‘分时线’图ID不一样外，其它四个标签显示图ID都一样
	public void testK_lineSelectD1() throws Exception{
		QuotesPage quotes_page = new QuotesPage();
		quotes_page.mK_D1.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "切换成功");
		ds.mRecoveryQuotesPgae();
	}
	
	@Test(description = "行情页面K线选择‘分时线’")//除‘分时线’图ID不一样外，其它四个标签显示图ID都一样
	public void testK_lineSelectTimeshare() throws Exception{
		QuotesPage quotes_page = new QuotesPage();
		quotes_page.mK_D1.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "切换成功");
		quotes_page.mK_Timeshare.click();
		Assertion.VerityBoolean(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_time_hour_1", 3000), true, "切换成功");
		ds.mRecoveryQuotesPgae();
	}
	
	@Test(description = "行情页面点击定购按钮")
	public void testClickOrder() throws Exception{
		QuotesPage quotes_page = new QuotesPage();
		quotes_page.mOrderButton.click();
		Assertion.VerityTextPresentPrecision("现价定购", "是否进入定购页面");
		Assertion.VerityTextPresentPrecision("行情", "已返回行情页面...");
		ds.mRecoveryQuotesPgae();
	}	
}
