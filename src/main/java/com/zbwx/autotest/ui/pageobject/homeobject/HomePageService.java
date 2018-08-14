package com.zbwx.autotest.ui.pageobject.homeobject;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;


import com.zbwx.autotest.ui.base.BasePage;

/**
 * 客服
 * @author zbwx
 *
 */
public class HomePageService extends BasePage {

	
	@FindElementBy(id= "id/leftBtn")	// 客服中心返回	
	public AndroidElement mBtnBackService;
	
	@FindElementBy(id= "id/newcfd_activity_kf_banner")	// 贴心小助手	
	public AndroidElement mServicesBanner;
		

	@FindElementBy(text="交易规则")		// 交易规则	
	public AndroidElement mKeFuGuiZe;
	@FindElementBy(text="找回密码")		// 找回密码	
	public AndroidElement mPassWordFind;
	
	@FindElementBy(id= "id/helpguide_rel_1")	// 购物攻略	
	public AndroidElement mHelpGuide1;
	@FindElementBy(id= "id/helpguide_rel_6")	// 基本面分析
	public AndroidElement mHelpGuide6;
	@FindElementBy(id= "id/helpguide_rel_7")	//  技术分析	
	public AndroidElement mHelpGuide7;


	
	
	protected HomePageService(){
		super();

	}

	public static HomePageService verify(){
		return  new HomePageService();
	}
	
	//点击返回 按钮
	public void clickBack(){
		this.mBtnBackService.click();
	}
}
