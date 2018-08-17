package com.zbwx.autotest.ui.pageobject.orderobject;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BaseTest;
import com.zbwx.autotest.ui.pageobject.HomePage;

import atx.client.adb.ElementAttribs;

public class DSa_Method extends BaseTest {
	
	/**
	 * 从首页开始，进入第一个商品的行情页面
	 */
	public void mOpenQuotesPage(){
		HomePage.verify().tv_homeAllProduct.click();
		CommodityListPage.verify().mCommodityName1.click();
	}
	
	/**
	 * 检查当前是否处于行情页面,如果不是,则返回首页后重新进入第一个商品的行情页面
	 */
	public void mCheckQuotesPage(){
		if(!BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/mogen_price", 3000)){
			mReturnHomePage();
			mOpenQuotesPage();
		}
	}
	
	/**
	 * 首页开始,点击‘现价定购’进入下单页面(默认第一个商品)
	 * :首页-->定购->现价定购
	 * @throws Exception
	 */
	public void mOpenOrder_xiadan() throws Exception{
		HomePage.verify().order.click();
		OrderPage.verify().mPresentPriceOrder.click();	
	}
	
	/**
	 * 首页开始,点击‘结算价定购’进入下单页面(默认第一个商品)
	 * :首页-->定购->结算价定购
	 * @throws Exception
	 */
	public void mOpenOrder_xiadan_JS() throws Exception{
		HomePage.verify().order.click();
		OrderPage.verify().mSettlementPriceOrder.click();
	}
	
	/**
	 * 检查当前是否处于下单页面,如果不是,则返回首页后点击‘现价定购’进入下单页面(默认第一个商品)
	 * @throws Exception
	 */
	public void mCheckTestXiaDanPage() throws Exception{
		if(!BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/item_below_order_price", 3000)){
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
			HomePage.verify().order.click();
		}
	}
	
	/**
	 * 初始化定购页面(点击第一个商品)
	 */
	public void mRecoveryOrderPage(){
		OrderPage.verify().mCommodity_1.click();
	}	
	
	/**
	 * 任意页面点击物理返回键返回首页
	 */
	public static void mReturnHomePage(){
		while(!BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/tv_allproduct", 2000)){
			if(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "	com.ylmall.app.ui:id/first_img", 2000)){
				BaseAction.driver.findElementById("com.ylmall.app.ui:id/first_img").click();
				break;
			}else{
				BaseAction.mReturn();
			}
		}
	}
	
	/**
	 * 延迟2秒
	 * @throws Exception 
	 */
	public void mWait2000() throws Exception{
		BaseAction.driver.sleep(2000);
	}
	
}
