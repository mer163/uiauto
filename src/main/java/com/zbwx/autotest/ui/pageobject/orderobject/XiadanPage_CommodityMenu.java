package com.zbwx.autotest.ui.pageobject.orderobject;

import com.zbwx.autotest.ui.base.BasePage;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

public class XiadanPage_CommodityMenu extends BasePage{
	@FindElementBy(id="id/full_open_text")//第一个商品
	public AndroidElement mCommodit_1;

	@FindElementBy(id="id/full_open_text",index = 1)//第二个商品
	public AndroidElement mCommodit_2;
	
		@FindElementBy(id="id/full_open_text",index = 2)//第三个商品
	public AndroidElement mCommodit_3;
	
	protected XiadanPage_CommodityMenu(){
		super();
	}

	public static XiadanPage_CommodityMenu verify(){
		return  new XiadanPage_CommodityMenu();
	}
}
