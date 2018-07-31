package com.zbwx.autotest.ui.pageobject;

import com.zbwx.autotest.ui.base.TestBaseCase;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;

public class OrderPage extends TestBaseCase {

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
	public ElementAdb myOorder;//我的订单按钮
	
	public OrderPage(){
		initElementsOP();
	}
	
	//初始化页面
	public void initElementsOP(){
		try{
			this.messageButton = position.findElementById("com.ylmall.app.ui:id/rightBtn");
			this.commodity_Ni = position.findElementByText("果礼镍");
			this.commodity_Cu = position.findElementByText("果礼铜");
			this.customerService = position.findElementById("com.ylmall.app.ui:id/leftBtn");
			this.k_Timeshare = position.findElementById("com.ylmall.app.ui:id/newcfd_line_fen");
			this.k_M5 = position.findElementById("com.ylmall.app.ui:id/newcfd_line_5");
			this.k_M15 = position.findElementById("com.ylmall.app.ui:id/newcfd_line_15");
			this.k_H1 = position.findElementById("com.ylmall.app.ui:id/newcfd_line_60");
			this.k_D1 = position.findElementById("com.ylmall.app.ui:id/newcfd_line_day");
			this.orderButton = position.findElementById("com.ylmall.app.ui:id/newcfd_fragdeal_xiadan");
			this.rechargeButton = position.findElementById("com.ylmall.app.ui:id/order_chongzhi");
			this.myOorder = position.findElementById("com.ylmall.app.ui:id/order_dingzhi");
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
		mWaitOpenApp();
		position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/deal_img", 3000);
		device.click(position.findElementById("com.ylmall.app.ui:id/deal_img"));
		Assertion.VerityTextPresentPrecision("现价定购", "是否已进入定购主页...");
	}
}
