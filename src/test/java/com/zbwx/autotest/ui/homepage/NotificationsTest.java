package com.zbwx.autotest.ui.homepage;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BaseTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.pageobject.homeobject.HomePageNotifications;
import com.zbwx.autotest.ui.pageobject.homeobject.HomePageService;
import com.zbwx.autotest.ui.utils.Assertion;
/**
 * 
 * @author zbwx
 * @date 2018年8月1日
 * 首页消息提醒测试
 */
public class NotificationsTest extends BaseTest {
	
	@BeforeClass   //所有方法开始前执行
	public void beforeclass() throws Exception{
		//从首页进入客服中心页面
		HomePage.verify().img_homeService.click();
	}
	@BeforeMethod   //每个方法执行前执行
	public void beforeMethod() throws Exception{
		
		//当前是否处于消息中心页面，否则返回首页点击消息中心重新进入
		if(!HomePageNotifications.verify().mNoticeContainer.getText().equals("公告提醒")){			
			HomePageService.verify().mBtnBackService.click();
			HomePage.verify().img_homeMessage.click();
		}
	}

	@AfterMethod
	public void aftermthod() throws Exception{
		//每个方法执行完后执行
		Assertion.VerityTextPresentPrecision("消息中心", "当前为消息中心页面......");
		BaseAction.mReturn();
		HomePage.verify().img_homeService.click();
	}

	@AfterClass
	public void afterClass() throws Exception{
		//所有测试方法执行完后执行		
		//回首页
		
	}
	
	@Test(description = "消息中心公告提醒")
	public void testNotificationsGG() throws Exception{
		//点击首页消息
		HomePage.verify().img_homeMessage.click();
		Thread.sleep(3000);
		//点击公告提醒，提现提醒，成交提醒
		HomePageNotifications.verify().mClickNoti();
		HomePageService.verify().mBtnBackService.click();
		
	}


	@AfterClass
	public void afterClassResult() {
		
	}
}
