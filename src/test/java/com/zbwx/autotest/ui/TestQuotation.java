package com.zbwx.autotest.ui;

import org.testng.annotations.Test;

import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.pageobject.QuotationPage;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAttribs;

public class TestQuotation extends QuotationPage {
	QuotationPage qPage =new QuotationPage();
	
	@Test(description = "进入行情页面")
    public void OpenQuotation() throws Exception {
		driver.startUiAutomator();
		position.waitForElement(ElementAttribs.TEXT, "客服", 20000);
		System.out.println(".......................................................");
		qPage.home_botton.click();
		qPage.AllCommodity.click();
		Assertion.VerityTextPresentPrecision("产品名称");
		Assertion.VerityTextPresentPrecision("最新价");
		Assertion.VerityTextPresentPrecision("涨跌幅");
		Assertion.VerityTextPresentPrecision("持仓比例");
		Assertion.VerityTextPresentPrecision("澳洲红酒");
		qPage.CommodityName_AZHJ.click();
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
		qPage.home_botton.click();
		qPage.AllCommodity.click();
		qPage.CommodityName_AZHJ.click();
		qPage.Order_Botton.click();
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
		qPage.Order_Botton.click();
		qPage.CommodityName_AZHJ.click();
		//选择规格,选择1件
		qPage.Pieces_1.click();
		Assertion.VerityTextPresent("奔富干红1件");
		Assertion.VerityNotTextPresentPrecision("8");
		//选择20件
		qPage.Pieces_20.click();
		Assertion.VerityTextPresent("奔富干红20件");
		Assertion.VerityNotTextPresentPrecision("100");
		//选择40件
		qPage.Pieces_40.click();
		Assertion.VerityTextPresent("奔富干红40件");
		Assertion.VerityNotTextPresentPrecision("100");
		//选择100件
		qPage.Pieces_100.click();
		Assertion.VerityTextPresent("奔富干红100件");
		Assertion.VerityNotTextPresentPrecision("500");		
	}
	
	@Test(description = "打开充值页面")
	public void OpenRechargePage() throws Exception{
		driver.startUiAutomator();
		position.waitForElement(ElementAttribs.TEXT, "客服", 10000);
		qPage.home_botton.click();
		qPage.CommodityName_AZHJ.click();
		qPage.NowPriceOrder.click();
		qPage.Recharge_Botton.click();
		Assertion.VerityNotTextPresentPrecision("充值金额","当前处于‘充值’页面...");
	}
	
	@Test(description = "打开我的订单")
	public void OpenMyOrder() throws Exception{
		driver.startUiAutomator();
		position.waitForElement(ElementAttribs.TEXT, "客服", 10000);
		qPage.home_botton.click();
		qPage.CommodityName_AZHJ.click();
		qPage.MyOrder.click();
		Assertion.VerityNotTextPresentPrecision("当前定制","当前处于‘我的订单’页面...");
	}
	
	@Test(description = "打开下单页面")
	public void OpenPlaceAnOrder() throws Exception{
		driver.startUiAutomator();
		position.waitForElement(ElementAttribs.TEXT, "客服", 10000);
		qPage.home_botton.click();
		qPage.CommodityName_AZHJ.click();
		qPage.NowPriceOrder.click();
		Assertion.VerityNotTextPresentPrecision("下单", "当前处于‘下单’页面...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/below_order_center_price", 2000), true, "最新价格...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/below_order_price_limit", 2000), true, "最新价格涨跌差数...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/below_order_price_limit_code", 2000), true, "最新价格涨跌比...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.TEXT, "选择卡券", 2000), true, "选择卡券功能...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.TEXT, "选择种类", 2000), true, "选择种类...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.TEXT, "购买手数", 2000), true, "购买手数...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.TEXT, "止盈", 2000), true, "止盈...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.TEXT, "止损", 2000), true, "止损...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.TEXT, "充值", 2000), true, "充值按钮...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.TEXT, "可用资产", 2000), true, "可用资产...");
		Assertion.VerityBoolean(position.waitForElement(ElementAttribs.TEXT, "现价定购", 2000), true, "现价定购按钮...");	
	}
	
	@Test(description = "下单页面选择商品")
	public void ChoiceCommodity() throws Exception{
		driver.startUiAutomator();
		position.waitForElement(ElementAttribs.TEXT, "客服", 20000);
		qPage.home_botton.click();
		qPage.CommodityName_AZHJ.click();
		qPage.NowPriceOrder.click();
		Assertion.VerityNotTextPresentPrecision("下单", "当前处于‘下单’页面...");
		driver.elementById("com.ylmall.app.ui:id/below_order_big_type_text").click();
		driver.elementByName("日本清酒").click();
		Assertion.VerityNotTextPresent("一滴入魂1件", "切换日本清酒商品-一滴入魂");
	}
}
