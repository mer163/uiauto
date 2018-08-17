package com.zbwx.autotest.ui.pageobject.orderobject;

import com.zbwx.autotest.ui.base.BasePage;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;
//下单确认弹窗
public class XiaDanPage_ConfirmOrder extends BasePage{
	@FindElementBy(id="id/dialog_cancle")//取消按钮
	public AndroidElement mCancelButton;

	@FindElementBy(id="id/dialog_ok",index = 1)//确定按钮
	public AndroidElement mOkButton;
	
	protected XiaDanPage_ConfirmOrder(){
		super();
	}

	public static XiaDanPage_ConfirmOrder verify(){
		return  new XiaDanPage_ConfirmOrder();
	}
}
