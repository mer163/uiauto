package com.zbwx.autotest.ui;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zbwx.autotest.ui.base.TestBaseCase;
import com.zbwx.autotest.ui.pageobject.QuotationPage;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAttribs;

public class TestQuotation extends  TestBaseCase {

	//QuotationPage qPage =new QuotationPage();
	
	@BeforeClass
	public void beforeClass(){
		driver.startUiAutomator();
	}
	

	@Test(description = "进入行情页面")
    public void testOpenQuotation() throws Exception {
		QuotationPage qPage =new QuotationPage();
		qPage.mOpenQuotationPage();		
		QuotationPage qPage1 = new QuotationPage();
		device.click(qPage1.returnButton);
		Assertion.VerityTextPresentPrecision("商品列表", "验证返回键");
    }
	
	@Test(description = "行情页面切换商品")
	public void testSwitchCommodity() throws Exception{
		QuotationPage qPage = new QuotationPage();
		qPage.mOpenQuotationPage();
		QuotationPage qPage1 = new QuotationPage();
		ArrayList<String> price0 = position.getTextById("com.ylmall.app.ui:id/mogen_price");
		device.click(qPage1.commodity_Cu);
		QuotationPage qPage2 = new QuotationPage();
		ArrayList<String> price1 = position.getTextById("com.ylmall.app.ui:id/mogen_price");
		Assertion.VerityBoolean(price0.equals(price1), false, "成功切换商品后价格会有变动...");
	}
	
	@Test(description = "行情页面点击消息按钮")
	public void testClickMessage() throws Exception{
		QuotationPage qpPage = new QuotationPage();
		qpPage.mOpenQuotationPage();
		QuotationPage qPage1 = new QuotationPage();
		device.click(qPage1.messageButton);
		Assertion.VerityTextPresentPrecision("消息中心", "已进入消息中心页面...");
		device.click(position.findElementById("com.ylmall.app.ui:id/leftBtn"));
		Assertion.VerityTextPresentPrecision("行情", "已返回行情页面...");
	}
	
	@Test(description = "行情页面K线选择M5")//除‘分时线’图ID不一样外，其它四个标签显示图ID都一样
	public void testK_lineSelectM5() throws Exception{
		QuotationPage qpPage = new QuotationPage();
		qpPage.mOpenQuotationPage();
		QuotationPage qp = new QuotationPage();
		device.click(qp.k_M5);
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "切换成功");
	}
	
	@Test(description = "行情页面K线选择M15")//除‘分时线’图ID不一样外，其它四个标签显示图ID都一样
	public void testK_lineSelectM15() throws Exception{
		QuotationPage qpPage = new QuotationPage();
		qpPage.mOpenQuotationPage();
		QuotationPage qp = new QuotationPage();
		device.click(qp.k_M15);
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "切换成功");
	}
	
	@Test(description = "行情页面K线选择H1")//除‘分时线’图ID不一样外，其它四个标签显示图ID都一样
	public void testK_lineSelectH1() throws Exception{
		QuotationPage qpPage = new QuotationPage();
		qpPage.mOpenQuotationPage();
		QuotationPage qp = new QuotationPage();
		device.click(qp.k_H1);
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "切换成功");
	}
	
	@Test(description = "行情页面K线选择D1")//除‘分时线’图ID不一样外，其它四个标签显示图ID都一样
	public void testK_lineSelectD1() throws Exception{
		QuotationPage qpPage = new QuotationPage();
		qpPage.mOpenQuotationPage();
		QuotationPage qp = new QuotationPage();
		device.click(qp.k_D1);
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "切换成功");
	}
	
	@Test(description = "行情页面K线选择‘分时线’")//除‘分时线’图ID不一样外，其它四个标签显示图ID都一样
	public void testK_lineSelectTimeshare() throws Exception{
		QuotationPage qpPage = new QuotationPage();
		qpPage.mOpenQuotationPage();
		QuotationPage qp = new QuotationPage();
		device.click(qp.k_D1);
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_view5_1", 3000), true, "切换成功");
		device.click(qp.k_Timeshare);
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_my_charts_time_hour_1", 3000), true, "切换成功");
	}
	
	@Test(description = "行情页面点击定购按钮")
	public void testClickOrder() throws Exception{
		QuotationPage qpPage = new QuotationPage();
		qpPage.mOpenQuotationPage();
		QuotationPage qp = new QuotationPage();
		device.click(qp.orderButton);
		Assertion.VerityTextPresentPrecision("现价定购", "是否进入定购页面");
	}	
}
