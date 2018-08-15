package com.zbwx.autotest.ui.pageobject.orderobject;

import com.zbwx.autotest.ui.base.BasePage;
import com.zbwx.autotest.ui.base.BaseTest;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

//我的订单
public class MyOrderPage extends BasePage {
	@FindElementBy(text="消息")
	public AndroidElement mMessage_Button;//消息按钮

	@FindElementBy(id= "id/leftBtn")
	public AndroidElement mReturn_Button;//返回按钮
	
	@FindElementBy(text="果礼镍")
	public AndroidElement mCommodity_Ni;//果礼镍
	

	public MyOrderPage(){
		super();
	}

	public static MyOrderPage verify(){
		return  new MyOrderPage();
	}
}
