package com.zbwx.autotest.ui;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zbwx.autotest.ui.base.TestBaseCase;
import com.zbwx.autotest.ui.pageobject.Order_xiadanPage;
import com.zbwx.autotest.ui.utils.Assertion;

public class TestOrder_xiadan extends TestBaseCase {

	@BeforeClass
	public void beforeClass(){
		driver.startUiAutomator();
	}
	
	@Test(description = "下单页面点击返回按钮")
	public void testClickReturn() throws Exception{
		Order_xiadanPage order_xd = new Order_xiadanPage();
		order_xd.mOpenOrder_xiadan();
		mReturnHomePage();
		Assertion.VerityTextPresentPrecision("com.ylmall.app.ui:id/img_ylbb", "是否返回定购主页...");
		mReturnHomePage();
	}
	
	@Test(description = "点击消息按钮")
	public void testClickMessage() throws Exception{
		Order_xiadanPage order_xd = new Order_xiadanPage();
		order_xd.mOpenOrder_xiadan();
		Order_xiadanPage oxd = new Order_xiadanPage();
		device.click(oxd.messageButton);
		Assertion.VerityTextPresentPrecision("消息中心", "是否进入消息中心页面");
		mClickReturnButton();
		Assertion.VerityTextPresent("止盈", "是否返回下单页面");
		mReturnHomePage();
	}
	
	@Test(description = "选择商品")
	public void testSelectOrder() throws Exception{
		Order_xiadanPage order_xd = new Order_xiadanPage();
		order_xd.mOpenOrder_xiadan();
		Order_xiadanPage oxd = new Order_xiadanPage();
		ArrayList<String> str1 = position.getTextById("com.ylmall.app.ui:id/below_order_center_price");
		device.click(oxd.selectOrderButton);
		device.click(position.findElementByText("果礼铜"));
		Order_xiadanPage oxd1 = new Order_xiadanPage();
		ArrayList<String> str2 = position.getTextById("com.ylmall.app.ui:id/below_order_center_price");
		Assertion.VerityBoolean(str1.equals(str2), false, "最新价格有无变动...");
		mReturnHomePage();
	}
	
	@Test(description = "点击选择卡券")
	public void testSelectCoupon() throws Exception{
		Order_xiadanPage order_xd = new Order_xiadanPage();
		order_xd.mOpenOrder_xiadan();
		Order_xiadanPage oxd = new Order_xiadanPage();
		device.click(oxd.selectCoupon);
		Assertion.VerityTextPresentPrecision("我的卡券", "是否进入我的卡券页面");
		mClickReturnButton();
		Assertion.VerityTextPresent("止盈", "是否返回下单页面");
		mReturnHomePage();
	}
	
	@Test(description = "选择商品种类")
	public void testSelectType() throws Exception{
		Order_xiadanPage order_xd = new Order_xiadanPage();
		order_xd.mOpenOrder_xiadan();
		Order_xiadanPage o = new Order_xiadanPage();
		device.click(o.selectType);
		device.click(position.findElementByText("果礼镍0.08吨"));
		Order_xiadanPage o1 = new Order_xiadanPage();
		Assertion.VerityTextPresentPrecision("果礼镍0.08吨", "是否成功选择...");
		Assertion.VerityTextPresentPrecision("200.0", "价格是否更新...");
		mReturnHomePage();
	}
	
	@Test(description = "设置止盈")
	public void testSetStopProfit() throws Exception{
		Order_xiadanPage order_xd = new Order_xiadanPage();
		order_xd.mOpenOrder_xiadan();
		device.click(position.findElementByText("16.0"));
		Order_xiadanPage o = new Order_xiadanPage();
		Assertion.VerityTextPresentPrecision("200%", "是否设置成功...");
		mReturnHomePage();		
	}
	
	@Test(description = "设置止损")
	public void testSetStopLoss() throws Exception{
		Order_xiadanPage order_xd = new Order_xiadanPage();
		order_xd.mOpenOrder_xiadan();
		device.click(position.findElementByText("2.4"));
		Order_xiadanPage o = new Order_xiadanPage();
		Assertion.VerityTextPresentPrecision("30%", "是否设置成功...");
		mReturnHomePage();		
	}
	
	@Test(description = "点击充值按钮")
	public void testClickRecharge() throws Exception{
		Order_xiadanPage order_xd = new Order_xiadanPage();
		order_xd.mOpenOrder_xiadan();
		Order_xiadanPage o = new Order_xiadanPage();
		device.click(o.rechargeButton);
		Assertion.VerityTextPresentPrecision("充值查询", "是否跳转至充值页面...");
		mClickReturnButton();
		Assertion.VerityTextPresentPrecision("止盈", "是否返回下单页面...");
		mReturnHomePage();
	}
	
	@Test(description = "下单页面点击现价定购按钮")
	public void testClickPresentPriceOrder() throws Exception{
		Order_xiadanPage order_xd = new Order_xiadanPage();
		order_xd.mOpenOrder_xiadan();
		Order_xiadanPage o = new Order_xiadanPage();
		device.click(o.presentPriceOrder);
		Assertion.VerityTextPresentPrecision("确认订单", "是否弹出弹框");
		device.click(position.findElementById("com.ylmall.app.ui:id/dialog_cancle"));
		Assertion.VerityTextPresentPrecision("止盈", "是否返回下单页面...");
		mReturnHomePage();
	}
	
	@Test(description = "下单页面点击现价定购按钮")
	public void testClickSettlementPriceOrder() throws Exception{
		Order_xiadanPage order_xd = new Order_xiadanPage();
		order_xd.mOpenOrder_xiadan_JS();
		Order_xiadanPage o = new Order_xiadanPage();
		device.click(o.settlementPriceOrder);
		Assertion.VerityTextPresentPrecision("确认订单", "是否弹出弹框");
		device.click(position.findElementById("com.ylmall.app.ui:id/dialog_cancle"));
		Assertion.VerityTextPresentPrecision("止盈", "是否返回下单页面...");
		mReturnHomePage();
	}
	
	@Test(description = "结算价购买")//未验证，等测试环境验证
	public void testPresentPriceOrder() throws Exception{
		Order_xiadanPage order_xd = new Order_xiadanPage();
		ArrayList<String> text1 = order_xd.mGegCost();//获取下单前订单页面总成本text
		mReturnHomePage();
		order_xd.mOpenOrder_xiadan();
		Order_xiadanPage o = new Order_xiadanPage();
		device.click(o.presentPriceOrder);
		device.click(position.findElementById("com.ylmall.app.ui:id/dialog_ok"));
		mReturnHomePage();
		ArrayList<String> text2 = order_xd.mGegCost();
		Assertion.VerityBoolean(text1.equals(text2), false, "总成本是否更改...");//购买成功后总成本会有更改
	}
	
	@Test(description = "结算价购买")//未验证，等测试环境验证
	public void testSettlementPriceOrder() throws Exception{
		Order_xiadanPage order_xd = new Order_xiadanPage();
		ArrayList<String> text1 = order_xd.mGegCost();//获取下单前订单页面总成本text
		mReturnHomePage();
		order_xd.mOpenOrder_xiadan_JS();
		Order_xiadanPage o = new Order_xiadanPage();
		device.click(o.settlementPriceOrder);
		device.click(position.findElementById("com.ylmall.app.ui:id/dialog_ok"));
		mReturnHomePage();
		ArrayList<String> text2 = order_xd.mGegCost();
		Assertion.VerityBoolean(text1.equals(text2), false, "总成本是否更改...");//购买成功后总成本会有更改
	}
}
