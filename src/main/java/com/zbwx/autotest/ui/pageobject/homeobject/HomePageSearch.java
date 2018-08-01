package com.zbwx.autotest.ui.pageobject.homeobject;

import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;
import atx.client.common.ElementObj;

import com.zbwx.autotest.ui.base.TestBaseCase;

public class HomePageSearch extends TestBaseCase{
	public ElementObj btn_homeSearch;

	public ElementAdb et_search;
	public ElementAdb img_right;
	public ElementAdb img_left;
	public HomePageSearch(){
		initElement();
	}

	public void initElement() {
		
		try {
			this.btn_homeSearch=driver.elementById(TestBaseCase.mAppMainPackage+":id/tv_search");//首页搜索
			this.et_search=position.findElementById(TestBaseCase.mAppMainPackage+":id/et_search");//点击输入框
			this.img_right=position.findElementById(TestBaseCase.mAppMainPackage+":id/img_right");//点击搜索
			this.img_left=position.findElementById(TestBaseCase.mAppMainPackage+":id/img_left");//点击返回

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void searchClick() throws Exception {
		position.waitForElement(ElementAttribs.TEXT, "客服", 3000);
		btn_homeSearch.click();
		
	}
	
}
