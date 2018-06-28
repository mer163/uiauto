package com.zbwx.autotest.ui;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import com.zbwx.autotest.ui.utils.ElementAction;
import com.zbwx.autotest.ui.utils.TestBaseCase;

import atx.client.model.AtxDriver;
import atx.client.AtxClient;
import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;
import atx.client.enums.KeyEventEnum;

import java.io.IOException;

public class LoginTest extends TestBaseCase{
//	ElementAction action=new ElementAction();
    @BeforeClass
    public  void  beforeclass() throws Exception {
//        StartPage startPage=new StartPage();
//        action.click(startPage.登录());
//        LoginPage loginPage=new LoginPage();
//        action.sleep(2);
//        action.click(loginPage.使用其他方式登录());
//        action.sleep(2);
    	
    		driver.startUiAutomator();
		Thread.sleep(3000);
//		driver.elementByName("我的").click();
    }
    
    
    
    @Test(description = "登录测试")
    public  void login() throws Exception {
       
    		driver.startUiAutomator();
    		Thread.sleep(3000);
    		driver.elementByName("我的").click();
    		position.findElementByCheckable("");
    		if(position.waitForElement(ElementAttribs.TEXT,"粉丝：-- --",3000)) {
    			ElementAdb e_search = position.findElementById("com.ylmall.app.ui:id/fourth_head_img");
    			device.click(e_search);
    		}
    			
		if(position.waitForElement(ElementAttribs.TEXT,"获取验证码",3000)) {
			driver.elementById("com.ylmall.app.ui:id/rightText").click();		//点击密码
			
			driver.elementById("com.ylmall.app.ui:id/login_new_tel").click();;

			device.sendText("13910643661");
//			driver.press(KeyEventEnum.ENTER.getValue());
			
			//输入密码
			driver.elementById("com.ylmall.app.ui:id/login_new_pwd").click();;

			device.sendText("111111");
//			driver.press(KeyEventEnum.ENTER.getValue());
			Thread.sleep(3000); 
			//点击登录
//			driver.elementByXpath("//android.widget.Button[@text='登 录']").click();
			driver.elementById("com.ylmall.app.ui:id/login_new_btn").click();
			
//			device.click(e_txt);
//			ElementAdb e_enter = position.findElementByText("确定兑换");
//			device.click(e_enter);
		}
    	
    }

    @AfterSuite
    public  void openResult()
    {
//        WebDriver driver =new FirefoxDriver();
//        driver.get("http://127.0.0.1");
    }
}
