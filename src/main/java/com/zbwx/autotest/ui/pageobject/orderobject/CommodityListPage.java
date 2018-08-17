package com.zbwx.autotest.ui.pageobject.orderobject;

import com.zbwx.autotest.ui.base.BasePage;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

//商品列表页面
public class CommodityListPage extends BasePage {
	
	@FindElementBy(id = "id/rightBtn")//消息按钮
	public AndroidElement mMessage_Button;

	@FindElementBy(id= "id/leftBtn")//返回按钮
	public AndroidElement mReturn_Button;
	
	@FindElementBy(id = "id/newcfd_frag_first_hot_name",index = 0)//第一个商品
	public AndroidElement mCommodityName1;
	
	@FindElementBy(id = "id/newcfd_frag_first_hot_name",index = 1)//第二个商品
	public AndroidElement mCommodityName2;

	protected CommodityListPage(){
		super();
	}

	public static CommodityListPage verify(){
		return  new CommodityListPage();
	}
}
