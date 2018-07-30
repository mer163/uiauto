package com.zbwx.autotest.ui.pageobject;

import com.zbwx.autotest.ui.base.TestBaseCase;

import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;
import atx.client.common.ElementObj;

public class HomePage extends TestBaseCase{
	
	
	public ElementObj home_bottom;
	public ElementObj my;
	public ElementObj CU;
	public ElementObj more;

	
	public HomePage() {
		initElements();
	}
	
	//初始化页面元素
	public void initElements() {
		try {
			this.home_bottom = driver.elementByName("首页");
			this.my = driver.elementByName("我的");
			this.CU= driver.elementByName("果礼铜");
			this.more=driver.elementById("com.ylmall.app.ui:id/tv_moreyl");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void login() throws Exception {
		if(position.waitForElement(ElementAttribs.TEXT,"粉丝：-- --",3000)) {
			ElementAdb e_search = position.findElementById("com.ylmall.app.ui:id/fourth_head_img");
			device.click(e_search);
		}
			
		if(position.waitForElement(ElementAttribs.TEXT,"获取验证码",3000)) {
		driver.elementById("com.ylmall.app.ui:id/rightText").click();		//点击密码
		
		driver.elementById("com.ylmall.app.ui:id/login_new_tel").click();;

		device.sendText("13910643661");
//		driver.press(KeyEventEnum.ENTER.getValue());
		
		//输入密码
		driver.elementById("com.ylmall.app.ui:id/login_new_pwd").click();;

		device.sendText("111111");
//		driver.press(KeyEventEnum.ENTER.getValue());
		Thread.sleep(3000); 
		//点击登录
//		driver.elementByXpath("//android.widget.Button[@text='登 录']").click();
		driver.elementById("com.ylmall.app.ui:id/login_new_btn").click();
		
//		device.click(e_txt);
//		ElementAdb e_enter = position.findElementByText("确定兑换");
//		device.click(e_enter);
	}
	}
}
