package com.zbwx.autotest.ui.pageobject.orderobject;

import com.zbwx.autotest.ui.base.BasePage;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

//我的订单
public class MyOrderPage extends BasePage {
	@FindElementBy(id = "id/rightBtn")
	public AndroidElement mMessage_Button;//消息按钮

	@FindElementBy(id= "id/leftBtn")
	public AndroidElement mReturn_Button;//返回按钮
	
	public MyOrderPage(){
		super();
	}

	public static MyOrderPage verify(){
		return  new MyOrderPage();
	}
}
