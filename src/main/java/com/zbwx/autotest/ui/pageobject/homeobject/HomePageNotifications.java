package com.zbwx.autotest.ui.pageobject.homeobject;


import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;





import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BasePage;
import com.zbwx.autotest.ui.base.BaseTest;
/**
 * 消息
 * @author zbwx
 *
 */
public class HomePageNotifications extends BasePage {
 
	@FindElementBy(id= "id/leftBtn")	
	public AndroidElement mMessageBackBtn;
	
	@FindElementBy(id= "id/notice_container")
	public AndroidElement mNoticeContainer;
	
	@FindElementBy(id= "id/tixian_container")	
	public AndroidElement mTixianContainer;
	
	@FindElementBy(id= "id/deal_container")	
	public AndroidElement mDealContainer;
	

	

	protected HomePageNotifications(){
		super();

	}

	public static HomePageNotifications verify(){
		return  new HomePageNotifications();
	}
	public void mClickNoti() throws Exception{
		this.mNoticeContainer.click();
		Thread.sleep(2000);
		((AndroidElement) BaseAction.driver.findElementById(BaseTest.mAppMainPackage +":id/newcfd_message_back")).click();
		Thread.sleep(2000);
		
		this.mTixianContainer.click();
		Thread.sleep(2000);
		((AndroidElement) BaseAction.driver.findElementById(BaseTest.mAppMainPackage +":id/newcfd_message_back")).click();
		Thread.sleep(2000);
		this.mDealContainer.click();
		Thread.sleep(2000);
		((AndroidElement) BaseAction.driver.findElementById(BaseTest.mAppMainPackage +":id/newcfd_message_back")).click();
	}
}
