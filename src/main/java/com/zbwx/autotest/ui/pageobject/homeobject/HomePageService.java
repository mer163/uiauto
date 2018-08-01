package com.zbwx.autotest.ui.pageobject.homeobject;



import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;
import atx.client.common.ElementObj;

import com.zbwx.autotest.ui.base.TestBaseCase;
import com.zbwx.autotest.ui.utils.Assertion;

public class HomePageService extends TestBaseCase{

	public   ElementObj img_homeService;
	public  static   ElementObj mServicesBanner;
	
	public static  ElementAdb mKeFuGuiZe;
	public static  ElementAdb mPassWordFind;
	
	public static  ElementAdb mHelpGuide1;
	public static  ElementAdb mHelpGuide6;
	public static  ElementAdb mHelpGuide7;
	public static  ElementAdb mKeFuBack;
	public static  ElementAdb mHelpGuideHuangJin_1;
	public static  ElementAdb mHelpGuideHuangJin_2;
	
	public static  ElementAdb mHelpGuideJiBen_1;
	public static  ElementAdb mHelpGuideJiBen_2;
	public static  ElementAdb mHelpGuideJiBen_3;
	public static  ElementAdb mHelpGuideJiBen_4;
	
	public static  ElementAdb mHelpGuideJiShu_1;
	public static  ElementAdb mHelpGuideJiShu_2;
	public static  ElementAdb mHelpGuideJiShu_3;
	
	
	public HomePageService(){
		initElements();
	}

	
	//初始化页面元素
	public void initElements() {
		
		try {
			this.img_homeService=driver.elementById(TestBaseCase.mAppMainPackage+":id/img_kefu");//首页客服
			//贴心小助手
			this.mServicesBanner=driver.elementById(TestBaseCase.mAppMainPackage+":id/newcfd_activity_kf_banner");//贴心小助手
			//交易规则和找回密码
			this.mKeFuGuiZe=position.findElementByText("交易规则");//交易规则
			this.mPassWordFind=position.findElementByText("找回密码");//找回密码
			
			this.mHelpGuide1=position.findElementById(TestBaseCase.mAppMainPackage+":id/helpguide_rel_1");//购物攻略
			this.mHelpGuide6=position.findElementById(TestBaseCase.mAppMainPackage+":id/helpguide_rel_6");//基本面分析
			this.mHelpGuide7=position.findElementById(TestBaseCase.mAppMainPackage+":id/helpguide_rel_7");//技术分析
			
			this.mKeFuBack = position.findElementById(TestBaseCase.mAppMainPackage+":id/baseweb_back");
			//购物攻略
			this.mHelpGuideHuangJin_1=position.findElementById(TestBaseCase.mAppMainPackage+":id/helpguide_rel_huangjin_1");//入门攻略
			this.mHelpGuideHuangJin_2=position.findElementById(TestBaseCase.mAppMainPackage+":id/helpguide_rel_huangjin_2");//新手常见问题
		
			//基本面分析
			this.mHelpGuideJiBen_1=position.findElementById(TestBaseCase.mAppMainPackage+":id/helpguide_rel_jiben_1");
			this.mHelpGuideJiBen_2=position.findElementById(TestBaseCase.mAppMainPackage+":id/helpguide_rel_jiben_2");
			this.mHelpGuideJiBen_3=position.findElementById(TestBaseCase.mAppMainPackage+":id/helpguide_rel_jiben_3");
			this.mHelpGuideJiBen_4=position.findElementById(TestBaseCase.mAppMainPackage+":id/helpguide_rel_jiben_4");
			//技术分析
			this.mHelpGuideJiShu_1=position.findElementById(TestBaseCase.mAppMainPackage+":id/helpguide_rel_jishu_1");
			this.mHelpGuideJiShu_2=position.findElementById(TestBaseCase.mAppMainPackage+":id/helpguide_rel_jishu_2");
			this.mHelpGuideJiShu_3=position.findElementById(TestBaseCase.mAppMainPackage+":id/helpguide_rel_jishu_3");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void keFuSecondaryListJB() {
		position.waitForElement(ElementAttribs.TEXT, "基本面分析简介", 3000);
	}
	public void keFuSecondaryListJS() {
		position.waitForElement(ElementAttribs.TEXT, "技术分析入门", 3000);
	}
	public void kefuClick() throws Exception {
		position.waitForElement(ElementAttribs.TEXT, "客服", 3000);
		img_homeService.click();
	}

	
}
