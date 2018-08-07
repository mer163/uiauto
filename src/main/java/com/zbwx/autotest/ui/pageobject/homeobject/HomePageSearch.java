package com.zbwx.autotest.ui.pageobject.homeobject;

import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;
import atx.client.common.ElementObj;
import atx.client.model.AndroidElement;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BasePage;
import com.zbwx.autotest.ui.base.BaseTest;

public class HomePageSearch extends BasePage{
	public AndroidElement btn_homeSearch;

	public ElementAdb et_search;
	public ElementAdb img_right;
	public ElementAdb img_left;
	public HomePageSearch(){
		initElement();
	}

	public void initElement() {
		
		try {
			this.btn_homeSearch= BaseAction.driver.findElementById(BaseTest.mAppMainPackage+":id/tv_search");//首页搜索
			this.et_search=BaseAction.position.findElementById(BaseTest.mAppMainPackage+":id/et_search");//点击输入框
			this.img_right=BaseAction.position.findElementById(BaseTest.mAppMainPackage+":id/img_right");//点击搜索
			this.img_left=BaseAction.position.findElementById(BaseTest.mAppMainPackage+":id/img_left");//点击返回

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void searchClick() throws Exception {
		BaseAction.position.waitForElement(ElementAttribs.TEXT, "客服", 3000);
		btn_homeSearch.click();
		
	}
	
}
