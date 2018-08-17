package com.zbwx.autotest.ui.orderpage;

import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BaseTest;
import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.pageobject.orderobject.DSa_Method;
import com.zbwx.autotest.ui.pageobject.orderobject.OrderPage;
import com.zbwx.autotest.ui.pageobject.orderobject.Order_xiadanPage;
import com.zbwx.autotest.ui.pageobject.orderobject.XiaDanPage_CommodityType;
import com.zbwx.autotest.ui.pageobject.orderobject.XiaDanPage_ConfirmOrder;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAttribs;

public class TestOrder_xiadan extends BaseTest {
	
	DSa_Method ds = new DSa_Method();
	
	@BeforeClass//所有方法开始前执行
	public void beforeClass() throws Exception {
		BaseAction.position.waitForElement(ElementAttribs.TEXT, "首页", 10000);
	}
	
	@BeforeMethod//每个方法执行前执行
	public void beforeMethod() throws Exception{
		//检查当前是否处于下单页面,如果不是,则返回首页后点击‘现价定购’进入下单页面(默认第一个商品)
		HomePage.verify().order.click();//
		OrderPage.verify().mPresentPriceOrder.click();//
	}

	@AfterMethod//每个方法执行完后执行
	public void aftermthod() throws Exception{
		BaseAction.mReturn();////
		HomePage.verify().home_bottom.click();////
	}

	@AfterClass//所有测试方法执行完后执行
	public void afterClass() {
		
	}
	
	@Test(description = "下单页面返回上一页面")
	public void testClickReturn() throws Exception{
		//点击返回按钮
		Order_xiadanPage.verify().mReturnButton.click();//
		Assertion.VerityTextPresentPrecision("结算价定购", "点击返回按钮后，返回上一页面");
		//进入下单页面，初始下单测试环境
		OrderPage.verify().mPresentPriceOrder.click();//
	}
	
	@Test(description = "进入消息页面")
	public void testClickMessage() throws Exception{
		//点击消息按钮
		Order_xiadanPage.verify().mMessageButton.click();//
		Assertion.VerityTextPresentPrecision("消息中心", "是否进入消息中心页面...");
		//点击返回下单页面，初始下单测试环境
		BaseAction.mReturn();////
	}
	
	@Test(description = "选择商品")
	public void testSelectOrder() throws Exception{
		//获取当前商品最新价格
		String str1 = Order_xiadanPage.verify().mPrice.getText();
		//切换商品(果礼铜)
		Order_xiadanPage.verify().mSelectOrder();//
		//获取切换后商品最新价格
		String str2 = Order_xiadanPage.verify().mPrice.getText();
		Assertion.VerityBoolean(str1.equals(str2), false, "最新价格有无变动...");
	}
	
	@Test(description = "进入选择卡券页面")
	public void testSelectCoupon() throws Exception{
		//点击‘选择卡券’
		Order_xiadanPage.verify().mSelectCoupon.click();//
		Assertion.VerityTextPresentPrecision("我的卡券", "是否进入我的卡券页面");
		BaseAction.mReturn();//
	}
	
	@Test(description = "选择商品种类")
	public void testSelectType() throws Exception{
		//获取当前商品种类
		String type1 = Order_xiadanPage.verify().mType.getText();
		//选择商品种类
		Order_xiadanPage.verify().mSelectType();
		XiaDanPage_CommodityType.verify().mType_2.click();
		//获取选择后商品种类
		String type2 = Order_xiadanPage.verify().mType.getText();
		Assertion.VerityBoolean(type1.equals(type2), false, "更改后text不同...");
	}
	
	@Test(description = "手动输入购买手数")
	public void testSendOrderNumber() throws Exception{
		//获取当前购买手数
		String oNum1 = Order_xiadanPage.verify().mOrderNumber.getText();
		//清除默认购买手数后，手动输入购买手数，输入为1
		if(oNum1.equals("1")){
			Order_xiadanPage.verify().mSendOrderNumber("2");
		}else {
			Order_xiadanPage.verify().mSendOrderNumber("1");
		}
		//获取更改后购买手数
		String oNum2 = Order_xiadanPage.verify().mOrderNumber.getText();
		Assertion.VerityBoolean(oNum1.equals(oNum2), false, "是否设置成功...");
	}
	
	@Test(description = "减少购买手数")
	public void testClickSubtractOrderNumber() throws Exception{
		//清除默认购买手数后，手动输入购买手数，输入为2
		Order_xiadanPage.verify().mSendOrderNumber("2");
		//获取当前购买手数
		String oNum1 = Order_xiadanPage.verify().mOrderNumber.getText();
		//点击减少手数按钮
		Order_xiadanPage.verify().mOrderNumber_subtract.click();//
		//获取修改后购买手数
		String oNum2 = Order_xiadanPage.verify().mOrderNumber.getText();
		Assertion.VerityBoolean(oNum1.equals(oNum2), false, "是否设置成功...");
	}
	
	@Test(description = "增加购买手数")
	public void testClickAddOrderNumber() throws Exception{
		//清除默认购买手数后，手动输入购买手数，输入为2
		Order_xiadanPage.verify().mSendOrderNumber("2");
		//获取当前购买手数
		String oNum1 = Order_xiadanPage.verify().mOrderNumber.getText();
		//点击增加手数按钮
		Order_xiadanPage.verify().mOrderNumber_add.click();//
		//获取修改后购买手数
		String oNum2 = Order_xiadanPage.verify().mOrderNumber.getText();
		Assertion.VerityBoolean(oNum1.equals(oNum2), false, "是否设置成功...");
	}
	
//	@Test(description = "设置止盈")
//	public void testSetStopProfit() throws Exception{
//		//设置止盈为16.0元
//		Order_xiadanPage.verify().mSetStopProfit_160();
//		Assertion.VerityTextPresentPrecision("200%", "是否设置成功...");
//		Order_xiadanPage.verify().mRecoveryXiaDanPgae();	
//	}
//	
//	@Test(description = "设置止损")
//	public void testSetStopLoss() throws Exception{
//		//设置止损为2.4元
//		Order_xiadanPage.verify().mSetStopLoss_24();
//		Assertion.VerityTextPresentPrecision("30%", "是否设置成功...");	
//	}
	
	@Test(description = "进入充值页面")
	public void testClickRecharge() throws Exception{
		//点击充值按钮
		Order_xiadanPage.verify().mRechargeButton.click();//
		Assertion.VerityTextPresentPrecision("充值查询", "是否跳转至充值页面...");
		//点击返回下单页面，初始下单测试环境
		BaseAction.mReturn();//
	}
	
//	@Test(description = "现价购买时取消")
//	public void testPresentPriceNoPurchase() throws Exception{
//		//等待可用资产加载显示
//		Order_xiadanPage.verify().mWaitAvailableAssets();
//		//获取当前可用资产
//		String text1 = ds.mGetYuE();
//		//设置购买为1手后，下单
//		Order_xiadanPage.verify().mXiaDan();
//		//确认订单弹窗进行取消
//		Order_xiadanPage.verify().mNOPurchase();
//		//获取当前可用资产
//		String text2 = ds.mGetYuE();
//		Assertion.VerityBoolean(text1.equals(text2), true, "未购买可用金额不变...");
//	}
//	
//	@Test(description = "结算价购买时取消")
//	public void testSettlementPriceNoPurchase() throws Exception{
//		//切换到结算价高购买下单页面
//		Order_xiadanPage.verify().mswitchSettlementPriceOrder();
//		//等待可用资产加载显示
//		Order_xiadanPage.verify().mWaitAvailableAssets();
//		//获取当前可用资产
//		String text1 = ds.mGetYuE();
//		//设置购买为1手后，下单
//		Order_xiadanPage.verify().mXiaDan();
//		//确认订单弹窗进行取消
//		Order_xiadanPage.verify().mNOPurchase();
//		//获取当前可用资产
//		String text2 = ds.mGetYuE();
//		Assertion.VerityBoolean(text1.equals(text2), true, "未购买可用金额不变...");
//	}
	
	@Test(description = "现价购买")//未验证，等测试环境验证
	public void testPresentPriceOrder() throws Exception{
		//等待可用资产加载显示
		Order_xiadanPage.verify().mWaitAvailableAssets();
		//获取当前可用资产
		String text1 = Order_xiadanPage.verify().mAsset.getText();
		//设置购买为1手后，下单
		Order_xiadanPage.verify().mXiaDan();
		//确认订单弹窗进行确认
		XiaDanPage_ConfirmOrder.verify().mOkButton.click();//
		//获取购买后可用资产
		String text2 = Order_xiadanPage.verify().mAsset.getText();
		Assertion.VerityBoolean(text1.equals(text2), false, "可用资产是否更改...");//购买成功后总成本会有更改
	}
	
	@Test(description = "结算价购买")//未验证，等测试环境验证
	public void testSettlementPriceOrder() throws Exception{
		//切换到结算价高购买下单页面
		Order_xiadanPage.verify().mswitchSettlementPriceOrder();
		//等待可用资产加载显示
		Order_xiadanPage.verify().mWaitAvailableAssets();
		//获取当前可用资产
		String text1 = Order_xiadanPage.verify().mAsset.getText();
		//设置购买为1手后，下单
		Order_xiadanPage.verify().mXiaDan();
		//确认订单弹窗进行确认
		XiaDanPage_ConfirmOrder.verify().mOkButton.click();//
		//获取购买后可用资产
		String text2 = Order_xiadanPage.verify().mAsset.getText();
		Assertion.VerityBoolean(text1.equals(text2), false, "可用资产是否更改...");
	}
}
