package com.zbwx.autotest.ui.pageobject;

import com.zbwx.autotest.ui.base.BasePage;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

public class ZiXunPage extends BasePage{

	// 为您推荐
	@FindElementBy(text = "购买指南")
	public AndroidElement ll_homeBuyZhiNan;// 购买指南
	@FindElementBy(text = "商城情报")
	public AndroidElement ll_homeStoreInfo;// 商城情报
	@FindElementBy(text = "公告")
	public AndroidElement ll_homeGongGao;	// 公告
	
	protected ZiXunPage() {
		super();

	}

	public static ZiXunPage verify() {
		return new ZiXunPage();
	}
}
