package com.zbwx.autotest.ui.pageobject;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.zbwx.autotest.ui.base.TestBaseCase;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.AtxClient;
import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;
import atx.client.adb.Position;
import atx.client.common.ElementObj;
import atx.client.enums.AttributeMask;

public class HomePage extends TestBaseCase{
	
	
	public ElementAdb home_bottom;
	public ElementAdb my;
	
	public ElementAdb btn_homeSearch;
	public static ElementAdb img_homeService;
	public static ElementAdb img_homeMessage;
	
	public static  ElementAdb vp_homeCbLoopViewPager;
	public static  ElementAdb tv_homeMoreylName;
	
	public static  ElementAdb mBack;
	public static  ElementAdb tv_homeAllProduct;
	public static  ElementAdb tv_homeNie;
	public static  ElementAdb tv_homeTong;
	public static  ElementAdb tv_homeYin;
	public static  ElementAdb tv_homeJapan;
	public static  ElementAdb tv_homeEngland;
	public static  ElementAdb tv_homeEurope;
	
	public static  ElementAdb ll_homeShow1;
	public static  ElementAdb ll_homeShow2;
	public static  ElementAdb ll_homeShow3;
	
	public static  ElementAdb img_homeFind1;
	public static  ElementAdb img_homeFind2;
	
	public static  ElementAdb ll_homeBuyZhiNan;
	public static  ElementAdb ll_homeStoreInfo;
	public static  ElementAdb ll_homeGongGao;
	
	public HomePage() {
		initElements();
	}
	
	//初始化页面元素
	public void initElements() {
		try {
			
			this.home_bottom = position.findElementByText("首页");
			this.my = position.findElementByText("我的");
			this.btn_homeSearch=position.findElementById(TestBaseCase.mAppMainPackage+":id/tv_search");//首页搜索
			this.img_homeService=position.findElementById(TestBaseCase.mAppMainPackage+":id/img_kefu");//首页客服
			
			this.img_homeMessage=position.findElementById(TestBaseCase.mAppMainPackage+":id/img_tixing");//首页消息
			//轮播
			this.vp_homeCbLoopViewPager=position.findElementById(TestBaseCase.mAppMainPackage+":id/cbLoopViewPager");//轮播
			//播报
			
			this.tv_homeMoreylName=position.findElementByText("更多");//首页更多
			
			//返回
			this.mBack = position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");

			//首页热门商品
			this.tv_homeAllProduct=position.findElementById(TestBaseCase.mAppMainPackage+":id/tv_allproduct");//首页全部商品点这里
			this.tv_homeNie=position.findElementById(TestBaseCase.mAppMainPackage+":id/ll_item");//首页果礼镍
			this.tv_homeTong=position.findElementByText("果礼铜");//首页果礼铜
			this.tv_homeYin=position.findElementByText("果礼银");//首页果礼银
			this.tv_homeJapan=position.findElementByText("日本清酒");//首页日本清酒
			this.tv_homeEngland=position.findElementByText("英国香水");//首页英国香水
			this.tv_homeEurope=position.findElementByText("欧洲红酒");//首页欧洲红酒
			
			//商城精选	新品上架
			this.ll_homeShow1=position.findElementById(TestBaseCase.mAppMainPackage+":id/ll_show1");
			this.ll_homeShow2=position.findElementById(TestBaseCase.mAppMainPackage+":id/img_show2");
			this.ll_homeShow3=position.findElementById(TestBaseCase.mAppMainPackage+":id/img_show3");
			//商城精选	发现好货
			this.img_homeFind1=position.findElementById(TestBaseCase.mAppMainPackage+":id/img_find1");
			this.img_homeFind2=position.findElementById(TestBaseCase.mAppMainPackage+":id/img_find2");
			//为您推荐
			this.ll_homeBuyZhiNan=position.findElementById(TestBaseCase.mAppMainPackage+":id/ll_buyzhinan");
			this.ll_homeStoreInfo=position.findElementById(TestBaseCase.mAppMainPackage+":id/ll_storeinfo");
			this.ll_homeGongGao=position.findElementById(TestBaseCase.mAppMainPackage+":id/ll_gonggao");
			
			
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
	

	public void search() throws Exception{
		if (position.waitForElement(ElementAttribs.TEXT, "热门商品", 3000)) {
			device.click(btn_homeSearch);
		}
//		Assertion.VerityTextPresentPrecision("热门商品", "当前处在首页");
		
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT, "搜索", 3000)) {
			ElementAdb mSearchBack = position.findElementById(TestBaseCase.mAppMainPackage+":id/img_left");
			device.click(mSearchBack);
		}
	}
	public void hotCommodity() throws Exception{
		
		device.click(tv_homeAllProduct);
		if (position.waitForElement(ElementAttribs.TEXT,"商品列表", 3000)) {
			ElementAdb mAllProductBack = position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mAllProductBack);
		}		
		Thread.sleep(3000);
	
		device.click(tv_homeNie);
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT,"定购", 3000)) {
			ElementAdb mNieBack = position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mNieBack);
		}		
		Thread.sleep(3000);
		
	    device.click(tv_homeTong);
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT,"定购", 3000)) {
			ElementAdb mTongBack =  position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mTongBack);
		}
		Thread.sleep(3000);
		
		device.click(tv_homeYin);
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT,"定购", 3000)) {
			ElementAdb mYinBack =  position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mYinBack);
		}		
		Thread.sleep(3000);
		
		device.click(tv_homeJapan);
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT,"定购", 3000)) {
			ElementAdb mJapanBack =  position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mJapanBack);
		}		
		Thread.sleep(3000);
		
		device.click(tv_homeEngland);
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT,"定购", 3000)) {
			ElementAdb mEnglandBack =  position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mEnglandBack);
		}		
		Thread.sleep(3000);
		

		position.waitForElement(ElementAttribs.TEXT, "热门商品", 3000);
		device.click(tv_homeEurope);
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT,"定购", 3000)) {
			ElementAdb mEuropeBack =  position.findElementById(TestBaseCase.mAppMainPackage+":id/leftBtn");
			device.click(mEuropeBack);
		}
	}

	public void mallSeclect() throws Exception{
		
		position.waitForElement(ElementAttribs.TEXT, "客服", 3000);
		device.click(ll_homeShow1);//新品上架
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.RESOURCE_ID, TestBaseCase.mAppMainPackage+":id/baseweb_webview", 3000)) {
			driver.press("BACK");			
		}
		Thread.sleep(3000);
		device.click(ll_homeShow2);
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.RESOURCE_ID, TestBaseCase.mAppMainPackage+":id/baseweb_webview", 3000)) {
			driver.press("BACK");			
		}
		Thread.sleep(3000);
		device.click(ll_homeShow3);
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.RESOURCE_ID, TestBaseCase.mAppMainPackage+":id/baseweb_webview", 3000)) {
			driver.press("BACK");			
		}
		Thread.sleep(3000);
		//发现好货
		device.click(img_homeFind1);
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.RESOURCE_ID, TestBaseCase.mAppMainPackage+":id/baseweb_webview", 3000)) {
			driver.press("BACK");			
		}
		Thread.sleep(3000);
		device.click(img_homeFind2);
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.RESOURCE_ID, TestBaseCase.mAppMainPackage+":id/baseweb_webview", 3000)) {
			driver.press("BACK");			
		}
	}

	public void mallSeclectMethod() {
		
	}
	public void forYouTuiJian()throws Exception{
		
		device.click(ll_homeBuyZhiNan);//购买指南
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT,"特朗普乱挥贸易大棒致全球市场闪崩，黄金日元意外迎来第二春",3000)) {
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/zixun_item_title"));
		}
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT,"资讯",3000)) {
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/baseweb_back"));
		}
		Thread.sleep(3000);
		
		device.click(ll_homeStoreInfo);//商城情报
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT,"7月27日-汇市日报",3000)) {
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/zixun_item_context"));
		}
		Thread.sleep(3000);
		if (position.findElementByText("资讯") != null) {
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/baseweb_back"));
		}
		
		device.click(ll_homeGongGao);//公告
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT,"今日最新中国银行汇率",3000)) {
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/zixun_item_context"));
		}
		Thread.sleep(3000);
		if (position.waitForElement(ElementAttribs.TEXT,"资讯",3000)) {
			device.click(position.findElementById(TestBaseCase.mAppMainPackage+":id/baseweb_back"));
		}
		
	}
	
}
