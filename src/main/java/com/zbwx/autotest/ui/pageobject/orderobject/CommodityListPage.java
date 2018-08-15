package com.zbwx.autotest.ui.pageobject.orderobject;

import com.zbwx.autotest.ui.base.BasePage;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

//商品列表页面
public class CommodityListPage extends BasePage {
	
	@FindElementBy(text="消息")//消息按钮
	public AndroidElement mMessage_Button;

	@FindElementBy(id= "id/leftBtn")//返回按钮
	public AndroidElement mReturn_Button;
	
	@FindElementBy(text="果礼镍")//果礼镍
	public AndroidElement mCommodity_Ni;

	protected CommodityListPage(){
		super();
	}

	public static CommodityListPage verify(){
		return  new CommodityListPage();
	}
}
