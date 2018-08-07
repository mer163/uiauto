package com.zbwx.autotest.ui.pageobject.homeobject;

import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;
import atx.client.common.ElementObj;
import atx.client.model.AndroidElement;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BaseTest;

public class HomePageNotifications extends BaseTest {
 
	public static AndroidElement img_homeMessage;
	
	public static ElementAdb mNoticeContainer;
	public static ElementAdb mTixianContainer;
	public static ElementAdb mDealContainer;
	
	public static ElementAdb mMessageBack;
	
	public HomePageNotifications(){
		initElements();
	}

	public void initElements() {
		
		try {
			this.img_homeMessage= BaseAction.driver.findElementById(BaseTest.mAppMainPackage+":id/img_tixing");//首页消息
			
			this.mNoticeContainer=BaseAction.position.findElementById(BaseTest.mAppMainPackage+":id/notice_container");//公告提醒
			
			this.mTixianContainer=BaseAction.position.findElementById(BaseTest.mAppMainPackage+":id/tixian_container");//提现提醒
			
			this.mDealContainer=BaseAction.position.findElementById(BaseTest.mAppMainPackage+":id/deal_container");//成交提醒
			this.mMessageBack=BaseAction.position.findElementById(BaseTest.mAppMainPackage+":id/newcfd_message_back");//成交提醒

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void newCentre() {		
		BaseAction.position.waitForElement(ElementAttribs.TEXT, "消息中心", 3000);
	}
	public void newClick() throws Exception {
		BaseAction.position.waitForElement(ElementAttribs.TEXT, "消息", 3000);
		img_homeMessage.click();
	}
}
