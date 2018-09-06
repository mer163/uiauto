package com.zbwx.autotest.ui.pageobject.homeobject;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;


import com.zbwx.autotest.ui.base.BasePage;

public class ShopGongLueService extends BasePage {

	// 购物攻略
	@FindElementBy(id = "id/helpguide_rel_huangjin_1")
	// 入门攻略
	public AndroidElement mHelpGuideHuangJin_1;

	@FindElementBy(id = "id/helpguide_rel_huangjin_2")
	// 新手常见问题
	public AndroidElement mHelpGuideHuangJin_2;

	protected ShopGongLueService() {
		super();

	}

	public static ShopGongLueService verify() {
		return new ShopGongLueService();
	}

	public void mClick() throws Exception{
		this.mHelpGuideHuangJin_1.click();//入门攻略	
		HomePageService.verify().mBtnBackService.click();
		Thread.sleep(2000);
		
		this.mHelpGuideHuangJin_2.click();//新手常见问题
		HomePageService.verify().mBtnBackService.click();
	}
}
