package com.zbwx.autotest.ui.pageobject;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BasePage;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAdb;

import static com.zbwx.autotest.ui.base.BaseAction.mWaitOpenApp;

public class QuotationPage extends BasePage {
	public ElementAdb returnButton;//返回按钮
	public ElementAdb messageButton;//消息按钮(图标)
	public ElementAdb commodity_Ni;//果礼镍
	public ElementAdb commodity_Cu;//果礼铜
	public ElementAdb commodity_ClearWine;//日本清酒
	public ElementAdb k_Timeshare;//分时线
	public ElementAdb k_M5;//M5
	public ElementAdb k_M15;//M15
	public ElementAdb k_H1;//H1
	public ElementAdb k_D1;//D1
	public ElementAdb orderButton;//定购按钮
	
	public QuotationPage(){
		initElementsQP();
	}
	
	//初始化页面元素
	public void initElementsQP() {
		try {
			this.returnButton = BaseAction.position.findElementById("com.ylmall.app.ui:id/leftBtn");
			this.messageButton = BaseAction.position.findElementById("com.ylmall.app.ui:id/rightBtn");
			this.commodity_Ni = BaseAction.position.findElementByText("果礼镍");
			this.commodity_Cu = BaseAction.position.findElementByText("果礼铜");
			this.commodity_ClearWine = BaseAction.position.findElementByText("日本清酒");
			this.k_Timeshare = BaseAction.position.findElementById("com.ylmall.app.ui:id/newcfd_line_fen");
			this.k_M5 = BaseAction.position.findElementById("com.ylmall.app.ui:id/newcfd_line_5");
			this.k_M15 = BaseAction.position.findElementById("com.ylmall.app.ui:id/newcfd_line_15");
			this.k_H1 = BaseAction.position.findElementById("com.ylmall.app.ui:id/newcfd_line_60");
			this.k_D1 = BaseAction.position.findElementById("com.ylmall.app.ui:id/newcfd_line_day");
			this.orderButton = BaseAction.position.findElementById("com.ylmall.app.ui:id/newcfd_fragdeal_xiadan");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	/**
	 * 进入行情页面
	 * @throws Exception
	 */
	public void mOpenQuotationPage() throws Exception{
		mWaitOpenApp();
		BaseAction.device.click(BaseAction.position.findElementById("com.ylmall.app.ui:id/tv_allproduct"));//首页点击‘全部商品点这里>’
		BaseAction.device.click(BaseAction.position.findElementByText("果礼镍"));;//商品列表点击‘果礼镍’
		Assertion.VerityNotTextPresentPrecision("行情");
	}
}
