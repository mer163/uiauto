package com.zbwx.autotest.ui.pageobject;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.zbwx.autotest.ui.base.TestBaseCase;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;
import atx.client.common.ElementObj;

public class HomePage extends TestBaseCase{
	
	
	public ElementObj home_bottom;
	public ElementObj my;
	public ElementObj btn_search;
	public ElementObj img_service;
	
	
	public HomePage() {
		initElements();
	}
	
	//初始化页面元素
	public void initElements() {
		try {
			
			this.home_bottom = driver.elementByClass("首页");
			this.my = driver.elementByName("我的");
			this.btn_search=driver.elementById("com.ylmall.app.ui:id/tv_search");//首页搜索
			this.img_service=driver.elementById("com.ylmall.app.ui:id/img_kefu");//首页客服
			
			
			
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

		device.sendText("15210034889");
//		driver.press(KeyEventEnum.ENTER.getValue());
		
		//输入密码
		driver.elementById("com.ylmall.app.ui:id/login_new_pwd").click();;

		device.sendText("654321");
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
	
	//首页搜索
	public void homePageSearch() throws Exception {
		
    	if(position.waitForElement(ElementAttribs.TEXT, "热门商品", 3000)) {
			ElementAdb tv_search = position.findElementById("com.ylmall.app.ui:id/tv_search");
			device.click(tv_search);
		}
    
    	Thread.sleep(3000);
    	//点击输入框
    	driver.elementById("com.ylmall.app.ui:id/et_search").click();
    	//输入查找内容
    	device.sendText("欧洲红酒");
    	Thread.sleep(3000); 
    	//点击搜索
    	driver.elementById("com.ylmall.app.ui:id/img_right").click();
    	System.out.println("--------搜索--------");
    	Thread.sleep(3000);
    	//页面显示
    	Assertion.VerityTextPresentPrecision("商品地区");
    	Assertion.VerityTextPresentPrecision("商品分类");
    	Assertion.VerityTextPresentPrecision("上架时间");
    	Assertion.VerityTextPresentPrecision("价格");
    	
    	//搜索失败重新输入
    	if (position.waitForElement(ElementAttribs.CONTENTDESC, "暂无内容", 2000)) {
    		//点击输入框
	    	driver.elementById("com.ylmall.app.ui:id/et_search").click();
	    	device.sendText("奶粉");
	    	Thread.sleep(3000); 
	    	ElementAdb seach = position.findElementById("com.ylmall.app.ui:id/img_right");
			device.click(seach);
			Thread.sleep(3000);
		}
    	
    	//搜索成功点击返回
    	if(position.waitForElement(ElementAttribs.TEXT, "澳大利亚", 3000)) {
			
    		ElementAdb btn_back = position.findElementById("com.ylmall.app.ui:id/img_left");
			device.click(btn_back);
			
    		/*driver.elementByDesc("1524123249701").click();
    		Thread.sleep(3000); 
    		
    		Assertion.VerityTextPresentPrecision("收藏");
    		Assertion.VerityTextPresentPrecision("购物车");
    		Assertion.VerityTextPresentPrecision("立即购买");*/
    		
		}

	}
	//首页客服
	public void  homePageService() throws Exception{
		
		if (position.waitForElement(ElementAttribs.TEXT, "客服中心", 3000)) {
			
			//检查页面元素
			Assertion.VerityBoolean(position.waitForElement(ElementAttribs.TEXT, "交易规则", 3000), true, "切换标签交易规则");
			Assertion.VerityBoolean(position.waitForElement(ElementAttribs.TEXT, "找回密码", 3000), true, "切换标签找回密码");
			
			driver.elementByName("交易规则").click();
			
		}
		
		if (position.waitForElement(ElementAttribs.TEXT, "交易规则", 3000)) {
			Assertion.VerityTextPresentPrecision("交易规则", "当前处在“交易规则”页");
			driver.elementById("com.ylmall.app.ui:id/baseweb_back").click();
		}
		Thread.sleep(3000);
		//找回密码
		driver.elementByName("找回密码").click();
		
		Assertion.VerityTextPresentPrecision("找回登录密码", "当前处在“找回登录密码页面”。。。");
		Thread.sleep(3000);
		//点击消息
		driver.elementById("com.ylmall.app.ui:id/rightBtn").click();
		//检查页面元素
		Assertion.VerityTextPresentPrecision("消息中心", "当前处在“消息中心页面”。。。");
		Assertion.VerityTextPresentPrecision("公告提醒");
		Assertion.VerityTextPresentPrecision("提现提醒");
		Assertion.VerityTextPresentPrecision("成交提醒");
		Thread.sleep(3000);
		
		//点击公告提醒
		driver.elementById("com.ylmall.app.ui:id/notice_container").click();
		Assertion.VerityTextPresentPrecision("公告提醒", "当前处在“公告提醒页面”。。。");
		if (position.waitForElement(ElementAttribs.TEXT, "今日最新中国银行汇率", 3000)) {
			driver.elementById("com.ylmall.app.ui:id/leftBtn").click();
		}
		Thread.sleep(3000);
		//点击提现提醒
		driver.elementById("com.ylmall.app.ui:id/tixian_container").click();
		Assertion.VerityTextPresentPrecision("充值提现提醒", "当前处在“充值提现提醒页面”。。。");
		if (position.waitForElement(ElementAttribs.TEXT, "提现成功", 3000)) {
			driver.elementById("com.ylmall.app.ui:id/newcfd_message_back").click();
		}
		Thread.sleep(3000);
		//点击成交提醒
		driver.elementById("com.ylmall.app.ui:id/deal_container").click();
		Thread.sleep(3000);
		driver.elementById("com.ylmall.app.ui:id/newcfd_message_back").click();
		Thread.sleep(3000);
		driver.elementById("com.ylmall.app.ui:id/leftBtn").click();
		Thread.sleep(3000);
		
		if (position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/forget_new_yzm", 3000)) {
			
			//点击手机号输入框
			driver.elementById("com.ylmall.app.ui:id/forget_new_tel").click();
			//输入手机号
	    	device.sendText("15210034889");
	    	
	    	//点击密码输入框
			driver.elementById("com.ylmall.app.ui:id/forget_new_in_pwd").click();
			//输入密码
	    	device.sendText("123456");
	    	
	    	//点击确认密码输入框
			driver.elementById("com.ylmall.app.ui:id/forget_new_repwd").click();
			//输入确认密码
	    	device.sendText("123456");
	    	
	    	//点击获取验证码
			driver.elementById("com.ylmall.app.ui:id/forget_new_yzm").click();
			//点击验证码输入框
			driver.elementById("com.ylmall.app.ui:id/forget_new_pwd").click();
			//输入确认密码
	    	device.sendText("4561");
	    	
	    	//点击完成
	    	driver.elementById("com.ylmall.app.ui:id/forget_new_btn").click();
	    	
	    	Thread.sleep(3000);
	    	//点击返回客服中心
	    	driver.elementById("com.ylmall.app.ui:id/leftBtn").click();
	    	
			//选择购物攻略
			driver.elementById("com.ylmall.app.ui:id/helpguide_rel_1").click();
			Assertion.VerityTextPresent("入门攻略");
			Assertion.VerityTextPresent("新手常见问题");
			//选择基本面分析
			driver.elementByName("基本面分析");
			Assertion.VerityTextPresent("基本面分析简介");
			Assertion.VerityTextPresent("不同货币对的独特个性");
			Assertion.VerityTextPresent("经济指标");
			Assertion.VerityTextPresent("影响外汇市场的因素");
			//选择技术分析
			driver.elementByName("技术分析");
			Assertion.VerityTextPresent("技术分析入门");
			Assertion.VerityTextPresent("使用技术指标");
			Assertion.VerityTextPresent("常用技术指标及应用");
			
			
			
		}
	
	}
	
	
}
