package com.zbwx.autotest.ui.pageobject.homeobject;

import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;
import atx.client.common.ElementObj;

import com.zbwx.autotest.ui.base.TestBaseCase;

public class HomePageNotifications extends TestBaseCase{
 
	public static ElementObj img_homeMessage;
	
	public static ElementAdb mNoticeContainer;
	public static ElementAdb mTixianContainer;
	public static ElementAdb mDealContainer;
	
	public static ElementAdb mMessageBack;
	
	public HomePageNotifications(){
		initElements();
	}

	public void initElements() {
		
		try {
			this.img_homeMessage=driver.elementById(TestBaseCase.mAppMainPackage+":id/img_tixing");//首页消息
			
			this.mNoticeContainer=position.findElementById(TestBaseCase.mAppMainPackage+":id/notice_container");//公告提醒			
			
			this.mTixianContainer=position.findElementById(TestBaseCase.mAppMainPackage+":id/tixian_container");//提现提醒
			
			this.mDealContainer=position.findElementById(TestBaseCase.mAppMainPackage+":id/deal_container");//成交提醒
			this.mMessageBack=position.findElementById(TestBaseCase.mAppMainPackage+":id/newcfd_message_back");//成交提醒

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void newCentre() {		
		position.waitForElement(ElementAttribs.TEXT, "消息中心", 3000);
	}
	public void newClick() throws Exception {
		position.waitForElement(ElementAttribs.TEXT, "消息", 3000);
		img_homeMessage.click();
	}
}
