package com.zbwx.autotest.ui.pageobject;

import com.zbwx.autotest.ui.base.TestBaseCase;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;

public class OrderPage extends TestBaseCase {

	public ElementAdb messageButton;//消息按钮(图标)
	public ElementAdb commodity_Ni;//果礼镍
	public ElementAdb commodity_Cu;//果礼铜
	
	public void OrderPage(){
		initElementsOP();
	}
	
	//初始化页面
	public void initElementsOP(){
		try{
			this.messageButton = position.findElementById("com.ylmall.app.ui:id/rightBtn");
			this.commodity_Ni = position.findElementByText("果礼镍");
			this.commodity_Cu = position.findElementByText("果礼铜");
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mOpenOrderPage() throws Exception{
		new QuotationPage().mWaitOpenApp();
		position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/deal_img", 3000);
		device.click(position.findElementById("com.ylmall.app.ui:id/deal_img"));
		Assertion.VerityTextPresentPrecision("现价定购", "是否已进入定购主页...");
	}
}
