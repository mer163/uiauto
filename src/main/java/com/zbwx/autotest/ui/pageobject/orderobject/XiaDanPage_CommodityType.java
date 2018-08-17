package com.zbwx.autotest.ui.pageobject.orderobject;

import com.zbwx.autotest.ui.base.BasePage;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;
//选择规格
public class XiaDanPage_CommodityType extends BasePage {
	@FindElementBy(id="id/full_open_layout")//第一个规格
	public AndroidElement mType_1;

	@FindElementBy(id="id/full_open_layout",index = 1)//第二个规格
	public AndroidElement mType_2;
	
	@FindElementBy(id="id/full_open_layout",index = 2)//第三个规格
	public AndroidElement mType_3;
	
	protected XiaDanPage_CommodityType(){
		super();
	}

	public static XiaDanPage_CommodityType verify(){
		return  new XiaDanPage_CommodityType();
	}
}
