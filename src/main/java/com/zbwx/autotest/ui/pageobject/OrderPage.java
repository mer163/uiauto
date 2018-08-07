package com.zbwx.autotest.ui.pageobject;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BasePage;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;

public class OrderPage extends BasePage {

	public ElementAdb messageButton;//消息按钮(图标)
	public ElementAdb commodity_Ni;//果礼镍
	public ElementAdb commodity_Cu;//果礼铜
	public ElementAdb customerService;//客服图标
	public ElementAdb k_Timeshare;//分时线
	public ElementAdb k_M5;//M5
	public ElementAdb k_M15;//M15
	public ElementAdb k_H1;//H1
	public ElementAdb k_D1;//D1
	public ElementAdb orderButton;//定购按钮
	public ElementAdb rechargeButton;//充值按钮
	public ElementAdb myOrder;//我的订单按钮
	public ElementAdb type_10;//10KG
	public ElementAdb type_80;//80KG
	public ElementAdb type_400;//400KG
	public ElementAdb presentPriceOrder;//现价定购
	public ElementAdb settlementPriceOrder;//结算价定购
	
	public OrderPage(){
		initElementsOP();
	}
	
	//初始化页面
	public void initElementsOP(){
		try{
			this.messageButton = BaseAction.position.findElementById("com.ylmall.app.ui:id/rightBtn");
			this.commodity_Ni = BaseAction.position.findElementByText("果礼镍");
			this.commodity_Cu = BaseAction.position.findElementByText("果礼铜");
			this.customerService = BaseAction.position.findElementById("com.ylmall.app.ui:id/leftBtn");
			this.k_Timeshare = BaseAction.position.findElementById("com.ylmall.app.ui:id/newcfd_line_fen");
			this.k_M5 = BaseAction.position.findElementById("com.ylmall.app.ui:id/newcfd_line_5");
			this.k_M15 = BaseAction.position.findElementById("com.ylmall.app.ui:id/newcfd_line_15");
			this.k_H1 = BaseAction.position.findElementById("com.ylmall.app.ui:id/newcfd_line_60");
			this.k_D1 = BaseAction.position.findElementById("com.ylmall.app.ui:id/newcfd_line_day");
			this.orderButton = BaseAction.position.findElementById("com.ylmall.app.ui:id/newcfd_fragdeal_xiadan");
			this.rechargeButton = BaseAction.position.findElementById("com.ylmall.app.ui:id/order_chongzhi");
			this.myOrder = BaseAction.position.findElementById("com.ylmall.app.ui:id/order_dingzhi");
			this.type_10 = BaseAction.position.findElementById("com.ylmall.app.ui:id/tv_typegroup1");
			this.type_80 = BaseAction.position.findElementById("com.ylmall.app.ui:id/tv_typegroup2");
			this.type_400 = BaseAction.position.findElementById("com.ylmall.app.ui:id/tv_typegroup3");
			this.presentPriceOrder = BaseAction.position.findElementById("com.ylmall.app.ui:id/below_order_buyup");
			this.settlementPriceOrder = BaseAction.position.findElementById("com.ylmall.app.ui:id/below_order_tobuy");
			
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入‘定购’首页
	 * @throws Exception
	 */
	public void mOpenOrderPage() throws Exception{
		BaseAction.mWaitOpenApp();
		BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/deal_img", 3000);
		BaseAction.device.click(BaseAction.position.findElementById("com.ylmall.app.ui:id/deal_img"));
		Assertion.VerityTextPresentPrecision("现价定购", "是否已进入定购主页...");
	}
}
