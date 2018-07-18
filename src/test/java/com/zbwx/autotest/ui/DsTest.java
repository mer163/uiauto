package com.zbwx.autotest.ui;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zbwx.autotest.base.DsBase;

import atx.client.AtxClient;
import atx.client.adb.ElementAttribs;
import atx.client.model.DesiredCapabilities;

public class DsTest extends DsBase {
//	static AtxClient driver = new AtxClient();
//	private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	
	@BeforeClass
	public void befreclass() throws InterruptedException{
//		desiredCapabilities.setPackageName("com.ylaijiaoyi.app.ui");
//        desiredCapabilities.setRemoteHost("192.168.0.159");
//        desiredCapabilities.setPlatformName("Android");
//        driver.initDriver(desiredCapabilities);
////        Thread.sleep(10000);
        driver.startUiAutomator();
//        System.out.println(driver.getCurrentActivity());
        
        
	}
	
	//启动登录，若已登录时，退出登录重新进行登录
	@Test(description = "启动登录")
	public void login() throws Exception{
		driver.startUiAutomator();
		mAssert("10秒内未启动成功...", mCheckText("客服", 20000));
		mOpenPage(MY_PAGE);
		mClickId("com.ylaijiaoyi.app.ui:id/my_goodsname", 3000);
		if (!mCheckText("密码登录", 3000)) {
			mClickText("退出当前账户", 3000);
			mAssert("退出登录失败...", mCheckText("密码登录", 5000));
		}
		mClickText("密码登录", 3000);
		driver.elementById("com.ylaijiaoyi.app.ui:id/login_new_tel").sendKeys(Test_MobileNumber);
		driver.elementById("com.ylaijiaoyi.app.ui:id/login_new_pwd").sendKeys(Test_PassWord);
		//mClickText("登 录", 3000);
		mClickId("com.ylaijiaoyi.app.ui:id/login_new_btn", 3000);
		mAssert("登录失败或登录后未跳转至‘我的’页面...", mCheckId("com.ylaijiaoyi.app.ui:id/my_goodsname", 3000) && !mCheckText("未登录", 2000));
		mLogPrint("账号已成功登录...");	
	}
	
	@AfterSuite
	public void aftersuite(){

	}
}
