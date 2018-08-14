package com.zbwx.autotest.ui.pageobject;

import java.util.ArrayList;

import org.eclipse.jetty.websocket.api.util.QuoteUtil;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BaseTest;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAttribs;
import atx.client.model.AndroidElement;

public class DSa_Method extends BaseTest {
	
	/**
	 * 从首页进入行情页面(打开商品‘果礼镍’)
	 * @throws Exception
	 */
	public void mOpenQuotationPage() throws Exception{	
		HomePage hp = new HomePage();
		hp.tv_homeAllProduct.click();
		BaseAction.position.waitForElement(ElementAttribs.TEXT, "商品列表", 2000);
		CommodityListPage clp = new CommodityListPage();
		clp.mCommodity_Ni.click();
		Assertion.VerityNotTextPresentPrecision("行情");
	}
	
	/**
	 * 行情页面，恢复行情页面初始(分点点击果礼镍和分时线)
	 */
	public void mRecoveryQuotesPgae(){
		QuotesPage quotes_page = new QuotesPage();
		quotes_page.mCommodity_Ni.click();
		quotes_page.mK_Timeshare.click();
	}

	/**
	 * 从首页开始，进入‘定购’首页
	 * @throws Exception
	 */
	public void mOpenOrderPage() throws Exception{
		HomePage home = new HomePage();
		home.order.click();
		boolean bl = BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/yl_textswitch", 2000);
		Assertion.VerityBoolean(bl, true, "当前是否在‘定购’首页...");
	}
	

	
	/**
	 * 首页开始,点击‘结算价定购’进入下单页面(果礼镍)
	 * @throws Exception
	 */
	public void mOpenOrder_xiadan_JS() throws Exception{
		mOpenOrderPage();
		OrderPage order = new OrderPage();
		order.mSettlementPriceOrder.click();
		Assertion.VerityTextPresentPrecision("下单", "是否已进入下单页面...");
		Assertion.VerityTextPresentPrecision("果礼镍", "商品是否为果礼镍...");	
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
	

}
