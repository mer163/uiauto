package com.zbwx.autotest.ui.pageobject.orderobject;

import java.util.ArrayList;

import org.eclipse.jetty.websocket.api.util.QuoteUtil;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BaseTest;
import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAttribs;
import atx.client.model.AndroidElement;

public class DSa_Method extends BaseTest {
	
	/**
	 * 从首页开始，进入果礼镍的行情页面
	 */
	public void mOpenQuotesPage(){
		HomePage.verify().tv_homeAllProduct.click();
		BaseAction.driver.findElementByName("果礼镍").click();
	}
	
	/**
	 * 检查当前是否处于行情页面,如果不是,则返回首页后重新进入果礼镍的行情页面
	 */
	public void mReturnQuotesPage(){
		if(!BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/mogen_price", 3000)){
			mReturnHomePage();
			mOpenQuotesPage();
		}
	}
	
	/**
	 * 从首页开始，进入‘定购’首页
	 * @throws Exception
	 */
	public void mOpenOrderPage() throws Exception{
		BaseAction.driver.findElementById("com.ylmall.app.ui:id/deal_img").click();
		boolean bl = BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/yl_textswitch", 2000);
		Assertion.VerityBoolean(bl, true, "当前是否在‘定购’首页...");
	}
	
	/**
	 * 首页开始,点击‘现价定购’进入下单页面(果礼镍)
	 * @throws Exception
	 */
	public void mOpenOrder_xiadan() throws Exception{
		mOpenOrderPage();
		BaseAction.driver.findElementById("com.ylmall.app.ui:id/below_order_buyup").click();
		Assertion.VerityTextPresentPrecision("下单", "是否已进入下单页面...");
		Assertion.VerityTextPresentPrecision("果礼镍", "商品是否为果礼镍...");	
	}
	
	/**
	 * 首页开始,点击‘结算价定购’进入下单页面(果礼镍)
	 * @throws Exception
	 */
	public void mOpenOrder_xiadan_JS() throws Exception{
		mOpenOrderPage();
		BaseAction.driver.findElementById("com.ylmall.app.ui:id/below_order_tobuy").click();
		Assertion.VerityTextPresentPrecision("下单", "是否已进入下单页面...");
		Assertion.VerityTextPresentPrecision("果礼镍", "商品是否为果礼镍...");	
	}
	
	/**
	 * 检查当前是否处于下单页面,如果不是,则返回首页后点击‘现价定购’进入下单页面(果礼镍)
	 * @throws Exception
	 */
	public void mCheckTestXiaDanPage() throws Exception{
		if(!BaseAction.position.waitForElement(ElementAttribs.TEXT, "选择种类", 3000)){
			mReturnHomePage();
			mOpenOrder_xiadan();
		}
	}
	
	/**
	 * 检查当前是否处于定购首页，如果不是，则返回到首页后重新进入定购首页
	 * @throws Exception
	 */
	public void mCheckTestOrderPage() throws Exception{
		if(!BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/yl_textswitch", 3000)){
			mReturnHomePage();
			mOpenOrderPage();
		}
	}
	
	/**
	 * 初始化定购页面(点击果礼镍)
	 */
	public void mRecoveryOrderPage(){
		BaseAction.driver.findElementByName("果礼镍").click();
	}
	
	/**
	 * 根据ID获取元素文本信息
	 * @param str
	 * @return
	 */
	public String mGetTextById(String str){
		AndroidElement Ob = BaseAction.driver.findElementById(str);
		return Ob.getText();		
	}
	
	
	/**
	 * 我的订单页面获取可用资产余额
	 * @return
	 */
	public String mGetYuE(){
		return mGetTextById("com.ylmall.app.ui:id/below_order_price");		
	}
	


	/**
	 * 任意页面点击物理返回键，回到首页
	 */
	public static void mReturnHomePage(){
		do{
			if(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/first_img", 2000)){
				BaseAction.device.click(BaseAction.position.findElementById("com.ylmall.app.ui:id/first_img"));
				break;
			}else{
				BaseAction.driver.press("back");
			}
		}while(!BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/tv_allproduct", 3000));
	}

	/**
	 * 以ID点击页面返回按钮
	 */
	public static void mClickReturnButton(){
		if(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/baseweb_back", 3000)){
			BaseAction.device.click(BaseAction.position.findElementById("com.ylmall.app.ui:id/baseweb_back"));
		}else if (BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/leftBtn", 3000)) {
			BaseAction.device.click(BaseAction.position.findElementById("com.ylmall.app.ui:id/leftBtn"));
		}else if (BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/leftBtn_mykaquan", 3000)) {
			BaseAction.device.click(BaseAction.position.findElementById("com.ylmall.app.ui:id/leftBtn_mykaquan"));
		}
	}
	
	/**
	 * 点击手机物理返回键
	 */
	public static void mReturn(){
		BaseAction.driver.press("back");
	}
	
	/**
	 * 根据输入点击：M5、M15、H1、D1、分时线
	 * @param KX
	 * @throws Exception
	 */
	public void mClickKX(String KX) throws Exception{
		switch (KX) {
		case "M5":
			BaseAction.driver.findElementById("com.ylmall.app.ui:id/newcfd_line_5").click();
			break;
		case "M15":
			BaseAction.driver.findElementById("com.ylmall.app.ui:id/newcfd_line_15").click();
			break;
		case "H1":
			BaseAction.driver.findElementById("com.ylmall.app.ui:id/newcfd_line_60").click();
			break;
		case "D1":
			BaseAction.driver.findElementById("com.ylmall.app.ui:id/newcfd_line_day").click();
			break;
		case "分时线":
			BaseAction.driver.findElementById("com.ylmall.app.ui:id/newcfd_line_fen").click();
			break;
		default:
			Assertion.VerityBoolean(false, true, "输入错误...");
			break;
		}
	}
		
	/**
	 * 切换商品（点击果礼铜）
	 */
	public void mSwitchCu(){
		BaseAction.driver.findElementByName("果礼铜").click();
	}
	
	
	/**
	 * 点击现价定购按钮
	 */
	public void mClickPresentPrice(){
		BaseAction.driver.findElementById("com.ylmall.app.ui:id/below_order_buyup").click();
	}
	
	/**
	 * 点击结算价定购按钮
	 */
	public void mClickSettlementPrice(){
		BaseAction.driver.findElementById("com.ylmall.app.ui:id/below_order_tobuy").click();
	}
}
