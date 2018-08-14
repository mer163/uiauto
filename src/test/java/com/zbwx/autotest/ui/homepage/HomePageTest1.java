package com.zbwx.autotest.ui.homepage;

import java.util.ArrayList;

import com.zbwx.autotest.ui.base.BaseTest;
import com.zbwx.autotest.ui.pageobject.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;
import atx.client.remote.PageFactory;

public class HomePageTest1 extends BaseTest {
    

	
	@BeforeClass
	public void beforeClass() {

	}

	@BeforeMethod
	public void beforeMethod(){
		//每个方法执行前执行

	}

	@AfterMethod
	public void aftermthod(){
		//每个方法执行完后执行
	}

	@AfterClass
	public void afterClass() {
		//所有测试方法执行完后执行

	}

	@Test(description = "test")
	public void testLoginSuccess() throws Exception{
		//进入我的页面
		HomePage1.verify().clickMy();

		//点击头像，进入登录页面
		MyPage.verify().clickHeadImage();
		//点击密码登录，跳转至密码登录页面
		LoginWithSmsPage.verify().passwordLogin.click();

		LoginWithPassword.verify().login();



//		HomePage1 mHomePage1 = new HomePage1();
//		Thread.sleep(3000);
//		PageFactory.initElements(mHomePage1, driver);
//		mHomePage1.my.click();
//		Thread.sleep(3000);
//		Assertion.VerityTextPresentPrecision("热门商品", "当前处在首页");
//		HomePage mHomePage2 = new HomePage();
//		BaseAction.device.click(mHomePage2.img_homeService);
//		
//		Thread.sleep(3000);
//		
//		if (BaseAction.position.waitForElement(ElementAttribs.TEXT, "交易规则",3000)) {
//			ElementAdb mServiceBack = BaseAction.position.findElementById("com.ylmall.app.ui:id/leftBtn");
//			BaseAction.device.click(mServiceBack);
//			
//		}
	
		
	}

	@Test
	public void testLoginFail(){

    }

}
