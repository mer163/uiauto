package com.zbwx.autotest.ui.pageobject.homeobject;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;


import com.zbwx.autotest.ui.base.BaseTest;
/**
 * 消息
 * @author zbwx
 *
 */
public class HomePageNotifications extends BaseTest {
 
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
	
}
