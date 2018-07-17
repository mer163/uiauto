package com.zbwx.autotest.ui.pageObject;

import com.zbwx.autotest.ui.utils.TestBaseCase;

import atx.client.common.ElementObj;

public class HomePage extends TestBaseCase{
	
	
	private ElementObj home_bottom;


	
	public HomePage() {
		initElements();
	}
	
	//初始化页面元素
	public void initElements() {
		try {
			this.home_bottom = driver.elementByClass("首页");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void login() {
		
	}
}
