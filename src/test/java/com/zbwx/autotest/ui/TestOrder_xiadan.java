package com.zbwx.autotest.ui;

import com.zbwx.autotest.ui.base.BaseAction;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zbwx.autotest.ui.base.BaseTest;
import com.zbwx.autotest.ui.pageobject.DSa_Method;
import com.zbwx.autotest.ui.pageobject.OrderPage;
import com.zbwx.autotest.ui.pageobject.Order_xiadanPage;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.model.AndroidElement;

public class TestOrder_xiadan extends BaseTest {
	
	DSa_Method ds = new DSa_Method();
	public Order_xiadanPage order_xd = new Order_xiadanPage();
	
	@BeforeClass
	public void beforeClass() throws Exception{
		BaseAction.driver.startUiAutomator();
		//Order_xiadanPage grder_xiadanpage = new Order_xiadanPage();
		order_xd.mOpenOrder_xiadan();
	}

	
	@Test(description = "下单页面点击返回按钮")
	public void testClickReturn() throws Exception{
		ds.mClickReturnButton();
		Assertion.VerityTextPresentPrecision("结算价定购", "点击返回按钮后，返回上一页面");
		order_xd.mOpenOrder_xiadan();//初始下单测试环境，进入下单页面
	}
	
	@Test(description = "点击消息按钮")
	public void testClickMessage() throws Exception{
		order_xd.mMessageButton.click();
		Assertion.VerityTextPresentPrecision("消息中心", "是否进入消息中心页面");
		ds.mClickReturnButton();
	}
	
	@Test(description = "选择商品")
	public void testSelectOrder() throws Exception{
		String str1 = ds.mGetTextById("com.ylmall.app.ui:id/below_order_center_price");
		order_xd.mSelectOrderButton.click();
		BaseAction.driver.findElementByName("果礼铜").click();
		String str2 = ds.mGetTextById("com.ylmall.app.ui:id/below_order_center_price");
		Assertion.VerityBoolean(str1.equals(str2), false, "最新价格有无变动...");
		order_xd.mRecoveryXiaDanPgae();
	}
	
	@Test(description = "点击选择卡券")
	public void testSelectCoupon() throws Exception{
		order_xd.mSelectCoupon.click();
		Assertion.VerityTextPresentPrecision("我的卡券", "是否进入我的卡券页面");
		ds.mClickReturnButton();
	}
	
	@Test(description = "选择商品种类")
	public void testSelectType() throws Exception{
		order_xd.mSelectType.click();
		BaseAction.driver.findElementByName("果礼镍0.08吨").click();
		Assertion.VerityTextPresentPrecision("200.0", "价格是否更新...");//止盈最大价格
		order_xd.mRecoveryXiaDanPgae();
	}
	
	@Test(description = "手动输入购买手数")
	public void testSendOrderNumber() throws Exception{
		String oNum1 = order_xd.mGetOrderNumber();
		order_xd.mOrderNumber.click();
		BaseAction.device.clearText("111");
		order_xd.mOrderNumber.click();
		BaseAction.device.sendText("2");
		String oNum2 = order_xd.mGetOrderNumber();
		Assertion.VerityBoolean(oNum1.equals(oNum2), false, "是否设置成功...");
		order_xd.mRecoveryXiaDanPgae();
	}
	
	@Test(description = "购买手数点击减按钮")
	public void testClickSubtractOrderNumber() throws Exception{
		order_xd.mOrderNumber.click();
		BaseAction.device.clearText("111");
		order_xd.mOrderNumber.click();
		BaseAction.device.sendText("2");
		String oNum1 = order_xd.mGetOrderNumber();
		order_xd.mOrderNumber_subtract.click();
		String oNum2 = order_xd.mGetOrderNumber();
		Assertion.VerityBoolean(oNum1.equals(oNum2), false, "是否设置成功...");
		order_xd.mRecoveryXiaDanPgae();
	}
	
	@Test(description = "购买手数点击加按钮")
	public void testClickAddOrderNumber() throws Exception{
		order_xd.mOrderNumber.click();
		BaseAction.device.clearText("111");
		order_xd.mOrderNumber.click();
		BaseAction.device.sendText("2");
		String oNum1 = order_xd.mGetOrderNumber();
		order_xd.mOrderNumber_add.click();
		String oNum2 = order_xd.mGetOrderNumber();
		Assertion.VerityBoolean(oNum1.equals(oNum2), false, "是否设置成功...");
		order_xd.mRecoveryXiaDanPgae();
	}
	
	@Test(description = "设置止盈")
	public void testSetStopProfit() throws Exception{
		order_xd.mStopProfit_16_0.click();
		Assertion.VerityTextPresentPrecision("200%", "是否设置成功...");
		order_xd.mRecoveryXiaDanPgae();	
	}
	
	@Test(description = "设置止损")
	public void testSetStopLoss() throws Exception{
		order_xd.mStopLoss_2_4.click();
		Assertion.VerityTextPresentPrecision("30%", "是否设置成功...");
		order_xd.mRecoveryXiaDanPgae();	
	}
	
	@Test(description = "点击充值按钮")
	public void testClickRecharge() throws Exception{
		order_xd.mRechargeButton.click();
		Assertion.VerityTextPresentPrecision("充值查询", "是否跳转至充值页面...");
		ds.mClickReturnButton();
		Assertion.VerityTextPresentPrecision("止盈", "是否返回下单页面...");
	}
	
	@Test(description = "下单页面点击现价定购按钮")
	public void testClickPresentPriceOrder() throws Exception{
		order_xd.mPresentPriceOrder.click();
		Assertion.VerityTextPresentPrecision("确认订单", "是否弹出弹框");
		BaseAction.driver.sleep(1500);
		BaseAction.device.click(BaseAction.position.findElementById("com.ylmall.app.ui:id/dialog_cancle"));
		Assertion.VerityTextPresentPrecision("止盈", "是否返回下单页面...");
	}
	
	@Test(description = "下单页面点击结算价定购按钮")
	public void testClickSettlementPriceOrder() throws Exception{
		order_xd.mSettlementPriceOrder.click();
		Assertion.VerityTextPresentPrecision("确认订单", "是否弹出弹框");
		BaseAction.driver.sleep(1500);
		BaseAction.device.click(BaseAction.position.findElementById("com.ylmall.app.ui:id/dialog_cancle"));
		Assertion.VerityTextPresentPrecision("止盈", "是否返回下单页面...");
	}
	
	@Test(description = "现价购买")//未验证，等测试环境验证
	public void testPresentPriceOrder() throws Exception{
		String str1 = "--.--";
		String str2;
		for (int i = 0; i < 9; i++) {
			BaseAction.driver.sleep(1000);
			str2 = ds.mGetYuE();
			if(str1.equals(str2)){
				break;
			}
		}
		String text1 = ds.mGetYuE();
		order_xd.mOrderNumber.click();
		BaseAction.device.clearText("111");
		order_xd.mOrderNumber.click();
		BaseAction.device.sendText("1");
		order_xd.mPresentPriceOrder.click();
		BaseAction.device.click(BaseAction.position.findElementById("com.ylmall.app.ui:id/dialog_ok"));
		BaseAction.driver.findElementById("com.ylmall.app.ui:id/dialog_ok").click();
		OrderPage ord = new OrderPage();
		ord.mPresentPriceOrder.click();
		String text2 = ds.mGetYuE();
		Assertion.VerityBoolean(text1.equals(text2), false, "总成本是否更改...");//购买成功后总成本会有更改
	}
	
	@Test(description = "结算价购买")//未验证，等测试环境验证
	public void testSettlementPriceOrder() throws Exception{
		String str1 = "--.--";
		String str2;
		for (int i = 0; i < 9; i++) {
			BaseAction.driver.sleep(1000);
			str2 = ds.mGetYuE();
			if(str1.equals(str2)){
				break;
			}
		}
		String text1 = ds.mGetYuE();
		order_xd.mOrderNumber.click();
		BaseAction.device.clearText("111");
		order_xd.mOrderNumber.click();
		BaseAction.device.sendText("1");
		order_xd.mSettlementPriceOrder.click();
		BaseAction.device.click(BaseAction.position.findElementById("com.ylmall.app.ui:id/dialog_ok"));
		BaseAction.driver.findElementById("com.ylmall.app.ui:id/dialog_ok").click();
		OrderPage ord = new OrderPage();
		ord.mSettlementPriceOrder.click();
		String text2 = ds.mGetYuE();
		Assertion.VerityBoolean(text1.equals(text2), false, "总成本是否更改...");//购买成功后总成本会有更改
	}
}
