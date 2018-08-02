package com.zbwx.autotest.ui.homepage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import atx.client.adb.ElementAttribs;

import com.zbwx.autotest.ui.base.TestBaseCase;
import com.zbwx.autotest.ui.pageobject.homeobject.HomePageNotifications;
import com.zbwx.autotest.ui.pageobject.homeobject.HomePageService;
import com.zbwx.autotest.ui.utils.Assertion;
/**
 * 
 * @author zbwx
 * @date 2018年8月1日
 * 首页消息提醒测试
 */
public class NotificationsTest extends TestBaseCase{
	
	@BeforeClass
	public void beforeclass() throws Exception{
		driver.startUiAutomator();
		Thread.sleep(3000);
	}
	@Test(description = "消息中心公告提醒")
	public void testNotificationsGG() throws Exception{
		HomePageNotifications mHomePageNotifications = new HomePageNotifications();
		mHomePageNotifications.newClick();
		Thread.sleep(3000);
		Assertion.VerityTextPresentPrecision("公告提醒", "进入消息中心页面");
		HomePageNotifications mHomePageNotifications1 = new HomePageNotifications();
		device.click(mHomePageNotifications1.mNoticeContainer);
		HomePageNotifications mHomePageNotifications2 = new HomePageNotifications();
		if (position.waitForElement(ElementAttribs.RESOURCE_ID,TestBaseCase.mAppMainPackage+":id/item_message_time",3000)) {
			device.click(mHomePageNotifications2.mMessageBack);
		}
		mReturnHomePage();
	}
	
	@Test(description = "消息中心提现提醒")
	public void testNotificationsTX() throws Exception{
		HomePageNotifications mHomePageNotifications = new HomePageNotifications();
		mHomePageNotifications.newClick();
		HomePageNotifications mHomePageNotifications1 = new HomePageNotifications();
		mHomePageNotifications1.newCentre();
		HomePageNotifications mHomePageNotifications2 = new HomePageNotifications();
		device.click(mHomePageNotifications2.mTixianContainer);
		Thread.sleep(3000);
		Assertion.VerityTextPresentPrecision("充值提现提醒", "进入充值提现提醒页面");
		HomePageNotifications mHomePageNotifications3 = new HomePageNotifications();
		device.click(mHomePageNotifications3.mMessageBack);
		mReturnHomePage();
	}
	@Test(description = "消息中心成交提醒")
	public void testNotificationsCJ() throws Exception{
		HomePageNotifications mHomePageNotifications = new HomePageNotifications();
		mHomePageNotifications.newClick();
		HomePageNotifications mHomePageNotifications3 = new HomePageNotifications();
		mHomePageNotifications3.newCentre();
		HomePageNotifications mHomePageNotifications1 = new HomePageNotifications();
		device.click(mHomePageNotifications1.mDealContainer);
		Assertion.VerityTextPresentPrecision("成交提醒", "进入成交提醒页面");
		Thread.sleep(3000);
		HomePageNotifications mHomePageNotifications2 = new HomePageNotifications();
		device.click(mHomePageNotifications2.mMessageBack);
		mReturnHomePage();
	}
	@AfterClass
	public void afterClassResult() {
		
	}
}
