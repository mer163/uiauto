package com.zbwx.autotest.ui;

import org.testng.annotations.Test;

import com.zbwx.autotest.ui.utils.Assertion;
import com.zbwx.autotest.ui.base.TestBaseCase;

import atx.client.adb.ElementAttribs;

public class QuotationPage extends TestBaseCase {
	
	@Test(description = "进入行情页面")
    public void OpenQuotation() throws Exception {
		driver.startUiAutomator();
		position.waitForElement(ElementAttribs.TEXT, "客服", 10000);
		driver.elementByName("首页").click();
		driver.elementByName("全部商品点这里 >").click();
		Assertion.VerityTextPresentPrecision("产品名称");
		Assertion.VerityTextPresentPrecision("最新价");
		Assertion.VerityTextPresentPrecision("涨跌幅");
		Assertion.VerityTextPresentPrecision("持仓比例");
		Assertion.VerityTextPresentPrecision("澳洲红酒");
		driver.elementByName("澳洲红酒").click();
		//检查页面元素
		Assertion.VerityNotTextPresentPrecision("日分线", "当前处于‘行情’页面...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/listitem_diagram_icon", 2000), true, "商品切换标签商品图标...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/frag_deal_recycler", 2000), true, "商品切换选择框...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/listitem_diagram_title", 2000), true, "商品切换标签商品名称...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/listitem_diagram_content", 2000), true, "商品切换标签商品最新价格...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/mogen_yk", 2000), true, "商品最新价格差...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/mogen_rate", 2000), true, "商品最新价涨幅百分比...");
		//拿不到K线数据
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/newcfd_deal_lin_1", 2000), true, "k线行情图...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/rl_processleft", 2000), true, "持仓比例图...");
		Assertion.VerityTextPresentPrecision("定购");
    }
	
	@Test(description = "进入定购页面")
	public void OpenOrder() throws Exception{
		driver.startUiAutomator();
		position.waitForElement(ElementAttribs.TEXT, "客服", 10000);
		driver.elementByName("首页").click();
		driver.elementByName("全部商品点这里 >").click();
		driver.elementByName("澳洲红酒").click();
		driver.elementByName("定购").click();
		Assertion.VerityNotTextPresentPrecision("现价定购	", "当前处于‘定购’页面...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/listitem_diagram_icon", 2000), true, "商品切换标签商品图标...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/frag_deal_recycler", 2000), true, "商品切换选择框...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/listitem_diagram_title", 2000), true, "商品切换标签商品名称...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/listitem_diagram_content", 2000), true, "商品切换标签商品最新价格...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/yl_textswitch", 2000), true, "盈利轮播消息...");
		Assertion.VerityTextPresentPrecision("可用余额");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/order_price", 2000), true, "余额显示...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/img_product", 2000), true, "商品图片显示...");
		Assertion.VerityTextPresentPrecision("奔富干红1件");
		Assertion.VerityTextPresent("波动盈亏约");
		Assertion.VerityTextPresentPrecision("现价定购");
		Assertion.VerityTextPresentPrecision("结算价定购");
	}
	
	@Test(description = "选择定购数量")
	public void PurchasePageSelectionNumber() throws Exception{
		driver.startUiAutomator();
		position.waitForElement(ElementAttribs.TEXT, "客服", 10000);
		driver.elementByName("定购").click();
		driver.elementByName("澳洲红酒").click();
		//选择规格,选择1件
		driver.elementByName("1件").click();
		Assertion.VerityTextPresent("奔富干红1件");
		Assertion.VerityNotTextPresentPrecision("8");
		//选择20件
		driver.elementByName("20件").click();
		Assertion.VerityTextPresent("奔富干红20件");
		Assertion.VerityNotTextPresentPrecision("100");
		//选择40件
		driver.elementByName("40件").click();
		Assertion.VerityTextPresent("奔富干红40件");
		Assertion.VerityNotTextPresentPrecision("100");
		driver.elementByName("100件").click();
		Assertion.VerityTextPresent("奔富干红100件");
		Assertion.VerityNotTextPresentPrecision("500");		
	}
}
